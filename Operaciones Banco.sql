DELIMITER $$

CREATE PROCEDURE RealizarTransferencia(
    IN cuenta_origen_param INT,
    IN cuenta_destino_param INT,
    IN monto_param INT
)
BEGIN
    DECLARE saldo_origen INT;
    DECLARE saldo_destino INT;

    -- Obtener el saldo de la cuenta origen
    SELECT saldo INTO saldo_origen FROM Cuentas WHERE id_cuenta = cuenta_origen_param;

    -- Obtener el saldo de la cuenta destino
    SELECT saldo INTO saldo_destino FROM Cuentas WHERE num_cuenta = cuenta_destino_param;

    START TRANSACTION;

    -- Se verifica que el saldo de la cuenta se mayor que el monto que se quiere transferir
    IF saldo_origen >= monto_param THEN
        -- Restar el monto del saldo de la cuenta origen
        UPDATE Cuentas SET saldo = saldo - monto_param WHERE id_cuenta = cuenta_origen_param;

        -- Sumar el monto al saldo de la cuenta destino
        UPDATE Cuentas SET saldo = saldo + monto_param WHERE num_cuenta = cuenta_destino_param;

        -- Registrar la transacción
        INSERT INTO Transacciones (fechaHora, monto, tipo_transaccion) VALUES (NOW(), monto_param, 'Transferencia');

        
        SET @id_transaccion = LAST_INSERT_ID();

        -- Registrar la transferencia
        INSERT INTO Transferencias (id_transaccion, cuenta_origen, cuenta_destino) VALUES (@id_transaccion, cuenta_origen_param, cuenta_destino_param);

        COMMIT;
    ELSE
        -- Si el saldo de la cuenta origen es menor que el monto que se quiere transferir, la operacion es cancelada.
        ROLLBACK;
    END IF;
END $$

DELIMITER ;


DELIMITER $$

CREATE EVENT LimpiarRetirosExpirados
ON SCHEDULE EVERY 1 MINUTE
DO
BEGIN
    -- Actualizar el estado de los registros de RetirosSinTarjeta que hayan expirado
    UPDATE RetirosSinTarjeta
    SET estado = 'No cobrado'
    WHERE TIMESTAMPDIFF(MINUTE, fechaHora, NOW()) > 10
    AND estado <> 'No cobrado';
END $$

DELIMITER ;


DELIMITER $$

CREATE PROCEDURE CobrarRetiroSinCuenta(
    IN p_folio INT,
    IN p_contraseña VARCHAR(8)
)
BEGIN
    DECLARE cuenta_origen_id INT;
    DECLARE monto_retiro INT;
    DECLARE saldo_cuenta_origen INT;
    DECLARE retiro_estado VARCHAR(20);

    -- Obtener la cuenta origen, el monto del retiro y el estado del retiro sin cuenta
    SELECT cuenta_origen, monto, estado INTO cuenta_origen_id, monto_retiro, retiro_estado
    FROM RetirosSinTarjeta
    WHERE folioOperacion = p_folio AND contraseña = p_contraseña;

    -- Obtener el saldo de la cuenta origen
    SELECT saldo INTO saldo_cuenta_origen
    FROM Cuentas
    WHERE id_cuenta = cuenta_origen_id;

    -- Verificar que el estado del retiro sin cuenta sea "pendiente"
    IF retiro_estado = 'pendiente' THEN
        -- Verificar que el monto a cobrar no sea mayor que el saldo disponible en la cuenta origen
        IF monto_retiro <= saldo_cuenta_origen THEN
            -- Iniciar la transacción
            START TRANSACTION;

            -- Actualizar el saldo de la cuenta origen
            UPDATE Cuentas
            SET saldo = saldo - monto_retiro
            WHERE id_cuenta = cuenta_origen_id;

            -- Registrar la transacción
            INSERT INTO Transacciones (fechaHora, monto, tipo_transaccion)
            VALUES (NOW(), monto_retiro, 'Retiro sin cuenta');

            -- Eliminar el registro del retiro sin cuenta
            DELETE FROM RetirosSinTarjeta
            WHERE folioOperacion = p_folio AND contraseña = p_contraseña;

            -- Confirmar la transacción
            COMMIT;
        ELSE
            -- Lanzar una excepción o mensaje de error si el monto es mayor que el saldo
            SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'El monto del retiro sin cuenta es mayor que el saldo disponible en la cuenta de origen';
        END IF;
    ELSE
        -- Lanzar una excepción o mensaje de error si el estado no es "pendiente"
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'El estado del retiro sin cuenta no es pendiente';
    END IF;
END $$

DELIMITER ;

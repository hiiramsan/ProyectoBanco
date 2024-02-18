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
        INSERT INTO Transacciones (fechaHora, monto,cuenta_origen, tipo_transaccion) VALUES (NOW(), monto_param,cuenta_origen_param, 'Transferencia');

        
        SET @id_transaccion = LAST_INSERT_ID();

        -- Registrar la transferencia
        INSERT INTO Transferencias (id_transaccion, cuenta_destino) VALUES (@id_transaccion, cuenta_destino_param);

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
    UPDATE RetirosSinTarjeta rst
    INNER JOIN Transacciones t ON rst.id_transaccion = t.id_transaccion
    SET rst.estado = 'No cobrado'
    WHERE TIMESTAMPDIFF(MINUTE, t.fechaHora, NOW()) > 10
    AND rst.estado <> 'No cobrado';
END $$

DELIMITER ;



DELIMITER $$

CREATE PROCEDURE CobrarRetiroSinCuenta(
    IN p_folio INT,
    IN p_contraseña VARCHAR(8)
)
BEGIN
    DECLARE monto_retiro INT;
    DECLARE saldo_cuenta_origen INT;
    DECLARE retiro_estado VARCHAR(20);
    DECLARE cuenta_origen_id INT;

    -- Obtener la cuenta origen, el monto del retiro y el estado del retiro sin cuenta
    SELECT t.monto, rs.estado, t.cuenta_origen
    INTO monto_retiro, retiro_estado, cuenta_origen_id
    FROM RetirosSinTarjeta rs
    INNER JOIN Transacciones t ON rs.id_transaccion = t.id_transaccion
    WHERE rs.folioOperacion = p_folio AND rs.contrasena = p_contraseña;

    -- Obtener el saldo de la cuenta origen
    SELECT saldo INTO saldo_cuenta_origen
    FROM Cuentas
    WHERE id_cuenta = cuenta_origen_id;

    -- Verificar que el estado del retiro sin cuenta sea "pendiente"
    IF retiro_estado = 'Pendiente' THEN
        -- Verificar que el monto a cobrar no sea mayor que el saldo disponible en la cuenta origen
        IF monto_retiro <= saldo_cuenta_origen THEN
            -- Iniciar la transacción
            START TRANSACTION;

            -- Actualizar el saldo de la cuenta origen
            UPDATE Cuentas
            SET saldo = saldo - monto_retiro
            WHERE id_cuenta = cuenta_origen_id;

            -- Eliminar el registro del retiro sin cuenta
            DELETE FROM RetirosSinTarjeta
            WHERE folioOperacion = p_folio AND contrasena = p_contraseña;

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


DELIMITER $$

CREATE PROCEDURE RegistrarRetiroSinCuenta(
    IN cuenta_origen INT,
    IN monto INT,
    IN folioOperacion INT,
    IN contrasena VARCHAR(8),
    IN fecha_hora DATETIME,
    IN estadoRetiro VARCHAR(20)
)
BEGIN
    DECLARE saldo_cuenta_origen INT;
    DECLARE id_transaccion INT;
    -- Obtener el saldo de la cuenta de origen
    SELECT saldo INTO saldo_cuenta_origen
    FROM Cuentas
    WHERE id_cuenta = cuenta_origen;
    
    -- Verificar si el monto es menor o igual al saldo de la cuenta de origen
    IF monto <= saldo_cuenta_origen THEN
        -- Registrar la transacción
        INSERT INTO Transacciones (fechaHora, monto, cuenta_origen, tipo_transaccion)
        VALUES (fecha_hora, monto, cuenta_origen, 'Retiro sin cuenta');
        
        -- Obtener el ID de la transacción registrada

        SELECT LAST_INSERT_ID() INTO id_transaccion;
        
        -- Registrar el retiro sin cuenta con estado "Pendiente"
        INSERT INTO RetirosSinTarjeta (id_transaccion, folioOperacion, contrasena, estado)
        VALUES (id_transaccion, folioOperacion, contrasena, estadoRetiro);
        
        -- Indicar que el retiro sin cuenta se registró correctamente
        SELECT 'Retiro sin cuenta registrado correctamente' AS mensaje;
        ELSE
        -- Indicar que el monto excede el saldo de la cuenta de origen
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'El monto excede el saldo de la cuenta de origen';
    END IF;
    
END $$

DELIMITER ;

DELIMITER $$

CREATE PROCEDURE ObtenerHistorialTransacciones(
    IN tipoTransaccionParam VARCHAR(20),
    IN fechaInicioParam VARCHAR(20),
    IN fechaFinParam VARCHAR(20)
)
BEGIN
    IF tipoTransaccionParam = 'Todas' THEN
    -- todas las transacciones
        IF fechaInicioParam = 'NoDate' OR fechaFinParam = 'NoDate' THEN
            SELECT id_transaccion, fechaHora, monto, tipo_transaccion, cuenta_origen
            FROM transacciones;
        ELSE
            SELECT id_transaccion, fechaHora, monto, tipo_transaccion, cuenta_origen
            FROM Transacciones 
            WHERE fechaHora BETWEEN STR_TO_DATE(fechaInicioParam, '%Y-%m-%d') AND STR_TO_DATE(fechaFinParam, '%Y-%m-%d');
        END IF;
    ELSE
        -- Consulta escpecifica por tipo de ttransaccion
        IF fechaInicioParam = 'NoDate' OR fechaFinParam = 'NoDate' THEN
            SELECT id_transaccion, fechaHora, monto, tipo_transaccion, cuenta_origen
            FROM Transacciones
            WHERE tipo_transaccion = tipoTransaccionParam;
        ELSE
            SELECT id_transaccion, fechaHora, monto, tipo_transaccion, cuenta_origen
            FROM Transacciones 
            WHERE tipo_transaccion = tipoTransaccionParam 
            AND fechaHora BETWEEN STR_TO_DATE(fechaInicioParam, '%Y-%m-%d') AND STR_TO_DATE(fechaFinParam, '%Y-%m-%d');
        END IF;
    END IF;
END $$

DELIMITER ;


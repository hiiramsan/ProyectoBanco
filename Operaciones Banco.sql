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
DELIMITER $$

CREATE TRIGGER CrearCuentaDespuesDeInsertarCliente
AFTER INSERT ON Clientes
FOR EACH ROW
BEGIN
    DECLARE cuenta_generada INT;
    
    -- Generar un número de cuenta aleatorio único
    REPEAT
        SET cuenta_generada = FLOOR(RAND() * 900000) + 100000; -- Número de cuenta de 6 dígitos
    UNTIL NOT EXISTS (SELECT * FROM Cuentas WHERE num_cuenta = cuenta_generada) END REPEAT;
    
    -- Insertar la nueva cuenta asociada al cliente
    INSERT INTO Cuentas (num_cuenta, fecha_apertura, saldo, id_cliente, estado)
    VALUES (cuenta_generada, CURDATE(), 0, NEW.id_cliente, 'Activa');
    
END $$

DELIMITER ;

DELIMITER $$
CREATE TRIGGER moverSaldoDespuesDeCancelarCuenta
AFTER UPDATE ON Cuentas
FOR EACH ROW
BEGIN
IF NEW.estado = 'Cancelada' AND OLD.estado != 'Cancelada' THEN
        DECLARE saldo_cancelado DOUBLE;
        DECLARE cliente_id_cancelado INT;
        DECLARE otra_cuenta_id INT;

        -- Obtener el saldo y el cliente_id de la cuenta cancelada
        SELECT saldo, cliente_id INTO saldo_cancelado, cliente_id_cancelado
        FROM Cuentas
        WHERE id_cuenta = NEW.id_cuenta;

        -- Buscar otra cuenta activa del mismo cliente
        SELECT id_cuenta INTO otra_cuenta_id
        FROM Cuentas
        WHERE cliente_id = cliente_id_cancelado
            AND estado = 'Activa'
            AND id_cuenta != NEW.id_cuenta
        LIMIT 1;

        -- Transferir saldo a la otra cuenta si se encuentra
        IF otra_cuenta_id IS NOT NULL THEN
            UPDATE Cuentas
            SET saldo = saldo + saldo_cancelado
            WHERE id_cuenta = otra_cuenta_id;
        END IF;
    END IF;
END //
DELIMITER ;


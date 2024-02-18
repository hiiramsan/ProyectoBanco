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




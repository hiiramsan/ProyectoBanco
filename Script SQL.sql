CREATE DATABASE banco;
use banco;

CREATE TABLE Clientes (
    id_cliente INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(50),
    apellido_paterno VARCHAR(50),
    apellido_materno VARCHAR(50),
    fechaNacimiento DATE,
    usuario VARCHAR(50) UNIQUE,
    contraseña VARCHAR(50),
    codigoPostal VARCHAR(5),
    calle VARCHAR(100),
    numeroExterior VARCHAR(8),
    colonia VARCHAR(100),
    ciudad VARCHAR(100)
);

CREATE TABLE Cuentas (
    id_cuenta INT PRIMARY KEY AUTO_INCREMENT,
    num_cuenta int unique,
    fecha_apertura DATE,
    saldo INT,
    id_cliente INT,
    estado VARCHAR(50),
    FOREIGN KEY (id_cliente) REFERENCES Clientes(id_cliente)
);

CREATE TABLE Transacciones (
    id_transaccion INT PRIMARY KEY AUTO_INCREMENT,
    fechaHora DATETIME,
    monto INT,
    cuenta_origen INT,
    tipo_transaccion VARCHAR(20),
    FOREIGN KEY (cuenta_origen) REFERENCES Cuentas(id_cuenta)
);

CREATE TABLE Transferencias (
    id_transaccion INT,
    cuenta_destino INT,
    PRIMARY KEY (id_transaccion),
    FOREIGN KEY (id_transaccion) REFERENCES Transacciones(id_transaccion),
    FOREIGN KEY (cuenta_destino) REFERENCES Cuentas(num_cuenta)
);

CREATE TABLE RetirosSinTarjeta (
    id_transaccion INT,
    folioOperacion INT,
    contrasena VARCHAR(8),
    estado VARCHAR(20),
    PRIMARY KEY (id_transaccion),
    FOREIGN KEY (id_transaccion) REFERENCES Transacciones (id_transaccion)
);

select * from clientes;
select * from cuentas;
select * from transferencias;
select * from transacciones;
select * from RetirosSinTarjeta;

-- todas las transacciones
SELECT T.*, R.folioOperacion, R.contrasena, TS.cuenta_destino
FROM Transacciones T
LEFT JOIN RetirosSinTarjeta R ON T.id_transaccion = R.id_transaccion
LEFT JOIN Transferencias TS ON T.id_transaccion = TS.id_transaccion;


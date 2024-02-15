/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bancopersistencia.daos;

import bancoblue.bancodominio.Cuenta;
import com.mycompany.bancopersistencia.conexion.IConexion;
import com.mycompany.bancopersistencia.dtos.CuentaDTO;
import com.mycompany.bancopersistencia.persistencia.PersistenciaException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PC
 */
public class CuentaDAO implements ICuentaDAO {

    final IConexion conexion;
    private static final Logger LOG = Logger.getLogger(CuentaDAO.class.getName());

    public CuentaDAO(IConexion conexion) {
        this.conexion = conexion;
    }

    @Override
    public Cuenta agregarCuenta(CuentaDTO cuenta) throws PersistenciaException {
        // 1. Crear la sentencia SQL que vamos a mandar a la BD
        String sentenciaSQL = "INSERT INTO CUENTA (fecha_apertura, saldo,id_cliente) VALUES (?,?,?)";

        // 2. Vamos a insertar o intentar hacer la inserción en la tabla
        try (
                // recursos
                Connection conexion = this.conexion.crearConexion(); // establecemos la conexion con la bd
                // Crear el statement o el comando donde ejecutamos la sentencia
                 PreparedStatement comandoSQL = conexion.prepareStatement(sentenciaSQL, Statement.RETURN_GENERATED_KEYS); // mandamos la sentencia y obtenemos de regreso la llave generada o el ID
                ) {

            // 3. mandar los valores del cliente al comandoSQL
            comandoSQL.setString(1, cuenta.getFecha_apertura());
            comandoSQL.setInt(2, cuenta.getSaldo());
            comandoSQL.setInt(3, cuenta.getId_cliente());

            // 4. Ejecutamos el comando o lo enviamos a la BD
            int registrosModificados = comandoSQL.executeUpdate();
            LOG.log(Level.INFO, "Se agregaron con éxito {0} ", registrosModificados);

            // obtener el conjunto de resultados que tiene o contiene las llaves generadas durante el registro o inserción
            ResultSet registroGenerado = comandoSQL.getGeneratedKeys();

            // nos posicionamos en el primer registro o en el siguiente disponible.
            registroGenerado.next();

            Cuenta cuentaNueva = new Cuenta(
                    registroGenerado.getInt(1),
                    cuenta.getFecha_apertura(),
                    cuenta.getSaldo(),
                    cuenta.getId_cliente()
            );
            // regresamos la cuenta
            return cuentaNueva;

        } catch (Exception e) {
            LOG.log(Level.SEVERE, "No se agregó con éxito la cuenta", e);
            throw new PersistenciaException("No se pudo guardar la cuenta ", e);
        }
    }

}

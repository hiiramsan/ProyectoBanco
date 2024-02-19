/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bancopersistencia.daos;

import com.mycompany.bancopersistencia.conexion.IConexion;
import com.mycompany.bancopersistencia.persistencia.PersistenciaException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PC
 */
public class TransferenciaDAO implements ITransferenciaDAO {

    final IConexion conexion;
    private static final Logger LOG = Logger.getLogger(TransferenciaDAO.class.getName());

    /**
     * Construye un nuevo objeto TransferenciaDAO con la conexión especificada.
     *
     * @param conexion La conexión a la base de datos.
     */
    public TransferenciaDAO(IConexion conexion) {
        this.conexion = conexion;
    }

    /**
     * Realiza una transferencia entre cuentas en la base de datos.
     *
     * @param cuentaOrigen El número de cuenta de origen.
     * @param cuentaDestino El número de cuenta de destino.
     * @param monto El monto a transferir.
     * @return true si la transferencia se realiza correctamente, false si no.
     * @throws PersistenciaException Si ocurre un error durante la
     * transferencia.
     */
    @Override
    public boolean realizarTransferencia(int cuentaOrigen, int cuentaDestino, int monto) throws PersistenciaException {
        try (
                Connection connection = conexion.crearConexion(); CallableStatement callableStatement = connection.prepareCall("{call RealizarTransferencia(?, ?, ?)}")) {
            // Establecer los parámetros del procedimiento almacenado
            callableStatement.setInt(1, cuentaOrigen);
            callableStatement.setInt(2, cuentaDestino);
            callableStatement.setInt(3, monto);

            // Ejecutar el procedimiento almacenado
            callableStatement.execute();

            // Si se ejecuta sin lanzar una excepción, la transferencia fue exitosa
            LOG.log(Level.INFO, "Transferencia realizada con éxito");
            return true;
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, "Error al realizar la transferencia", e);
            return false;
        }
    }
}

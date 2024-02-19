/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bancopersistencia.daos;

import bancoblue.bancodominio.RetiroSinCuenta;
import com.mycompany.bancopersistencia.conexion.IConexion;
import com.mycompany.bancopersistencia.dtos.RetiroSinCuentaDTO;
import com.mycompany.bancopersistencia.persistencia.PersistenciaException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Armenta Baca Jose Maria, Carlos Hiram Sanchez Meneses
 */
public class RetiroSinCuentaDAO implements IRetiroSinCuentaDAO {

    final IConexion conexion;
    private static final Logger LOG = Logger.getLogger(RetiroSinCuentaDAO.class.getName());

    /**
     * Constructor de la clase RetiroSinCuentaDAO.
     *
     * @param conexion Objeto que implementa la interfaz IConexion para
     * establecer la conexión con la base de datos.
     */
    public RetiroSinCuentaDAO(IConexion conexion) {
        this.conexion = conexion;
    }

    /**
     * Inserta un retiro sin tarjeta en la base de datos.
     *
     * @param retiro El DTO que contiene la información del retiro sin tarjeta.
     * @return true si el retiro se inserta correctamente, false si no.
     * @throws PersistenciaException Si ocurre un error durante la inserción del
     * retiro.
     */
    @Override
    public boolean insertarRetiroSinTarjeta(RetiroSinCuentaDTO retiro) throws PersistenciaException {
        // Definir el nombre del procedimiento almacenado
        String procedimientoAlmacenado = "{CALL RegistrarRetiroSinCuenta(?, ?, ?, ?,?,?)}";

        // Intentar llamar al procedimiento almacenado
        try (
                // Recursos
                Connection conexion = this.conexion.crearConexion(); // Establecer la conexión con la BD
                 CallableStatement llamadaProcedimiento = conexion.prepareCall(procedimientoAlmacenado); // Crear la llamada al procedimiento almacenado
                ) {
            // Asignar los parámetros al procedimiento almacenado
            llamadaProcedimiento.setInt(1, retiro.getCuenta_origen());
            llamadaProcedimiento.setInt(2, retiro.getMonto());
            llamadaProcedimiento.setInt(3, retiro.getFolio_operacion());
            llamadaProcedimiento.setString(4, retiro.getContraseña());
            llamadaProcedimiento.setString(5, retiro.getFecha_hora());
            llamadaProcedimiento.setString(6, retiro.getEstado());

            // Ejecutar el procedimiento almacenado
            llamadaProcedimiento.execute();
            LOG.log(Level.INFO, "Transferencia realizada con éxito");
            return true;
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, "Error al insertar el retiro sin cuenta", e);
            return false;

        }
    }

    /**
     * Genera una contraseña aleatoria para ser utilizada en un retiro sin
     * tarjeta.
     *
     * @return Una contraseña aleatoria.
     * @throws PersistenciaException Si ocurre un error durante la generación de
     * la contraseña.
     */
    @Override
    public String generarContraseña() throws PersistenciaException {
        Random random = new Random();
        // Generar un número aleatorio de 8 dígitos
        int contraseñaAleatoria = 10000000 + random.nextInt(90000000);
        return Integer.toString(contraseñaAleatoria);
    }

    /**
     * Obtiene el último folio utilizado para un retiro sin tarjeta.
     *
     * @return El último folio utilizado.
     * @throws PersistenciaException Si ocurre un error durante la obtención del
     * último folio.
     */
    @Override
    public int obtenerUltimoFolioUtilizado() throws PersistenciaException {
        int ultimoFolio = 999;

        // Consulta SQL para obtener el máximo folioOperacion
        String sentenciaSQL = "SELECT MAX(folioOperacion) AS ultimoFolio FROM RetirosSinTarjeta";

        try (
                Connection conexion = this.conexion.crearConexion(); Statement comandoSQL = conexion.createStatement(); ResultSet resultado = comandoSQL.executeQuery(sentenciaSQL);) {
            // Verificar si hay resultados
            if (resultado.next()) {
                // Obtener el valor del máximo folioOperacion
                ultimoFolio = resultado.getInt("ultimoFolio");
            }
        } catch (SQLException e) {
            // Manejo de excepciones
        }

        return ultimoFolio;
    }

    /**
     * Cobra un retiro sin tarjeta en la base de datos.
     *
     * @param folio El folio del retiro a cobrar.
     * @param contraseña La contraseña asociada al retiro.
     * @return true si el retiro se cobra correctamente, false si no.
     * @throws PersistenciaException Si ocurre un error durante el cobro del
     * retiro.
     */
    @Override
    public boolean cobrarRetiroSinCuenta(int folio, String contraseña) throws PersistenciaException {
        String procedimientoAlmacenado = "{CALL CobrarRetiroSinCuenta(?, ?)}";

        try (
                Connection conexion = this.conexion.crearConexion(); CallableStatement llamadaProcedimiento = conexion.prepareCall(procedimientoAlmacenado);) {
            llamadaProcedimiento.setInt(1, folio);
            llamadaProcedimiento.setString(2, contraseña);

            llamadaProcedimiento.execute();
            return true;
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, "Error al cobrar el retiro sin cuenta", e);
            return false;
        }
    }
}

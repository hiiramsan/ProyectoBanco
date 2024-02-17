/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bancopersistencia.daos;

import bancoblue.bancodominio.RetiroSinCuenta;
import com.mycompany.bancopersistencia.conexion.IConexion;
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
 * @author PC
 */
public class RetiroSinCuentaDAO implements IRetiroSinCuentaDAO{
    
    final IConexion conexion;
    private static final Logger LOG = Logger.getLogger(RetiroSinCuentaDAO.class.getName());
    

    public RetiroSinCuentaDAO (IConexion conexion) {
        this.conexion = conexion;
    }

    @Override
    public void insertarRetiroSinTarjeta(RetiroSinCuenta retiro) throws PersistenciaException {
         // 1. Crear la sentencia SQL para la inserción
        String sentenciaSQL = "INSERT INTO RetirosSinTarjeta (folioOperacion, contraseña, fechaHora, estado) VALUES (?, ?, ?, ?)";

        // 2. Intentar hacer la inserción en la tabla
        try (
            // Recursos
            Connection conexion = this.conexion.crearConexion(); // Establecer la conexión con la BD
            PreparedStatement comandoSQL = conexion.prepareStatement(sentenciaSQL); // Crear el comando SQL
        ) {
            // 3. Asignar los valores del retiro sin cuenta al comando SQL
            comandoSQL.setInt(1, retiro.getFolio_operacion());
            comandoSQL.setString(2, retiro.getContraseña());
            comandoSQL.setTimestamp(3, Timestamp.valueOf(retiro.getFecha_hora()));
            comandoSQL.setString(4, retiro.getEstado());

            // 4. Ejecutar el comando SQL para realizar la inserción
            comandoSQL.executeUpdate();
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, "Error al insertar el retiro sin cuenta", e);
            throw new PersistenciaException("Error al insertar el retiro sin cuenta", e);
        }
    }

    @Override
    public String generarContraseña()throws PersistenciaException {
        Random random = new Random();
        // Generar un número aleatorio de 8 dígitos
        int contraseñaAleatoria = 10000000 + random.nextInt(90000000);
        return Integer.toString(contraseñaAleatoria);
    }

    @Override
    public int obtenerUltimoFolioUtilizado() throws PersistenciaException {
        int ultimoFolio = 0;

        // Consulta SQL para obtener el máximo folioOperacion
        String sentenciaSQL = "SELECT MAX(folioOperacion) AS ultimoFolio FROM RetirosSinTarjeta";

        try (
            Connection conexion = this.conexion.crearConexion();
            Statement comandoSQL = conexion.createStatement();
            ResultSet resultado = comandoSQL.executeQuery(sentenciaSQL);
        ) {
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

    @Override
    public void cobrarRetiroSinCuenta(int folio, String contraseña) throws PersistenciaException {
        String procedimientoAlmacenado = "{CALL CobrarRetiroSinCuenta(?, ?)}";

        try (
            Connection conexion = this.conexion.crearConexion();
            CallableStatement llamadaProcedimiento = conexion.prepareCall(procedimientoAlmacenado);
        ) {
            llamadaProcedimiento.setInt(1, folio);
            llamadaProcedimiento.setString(2, contraseña);

            llamadaProcedimiento.execute();
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, "Error al cobrar el retiro sin cuenta", e);
            throw new PersistenciaException("Error al cobrar el retiro sin cuenta", e);
        }
    }
    }
    


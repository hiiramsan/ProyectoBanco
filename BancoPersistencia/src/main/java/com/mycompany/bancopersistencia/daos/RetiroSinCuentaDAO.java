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
 * @author PC
 */
public class RetiroSinCuentaDAO implements IRetiroSinCuentaDAO{
    
    final IConexion conexion;
    private static final Logger LOG = Logger.getLogger(RetiroSinCuentaDAO.class.getName());
    

    public RetiroSinCuentaDAO (IConexion conexion) {
        this.conexion = conexion;
    }

    @Override
    public boolean insertarRetiroSinTarjeta(RetiroSinCuentaDTO retiro) throws PersistenciaException {
        // Definir el nombre del procedimiento almacenado
    String procedimientoAlmacenado = "{CALL RegistrarRetiroSinCuenta(?, ?, ?, ?,?)}";

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
        llamadaProcedimiento.setString(5,retiro.getFecha_hora());

        // Ejecutar el procedimiento almacenado
        llamadaProcedimiento.execute();
        LOG.log(Level.INFO, "Transferencia realizada con éxito");
         return true;
    } catch (SQLException e) {
        LOG.log(Level.SEVERE, "Error al insertar el retiro sin cuenta", e);
        return false;
        
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
        int ultimoFolio = 999;

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
    


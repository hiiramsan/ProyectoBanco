/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bancopersistencia.daos;

import bancoblue.bancodominio.Transaccion;
import com.mycompany.bancopersistencia.conexion.IConexion;
import com.mycompany.bancopersistencia.persistencia.PersistenciaException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author carlo
 */
public class HistorialDAO implements IHistorialDAO {

    final IConexion conexion;
    private static final Logger LOG = Logger.getLogger(HistorialDAO.class.getName());

    public HistorialDAO(IConexion conexion) {
        this.conexion = conexion;
    }

    @Override
    public List<Transaccion> obtenerHistorialTransacciones(String tipoTransaccion, String fechaInicio, String fechaFin) throws PersistenciaException {
        List<Transaccion> transacciones = new ArrayList<>();
        String llamadaSP = "{CALL ObtenerHistorialTransacciones(?, ?, ?)}";

        try (
                Connection conexion = this.conexion.crearConexion(); 
                CallableStatement llamada = conexion.prepareCall(llamadaSP);) {
            
            llamada.setString(1, tipoTransaccion);
            llamada.setString(2, fechaInicio);
            llamada.setString(3, fechaFin);

            ResultSet resultado = llamada.executeQuery();

            while (resultado.next()) {
                int idTransaccion = resultado.getInt("id_transaccion");
                Timestamp fechaHoraTimestamp = resultado.getTimestamp("fechaHora");
                String fechaHora = (fechaHoraTimestamp != null) ? fechaHoraTimestamp.toString() : null;
                int monto = resultado.getInt("monto");
                int cuentaOrigen = resultado.getInt("cuenta_origen");
                String tipoTransaccionResultado = resultado.getString("tipo_transaccion");
                

                Transaccion transaccion = new Transaccion(idTransaccion, fechaHora, monto, tipoTransaccionResultado, cuentaOrigen);
                transacciones.add(transaccion);
            }

        } catch (Exception e) {
            LOG.log(Level.SEVERE, "Error al obtener historial de transacciones", e);
            throw new PersistenciaException("Error al obtener historial de transacciones", e);
        }

        return transacciones;
    }

}

/*

public List<Cliente> consultarTodos() throws PersistenciaException {
        List<Cliente> listaClientes = new ArrayList<>();
        String sentenciaSQL = "select * from CLIENTES";
      
      try (Connection conexion = this.conexionBD.crearConexion();
              PreparedStatement comandoSQL = conexion.prepareStatement(sentenciaSQL);) {
          
          ResultSet resultado = comandoSQL.executeQuery();
          
          while(resultado.next()) {
              int id = resultado.getInt("id_cliente");
              String nombre = resultado.getString("nombre");
              String apellidoPaterno = resultado.getString("apellido_paterno");
              String apellidoMaterno = resultado.getString("apellido_materno");
              String direccion = resultado.getString("direccion");
              Cliente cliente = new Cliente(id, nombre, apellidoPaterno, apellidoMaterno, direccion);
              listaClientes.add(cliente);
          }
          
          LOG.log(Level.INFO, sentenciaSQL, this);
      }catch(Exception e) {
          e.printStackTrace();
          LOG.log(Level.SEVERE, "no se recuperaron los clientess");
          throw new PersistenciaException("hola");
      }
        
      return listaClientes;
    }
*/

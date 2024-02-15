/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bancopersistencia.daos;

import bancoblue.bancodominio.Cliente;
import com.mycompany.bancopersistencia.conexion.IConexion;
import com.mycompany.bancopersistencia.dtos.ClienteDTO;
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
public class ClienteDAO implements IClienteDAO {
    final IConexion conexion;
    private static final Logger LOG = Logger.getLogger(ClienteDAO.class.getName());
    
    
    public ClienteDAO(IConexion conexion) {
        this.conexion = conexion;
    }
    
    
    @Override
    public Cliente agregarCliente(ClienteDTO cliente) throws PersistenciaException {
       // 1. Crear la sentencia SQL que vamos a mandar a la BD
        String sentenciaSQL = "INSERT INTO CLIENTES (nombre, apellido_paterno, apellido_materno, fechaNacimiento,usuario,contraseña, codigoPostal, calle, numeroExterior, colonia, ciudad) VALUES (?,?,?,?,?,?,?,?,?,?,?)";

        // 2. Vamos a insertar o intentar hacer la inserción en la tabla
        try (
                // recursos
                Connection conexion = this.conexion.crearConexion(); // establecemos la conexion con la bd
                // Crear el statement o el comando donde ejecutamos la sentencia
                 PreparedStatement comandoSQL = conexion.prepareStatement(sentenciaSQL, Statement.RETURN_GENERATED_KEYS); // mandamos la sentencia y obtenemos de regreso la llave generada o el ID
                ) {

            // 3. mandar los valores del cliente al comandoSQL
            comandoSQL.setString(1, cliente.getNombre());
            comandoSQL.setString(2, cliente.getApellidoP());
            comandoSQL.setString(3, cliente.getApellidoM());
            comandoSQL.setString(4, cliente.getFechaNacimiento());
            comandoSQL.setString(5, cliente.getUsuario());
            comandoSQL.setString(6, cliente.getContraseña());
            comandoSQL.setString(7, cliente.getCodigoPostal());
            comandoSQL.setString(8, cliente.getCalle());
            comandoSQL.setString(9, cliente.getNumero());
            comandoSQL.setString(10, cliente.getColonia());
            comandoSQL.setString(11, cliente.getCiudad());


            // 4. Ejecutamos el comando o lo enviamos a la BD
            int registrosModificados = comandoSQL.executeUpdate();
            LOG.log(Level.INFO, "Se agregaron con éxito {0} ", registrosModificados);

            // obtener el conjunto de resultados que tiene o contiene las llaves generadas durante el registro o inserción
            ResultSet registroGenerado = comandoSQL.getGeneratedKeys();

            // nos posicionamos en el primer registro o en el siguiente disponible.
            registroGenerado.next();

            Cliente clienteNuevo = new Cliente(
                    registroGenerado.getInt(1),
                    cliente.getNombre(),
                    cliente.getApellidoP(),
                    cliente.getApellidoM(),
                    cliente.getFechaNacimiento(),
                    cliente.getUsuario(),
                    cliente.getContraseña(),
                    cliente.getCodigoPostal(),
                    cliente.getCiudad(),
                    cliente.getCalle(),
                    cliente.getColonia(),
                    cliente.getNumero()
            );
            // regresamos el cliente
            return clienteNuevo;

        } catch (Exception e) {
            LOG.log(Level.SEVERE, "No se agregó con éxito el cliente", e);
            throw new PersistenciaException("No se pudo guardar el cliente ", e);
        }
    }
    
}

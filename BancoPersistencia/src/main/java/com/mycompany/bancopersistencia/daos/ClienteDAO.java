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
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Armenta Baca Jose Maria, Carlos Hiram Sanchez Meneses
 */
public class ClienteDAO implements IClienteDAO {

    final IConexion conexion;
    private static final Logger LOG = Logger.getLogger(ClienteDAO.class.getName());

    /**
     * Constructor de la clase ClienteDAO.
     *
     * @param conexion Objeto que proporciona métodos para establecer la
     * conexión con la base de datos.
     */
    public ClienteDAO(IConexion conexion) {
        this.conexion = conexion;
    }

    /**
     * Agrega un nuevo cliente a la base de datos.
     *
     * @param cliente Objeto ClienteDTO que contiene la información del cliente
     * a agregar.
     * @return El cliente agregado.
     * @throws PersistenciaException Si ocurre un error durante la operación de
     * persistencia.
     */
    @Override
    public Cliente agregarCliente(ClienteDTO cliente) throws PersistenciaException {
        // 1. Crear la sentencia SQL que vamos a mandar a la BD
        String sentenciaSQL = "INSERT INTO CLIENTES (nombre, apellido_paterno, apellido_materno, fechaNacimiento,usuario,contraseña, codigoPostal, calle, numeroExterior, colonia, ciudad) VALUES (?,?,?,?,?,?,?,?,?,?,?)";

        // 2. Vamos a insertar o intentar hacer la inserción en la tabla
        try (
                // recursos
                Connection conexion = this.conexion.crearConexion(); // establecemos la conexion con la bd
                // Creaqqq  r el statement o el comando donde ejecutamos la sentencia
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

            Cliente clienteNuevo = buscarClientePorId(registroGenerado.getInt(1));

            // regresamos el cliente
            return clienteNuevo;

        } catch (Exception e) {
            LOG.log(Level.SEVERE, "No se agregó con éxito el cliente", e);
            throw new PersistenciaException("No se pudo guardar el cliente ", e);
        }
    }

    // MOVER A VALIDADORESSSSSSSSSSS
    /**
     * Valida si un usuario ya existe en la base de datos.
     *
     * @param usuario El nombre de usuario a validar.
     * @return true si el usuario existe, false de lo contrario.
     * @throws PersistenciaException Si ocurre un error durante la operación de
     * persistencia.
     */
    public boolean validarUsuario(String usuario) throws PersistenciaException {
        String sentenciaSQL = "SELECT * FROM Clientes WHERE usuario = ?";

        try (
                // recursos
                Connection conexion = this.conexion.crearConexion(); // establecemos la conexion con la bd
                // Crear el statement o el comando donde ejecutamos la sentencia
                 PreparedStatement comandoSQL = conexion.prepareStatement(sentenciaSQL, Statement.RETURN_GENERATED_KEYS); // mandamos la sentencia y obtenemos de regreso la llave generada o el ID
                ) {

            comandoSQL.setString(1, usuario);

            // obtener el conjunto de resultados que tiene o contiene las llaves generadas durante el registro o inserción
            ResultSet registroGenerado = comandoSQL.executeQuery();

            return registroGenerado.next();

        } catch (Exception e) {
            LOG.log(Level.SEVERE, "No se pudo iniciar sesion", e);
            throw new PersistenciaException("No se pudo guardar el cliente ", e);
        }

    }

    /**
     * Inicia sesión de un usuario en la aplicación.
     *
     * @param usuario El nombre de usuario.
     * @param contra La contraseña del usuario.
     * @return true si la sesión se inicia correctamente, false de lo contrario.
     * @throws PersistenciaException Si ocurre un error durante la operación de
     * persistencia.
     */
    public boolean iniciarSesion(String usuario, String contra) throws PersistenciaException {
        //validar si usuario existe
        if (validarUsuario(usuario)) {
            String sentenciaSQL = "SELECT contraseña FROM Clientes WHERE usuario = ?";

            try (
                    // recursos
                    Connection conexion = this.conexion.crearConexion(); // establecemos la conexion con la bd
                    // Crear el statement o el comando donde ejecutamos la sentencia
                     PreparedStatement comandoSQL = conexion.prepareStatement(sentenciaSQL, Statement.RETURN_GENERATED_KEYS); // mandamos la sentencia y obtenemos de regreso la llave generada o el ID
                    ) {

                comandoSQL.setString(1, usuario);

                // obtener el conjunto de resultados que tiene o contiene las llaves generadas durante el registro o inserción
                ResultSet registroGenerado = comandoSQL.executeQuery();

                registroGenerado.next();
                String contraBD = registroGenerado.getString("contraseña");

                if (contraBD.equals(contra)) {
                    // Usuario y contraseña coinciden, inicio de sesión exitoso
                    System.out.println("Inicio de sesión exitoso de " + usuario);
                    return true;
                } else {
                    // Contraseña incorrecta
                    System.out.println("Contraseña incorrecta de " + usuario);
                    return false;
                }

            } catch (Exception e) {
                LOG.log(Level.SEVERE, "No se pudo iniciar sesion", e);
                throw new PersistenciaException("No se pudo guardar el cliente ", e);

            }

        } else {
            System.out.println("usuario no existe");
            return false;
        }
    }

    /**
     * Obtiene el ID de un cliente dado su nombre de usuario.
     *
     * @param usuario El nombre de usuario del cliente.
     * @return El ID del cliente.
     * @throws PersistenciaException Si ocurre un error durante la operación de
     * persistencia.
     */
    public String obtenerIdCliente(String usuario) throws PersistenciaException {
        String sentenciaSQL = "SELECT id_cliente FROM Clientes WHERE usuario = ?";
        String idCliente = null;  // Variable para almacenar el resultado

        try (
                // recursos
                Connection conexion = this.conexion.crearConexion(); PreparedStatement comandoSQL = conexion.prepareStatement(sentenciaSQL);) {
            comandoSQL.setString(1, usuario);

            try (ResultSet resultado = comandoSQL.executeQuery()) {
                if (resultado.next()) {
                    idCliente = resultado.getString("id_cliente");
                }
            }

        } catch (SQLException e) {
            LOG.log(Level.SEVERE, "Error", e);
            throw new PersistenciaException("Error", e);
        }

        return idCliente;
    }

    /**
     * Busca un cliente en la base de datos por su ID.
     *
     * @param idCliente El ID del cliente a buscar.
     * @return El cliente encontrado, o null si no se encuentra.
     * @throws PersistenciaException Si ocurre un error durante la operación de
     * persistencia.
     */
    @Override
    public Cliente buscarClientePorId(int idCliente) throws PersistenciaException {
        String sentenciaSQL = "SELECT * FROM Clientes WHERE id_cliente = ?";

        try (
                // recursos
                Connection conexion = this.conexion.crearConexion(); // establecemos la conexion con la bd
                // Crear el statement o el comando donde ejecutamos la sentencia
                 PreparedStatement comandoSQL = conexion.prepareStatement(sentenciaSQL); // mandamos la sentencia y obtenemos de regreso la llave generada o el ID
                ) {
            comandoSQL.setInt(1, idCliente);

            try (ResultSet resultado = comandoSQL.executeQuery()) {
                if (resultado.next()) {
                    // Construir un objeto Cliente basado en los datos obtenidos de la consulta
                    Cliente cliente = new Cliente(
                            resultado.getInt("id_cliente"),
                            resultado.getString("nombre"),
                            resultado.getString("apellido_paterno"),
                            resultado.getString("apellido_materno"),
                            resultado.getString("fechaNacimiento"),
                            resultado.getString("usuario"),
                            resultado.getString("contraseña"),
                            resultado.getString("codigoPostal"),
                            resultado.getString("ciudad"),
                            resultado.getString("calle"),
                            resultado.getString("colonia"),
                            resultado.getString("numeroExterior")
                    );
                    return cliente;
                }
            }
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, "Error al buscar cliente por ID", e);
            throw new PersistenciaException("Error al buscar cliente por ID", e);
        }

        // Si no se encuentra ningún cliente con el ID dado, se retorna null
        return null;
    }

    /**
     * Modifica los datos de un cliente en la base de datos.
     *
     * @param idCliente El ID del cliente a modificar.
     * @param cliente El objeto ClienteDTO con los nuevos datos del cliente.
     * @return El cliente modificado.
     * @throws PersistenciaException Si ocurre un error durante la operación de
     * persistencia.
     */
    @Override
    public Cliente modifcarClientePorID(String idCliente, ClienteDTO cliente) throws PersistenciaException {
        // 1. Crear la sentencia SQL que vamos a mandar a la BD
        String sentenciaSQL = "UPDATE CLIENTES SET nombre=?, apellido_paterno=?, apellido_materno=?, fechaNacimiento=?, usuario=?, contraseña=?, codigoPostal=?, calle=?, numeroExterior=?, colonia=?, ciudad=? WHERE id_cliente=?";

        // 2. Vamos a insertar o intentar hacer la inserción en la tabla
        try (
                // recursos
                Connection conexion = this.conexion.crearConexion(); // establecemos la conexion con la bd
                // Creaqqq  r el statement o el comando donde ejecutamos la sentencia
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
            int idClienteInt = Integer.parseInt(idCliente);
            comandoSQL.setInt(12, idClienteInt);

            // 4. Ejecutamos el comando o lo enviamos a la BD
            int registrosModificados = comandoSQL.executeUpdate();
            LOG.log(Level.INFO, "Se agregaron con éxito {0} ", registrosModificados);

            return buscarClientePorId(idClienteInt);

        } catch (Exception e) {
            LOG.log(Level.SEVERE, "No se agregó con éxito el cliente", e);
            throw new PersistenciaException("No se pudo guardar el cliente ", e);
        }
    }

}

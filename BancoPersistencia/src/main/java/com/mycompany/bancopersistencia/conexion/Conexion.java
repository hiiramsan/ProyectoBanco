/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bancopersistencia.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Carlos
 */
public class Conexion implements IConexion {
    final String cadenaConexion;
    final String usuario;
    final String contra;
    private static final Logger LOG = Logger.getLogger(Conexion.class.getName());
    
    /**
     * Constructor de la clase Conexion.
     * Inicializa una instancia de Conexion con la cadena de conexión, el nombre de usuario y la contraseña proporcionados.
     * 
     * @param cadenaConexion La cadena de conexión a la base de datos.
     * @param usuario El nombre de usuario para la conexión.
     * @param contra La contraseña para la conexión.
     */
    public Conexion(String cadenaConexion, String usuario, String contra) {
        this.cadenaConexion = cadenaConexion;
        this.usuario = usuario;
        this.contra = contra;
    }

    // Métodos
    
    /**
     * Crea y establece una conexión a la base de datos.
     * 
     * @return La conexión establecida.
     * @throws SQLException Si ocurre un error durante la conexión.
     */
    public Connection crearConexion() throws SQLException {
        Connection conexion = DriverManager.getConnection(cadenaConexion, usuario, contra);
        LOG.log(Level.INFO, "Conexion establecida: {0}", cadenaConexion);
        return conexion;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.bancopersistencia.conexion;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Interfaz que define un método para crear una conexión a la base de datos.
 *
 * @author Armenta Baca Jose Maria, Carlos Hiram Sanchez Meneses
 */
public interface IConexion {

    /**
     * Crea y establece una conexión a la base de datos.
     *
     * @return La conexión establecida.
     * @throws SQLException Si ocurre un error durante la conexión.
     */
    public Connection crearConexion() throws SQLException;
}

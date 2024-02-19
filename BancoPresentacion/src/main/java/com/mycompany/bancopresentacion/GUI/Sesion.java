/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bancopresentacion.GUI;

/**
 *
 * @author Armenta Baca Jose Maria, Carlos Hiram Sanchez Meneses
 */
public class Sesion {
    private static String usuario;
    private static String idCliente;
    
     /**
     * Obtiene el nombre de usuario de la sesión.
     * @return El nombre de usuario actual.
     */
    public static String getUsuario() {
        return usuario;
    }

    /**
     * Establece el nombre de usuario para la sesión actual.
     * @param usuario El nombre de usuario a establecer.
     */
    public static void setUsuario(String usuario) {
        Sesion.usuario = usuario;
    }   

    /**
     * Obtiene el ID del cliente de la sesión.
     * @return El ID del cliente actual.
     */
    public static String getIdCliente() {
        return idCliente;
    }

    /**
     * Establece el ID del cliente para la sesión actual.
     * @param idCliente El ID del cliente a establecer.
     */
    public static void setIdCliente(String idCliente) {
        Sesion.idCliente = idCliente;
    }
    
     
}

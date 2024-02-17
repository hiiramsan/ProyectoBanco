/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bancopresentacion.GUI;

/**
 *
 * @author carlo
 */
public class Sesion {
    private static String usuario;
    private static String idCliente;
    
    public static String getUsuario() {
        return usuario;
    }

    public static void setUsuario(String usuario) {
        Sesion.usuario = usuario;
    }   

    public static String getIdCliente() {
        return idCliente;
    }

    public static void setIdCliente(String idCliente) {
        Sesion.idCliente = idCliente;
    }
    
     
}

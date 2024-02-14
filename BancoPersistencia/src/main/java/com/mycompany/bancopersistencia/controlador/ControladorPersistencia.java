/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bancopersistencia.controlador;

import bancoblue.bancodominio.Cliente;
import bancoblue.bancodominio.Cuenta;
import com.mycompany.bancopersistencia.conexion.Conexion;
import com.mycompany.bancopersistencia.conexion.IConexion;
import com.mycompany.bancopersistencia.dtos.ClienteDTO;
import com.mycompany.bancopersistencia.dtos.CuentaDTO;
import com.mycompany.bancopersistencia.persistencia.PersistenciaException;

/**
 *
 * @author PC
 */
public class ControladorPersistencia {
    String cadenaConexion = "jdbc:mysql://localhost:3306/banco";
    String usuario = "root";
    String contrasenia = "Itson";
    IConexion conexionBD = new Conexion(cadenaConexion, usuario, contrasenia);
    
    public Cliente agregarCuenta(ClienteDTO cliente) throws PersistenciaException {
        Cliente clienteAgregado = new Cliente();
        return clienteAgregado;
    }
    
    public Cuenta agregarCuenta(CuentaDTO cliente) throws PersistenciaException {
        Cuenta cuentaAgregada = new Cuenta();
        return cuentaAgregada;
    }
}

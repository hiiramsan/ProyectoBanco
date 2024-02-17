/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.banconegocio;

import bancoblue.bancodominio.Cliente;
import bancoblue.bancodominio.Cuenta;
import com.mycompany.banconegocio.validadores.Encriptador;
import com.mycompany.bancopersistencia.controlador.ControladorPersistencia;
import com.mycompany.bancopersistencia.dtos.ClienteDTO;
import com.mycompany.bancopersistencia.dtos.CuentaDTO;
import com.mycompany.bancopersistencia.persistencia.PersistenciaException;
import java.util.List;

/**
 *
 * @author carlo
 */
public class ControladorNegocio {
  ControladorPersistencia controladorPersistencia = new ControladorPersistencia();
  
   public Cliente agregarCliente(ClienteDTO cliente) throws PersistenciaException {
       cliente.setContraseña(Encriptador.encriptar(cliente.getContraseña()));
       return controladorPersistencia.agregarCliente(cliente);
    }
   
   public Cuenta agregarCuenta(CuentaDTO cuenta) throws PersistenciaException  {
       return controladorPersistencia.agregarCuenta(cuenta);
   }
   
   public boolean validarCuenta(String usuario) throws PersistenciaException {
       return controladorPersistencia.validarUsuario(usuario);
   }
   
   public boolean iniciarSesion(String usuario, String contra) throws PersistenciaException {
       contra = Encriptador.desencriptar(contra);
       return controladorPersistencia.iniciarSesion(usuario, contra);
   }
   
   public String obtenerIdCliente(String usuario) throws PersistenciaException {
       return controladorPersistencia.obtenerIdCliente(usuario);
   }
   
   public List<String> obtenerCuentas(String id_cliente) throws PersistenciaException {
       return controladorPersistencia.obtenerCuentas(id_cliente);
   }
} 

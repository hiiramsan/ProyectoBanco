/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.banconegocio;

import bancoblue.bancodominio.Cliente;
import bancoblue.bancodominio.Cuenta;
import com.mycompany.bancopersistencia.controlador.ControladorPersistencia;
import com.mycompany.bancopersistencia.dtos.ClienteDTO;
import com.mycompany.bancopersistencia.dtos.CuentaDTO;
import com.mycompany.bancopersistencia.persistencia.PersistenciaException;

/**
 *
 * @author carlo
 */
public class ControladorNegocio {
  ControladorPersistencia controladorPersistencia = new ControladorPersistencia();
  
   public Cliente agregarCliente(ClienteDTO cliente) throws PersistenciaException {
       return controladorPersistencia.agregarCliente(cliente);
    }
   
   public Cuenta agregarCuenta(CuentaDTO cuenta) throws PersistenciaException  {
       return controladorPersistencia.agregarCuenta(cuenta);
   }
}

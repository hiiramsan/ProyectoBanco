/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.banconegocio;

import bancoblue.bancodominio.Cliente;
import bancoblue.bancodominio.Cuenta;
import bancoblue.bancodominio.RetiroSinCuenta;
import bancoblue.bancodominio.Transaccion;
import com.mycompany.banconegocio.validadores.Encriptador;
import com.mycompany.bancopersistencia.controlador.ControladorPersistencia;
import com.mycompany.bancopersistencia.dtos.ClienteDTO;
import com.mycompany.bancopersistencia.dtos.CuentaDTO;
import com.mycompany.bancopersistencia.dtos.RetiroSinCuentaDTO;
import com.mycompany.bancopersistencia.persistencia.PersistenciaException;
import java.sql.Date;
import java.util.List;
import javax.swing.JOptionPane;

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

    public Cuenta agregarCuenta(CuentaDTO cuenta) throws PersistenciaException {
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

    public Cliente buscarClientePorId(int idCliente) throws PersistenciaException {
        return controladorPersistencia.buscarClientePorId(idCliente);
    }

    public Cliente modifcarClientePorID(String idCliente, ClienteDTO cliente) throws PersistenciaException {
        cliente.setContraseña(Encriptador.encriptar(cliente.getContraseña()));
        return controladorPersistencia.modificarClientePorId(idCliente, cliente);
    }

    public Cuenta obtenerCuentaPorNumCuentas(String numeroCuenta) throws PersistenciaException {
        return controladorPersistencia.obtenerCuentaPorNumeroCuenta(numeroCuenta);
    }

    public void modificarSaldoPorId(int idCuenta, double nuevoSaldo) throws PersistenciaException {
        controladorPersistencia.modificarSaldoPorId(idCuenta, nuevoSaldo);
    }

    public boolean cobrarRetiroSinCuenta(int folio, String contraseña) throws PersistenciaException {
        return controladorPersistencia.cobrarRetiroSinCuenta(folio, contraseña);
    }

    public String generarContraseña() throws PersistenciaException {
        return controladorPersistencia.generarContraseña();
    }
    
    public boolean insertarRetiroSinTarjeta(RetiroSinCuentaDTO retiro) throws PersistenciaException {
        return controladorPersistencia.insertarRetiroSinTarjeta(retiro);
    }
    
    public int obtenerUltimoFolioUtilizado() throws PersistenciaException {
        return controladorPersistencia.obtenerUltimoFolioUtilizado();
    }
    
    public boolean realizarTransferencia(int cuentaOrigen, int cuentaDestino, int monto) throws PersistenciaException {
        if(controladorPersistencia.validarNumCuenta(cuentaDestino)) {
            return controladorPersistencia.realizarTransferencia(cuentaOrigen, cuentaDestino, monto);
        } else {
            
            return false;
            
        } 
    }
    
    public boolean cancelarCuentaPorId(int idCuenta) throws PersistenciaException {
        if(cuentaTieneSaldo(idCuenta)) {
            return false;
        } else {
            controladorPersistencia.cancelarCuentaPorId(idCuenta);
            return true;
        }
        
    }
    
    public List<Transaccion> obtenerHistorialTransacciones(String tipoTransaccion, String fechaInicio, String fechaFin) throws PersistenciaException{
        return controladorPersistencia.obtenerHistorialTransacciones(tipoTransaccion, fechaInicio, fechaFin);
    }
    
    public boolean cuentaTieneSaldo(int numCuenta) throws PersistenciaException {
        return controladorPersistencia.cuentaTieneSaldo(numCuenta);
    }
    
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bancopersistencia.controlador;

import bancoblue.bancodominio.Cliente;
import bancoblue.bancodominio.Cuenta;
import bancoblue.bancodominio.RetiroSinCuenta;
import bancoblue.bancodominio.Transaccion;
import com.mycompany.bancopersistencia.conexion.Conexion;
import com.mycompany.bancopersistencia.conexion.IConexion;
import com.mycompany.bancopersistencia.daos.ClienteDAO;
import com.mycompany.bancopersistencia.daos.CuentaDAO;
import com.mycompany.bancopersistencia.daos.HistorialDAO;
import com.mycompany.bancopersistencia.daos.IClienteDAO;
import com.mycompany.bancopersistencia.daos.ICuentaDAO;
import com.mycompany.bancopersistencia.daos.IHistorialDAO;
import com.mycompany.bancopersistencia.daos.IRetiroSinCuentaDAO;
import com.mycompany.bancopersistencia.daos.ITransferenciaDAO;
import com.mycompany.bancopersistencia.daos.RetiroSinCuentaDAO;
import com.mycompany.bancopersistencia.daos.TransferenciaDAO;
import com.mycompany.bancopersistencia.dtos.ClienteDTO;
import com.mycompany.bancopersistencia.dtos.CuentaDTO;
import com.mycompany.bancopersistencia.dtos.RetiroSinCuentaDTO;
import com.mycompany.bancopersistencia.persistencia.PersistenciaException;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author PC
 */
public class ControladorPersistencia {
    String cadenaConexion = "jdbc:mysql://localhost:3306/banco";
    String usuario = "root";
    String contrasenia = "messi";
    IConexion conexionBD = new Conexion(cadenaConexion, usuario, contrasenia);
    IClienteDAO clienteDAO = new ClienteDAO(conexionBD);
    ICuentaDAO cuentaDAO = new CuentaDAO(conexionBD);
    IRetiroSinCuentaDAO retiroSinCuentaDAO= new RetiroSinCuentaDAO(conexionBD);
    ITransferenciaDAO transferenciaDAO = new TransferenciaDAO(conexionBD);
    IHistorialDAO historialDAO = new HistorialDAO(conexionBD);
    
    public Cliente agregarCliente(ClienteDTO cliente) throws PersistenciaException {
        Cliente clienteAgregado = this.clienteDAO.agregarCliente(cliente);
        return clienteAgregado;
    }
    
    public Cuenta agregarCuenta(CuentaDTO cuenta) throws PersistenciaException {
        Cuenta cuentaAgregada = this.cuentaDAO.agregarCuenta(cuenta);
        return cuentaAgregada;
    }
    
    public boolean validarUsuario(String usuario) throws PersistenciaException {
        Boolean usuarioValido = this.clienteDAO.validarUsuario(usuario);
        return usuarioValido;
    }
    
    public boolean iniciarSesion(String usuario, String contra) throws PersistenciaException {
        Boolean usuarioIniciado = this.clienteDAO.iniciarSesion(usuario, contra);
        return usuarioIniciado;
    }
    
    public List<String> obtenerCuentas(String id_cliente) throws PersistenciaException {
        return this.cuentaDAO.obtenerCuentas(id_cliente);
    }
    
    public String obtenerIdCliente(String usuario) throws PersistenciaException {
        return this.clienteDAO.obtenerIdCliente(usuario);
    }
    
    public Cliente buscarClientePorId(int idCliente) throws PersistenciaException {
        return this.clienteDAO.buscarClientePorId(idCliente);
    }
    
    public Cliente modifcarClientePorID(String idCliente, ClienteDTO cliente) throws PersistenciaException {
        return this.clienteDAO.modifcarClientePorID(idCliente, cliente);
    }
    
    public Cuenta obtenerCuentaPorNumCuentas(String numeroCuenta) throws PersistenciaException {
        return this.cuentaDAO.obtenerCuentaPorNumCuentas(numeroCuenta);
    }
    
    public void modificarSaldoPorId(int idCuenta, double nuevoSaldo) throws PersistenciaException {
        this.cuentaDAO.modificarSaldoPorId(idCuenta, nuevoSaldo);
    }
    
    public boolean cobrarRetiroSinCuenta(int folio, String contraseña) throws PersistenciaException{
        return this.retiroSinCuentaDAO.cobrarRetiroSinCuenta(folio, contraseña);
    }
    
    public String generarContraseña()throws PersistenciaException{
        return this.retiroSinCuentaDAO.generarContraseña();
    }
    
    public boolean insertarRetiroSinTarjeta(RetiroSinCuentaDTO retiro) throws PersistenciaException {
        return this.retiroSinCuentaDAO.insertarRetiroSinTarjeta(retiro);
    }
    
    public int obtenerUltimoFolioUtilizado() throws PersistenciaException {
        return this.retiroSinCuentaDAO.obtenerUltimoFolioUtilizado();
    }
    
    public boolean realizarTransferencia(int cuentaOrigen, int cuentaDestino, int monto) throws PersistenciaException {
        return this.transferenciaDAO.realizarTransferencia(cuentaOrigen, cuentaDestino, monto);
    }
    
    public void cancelarCuentaPorId(int idCuenta) throws PersistenciaException {
       this.cuentaDAO.cancelarCuentaPorId(idCuenta);
    }
    
    public List<Transaccion> obtenerHistorialTransacciones(String tipoTransaccion, String fechaInicio, String fechaFin) throws PersistenciaException{
        return historialDAO.obtenerHistorialTransacciones(tipoTransaccion, fechaInicio, fechaFin);
    }
}

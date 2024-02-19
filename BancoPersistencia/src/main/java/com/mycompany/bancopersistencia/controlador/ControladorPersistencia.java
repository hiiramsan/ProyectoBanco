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
 * @author Armenta Baca Jose Maria, Carlos Hiram Sanchez Meneses
 */
public class ControladorPersistencia {

    String cadenaConexion = "jdbc:mysql://localhost:3306/banco";
    String usuario = "root";
    String contrasenia = "messi";
    IConexion conexionBD = new Conexion(cadenaConexion, usuario, contrasenia);
    IClienteDAO clienteDAO = new ClienteDAO(conexionBD);
    ICuentaDAO cuentaDAO = new CuentaDAO(conexionBD);
    IRetiroSinCuentaDAO retiroSinCuentaDAO = new RetiroSinCuentaDAO(conexionBD);
    ITransferenciaDAO transferenciaDAO = new TransferenciaDAO(conexionBD);
    IHistorialDAO historialDAO = new HistorialDAO(conexionBD);

    /**
     * Agrega un cliente a la base de datos.
     *
     * @param cliente El cliente a agregar.
     * @return El cliente agregado.
     * @throws PersistenciaException Si ocurre un error durante la persistencia.
     */
    public Cliente agregarCliente(ClienteDTO cliente) throws PersistenciaException {
        Cliente clienteAgregado = this.clienteDAO.agregarCliente(cliente);
        return clienteAgregado;
    }

    /**
     * Agrega una cuenta a la base de datos.
     *
     * @param cuenta La cuenta a agregar.
     * @return La cuenta agregada.
     * @throws PersistenciaException Si ocurre un error durante la persistencia.
     */
    public Cuenta agregarCuenta(CuentaDTO cuenta) throws PersistenciaException {
        Cuenta cuentaAgregada = this.cuentaDAO.agregarCuenta(cuenta);
        return cuentaAgregada;
    }

    /**
     * Valida si un usuario existe en la base de datos.
     *
     * @param usuario El usuario a validar.
     * @return true si el usuario es válido, false de lo contrario.
     * @throws PersistenciaException Si ocurre un error durante la persistencia.
     */
    public boolean validarUsuario(String usuario) throws PersistenciaException {
        Boolean usuarioValido = this.clienteDAO.validarUsuario(usuario);
        return usuarioValido;
    }

    /**
     * Inicia sesión para un usuario en la base de datos.
     *
     * @param usuario El usuario.
     * @param contra La contraseña.
     * @return true si la sesión se inicia correctamente, false de lo contrario.
     * @throws PersistenciaException Si ocurre un error durante la persistencia.
     */
    public boolean iniciarSesion(String usuario, String contra) throws PersistenciaException {
        Boolean usuarioIniciado = this.clienteDAO.iniciarSesion(usuario, contra);
        return usuarioIniciado;
    }

    /**
     * Obtiene las cuentas asociadas a un cliente.
     *
     * @param id_cliente El identificador del cliente.
     * @return Una lista de números de cuentas asociadas al cliente.
     * @throws PersistenciaException Si ocurre un error durante la persistencia.
     */
    public List<String> obtenerCuentas(String id_cliente) throws PersistenciaException {
        return this.cuentaDAO.obtenerCuentas(id_cliente);
    }

    /**
     * Obtiene el identificador de cliente asociado a un usuario.
     *
     * @param usuario El usuario.
     * @return El identificador del cliente.
     * @throws PersistenciaException Si ocurre un error durante la persistencia.
     */
    public String obtenerIdCliente(String usuario) throws PersistenciaException {
        return this.clienteDAO.obtenerIdCliente(usuario);
    }

    /**
     * Busca un cliente por su identificador.
     *
     * @param idCliente El identificador del cliente.
     * @return El cliente encontrado.
     * @throws PersistenciaException Si ocurre un error durante la persistencia.
     */
    public Cliente buscarClientePorId(int idCliente) throws PersistenciaException {
        return this.clienteDAO.buscarClientePorId(idCliente);
    }

    /**
     * Modifica los datos de un cliente por su identificador.
     *
     * @param idCliente El identificador del cliente a modificar.
     * @param cliente Los nuevos datos del cliente.
     * @return El cliente modificado.
     * @throws PersistenciaException Si ocurre un error durante la persistencia.
     */
    public Cliente modificarClientePorId(String idCliente, ClienteDTO cliente) throws PersistenciaException {
        return this.clienteDAO.modifcarClientePorID(idCliente, cliente);
    }

    /**
     * Obtiene una cuenta por su número de cuenta.
     *
     * @param numeroCuenta El número de cuenta.
     * @return La cuenta encontrada.
     * @throws PersistenciaException Si ocurre un error durante la persistencia.
     */
    public Cuenta obtenerCuentaPorNumeroCuenta(String numeroCuenta) throws PersistenciaException {
        return this.cuentaDAO.obtenerCuentaPorNumCuentas(numeroCuenta);
    }

    /**
     * Modifica el saldo de una cuenta por su identificador.
     *
     * @param idCuenta El identificador de la cuenta.
     * @param nuevoSaldo El nuevo saldo.
     * @throws PersistenciaException Si ocurre un error durante la persistencia.
     */
    public void modificarSaldoPorId(int idCuenta, double nuevoSaldo) throws PersistenciaException {
        this.cuentaDAO.modificarSaldoPorId(idCuenta, nuevoSaldo);
    }

    /**
     * Cobra un retiro sin tarjeta.
     *
     * @param folio El folio de la transacción.
     * @param contraseña La contraseña asociada al retiro.
     * @return true si se realiza el cobro correctamente, false de lo contrario.
     * @throws PersistenciaException Si ocurre un error durante la persistencia.
     */
    public boolean cobrarRetiroSinCuenta(int folio, String contraseña) throws PersistenciaException {
        return this.retiroSinCuentaDAO.cobrarRetiroSinCuenta(folio, contraseña);
    }

    /**
     * Genera una contraseña para un retiro sin tarjeta.
     *
     * @return La contraseña generada.
     * @throws PersistenciaException Si ocurre un error durante la persistencia.
     */
    public String generarContraseña() throws PersistenciaException {
        return this.retiroSinCuentaDAO.generarContraseña();
    }

    /**
     * Inserta un retiro sin tarjeta en la base de datos.
     *
     * @param retiro El objeto RetiroSinCuentaDTO a insertar.
     * @return true si se inserta correctamente, false de lo contrario.
     * @throws PersistenciaException Si ocurre un error durante la persistencia.
     */
    public boolean insertarRetiroSinTarjeta(RetiroSinCuentaDTO retiro) throws PersistenciaException {
        return this.retiroSinCuentaDAO.insertarRetiroSinTarjeta(retiro);
    }

    /**
     * Obtiene el último folio utilizado para un retiro sin tarjeta.
     *
     * @return El último folio utilizado.
     * @throws PersistenciaException Si ocurre un error durante la persistencia.
     */
    public int obtenerUltimoFolioUtilizado() throws PersistenciaException {
        return this.retiroSinCuentaDAO.obtenerUltimoFolioUtilizado();
    }

    /**
     * Realiza una transferencia de fondos entre dos cuentas.
     *
     * @param cuentaOrigen El número de cuenta de origen.
     * @param cuentaDestino El número de cuenta de destino.
     * @param monto El monto a transferir.
     * @return true si la transferencia se realiza correctamente, false de lo
     * contrario.
     * @throws PersistenciaException Si ocurre un error durante la persistencia.
     */
    public boolean realizarTransferencia(int cuentaOrigen, int cuentaDestino, int monto) throws PersistenciaException {
        return this.transferenciaDAO.realizarTransferencia(cuentaOrigen, cuentaDestino, monto);
    }

    /**
     * Cancela una cuenta por su identificador.
     *
     * @param idCuenta El identificador de la cuenta a cancelar.
     * @throws PersistenciaException Si ocurre un error durante la persistencia.
     */
    public void cancelarCuentaPorId(int idCuenta) throws PersistenciaException {
        this.cuentaDAO.cancelarCuentaPorId(idCuenta);
    }

    /**
     * Obtiene el historial de transacciones de acuerdo a ciertos criterios.
     *
     * @param tipoTransaccion El tipo de transacción a filtrar (puede ser null
     * para no filtrar por tipo).
     * @param fechaInicio La fecha de inicio del intervalo de tiempo (en formato
     * YYYY-MM-DD).
     * @param fechaFin La fecha de fin del intervalo de tiempo (en formato
     * YYYY-MM-DD).
     * @return Una lista de Transacciones que cumplen con los criterios
     * especificados.
     * @throws PersistenciaException Si ocurre un error durante la persistencia.
     */
    public List<Transaccion> obtenerHistorialTransacciones(String tipoTransaccion, String fechaInicio, String fechaFin) throws PersistenciaException {
        return historialDAO.obtenerHistorialTransacciones(tipoTransaccion, fechaInicio, fechaFin);
    }

    /**
     * Valida si un número de cuenta es válido.
     *
     * @param numCuenta El número de cuenta a validar.
     * @return true si el número de cuenta es válido, false de lo contrario.
     */
    public boolean validarNumCuenta(int numCuenta) {
        return cuentaDAO.validarNumCuenta(numCuenta);
    }
    
    /**
     * Valida si una cuenta tiene saldo.
     *
     * @param numCuenta El número de cuenta a validar.
     * @return true si el tiene saldo, false de lo contrario.
     */
    public boolean cuentaTieneSaldo(int numeroCuenta) throws PersistenciaException {
        return cuentaDAO.cuentaTieneSaldo(numeroCuenta);
    }
}

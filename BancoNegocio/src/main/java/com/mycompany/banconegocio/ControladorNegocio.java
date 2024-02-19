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
 * @author Armenta Baca Jose Maria, Carlos Hiram Sanchez Meneses
 */
public class ControladorNegocio {

    ControladorPersistencia controladorPersistencia = new ControladorPersistencia();

    /**
     * Agrega un cliente a la base de datos.
     *
     * @param cliente El cliente a agregar.
     * @return El cliente agregado.
     * @throws PersistenciaException Si ocurre un error durante la persistencia.
     */
    public Cliente agregarCliente(ClienteDTO cliente) throws PersistenciaException {
        cliente.setContraseña(Encriptador.encriptar(cliente.getContraseña()));
        return controladorPersistencia.agregarCliente(cliente);
    }

    /**
     * Agrega una cuenta a la base de datos.
     *
     * @param cuenta La cuenta a agregar.
     * @return La cuenta agregada.
     * @throws PersistenciaException Si ocurre un error durante la persistencia.
     */
    public Cuenta agregarCuenta(CuentaDTO cuenta) throws PersistenciaException {
        return controladorPersistencia.agregarCuenta(cuenta);
    }

    /**
     * Valida si un usuario existe en la base de datos.
     *
     * @param usuario El usuario a validar.
     * @return true si el usuario es válido, false de lo contrario.
     * @throws PersistenciaException Si ocurre un error durante la persistencia.
     */
    public boolean validarCuenta(String usuario) throws PersistenciaException {
        return controladorPersistencia.validarUsuario(usuario);
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
        contra = Encriptador.desencriptar(contra);
        return controladorPersistencia.iniciarSesion(usuario, contra);
    }

    /**
     * Obtiene el identificador de cliente asociado a un usuario.
     *
     * @param usuario El usuario.
     * @return El identificador del cliente.
     * @throws PersistenciaException Si ocurre un error durante la persistencia.
     */
    public String obtenerIdCliente(String usuario) throws PersistenciaException {
        return controladorPersistencia.obtenerIdCliente(usuario);
    }

    /**
     * Obtiene las cuentas asociadas a un cliente.
     *
     * @param id_cliente El identificador del cliente.
     * @return Una lista de números de cuentas asociadas al cliente.
     * @throws PersistenciaException Si ocurre un error durante la persistencia.
     */
    public List<String> obtenerCuentas(String id_cliente) throws PersistenciaException {
        return controladorPersistencia.obtenerCuentas(id_cliente);
    }

    /**
     * Busca un cliente por su identificador.
     *
     * @param idCliente El identificador del cliente.
     * @return El cliente encontrado.
     * @throws PersistenciaException Si ocurre un error durante la persistencia.
     */
    public Cliente buscarClientePorId(int idCliente) throws PersistenciaException {
        return controladorPersistencia.buscarClientePorId(idCliente);
    }

    /**
     * Modifica los datos de un cliente por su identificador.
     *
     * @param idCliente El identificador del cliente a modificar.
     * @param cliente Los nuevos datos del cliente.
     * @return El cliente modificado.
     * @throws PersistenciaException Si ocurre un error durante la persistencia.
     */
    public Cliente modifcarClientePorID(String idCliente, ClienteDTO cliente) throws PersistenciaException {
        cliente.setContraseña(Encriptador.encriptar(cliente.getContraseña()));
        return controladorPersistencia.modificarClientePorId(idCliente, cliente);
    }

    /**
     * Obtiene una cuenta por su número de cuenta.
     *
     * @param numeroCuenta El número de cuenta.
     * @return La cuenta encontrada.
     * @throws PersistenciaException Si ocurre un error durante la persistencia.
     */
    public Cuenta obtenerCuentaPorNumCuentas(String numeroCuenta) throws PersistenciaException {
        return controladorPersistencia.obtenerCuentaPorNumeroCuenta(numeroCuenta);
    }

    /**
     * Modifica el saldo de una cuenta por su identificador.
     *
     * @param idCuenta El identificador de la cuenta.
     * @param nuevoSaldo El nuevo saldo.
     * @throws PersistenciaException Si ocurre un error durante la persistencia.
     */
    public void modificarSaldoPorId(int idCuenta, double nuevoSaldo) throws PersistenciaException {
        controladorPersistencia.modificarSaldoPorId(idCuenta, nuevoSaldo);
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
        contraseña = Encriptador.desencriptar(contraseña);
        return controladorPersistencia.cobrarRetiroSinCuenta(folio, contraseña);
    }

    /**
     * Genera una contraseña para un retiro sin tarjeta.
     *
     * @return La contraseña generada.
     * @throws PersistenciaException Si ocurre un error durante la persistencia.
     */
    public String generarContraseña() throws PersistenciaException {
        return controladorPersistencia.generarContraseña();
    }

    /**
     * Inserta un retiro sin tarjeta en la base de datos.
     *
     * @param retiro El objeto RetiroSinCuentaDTO a insertar.
     * @return true si se inserta correctamente, false de lo contrario.
     * @throws PersistenciaException Si ocurre un error durante la persistencia.
     */
    public boolean insertarRetiroSinTarjeta(RetiroSinCuentaDTO retiro) throws PersistenciaException {
        // modificacion de encriptacion
        retiro.setContraseña(Encriptador.encriptar(retiro.getContraseña()));
        return controladorPersistencia.insertarRetiroSinTarjeta(retiro);
    }

    /**
     * Obtiene el último folio utilizado para un retiro sin tarjeta.
     *
     * @return El último folio utilizado.
     * @throws PersistenciaException Si ocurre un error durante la persistencia.
     */
    public int obtenerUltimoFolioUtilizado() throws PersistenciaException {
        return controladorPersistencia.obtenerUltimoFolioUtilizado();
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
        if (controladorPersistencia.validarNumCuenta(cuentaDestino)) {
            return controladorPersistencia.realizarTransferencia(cuentaOrigen, cuentaDestino, monto);
        } else {

            return false;

        }
    }

    /**
     * Cancela una cuenta por su identificador.
     *
     * @param idCuenta El identificador de la cuenta a cancelar.
     * @throws PersistenciaException Si ocurre un error durante la persistencia.
     */
    public boolean cancelarCuentaPorId(int idCuenta) throws PersistenciaException {
        if (cuentaTieneSaldo(idCuenta)) {
            return false;
        } else {
            controladorPersistencia.cancelarCuentaPorId(idCuenta);
            return true;
        }

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
        return controladorPersistencia.obtenerHistorialTransacciones(tipoTransaccion, fechaInicio, fechaFin);
    }

    /**
     * Valida si una cuenta tiene saldo.
     *
     * @param numCuenta El número de cuenta a validar.
     * @return true si el tiene saldo, false de lo contrario.
     */
    public boolean cuentaTieneSaldo(int numCuenta) throws PersistenciaException {
        return controladorPersistencia.cuentaTieneSaldo(numCuenta);
    }

}

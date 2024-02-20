/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.bancopersistencia.daos;

import bancoblue.bancodominio.Cuenta;
import com.mycompany.bancopersistencia.dtos.CuentaDTO;
import com.mycompany.bancopersistencia.persistencia.PersistenciaException;
import java.util.List;

/**
 *
 * @author Armenta Baca Jose Maria, Carlos Hiram Sanchez Meneses
 */
public interface ICuentaDAO {

    /**
     * Agrega una nueva cuenta a la base de datos.
     *
     * @param cuenta El objeto CuentaDTO que representa la cuenta a agregar.
     * @return La cuenta agregada.
     * @throws PersistenciaException Si ocurre un error durante la operación de
     * persistencia.
     */
    public Cuenta agregarCuenta(CuentaDTO cuenta) throws PersistenciaException;

    /**
     * Obtiene una lista de las cuentas asociadas a un cliente dado su ID.
     *
     * @param id_cliente El ID del cliente cuyas cuentas se desean obtener.
     * @return Una lista de cadenas que representan las cuentas y sus saldos.
     * @throws PersistenciaException Si ocurre un error durante la operación de
     * persistencia.
     */
    public List<String> obtenerCuentas(String id_cliente) throws PersistenciaException;

    /**
     * Obtiene una cuenta de la base de datos por su número de cuenta.
     *
     * @param numeroCuenta El número de cuenta de la cuenta deseada.
     * @return La cuenta encontrada, o null si no se encuentra.
     * @throws PersistenciaException Si ocurre un error durante la operación de
     * persistencia.
     */
    public Cuenta obtenerCuentaPorNumCuentas(String numeroCuenta) throws PersistenciaException;

    
    /**
     * Obtiene las cuentas canceladas asociadas a un cliente.
     *
     * @param id_cliente El ID del cliente.
     * @return Una lista de cadenas que representan las cuentas canceladas del cliente con
     * @throws PersistenciaException Si ocurre un error durante la operación de
     * persistencia.
     */
    public List<String> obtenerCuentasCanceladas(String id_cliente) throws PersistenciaException;
    
    /**
     * Modifica el saldo de una cuenta en la base de datos por su ID.
     *
     * @param idCuenta El ID de la cuenta cuyo saldo se desea modificar.
     * @param nuevoSaldo El nuevo saldo de la cuenta.
     * @throws PersistenciaException Si ocurre un error durante la operación de
     * persistencia.
     */
    public void modificarSaldoPorId(int idCuenta, double nuevoSaldo) throws PersistenciaException;

    /**
     * Cancela una cuenta en la base de datos por su ID.
     *
     * @param idCuenta El ID de la cuenta que se desea cancelar.
     * @throws PersistenciaException Si ocurre un error durante la operación de
     * persistencia.
     */
    public void cancelarCuentaPorId(int idCuenta) throws PersistenciaException;

    /**
     * Activa una cuenta en la base de datos por su ID.
     *
     * @param idCuenta El ID de la cuenta que se desea activar.
     * @throws PersistenciaException Si ocurre un error durante la operación de
     * persistencia.
     */
    public void activarCuentaPorId(int idCuenta) throws PersistenciaException;
    
    /**
     * Valida si un número de cuenta dado está activo en la base de datos.
     *
     * @param numCuenta El número de cuenta a validar.
     * @return true si la cuenta está activa, false si no lo está.
     */
    public boolean validarNumCuenta(int numCuenta);
    
    /**
     * Valida si una cuenta tiene saldo.
     *
     * @param numCuenta El número de cuenta a validar.
     * @return true si el tiene saldo, false de lo contrario.
     */
    public boolean cuentaTieneSaldo(int numCuenta)throws PersistenciaException;
}

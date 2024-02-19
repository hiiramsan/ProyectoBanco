/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.bancopersistencia.daos;

import bancoblue.bancodominio.Cliente;
import com.mycompany.bancopersistencia.dtos.ClienteDTO;
import com.mycompany.bancopersistencia.persistencia.PersistenciaException;
import java.util.List;

/**
 *
 * @author Armenta Baca Jose Maria, Carlos Hiram Sanchez Meneses
 */
public interface IClienteDAO {

    /**
     * Agrega un nuevo cliente a la base de datos.
     *
     * @param cliente El objeto ClienteDTO que representa al cliente a agregar.
     * @return El cliente agregado.
     * @throws PersistenciaException Si ocurre un error durante la operación de
     * persistencia.
     */
    public Cliente agregarCliente(ClienteDTO cliente) throws PersistenciaException;

    /**
     * Valida si un nombre de usuario ya está en uso en la base de datos.
     *
     * @param usuario El nombre de usuario a validar.
     * @return true si el usuario está disponible, false si ya está en uso.
     * @throws PersistenciaException Si ocurre un error durante la operación de
     * persistencia.
     */
    public boolean validarUsuario(String usuario) throws PersistenciaException;

    /**
     * Inicia sesión para un cliente dado su nombre de usuario y contraseña.
     *
     * @param usuario El nombre de usuario del cliente.
     * @param contra La contraseña del cliente.
     * @return true si la sesión se inicia correctamente, false si las
     * credenciales son incorrectas.
     * @throws PersistenciaException Si ocurre un error durante la operación de
     * persistencia.
     */
    public boolean iniciarSesion(String usuario, String contra) throws PersistenciaException;

    /**
     * Obtiene el ID de cliente dado su nombre de usuario.
     *
     * @param usuario El nombre de usuario del cliente.
     * @return El ID del cliente.
     * @throws PersistenciaException Si ocurre un error durante la operación de
     * persistencia.
     */
    public String obtenerIdCliente(String usuario) throws PersistenciaException;

    /**
     * Busca un cliente en la base de datos por su ID.
     *
     * @param idCliente El ID del cliente a buscar.
     * @return El cliente encontrado, o null si no se encuentra.
     * @throws PersistenciaException Si ocurre un error durante la operación de
     * persistencia.
     */
    public Cliente buscarClientePorId(int idCliente) throws PersistenciaException;

    /**
     * Modifica un cliente existente en la base de datos.
     *
     * @param idCliente El ID del cliente a modificar.
     * @param cliente El objeto ClienteDTO con los nuevos datos del cliente.
     * @return El cliente modificado.
     * @throws PersistenciaException Si ocurre un error durante la operación de
     * persistencia.
     */
    public Cliente modifcarClientePorID(String idCliente, ClienteDTO cliente) throws PersistenciaException;
}

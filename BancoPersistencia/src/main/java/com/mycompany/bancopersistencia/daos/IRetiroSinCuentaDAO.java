/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.bancopersistencia.daos;

import bancoblue.bancodominio.RetiroSinCuenta;
import com.mycompany.bancopersistencia.dtos.RetiroSinCuentaDTO;
import com.mycompany.bancopersistencia.persistencia.PersistenciaException;

/**
 *
 * @author PC
 */
public interface IRetiroSinCuentaDAO {

    /**
     * Inserta un retiro sin tarjeta en la base de datos.
     *
     * @param retiro El objeto RetiroSinCuentaDTO que contiene la información
     * del retiro.
     * @return true si el retiro se inserta correctamente, false en caso
     * contrario.
     * @throws PersistenciaException Si ocurre un error durante la operación de
     * persistencia.
     */
    public boolean insertarRetiroSinTarjeta(RetiroSinCuentaDTO retiro) throws PersistenciaException;

    /**
     * Genera una contraseña para el retiro sin tarjeta.
     *
     * @return La contraseña generada.
     * @throws PersistenciaException Si ocurre un error durante la generación de
     * la contraseña.
     */
    public String generarContraseña() throws PersistenciaException;

    /**
     * Obtiene el último folio utilizado para un retiro sin tarjeta.
     *
     * @return El último folio utilizado.
     * @throws PersistenciaException Si ocurre un error durante la obtención del
     * último folio.
     */
    public int obtenerUltimoFolioUtilizado() throws PersistenciaException;

    /**
     * Cobra un retiro sin tarjeta utilizando el folio y la contraseña
     * proporcionados.
     *
     * @param folio El folio del retiro.
     * @param contraseña La contraseña asociada al retiro.
     * @return true si el retiro se cobra correctamente, false en caso
     * contrario.
     * @throws PersistenciaException Si ocurre un error durante la operación de
     * cobro del retiro.
     */
    public boolean cobrarRetiroSinCuenta(int folio, String contraseña) throws PersistenciaException;
}

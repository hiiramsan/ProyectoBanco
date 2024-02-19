/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.bancopersistencia.daos;

import com.mycompany.bancopersistencia.persistencia.PersistenciaException;

/**
 *
 * @author PC
 */
public interface ITransferenciaDAO {

    /**
     * Realiza una transferencia de dinero entre dos cuentas.
     *
     * @param cuentaOrigen El número de cuenta de origen.
     * @param cuentaDestino El número de cuenta de destino.
     * @param monto El monto a transferir.
     * @return true si la transferencia se realiza con éxito, false en caso
     * contrario.
     * @throws PersistenciaException Si ocurre un error durante la operación de
     * transferencia.
     */
    public boolean realizarTransferencia(int cuentaOrigen, int cuentaDestino, int monto) throws PersistenciaException;

}

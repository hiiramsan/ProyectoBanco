/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.bancopersistencia.daos;

import bancoblue.bancodominio.RetiroSinCuenta;
import com.mycompany.bancopersistencia.persistencia.PersistenciaException;

/**
 *
 * @author PC
 */
public interface IRetiroSinCuentaDAO {
    
    public void insertarRetiroSinTarjeta(RetiroSinCuenta retiro) throws PersistenciaException;
    public String generarContraseña() throws PersistenciaException;
    public int obtenerUltimoFolioUtilizado() throws PersistenciaException;
    public void cobrarRetiroSinCuenta(int folio, String contraseña) throws PersistenciaException;
}

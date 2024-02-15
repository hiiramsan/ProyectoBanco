/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.bancopersistencia.daos;

import bancoblue.bancodominio.Cuenta;
import com.mycompany.bancopersistencia.dtos.CuentaDTO;
import com.mycompany.bancopersistencia.persistencia.PersistenciaException;

/**
 *
 * @author PC
 */
public interface ICuentaDAO {
    
    
    public Cuenta agregarCuenta(CuentaDTO cuenta) throws PersistenciaException;
}

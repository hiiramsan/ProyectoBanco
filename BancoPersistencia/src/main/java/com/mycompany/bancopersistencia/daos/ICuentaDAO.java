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
 * @author PC
 */
public interface ICuentaDAO {
    
    
    public Cuenta agregarCuenta(CuentaDTO cuenta) throws PersistenciaException;
    
    public List<String> obtenerCuentas(String id_cliente) throws PersistenciaException;
    
    public Cuenta obtenerCuentaPorNumCuentas(String numeroCuenta) throws PersistenciaException;
    
    public void modificarSaldoPorId(int idCuenta, double nuevoSaldo) throws PersistenciaException;
    
    public void cancelarCuentaPorId(int idCuenta) throws PersistenciaException;
}

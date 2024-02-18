/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.bancopersistencia.daos;

import bancoblue.bancodominio.Transaccion;
import com.mycompany.bancopersistencia.persistencia.PersistenciaException;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author carlo
 */
public interface IHistorialDAO {
   public List<Transaccion> obtenerHistorialTransacciones(String tipoTransaccion, String fechaInicio, String fechaFin) throws PersistenciaException; 
}

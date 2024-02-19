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

    /**
     * Obtiene el historial de transacciones filtrado por tipo y rango de
     * fechas.
     *
     * @param tipoTransaccion El tipo de transacción a filtrar (por ejemplo,
     * "Depósito", "Retiro").
     * @param fechaInicio La fecha de inicio del rango de búsqueda en formato
     * "YYYY-MM-DD".
     * @param fechaFin La fecha de fin del rango de búsqueda en formato
     * "YYYY-MM-DD".
     * @return Una lista de objetos Transaccion que representan las
     * transacciones encontradas.
     * @throws PersistenciaException Si ocurre un error durante la operación de
     * persistencia.
     */
    public List<Transaccion> obtenerHistorialTransacciones(String tipoTransaccion, String fechaInicio, String fechaFin) throws PersistenciaException;
}

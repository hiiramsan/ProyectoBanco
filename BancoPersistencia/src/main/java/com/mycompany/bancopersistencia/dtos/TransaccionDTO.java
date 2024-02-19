/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bancopersistencia.dtos;

/**
 *
 * @author PC
 */
public class TransaccionDTO {

    private String fecha_hora;
    private int monto;
    private String tipo_transaccion;
    private int cuenta_origen;

    /**
     * Constructor para inicializar un objeto TransaccionDTO con todos sus
     * atributos.
     *
     * @param fecha_hora La fecha y hora de la transacción.
     * @param monto El monto de la transacción.
     * @param tipo_transaccion El tipo de transacción (p. ej., "Retiro",
     * "Depósito", etc.).
     * @param cuenta_origen El número de cuenta de origen de la transacción.
     */
    public TransaccionDTO(String fecha_hora, int monto, String tipo_transaccion, int cuenta_origen) {
        this.fecha_hora = fecha_hora;
        this.monto = monto;
        this.tipo_transaccion = tipo_transaccion;
        this.cuenta_origen = cuenta_origen;
    }

    // Getters y setters para todos los atributos
    /**
     * Obtiene la fecha y hora de la transacción.
     *
     * @return La fecha y hora de la transacción.
     */
    public String getFecha_hora() {
        return fecha_hora;
    }

    /**
     * Establece la fecha y hora de la transacción.
     *
     * @param fecha_hora La fecha y hora de la transacción a establecer.
     */
    public void setFecha_hora(String fecha_hora) {
        this.fecha_hora = fecha_hora;
    }

    /**
     * Obtiene el monto de la transacción.
     *
     * @return El monto de la transacción.
     */
    public int getMonto() {
        return monto;
    }

    /**
     * Establece el monto de la transacción.
     *
     * @param monto El monto de la transacción a establecer.
     */
    public void setMonto(int monto) {
        this.monto = monto;
    }

    /**
     * Obtiene el tipo de transacción.
     *
     * @return El tipo de transacción.
     */
    public String getTipo_transaccion() {
        return tipo_transaccion;
    }

    /**
     * Establece el tipo de transacción.
     *
     * @param tipo_transaccion El tipo de transacción a establecer.
     */
    public void setTipo_transaccion(String tipo_transaccion) {
        this.tipo_transaccion = tipo_transaccion;
    }

    /**
     * Obtiene el número de cuenta de origen de la transacción.
     *
     * @return El número de cuenta de origen de la transacción.
     */
    public int getCuenta_origen() {
        return cuenta_origen;
    }

    /**
     * Establece el número de cuenta de origen de la transacción.
     *
     * @param cuenta_origen El número de cuenta de origen de la transacción a
     * establecer.
     */
    public void setCuenta_origen(int cuenta_origen) {
        this.cuenta_origen = cuenta_origen;
    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bancopersistencia.dtos;

/**
 *
 * @author Armenta Baca Jose Maria, Carlos Hiram Sanchez Meneses
 */
public class RetiroSinCuentaDTO extends TransaccionDTO {

    private int folio_operacion;
    private String contraseña;
    private String estado;

    /**
     * Constructor para inicializar un objeto RetiroSinCuentaDTO con todos sus
     * atributos.
     *
     * @param folio_operacion El folio de la operación de retiro.
     * @param contraseña La contraseña asociada al retiro.
     * @param estado El estado del retiro.
     * @param fecha_hora La fecha y hora del retiro.
     * @param monto El monto del retiro.
     * @param cuenta_origen El número de cuenta de origen del retiro.
     */
    public RetiroSinCuentaDTO(int folio_operacion, String contraseña, String estado, String fecha_hora, int monto, int cuenta_origen) {
        super(fecha_hora, monto, "RetiroSinCuenta", cuenta_origen);
        this.folio_operacion = folio_operacion;
        this.contraseña = contraseña;
        this.estado = estado;
    }

    // Getters y setters para todos los atributos
    /**
     * Obtiene el folio de la operación de retiro.
     *
     * @return El folio de la operación de retiro.
     */
    public int getFolio_operacion() {
        return folio_operacion;
    }

    /**
     * Establece el folio de la operación de retiro.
     *
     * @param folio_operacion El folio de la operación de retiro a establecer.
     */
    public void setFolio_operacion(int folio_operacion) {
        this.folio_operacion = folio_operacion;
    }

    /**
     * Obtiene la contraseña asociada al retiro.
     *
     * @return La contraseña asociada al retiro.
     */
    public String getContraseña() {
        return contraseña;
    }

    /**
     * Establece la contraseña asociada al retiro.
     *
     * @param contraseña La contraseña asociada al retiro a establecer.
     */
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    /**
     * Obtiene el estado del retiro.
     *
     * @return El estado del retiro.
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Establece el estado del retiro.
     *
     * @param estado El estado del retiro a establecer.
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

}

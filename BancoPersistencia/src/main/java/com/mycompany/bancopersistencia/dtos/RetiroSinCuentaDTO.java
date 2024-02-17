/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bancopersistencia.dtos;

/**
 *
 * @author PC
 */
public class RetiroSinCuentaDTO extends TransaccionDTO {
    private int folio_operacion;
    private String contraseña;
    private String estado;

    public RetiroSinCuentaDTO(int folio_operacion, String contraseña, String estado, String fecha_hora, int monto, int cuenta_origen) {
        super(fecha_hora, monto, "RetiroSinCuenta", cuenta_origen);
        this.folio_operacion = folio_operacion;
        this.contraseña = contraseña;
        this.estado = estado;
    }

    public int getFolio_operacion() {
        return folio_operacion;
    }

    public void setFolio_operacion(int folio_operacion) {
        this.folio_operacion = folio_operacion;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
    
}

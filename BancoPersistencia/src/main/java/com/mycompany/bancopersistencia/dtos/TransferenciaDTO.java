/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bancopersistencia.dtos;

/**
 *
 * @author PC
 */
public class TransferenciaDTO extends TransaccionDTO {
    
     private int cuenta_destino;

    public TransferenciaDTO(int cuenta_destino, String fecha_hora, int monto, int cuenta_origen) {
        super(fecha_hora, monto, "Transferencia", cuenta_origen);
        this.cuenta_destino = cuenta_destino;
    }

    public int getCuenta_destino() {
        return cuenta_destino;
    }

    public void setCuenta_destino(int cuenta_destino) {
        this.cuenta_destino = cuenta_destino;
    }
     
     
}

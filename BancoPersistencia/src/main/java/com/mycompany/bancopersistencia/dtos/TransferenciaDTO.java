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

    /**
     * Constructor para inicializar un objeto TransferenciaDTO con todos sus
     * atributos.
     *
     * @param cuenta_destino El número de cuenta de destino de la transferencia.
     * @param fecha_hora La fecha y hora de la transferencia.
     * @param monto El monto de la transferencia.
     * @param cuenta_origen El número de cuenta de origen de la transferencia.
     */
    public TransferenciaDTO(int cuenta_destino, String fecha_hora, int monto, int cuenta_origen) {
        super(fecha_hora, monto, "Transferencia", cuenta_origen);
        this.cuenta_destino = cuenta_destino;
    }

    /**
     * Obtiene el número de cuenta de destino de la transferencia.
     *
     * @return El número de cuenta de destino.
     */
    public int getCuenta_destino() {
        return cuenta_destino;
    }

    /**
     * Establece el número de cuenta de destino de la transferencia.
     *
     * @param cuenta_destino El número de cuenta de destino a establecer.
     */
    public void setCuenta_destino(int cuenta_destino) {
        this.cuenta_destino = cuenta_destino;
    }

}

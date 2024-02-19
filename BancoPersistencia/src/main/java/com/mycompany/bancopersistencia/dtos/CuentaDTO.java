/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bancopersistencia.dtos;

/**
 *
 * @author Armenta Baca Jose Maria, Carlos Hiram Sanchez Meneses
 */
public class CuentaDTO {

    private int num_cuenta;
    private String fecha_apertura;
    private int saldo;
    private int id_cliente;
    private String estado;

    /**
     * Constructor para inicializar un objeto CuentaDTO con todos sus atributos.
     *
     * @param num_cuenta El número de cuenta.
     * @param fecha_apertura La fecha de apertura de la cuenta.
     * @param saldo El saldo de la cuenta.
     * @param id_cliente El ID del cliente asociado a la cuenta.
     * @param estado El estado de la cuenta.
     */
    public CuentaDTO(int num_cuenta, String fecha_apertura, int saldo, int id_cliente, String estado) {
        this.num_cuenta = num_cuenta;
        this.fecha_apertura = fecha_apertura;
        this.saldo = saldo;
        this.id_cliente = id_cliente;
        this.estado = estado;
    }

    // Getters y setters para todos los atributos
    /**
     * Obtiene el número de cuenta.
     *
     * @return El número de cuenta.
     */
    public int getNum_cuenta() {
        return num_cuenta;
    }

    /**
     * Establece el número de cuenta.
     *
     * @param num_cuenta El número de cuenta a establecer.
     */
    public void setNum_cuenta(int num_cuenta) {
        this.num_cuenta = num_cuenta;
    }

    /**
     * Obtiene el estado de la cuenta.
     *
     * @return El estado de la cuenta.
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Establece el estado de la cuenta.
     *
     * @param estado El estado de la cuenta a establecer.
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * Obtiene la fecha de apertura de la cuenta.
     *
     * @return La fecha de apertura de la cuenta.
     */
    public String getFecha_apertura() {
        return fecha_apertura;
    }

    /**
     * Establece la fecha de apertura de la cuenta.
     *
     * @param fecha_apertura La fecha de apertura de la cuenta a establecer.
     */
    public void setFecha_apertura(String fecha_apertura) {
        this.fecha_apertura = fecha_apertura;
    }

    /**
     * Obtiene el saldo de la cuenta.
     *
     * @return El saldo de la cuenta.
     */
    public int getSaldo() {
        return saldo;
    }

    /**
     * Establece el saldo de la cuenta.
     *
     * @param saldo El saldo de la cuenta a establecer.
     */
    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    /**
     * Obtiene el ID del cliente asociado a la cuenta.
     *
     * @return El ID del cliente asociado a la cuenta.
     */
    public int getId_cliente() {
        return id_cliente;
    }

    /**
     * Establece el ID del cliente asociado a la cuenta.
     *
     * @param id_cliente El ID del cliente asociado a la cuenta.
     */
    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

}

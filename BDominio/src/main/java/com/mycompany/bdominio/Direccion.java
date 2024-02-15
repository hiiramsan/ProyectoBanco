/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bdominio;

/**
 *
 * @author carlo
 */
public class Direccion {
    private int id_direccion;
    private String codigo_postal;
    private String calle;
    private String numero_exterior;
    private String colonia;
    private int id_cliente;

    public Direccion() {
    }

    public Direccion(int id_direccion, String codigo_postal, String calle, String numero_exterior, String colonia, int id_cliente) {
        this.id_direccion = id_direccion;
        this.codigo_postal = codigo_postal;
        this.calle = calle;
        this.numero_exterior = numero_exterior;
        this.colonia = colonia;
        this.id_cliente = id_cliente;
    }

    public Direccion(String codigo_postal, String calle, String numero_exterior, String colonia, int id_cliente) {
        this.codigo_postal = codigo_postal;
        this.calle = calle;
        this.numero_exterior = numero_exterior;
        this.colonia = colonia;
        this.id_cliente = id_cliente;
    }

    public int getId_direccion() {
        return id_direccion;
    }

    public void setId_direccion(int id_direccion) {
        this.id_direccion = id_direccion;
    }

    public String getCodigo_postal() {
        return codigo_postal;
    }

    public void setCodigo_postal(String codigo_postal) {
        this.codigo_postal = codigo_postal;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNumero_exterior() {
        return numero_exterior;
    }

    public void setNumero_exterior(String numero_exterior) {
        this.numero_exterior = numero_exterior;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }
}

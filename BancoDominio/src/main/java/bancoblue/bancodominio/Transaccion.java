/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bancoblue.bancodominio;

/**
 *
 * @author Armenta Baca Jose Maria, Carlos Hiram Sanchez Meneses
 */
public class Transaccion {

    private int id_transaccion;
    private String fecha_hora;
    private int monto;
    private String tipo_transaccion;

    public Transaccion() {
    }

    public Transaccion(int id_transaccion, String fecha_hora, int monto, String tipo_transaccion) {
        this.id_transaccion = id_transaccion;
        this.fecha_hora = fecha_hora;
        this.monto = monto;
        this.tipo_transaccion = tipo_transaccion;
    }

    public Transaccion(String fecha_hora, int monto, String tipo_transaccion) {
        this.fecha_hora = fecha_hora;
        this.monto = monto;
        this.tipo_transaccion = tipo_transaccion;
    }

    public int getId_transaccion() {
        return id_transaccion;
    }

    public void setId_transaccion(int id_transaccion) {
        this.id_transaccion = id_transaccion;
    }

    public String getFecha_hora() {
        return fecha_hora;
    }

    public void setFecha_hora(String fecha_hora) {
        this.fecha_hora = fecha_hora;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public String getTipo_transaccion() {
        return tipo_transaccion;
    }

    public void setTipo_transaccion(String tipo_transaccion) {
        this.tipo_transaccion = tipo_transaccion;
    }

}

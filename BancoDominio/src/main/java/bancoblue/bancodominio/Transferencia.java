/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bancoblue.bancodominio;

/**
 *
 * @author Armenta Baca Jose Maria, Carlos Hiram Sanchez Meneses
 */
public class Transferencia extends Transaccion {
    private int cuenta_origen;
    private int cuenta_destino;

    public Transferencia() {
        super();
    }

    public Transferencia(int cuenta_origen, int cuenta_destino, int id_transaccion, String fecha_hora, int monto) {
        super(id_transaccion, fecha_hora, monto, "Transferencia");
        this.cuenta_origen = cuenta_origen;
        this.cuenta_destino = cuenta_destino;
    }

    public Transferencia(int cuenta_origen, int cuenta_destino, String fecha_hora, int monto) {
        super(fecha_hora, monto, "Transferencia");
        this.cuenta_origen = cuenta_origen;
        this.cuenta_destino = cuenta_destino;
    }

    public int getCuenta_origen() {
        return cuenta_origen;
    }

    public void setCuenta_origen(int cuenta_origen) {
        this.cuenta_origen = cuenta_origen;
    }

    public int getCuenta_destino() {
        return cuenta_destino;
    }

    public void setCuenta_destino(int cuenta_destino) {
        this.cuenta_destino = cuenta_destino;
    }



}
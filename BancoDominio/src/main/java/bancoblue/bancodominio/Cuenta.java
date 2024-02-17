/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bancoblue.bancodominio;

/**
 *
 * @author Armenta Baca Jose Maria, Carlos Hiram Sanchez Meneses
 */
public class Cuenta {

    private int id_cuenta;
    private int num_cuenta;
    private String fecha_apertura;
    private int saldo;
    private int id_cliente;
    private String estado;
    

    public Cuenta() {
    }

    public Cuenta(int id_cuenta, int num_cuenta, String fecha_apertura, int saldo, int id_cliente, String estado) {
        this.id_cuenta = id_cuenta;
        this.num_cuenta = num_cuenta;
        this.fecha_apertura = fecha_apertura;
        this.saldo = saldo;
        this.id_cliente = id_cliente;
        this.estado = estado;
    }
    
    public Cuenta(int num_cuenta, String fecha_apertura, int saldo, int id_cliente, String estado) {
        this.num_cuenta = num_cuenta;
        this.fecha_apertura = fecha_apertura;
        this.saldo = saldo;
        this.id_cliente = id_cliente;
        this.estado = estado;
    }

    

    public int getId_cuenta() {
        return id_cuenta;
    }

    public void setId_cuenta(int id_cuenta) {
        this.id_cuenta = id_cuenta;
    }

    
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getNum_cuenta() {
        return num_cuenta;
    }

    public void setNum_cuenta(int num_cuenta) {
        this.num_cuenta = num_cuenta;
    }

    public String getFecha_apertura() {
        return fecha_apertura;
    }

    public void setFecha_apertura(String fecha_apertura) {
        this.fecha_apertura = fecha_apertura;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

}

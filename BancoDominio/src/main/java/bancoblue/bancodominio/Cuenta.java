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

    /**
     * Constructor sin parámetros. Inicializa un objeto Cuenta con valores
     * predeterminados para todos los atributos.
     */
    public Cuenta() {
    }

    /**
     * Constructor con parámetros. Inicializa un objeto Cuenta con los valores
     * proporcionados para cada atributo.
     *
     * @param id_cuenta Identificador único de la cuenta.
     * @param num_cuenta Número de la cuenta.
     * @param fecha_apertura Fecha de apertura de la cuenta (en formato
     * AAAA-MM-DD).
     * @param saldo Saldo de la cuenta.
     * @param id_cliente Identificador único del cliente al que pertenece la
     * cuenta.
     * @param estado Estado de la cuenta.
     */
    public Cuenta(int id_cuenta, int num_cuenta, String fecha_apertura, int saldo, int id_cliente, String estado) {
        this.id_cuenta = id_cuenta;
        this.num_cuenta = num_cuenta;
        this.fecha_apertura = fecha_apertura;
        this.saldo = saldo;
        this.id_cliente = id_cliente;
        this.estado = estado;
    }

    /**
     * Constructor con parámetros (sin el identificador único de la cuenta).
     * Inicializa un objeto Cuenta con los valores proporcionados para cada
     * atributo, excepto el identificador único.
     *
     * @param num_cuenta Número de la cuenta.
     * @param fecha_apertura Fecha de apertura de la cuenta (en formato
     * AAAA-MM-DD).
     * @param saldo Saldo de la cuenta.
     * @param id_cliente Identificador único del cliente al que pertenece la
     * cuenta.
     * @param estado Estado de la cuenta.
     */
    public Cuenta(int num_cuenta, String fecha_apertura, int saldo, int id_cliente, String estado) {
        this.num_cuenta = num_cuenta;
        this.fecha_apertura = fecha_apertura;
        this.saldo = saldo;
        this.id_cliente = id_cliente;
        this.estado = estado;
    }

    /**
     * Obtiene el identificador único de la cuenta.
     *
     * @return El identificador único de la cuenta.
     */
    public int getId_cuenta() {
        return id_cuenta;
    }

    /**
     * Establece el identificador único de la cuenta.
     *
     * @param id_cuenta El identificador único de la cuenta.
     */
    public void setId_cuenta(int id_cuenta) {
        this.id_cuenta = id_cuenta;
    }

    /**
     * Obtiene el número de la cuenta.
     *
     * @return El número de la cuenta.
     */
    public int getNum_cuenta() {
        return num_cuenta;
    }

    /**
     * Establece el número de la cuenta.
     *
     * @param num_cuenta El número de la cuenta.
     */
    public void setNum_cuenta(int num_cuenta) {
        this.num_cuenta = num_cuenta;
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
     * @param fecha_apertura La fecha de apertura de la cuenta.
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
     * @param saldo El saldo de la cuenta.
     */
    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    /**
     * Obtiene el identificador único del cliente al que pertenece la cuenta.
     *
     * @return El identificador único del cliente al que pertenece la cuenta.
     */
    public int getId_cliente() {
        return id_cliente;
    }

    /**
     * Establece el identificador único del cliente al que pertenece la cuenta.
     *
     * @param id_cliente El identificador único del cliente al que pertenece la
     * cuenta.
     */
    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
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
     * @param estado El estado de la cuenta.
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }
}

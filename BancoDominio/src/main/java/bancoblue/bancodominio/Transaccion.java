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
    private int cuenta_origen;

    /**
     * Constructor sin parámetros. Inicializa un objeto Transaccion con valores
     * predeterminados para todos los atributos.
     */
    public Transaccion() {

    }

    /**
     * Constructor con parámetros. Inicializa un objeto Transaccion con los
     * valores proporcionados para cada atributo.
     *
     * @param id_transaccion Identificador único de la transacción.
     * @param fecha_hora Fecha y hora de la transacción.
     * @param monto Monto de la transacción.
     * @param tipo_transaccion Tipo de transacción.
     * @param cuenta_origen Identificador de la cuenta de origen de la
     * transacción.
     */
    public Transaccion(int id_transaccion, String fecha_hora, int monto, String tipo_transaccion, int cuenta_origen) {
        this.id_transaccion = id_transaccion;
        this.fecha_hora = fecha_hora;
        this.monto = monto;
        this.tipo_transaccion = tipo_transaccion;
        this.cuenta_origen = cuenta_origen;
    }

    /**
     * Constructor con parámetros (sin el identificador de la transacción).
     * Inicializa un objeto Transaccion con los valores proporcionados para cada
     * atributo, excepto el identificador de la transacción.
     *
     * @param fecha_hora Fecha y hora de la transacción.
     * @param monto Monto de la transacción.
     * @param tipo_transaccion Tipo de transacción.
     * @param cuenta_origen Identificador de la cuenta de origen de la
     * transacción.
     */
    public Transaccion(String fecha_hora, int monto, String tipo_transaccion, int cuenta_origen) {
        this.fecha_hora = fecha_hora;
        this.monto = monto;
        this.tipo_transaccion = tipo_transaccion;
        this.cuenta_origen = cuenta_origen;
    }

    // Métodos get y set para cada atributo
    /**
     * Obtiene el identificador único de la transacción.
     *
     * @return El identificador único de la transacción.
     */
    public int getId_transaccion() {
        return id_transaccion;
    }

    /**
     * Establece el identificador único de la transacción.
     *
     * @param id_transaccion El identificador único de la transacción.
     */
    public void setId_transaccion(int id_transaccion) {
        this.id_transaccion = id_transaccion;
    }

    /**
     * Obtiene la fecha y hora de la transacción.
     *
     * @return La fecha y hora de la transacción.
     */
    public String getFecha_hora() {
        return fecha_hora;
    }

    /**
     * Establece la fecha y hora de la transacción.
     *
     * @param fecha_hora La fecha y hora de la transacción.
     */
    public void setFecha_hora(String fecha_hora) {
        this.fecha_hora = fecha_hora;
    }

    /**
     * Obtiene el monto de la transacción.
     *
     * @return El monto de la transacción.
     */
    public int getMonto() {
        return monto;
    }

    /**
     * Establece el monto de la transacción.
     *
     * @param monto El monto de la transacción.
     */
    public void setMonto(int monto) {
        this.monto = monto;
    }

    /**
     * Obtiene el tipo de transacción.
     *
     * @return El tipo de transacción.
     */
    public String getTipo_transaccion() {
        return tipo_transaccion;
    }

    /**
     * Establece el tipo de transacción.
     *
     * @param tipo_transaccion El tipo de transacción.
     */
    public void setTipo_transaccion(String tipo_transaccion) {
        this.tipo_transaccion = tipo_transaccion;
    }

    /**
     * Obtiene el identificador de la cuenta de origen de la transacción.
     *
     * @return El identificador de la cuenta de origen de la transacción.
     */
    public int getCuenta_origen() {
        return cuenta_origen;
    }

    /**
     * Establece el identificador de la cuenta de origen de la transacción.
     *
     * @param cuenta_origen El identificador de la cuenta de origen de la
     * transacción.
     */
    public void setCuenta_origen(int cuenta_origen) {
        this.cuenta_origen = cuenta_origen;
    }

}

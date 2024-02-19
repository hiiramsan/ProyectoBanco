/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bancoblue.bancodominio;

/**
 *
 * @author Armenta Baca Jose Maria, Carlos Hiram Sanchez Meneses
 */
public class RetiroSinCuenta extends Transaccion {

    private int folio_operacion;
    private String contraseña;
    private String estado;

    /**
     * Constructor sin parámetros. Inicializa un objeto RetiroSinCuenta con
     * valores predeterminados para todos los atributos.
     */
    public RetiroSinCuenta() {
        super();
    }

    /**
     * Constructor con parámetros. Inicializa un objeto RetiroSinCuenta con los
     * valores proporcionados para cada atributo.
     *
     * @param id_transaccion Identificador de la transacción.
     * @param fecha_hora Fecha y hora de la transacción.
     * @param monto Monto de la transacción.
     * @param cuenta_origen Identificador de la cuenta de origen.
     * @param folio_operacion Folio de la operación de retiro.
     * @param contraseña Contraseña para autorizar el retiro.
     * @param estado Estado de la operación de retiro.
     */
    public RetiroSinCuenta(int id_transaccion, String fecha_hora, int monto, int cuenta_origen, int folio_operacion, String contraseña, String estado) {
        super(id_transaccion, fecha_hora, monto, "RetiroSinCuenta", cuenta_origen); // Llama al constructor de la clase base (Transaccion)
        this.folio_operacion = folio_operacion;
        this.contraseña = contraseña;
        this.estado = estado;
    }

    /**
     * Constructor con parámetros (sin el identificador de la transacción).
     * Inicializa un objeto RetiroSinCuenta con los valores proporcionados para
     * cada atributo, excepto el identificador de la transacción.
     *
     * @param fecha_hora Fecha y hora de la transacción.
     * @param monto Monto de la transacción.
     * @param cuenta_origen Identificador de la cuenta de origen.
     * @param folio_operacion Folio de la operación de retiro.
     * @param contraseña Contraseña para autorizar el retiro.
     * @param estado Estado de la operación de retiro.
     */
    public RetiroSinCuenta(String fecha_hora, int monto, int cuenta_origen, int folio_operacion, String contraseña, String estado) {
        super(fecha_hora, monto, "RetiroSinCuenta", cuenta_origen); // Llama al constructor de la clase base (Transaccion)
        this.folio_operacion = folio_operacion;
        this.contraseña = contraseña;
        this.estado = estado;
    }

    // Métodos get y set para cada atributo
    /**
     * Obtiene el folio de la operación de retiro.
     *
     * @return El folio de la operación de retiro.
     */
    public int getFolio_operacion() {
        return folio_operacion;
    }

    /**
     * Establece el folio de la operación de retiro.
     *
     * @param folio_operacion El folio de la operación de retiro.
     */
    public void setFolio_operacion(int folio_operacion) {
        this.folio_operacion = folio_operacion;
    }

    /**
     * Obtiene la contraseña para autorizar el retiro.
     *
     * @return La contraseña para autorizar el retiro.
     */
    public String getContraseña() {
        return contraseña;
    }

    /**
     * Establece la contraseña para autorizar el retiro.
     *
     * @param contraseña La contraseña para autorizar el retiro.
     */
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    /**
     * Obtiene el estado de la operación de retiro.
     *
     * @return El estado de la operación de retiro.
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Establece el estado de la operación de retiro.
     *
     * @param estado El estado de la operación de retiro.
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

}

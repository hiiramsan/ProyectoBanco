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

    private int cuenta_destino;

    /**
     * Constructor sin parámetros. Inicializa un objeto Transferencia con
     * valores predeterminados para todos los atributos.
     */
    public Transferencia() {
        super(); // Llama al constructor de la clase base (Transaccion)
    }

    /**
     * Constructor con parámetros. Inicializa un objeto Transferencia con los
     * valores proporcionados para cada atributo.
     *
     * @param cuenta_destino Identificador de la cuenta de destino de la
     * transferencia.
     * @param id_transaccion Identificador de la transacción.
     * @param fecha_hora Fecha y hora de la transacción.
     * @param monto Monto de la transacción.
     * @param cuenta_origen Identificador de la cuenta de origen de la
     * transacción.
     */
    public Transferencia(int cuenta_destino, int id_transaccion, String fecha_hora, int monto, int cuenta_origen) {
        super(id_transaccion, fecha_hora, monto, "Transferencia", cuenta_origen); 
        this.cuenta_destino = cuenta_destino;
    }

    /**
     * Constructor con parámetros (sin el identificador de la transacción).
     * Inicializa un objeto Transferencia con los valores proporcionados para
     * cada atributo, excepto el identificador de la transacción.
     *
     * @param cuenta_destino Identificador de la cuenta de destino de la
     * transferencia.
     * @param fecha_hora Fecha y hora de la transacción.
     * @param monto Monto de la transacción.
     * @param cuenta_origen Identificador de la cuenta de origen de la
     * transacción.
     */
    public Transferencia(int cuenta_destino, String fecha_hora, int monto, int cuenta_origen) {
        super(fecha_hora, monto, "Transferencia", cuenta_origen);
        this.cuenta_destino = cuenta_destino;
    }

    /**
     * Obtiene el identificador de la cuenta de destino de la transferencia.
     *
     * @return El identificador de la cuenta de destino de la transferencia.
     */
    public int getCuenta_destino() {
        return cuenta_destino;
    }

    /**
     * Establece el identificador de la cuenta de destino de la transferencia.
     *
     * @param cuenta_destino El identificador de la cuenta de destino de la
     * transferencia.
     */
    public void setCuenta_destino(int cuenta_destino) {
        this.cuenta_destino = cuenta_destino;
    }

}

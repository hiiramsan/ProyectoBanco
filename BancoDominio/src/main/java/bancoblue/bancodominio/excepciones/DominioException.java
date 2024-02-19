/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bancoblue.bancodominio.excepciones;

/**
 *
 * @author Armenta Baca Jose Maria, Carlos Hiram Sanchez Meneses
 */
public class DominioException extends Exception {

    /**
     * Constructor sin parámetros. Inicializa una instancia de DominioException.
     */
    public DominioException() {
    }

    /**
     * Constructor con un mensaje de error. Inicializa una instancia de
     * DominioException con el mensaje de error proporcionado.
     *
     * @param message El mensaje de error asociado a la excepción.
     */
    public DominioException(String message) {
        super(message);
    }

    /**
     * Constructor con un mensaje de error y una causa. Inicializa una instancia
     * de DominioException con el mensaje de error y la causa proporcionados.
     *
     * @param message El mensaje de error asociado a la excepción.
     * @param cause La causa de la excepción.
     */
    public DominioException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructor con una causa. Inicializa una instancia de DominioException
     * con la causa proporcionada.
     *
     * @param cause La causa de la excepción.
     */
    public DominioException(Throwable cause) {
        super(cause);
    }

    /**
     * Constructor con un mensaje de error, una causa, y opciones de supresión y
     * escritura. Inicializa una instancia de DominioException con el mensaje de
     * error, la causa y las opciones de supresión y escritura proporcionados.
     *
     * @param message El mensaje de error asociado a la excepción.
     * @param cause La causa de la excepción.
     * @param enableSuppression Indica si la supresión está habilitada o no.
     * @param writableStackTrace Indica si el rastreo de pila debe ser
     * escribible o no.
     */
    public DominioException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}

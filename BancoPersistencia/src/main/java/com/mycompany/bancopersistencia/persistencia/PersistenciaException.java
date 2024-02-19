/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bancopersistencia.persistencia;

/**
 *
 * @author PC
 */
public class PersistenciaException extends Exception {

    /**
     * Constructor por defecto de PersistenciaException.
     */
    public PersistenciaException() {
    }

    /**
     * Constructor que acepta un mensaje de error personalizado.
     *
     * @param message El mensaje de error.
     */
    public PersistenciaException(String message) {
        super(message);
    }

    /**
     * Constructor que acepta un mensaje de error y una causa subyacente.
     *
     * @param message El mensaje de error.
     * @param cause La causa subyacente de la excepción.
     */
    public PersistenciaException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructor que acepta una causa subyacente.
     *
     * @param cause La causa subyacente de la excepción.
     */
    public PersistenciaException(Throwable cause) {
        super(cause);
    }

    /**
     * Constructor que acepta un mensaje de error, una causa subyacente, y
     * opciones para habilitar la supresión y la trazabilidad de la pila.
     *
     * @param message El mensaje de error.
     * @param cause La causa subyacente de la excepción.
     * @param enableSuppression Indica si se habilita la supresión de la
     * excepción.
     * @param writableStackTrace Indica si se habilita la trazabilidad de la
     * pila.
     */
    public PersistenciaException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}

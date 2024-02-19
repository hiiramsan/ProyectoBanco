/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bancopresentacion.GUI.utils;

import java.util.Random;

/**
 *
 * @author Armenta Baca Jose Maria, Carlos Hiram Sanchez Meneses
 */
public class GeneradorCuentas {

    /**
     * Método estático utilizado para generar un nuevo número de cuenta
     * aleatorio.
     *
     * @return El nuevo número de cuenta generado.
     */
    public static int getNuevoNumCuenta() {
        Random random = new Random();
        // Generar un número aleatorio de 6 dígitos
        return 100000 + random.nextInt(900000);
    }
}

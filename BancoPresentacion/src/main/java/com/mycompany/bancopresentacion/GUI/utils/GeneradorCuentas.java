/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bancopresentacion.GUI.utils;

import java.util.Random;

/**
 *
 * @author carlo
 */
public class GeneradorCuentas {
    public static int getNuevoNumCuenta() {
        Random random = new Random();
        // Generar un número aleatorio de 6 dígitos
        return 100000 + random.nextInt(900000);
    }
}

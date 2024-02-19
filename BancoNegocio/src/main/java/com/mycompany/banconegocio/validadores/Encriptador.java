/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.banconegocio.validadores;

/**
 *
 * @author Armenta Baca Jose Maria, Carlos Hiram Sanchez Meneses
 */
public class Encriptador {

    /**
     * Encripta una cadena de texto utilizando un algoritmo de sustitución.
     *
     * @param texto El texto a encriptar.
     * @return El texto encriptado.
     */
    public static String encriptar(String texto) {
        char[] caracteres = texto.toCharArray();
        for (int i = 0; i < caracteres.length; i++) {
            char caracter = caracteres[i];
            if (Character.isLetter(caracter)) {
                // Solo sustituir letras
                char inicio = Character.isUpperCase(caracter) ? 'A' : 'a';
                caracteres[i] = (char) (inicio + (caracter - inicio + 5) % 26);
            }
        }
        return new String(caracteres);
    }

    /**
     * Desencripta una cadena de texto encriptada utilizando el mismo algoritmo
     * de sustitución.
     *
     * @param textoEncriptado El texto encriptado.
     * @return El texto original desencriptado.
     */
    public static String desencriptar(String textoEncriptado) {
        // Desencriptar es lo mismo que encriptar con un desplazamiento negativo
        return encriptar(textoEncriptado);
    }

}

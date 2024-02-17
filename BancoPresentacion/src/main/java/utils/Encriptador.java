/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

/**
 *
 * @author carlo
 */
public class Encriptador {

    // Función de encriptación simple de sustitución de caracteres
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

    // Función de desencriptación inversa
    public static String desencriptar(String textoEncriptado) {
        // Desencriptar es lo mismo que encriptar con un desplazamiento negativo
        return encriptar(textoEncriptado);
    }
}



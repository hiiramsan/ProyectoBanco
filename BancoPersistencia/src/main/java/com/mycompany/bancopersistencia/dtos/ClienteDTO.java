/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bancopersistencia.dtos;

/**
 *
 * @author Armenta Baca Jose Maria, Carlos Hiram Sanchez Meneses
 */
public class ClienteDTO {

    private String nombre;
    private String apellidoP;
    private String apellidoM;
    private String fechaNacimiento;
    private String usuario;
    private String contraseña;
    private String codigoPostal;
    private String ciudad;
    private String calle;
    private String colonia;
    private String numero;

    /**
     * Constructor para inicializar un objeto ClienteDTO con todos sus
     * atributos.
     *
     * @param nombre El nombre del cliente.
     * @param apellidoP El primer apellido del cliente.
     * @param apellidoM El segundo apellido del cliente.
     * @param fechaNacimiento La fecha de nacimiento del cliente.
     * @param usuario El nombre de usuario del cliente.
     * @param contraseña La contraseña del cliente.
     * @param codigoPostal El código postal del cliente.
     * @param ciudad La ciudad de residencia del cliente.
     * @param calle La calle de residencia del cliente.
     * @param colonia La colonia de residencia del cliente.
     * @param numero El número de residencia del cliente.
     */
    public ClienteDTO(String nombre, String apellidoP, String apellidoM, String fechaNacimiento, String usuario, String contraseña, String codigoPostal, String ciudad, String calle, String colonia, String numero) {
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.fechaNacimiento = fechaNacimiento;
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.codigoPostal = codigoPostal;
        this.ciudad = ciudad;
        this.calle = calle;
        this.colonia = colonia;
        this.numero = numero;
    }

    // Getters y setters para todos los atributos
    /**
     * Obtiene el nombre de usuario del cliente.
     *
     * @return El nombre de usuario del cliente.
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * Establece el nombre de usuario del cliente.
     *
     * @param usuario El nombre de usuario a establecer.
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * Obtiene el código postal del cliente.
     *
     * @return El código postal del cliente.
     */
    public String getCodigoPostal() {
        return codigoPostal;
    }

    /**
     * Establece el código postal del cliente.
     *
     * @param codigoPostal El código postal a establecer.
     */
    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    /**
     * Obtiene la ciudad de residencia del cliente.
     *
     * @return La ciudad de residencia del cliente.
     */
    public String getCiudad() {
        return ciudad;
    }

    /**
     * Establece la ciudad de residencia del cliente.
     *
     * @param ciudad La ciudad de residencia a establecer.
     */
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    /**
     * Obtiene la calle de residencia del cliente.
     *
     * @return La calle de residencia del cliente.
     */
    public String getCalle() {
        return calle;
    }

    /**
     * Establece la calle de residencia del cliente.
     *
     * @param calle La calle de residencia a establecer.
     */
    public void setCalle(String calle) {
        this.calle = calle;
    }

    /**
     * Obtiene la colonia de residencia del cliente.
     *
     * @return La colonia de residencia del cliente.
     */
    public String getColonia() {
        return colonia;
    }

    /**
     * Establece la colonia de residencia del cliente.
     *
     * @param colonia La colonia de residencia a establecer.
     */
    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    /**
     * Obtiene el número de residencia del cliente.
     *
     * @return El número de residencia del cliente.
     */
    public String getNumero() {
        return numero;
    }

    /**
     * Establece el número de residencia del cliente.
     *
     * @param numero El número de residencia a establecer.
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     * Obtiene el nombre del cliente.
     *
     * @return El nombre del cliente.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del cliente.
     *
     * @param nombre El nombre a establecer.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el primer apellido del cliente.
     *
     * @return El primer apellido del cliente.
     */
    public String getApellidoP() {
        return apellidoP;
    }

    /**
     * Establece el primer apellido del cliente.
     *
     * @param apellidoP El primer apellido a establecer.
     */
    public void setApellidoP(String apellidoP) {
        this.apellidoP = apellidoP;
    }

    /**
     * Obtiene el segundo apellido del cliente.
     *
     * @return El segundo apellido del cliente.
     */
    public String getApellidoM() {
        return apellidoM;
    }

    /**
     * Establece el segundo apellido del cliente.
     *
     * @param apellidoM El segundo apellido a establecer.
     */
    public void setApellidoM(String apellidoM) {
        this.apellidoM = apellidoM;
    }

    /**
     * Obtiene la fecha de nacimiento del cliente.
     *
     * @return La fecha de nacimiento del cliente.
     */
    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * Establece la fecha de nacimiento del cliente.
     *
     * @param fechaNacimiento La fecha de nacimiento a establecer.
     */
    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * Obtiene la contraseña del cliente.
     *
     * @return La contraseña del cliente.
     */
    public String getContraseña() {
        return contraseña;
    }

    /**
     * Establece la contraseña del cliente.
     *
     * @param contraseña La contraseña a establecer.
     */
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

}

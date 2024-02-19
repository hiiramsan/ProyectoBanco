/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bancoblue.bancodominio;

/**
 *
 * @author Armenta Baca Jose Maria, Carlos Hiram Sanchez Meneses
 */
public class Cliente {

    private int id_cliente;
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
     * Constructor sin parámetros. Inicializa un objeto Cliente con valores
     * predeterminados para todos los atributos.
     */
    public Cliente() {

    }

    /**
     * Constructor con parámetros. Inicializa un objeto Cliente con los valores
     * proporcionados para cada atributo.
     *
     * @param id_cliente Identificador único del cliente.
     * @param nombre Nombre del cliente.
     * @param apellidoP Primer apellido del cliente.
     * @param apellidoM Segundo apellido del cliente.
     * @param fechaNacimiento Fecha de nacimiento del cliente (en formato
     * AAAA-MM-DD).
     * @param usuario Nombre de usuario del cliente.
     * @param contraseña Contraseña del cliente.
     * @param codigoPostal Código postal de la dirección del cliente.
     * @param ciudad Ciudad de residencia del cliente.
     * @param calle Nombre de la calle de la dirección del cliente.
     * @param colonia Colonia de la dirección del cliente.
     * @param numero Número de la dirección del cliente.
     */
    public Cliente(int id_cliente, String nombre, String apellidoP, String apellidoM, String fechaNacimiento, String usuario, String contraseña, String codigoPostal, String ciudad, String calle, String colonia, String numero) {
        this.id_cliente = id_cliente;
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

    /**
     * Constructor con parámetros (sin el identificador único del cliente).
     * Inicializa un objeto Cliente con los valores proporcionados para cada
     * atributo, excepto el identificador único.
     *
     * @param nombre Nombre del cliente.
     * @param apellidoP Primer apellido del cliente.
     * @param apellidoM Segundo apellido del cliente.
     * @param fechaNacimiento Fecha de nacimiento del cliente (en formato
     * AAAA-MM-DD).
     * @param usuario Nombre de usuario del cliente.
     * @param contraseña Contraseña del cliente.
     * @param codigoPostal Código postal de la dirección del cliente.
     * @param ciudad Ciudad de residencia del cliente.
     * @param calle Nombre de la calle de la dirección del cliente.
     * @param colonia Colonia de la dirección del cliente.
     * @param numero Número de la dirección del cliente.
     */
    public Cliente(String nombre, String apellidoP, String apellidoM, String fechaNacimiento, String usuario, String contraseña, String codigoPostal, String ciudad, String calle, String colonia, String numero) {
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
     * @param usuario El nombre de usuario del cliente.
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * Obtiene el código postal de la dirección del cliente.
     *
     * @return El código postal de la dirección del cliente.
     */
    public String getCodigoPostal() {
        return codigoPostal;
    }

    /**
     * Establece el código postal de la dirección del cliente.
     *
     * @param codigoPostal El código postal de la dirección del cliente.
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
     * @param ciudad La ciudad de residencia del cliente.
     */
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    /**
     * Obtiene el nombre de la calle de la dirección del cliente.
     *
     * @return El nombre de la calle de la dirección del cliente.
     */
    public String getCalle() {
        return calle;
    }

    /**
     * Establece el nombre de la calle de la dirección del cliente.
     *
     * @param calle El nombre de la calle de la dirección del cliente.
     */
    public void setCalle(String calle) {
        this.calle = calle;
    }

    /**
     * Obtiene la colonia de la dirección del cliente.
     *
     * @return La colonia de la dirección del cliente.
     */
    public String getColonia() {
        return colonia;
    }

    /**
     * Establece la colonia de la dirección del cliente.
     *
     * @param colonia La colonia de la dirección del cliente.
     */
    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    /**
     * Obtiene el número de la dirección del cliente.
     *
     * @return El número de la dirección del cliente.
     */
    public String getNumero() {
        return numero;
    }

    /**
     * Establece el número de la dirección del cliente.
     *
     * @param numero El número de la dirección del cliente.
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     * Obtiene el identificador único del cliente.
     *
     * @return El identificador único del cliente.
     */
    public int getId_cliente() {
        return id_cliente;
    }

    /**
     * Establece el identificador único del cliente.
     *
     * @param id_cliente El identificador único del cliente.
     */
    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
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
     * @param nombre El nombre del cliente.
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
     * @param apellidoP El primer apellido del cliente.
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
     * @param apellidoM El segundo apellido del cliente.
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
     * @param fechaNacimiento La fecha de nacimiento del cliente.
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
     * @param contraseña La contraseña del cliente.
     */
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

}

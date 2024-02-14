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

    private String folio_operacion;
    private String contraseña;
    private String estado;

    public RetiroSinCuenta() {
        super();
    }

    public RetiroSinCuenta(int id_transaccion, String fecha_hora, int monto, String folio_operacion, String contraseña, String estado) {
        super(id_transaccion, fecha_hora, monto, "RetiroSinCuenta");
        this.folio_operacion = folio_operacion;
        this.contraseña = contraseña;
        this.estado = estado;
    }

    public RetiroSinCuenta(String fecha_hora, int monto, String folio_operacion, String contraseña, String estado) {
        super(fecha_hora, monto, "RetiroSinCuenta");
        this.folio_operacion = folio_operacion;
        this.contraseña = contraseña;
        this.estado = estado;
    }

    public String getFolio_operacion() {
        return folio_operacion;
    }

    public void setFolio_operacion(String folio_operacion) {
        this.folio_operacion = folio_operacion;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bancopersistencia.daos;

import bancoblue.bancodominio.Cuenta;
import com.mycompany.bancopersistencia.conexion.IConexion;
import com.mycompany.bancopersistencia.dtos.CuentaDTO;
import com.mycompany.bancopersistencia.persistencia.PersistenciaException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Armenta Baca Jose Maria, Carlos Hiram Sanchez Meneses
 */
public class CuentaDAO implements ICuentaDAO {

    final IConexion conexion;
    private static final Logger LOG = Logger.getLogger(CuentaDAO.class.getName());

    /**
     * Constructor de la clase CuentaDAO.
     *
     * @param conexion Objeto que proporciona métodos para establecer la
     * conexión con la base de datos.
     */
    public CuentaDAO(IConexion conexion) {
        this.conexion = conexion;
    }

    /**
     * Agrega una nueva cuenta a la base de datos.
     *
     * @param cuenta Objeto CuentaDTO que contiene la información de la cuenta a
     * agregar.
     * @return La cuenta agregada.
     * @throws PersistenciaException Si ocurre un error durante la operación de
     * persistencia.
     */
    @Override
    public Cuenta agregarCuenta(CuentaDTO cuenta) throws PersistenciaException {
        // 1. Crear la sentencia SQL que vamos a mandar a la BD
        String sentenciaSQL = "INSERT INTO CUENTAS (num_cuenta, fecha_apertura, saldo,id_cliente,estado) VALUES (?,?,?,?,?)";

        // 2. Vamos a insertar o intentar hacer la inserción en la tabla
        try (
                // recursos
                Connection conexion = this.conexion.crearConexion(); // establecemos la conexion con la bd
                // Crear el statement o el comando donde ejecutamos la sentencia
                 PreparedStatement comandoSQL = conexion.prepareStatement(sentenciaSQL, Statement.RETURN_GENERATED_KEYS); // mandamos la sentencia y obtenemos de regreso la llave generada o el ID
                ) {

            // 3. mandar los valores del cliente al comandoSQL
            comandoSQL.setInt(1, cuenta.getNum_cuenta());
            comandoSQL.setString(2, cuenta.getFecha_apertura());
            comandoSQL.setInt(3, cuenta.getSaldo());
            comandoSQL.setInt(4, cuenta.getId_cliente());
            comandoSQL.setString(5, cuenta.getEstado());

            // 4. Ejecutamos el comando o lo enviamos a la BD
            int registrosModificados = comandoSQL.executeUpdate();
            LOG.log(Level.INFO, "Se agregaron con éxito {0} ", registrosModificados);

            // obtener el conjunto de resultados que tiene o contiene las llaves generadas durante el registro o inserción
            ResultSet registroGenerado = comandoSQL.getGeneratedKeys();

            // nos posicionamos en el primer registro o en el siguiente disponible.
            registroGenerado.next();

            Cuenta cuentaNueva = new Cuenta(
                    registroGenerado.getInt(1),
                    cuenta.getNum_cuenta(),
                    cuenta.getFecha_apertura(),
                    cuenta.getSaldo(),
                    cuenta.getId_cliente(),
                    cuenta.getEstado()
            );
            // regresamos la cuenta
            return cuentaNueva;

        } catch (Exception e) {
            LOG.log(Level.SEVERE, "No se agregó con éxito la cuenta", e);
            throw new PersistenciaException("No se pudo guardar la cuenta ", e);
        }
    }

    /**
     * Obtiene las cuentas asociadas a un cliente.
     *
     * @param id_cliente El ID del cliente.
     * @return Una lista de cadenas que representan las cuentas del cliente con
     * su saldo.
     * @throws PersistenciaException Si ocurre un error durante la operación de
     * persistencia.
     */
    @Override
    public List<String> obtenerCuentas(String id_cliente) throws PersistenciaException {
        List<String> listaCuentas = new ArrayList<>();
        String sentenciaSQL = "select num_cuenta, saldo from Cuentas where id_cliente = ? and estado = 'Activa'";
        try (
                // recursos
                Connection conexion = this.conexion.crearConexion(); // establecemos la conexion con la bd
                // Crear el statement o el comando donde ejecutamos la sentencia
                 PreparedStatement comandoSQL = conexion.prepareStatement(sentenciaSQL, Statement.RETURN_GENERATED_KEYS); // mandamos la sentencia y obtenemos de regreso la llave generada o el ID
                ) {

            comandoSQL.setString(1, id_cliente);

            ResultSet resultado = comandoSQL.executeQuery();

            listaCuentas.clear();
            while (resultado.next()) {
                int cuenta = resultado.getInt("num_cuenta");
                int saldo = resultado.getInt("saldo");

                String cuentaConSaldo = String.format("#%d     Saldo: %d", cuenta, saldo);
                listaCuentas.add(cuentaConSaldo);
            }

            return listaCuentas;
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "Error", e);
            throw new PersistenciaException("Error", e);
        }

    }

    /**
     * Obtiene una cuenta de la base de datos por su número de cuenta.
     *
     * @param numeroCuenta El número de cuenta.
     * @return La cuenta encontrada, o null si no se encuentra.
     * @throws PersistenciaException Si ocurre un error durante la operación de
     * persistencia.
     */
    @Override
    public Cuenta obtenerCuentaPorNumCuentas(String numeroCuenta) throws PersistenciaException {
        // 1. Crear la sentencia SQL que vamos a mandar a la BD
        String sentenciaSQL = "SELECT * FROM Cuentas WHERE num_cuenta = ?";

        try (
                Connection conexion = this.conexion.crearConexion(); PreparedStatement comandoSQL = conexion.prepareStatement(sentenciaSQL);) {

            comandoSQL.setString(1, numeroCuenta);

            // 3. Ejecutar la consulta
            ResultSet resultado = comandoSQL.executeQuery();

            if (resultado.next()) {

                int idCuenta = resultado.getInt("id_cuenta");
                int num_cuenta = resultado.getInt("num_cuenta");
                String fechaApertura = resultado.getString("fecha_apertura");
                int saldo = resultado.getInt("saldo");
                int idCliente = resultado.getInt("id_cliente");
                String estado = resultado.getString("estado");
                // Otros campos...

                // (int id_cuenta, int num_cuenta, String fecha_apertura, int saldo, int id_cliente, String estado) 
                Cuenta cuenta = new Cuenta(idCuenta, num_cuenta, fechaApertura, saldo, idCliente, estado);

                return cuenta;
            } else {

                return null;
            }
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "Error al obtener la cuenta por número", e);
            throw new PersistenciaException("No se pudo obtener la cuenta por número", e);
        }
    }

    /**
     * Modifica el saldo de una cuenta en la base de datos.
     *
     * @param idCuenta El ID de la cuenta.
     * @param nuevoSaldo El nuevo saldo de la cuenta.
     * @throws PersistenciaException Si ocurre un error durante la operación de
     * persistencia.
     */
    @Override
    public void modificarSaldoPorId(int idCuenta, double nuevoSaldo) throws PersistenciaException {
        String sentenciaSQL = "UPDATE Cuentas SET saldo = saldo + ? WHERE id_cuenta = ?";

        try (
                Connection conexion = this.conexion.crearConexion(); PreparedStatement comandoSQL = conexion.prepareStatement(sentenciaSQL, Statement.RETURN_GENERATED_KEYS); // mandamos la sentencia y obtenemos de regreso la llave generada o el ID
                ) {
            comandoSQL.setDouble(1, nuevoSaldo);
            comandoSQL.setInt(2, idCuenta);

            int registrosModificados = comandoSQL.executeUpdate();

            if (registrosModificados == 0) {
                throw new PersistenciaException("No se encontró la cuenta con id_cuenta: " + idCuenta);
            }

            LOG.log(Level.INFO, "Se modificó con éxito el saldo de la cuenta con id_cuenta {0}", idCuenta);

        } catch (Exception e) {
            LOG.log(Level.SEVERE, "Error al modificar el saldo de la cuenta con id_cuenta " + idCuenta, e);
            throw new PersistenciaException("No se pudo modificar el saldo de la cuenta", e);
        }
    }

    /**
     * Cancela una cuenta en la base de datos.
     *
     * @param idCuenta El ID de la cuenta a cancelar.
     * @throws PersistenciaException Si ocurre un error durante la operación de
     * persistencia.
     */
    @Override
    public void cancelarCuentaPorId(int idCuenta) throws PersistenciaException {
        String sentenciaSQL = "UPDATE Cuentas SET estado = 'Cancelada' WHERE id_cuenta = ?";

        try (
                Connection conexion = this.conexion.crearConexion(); PreparedStatement comandoSQL = conexion.prepareStatement(sentenciaSQL);) {
            comandoSQL.setInt(1, idCuenta);

            int registrosModificados = comandoSQL.executeUpdate();

            if (registrosModificados == 0) {
                throw new PersistenciaException("No se encontró la cuenta con id_cuenta: " + idCuenta);
            }

            LOG.log(Level.INFO, "Se canceló con éxito la cuenta con id_cuenta {0}", idCuenta);

        } catch (Exception e) {
            LOG.log(Level.SEVERE, "Error al cancelar la cuenta con id_cuenta " + idCuenta, e);
            throw new PersistenciaException("No se pudo cancelar la cuenta", e);
        }
    }

    /**
     * Valida si un número de cuenta está activo en la base de datos.
     *
     * @param numeroCuenta El número de cuenta a validar.
     * @return true si la cuenta está activa, false de lo contrario.
     */
    @Override
    public boolean validarNumCuenta(int numeroCuenta) {
        boolean cuentaActiva = false;

        String sentenciaSQL = "SELECT * FROM Cuentas WHERE num_cuenta = ? AND estado = 'Activa'";
        try (
                Connection conexion = this.conexion.crearConexion(); PreparedStatement comandoSQL = conexion.prepareStatement(sentenciaSQL, Statement.RETURN_GENERATED_KEYS); // mandamos la sentencia y obtenemos de regreso la llave generada o el ID
                ) {

            comandoSQL.setInt(1, numeroCuenta);

            ResultSet resultado = comandoSQL.executeQuery();

            if (resultado.next()) {
                cuentaActiva = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return cuentaActiva;
    }

    /**
     * Valida si una cuenta tiene saldo.
     *
     * @param numCuenta El número de cuenta a validar.
     * @return true si el tiene saldo, false de lo contrario.
     */
    @Override
    public boolean cuentaTieneSaldo(int numeroCuenta) throws PersistenciaException {
        boolean tieneSaldo = false;

        String sentenciaSQL = "SELECT saldo FROM Cuentas WHERE id_cuenta = ?";
        try (
                Connection conexion = this.conexion.crearConexion(); PreparedStatement comandoSQL = conexion.prepareStatement(sentenciaSQL, Statement.RETURN_GENERATED_KEYS);
                ) {

            comandoSQL.setInt(1, numeroCuenta);

            ResultSet resultado = comandoSQL.executeQuery();

            if (resultado.next() && resultado.getInt("saldo") > 0) {
                tieneSaldo = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
       return tieneSaldo;
    }
}

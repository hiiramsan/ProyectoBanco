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
 * @author PC
 */
public class CuentaDAO implements ICuentaDAO {

    final IConexion conexion;
    private static final Logger LOG = Logger.getLogger(CuentaDAO.class.getName());

    public CuentaDAO(IConexion conexion) {
        this.conexion = conexion;
    }

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

    public List<String> obtenerCuentas(String id_cliente) throws PersistenciaException {
        List<String> listaCuentas = new ArrayList<>();
        String sentenciaSQL = "select num_cuenta, saldo from Cuentas where id_cliente = ?";
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
    
    public Cuenta obtenerCuentaPorNumCuentas(String numeroCuenta) throws PersistenciaException {
    // 1. Crear la sentencia SQL que vamos a mandar a la BD
    String sentenciaSQL = "SELECT * FROM Cuentas WHERE num_cuenta = ?";

    try (
            // recursos
            Connection conexion = this.conexion.crearConexion();
            PreparedStatement comandoSQL = conexion.prepareStatement(sentenciaSQL);
    ) {
        // 2. Establecer el parámetro en la sentencia SQL
        comandoSQL.setString(1, numeroCuenta);

        // 3. Ejecutar la consulta
        ResultSet resultado = comandoSQL.executeQuery();

        // 4. Verificar si hay resultados
        if (resultado.next()) {
            // 5. Obtener los datos de la cuenta
            int idCuenta = resultado.getInt("id_cuenta");
            int num_cuenta = resultado.getInt("num_cuenta");
            String fechaApertura = resultado.getString("fecha_apertura");
            int saldo = resultado.getInt("saldo");
            int idCliente = resultado.getInt("id_cliente");
            String estado = resultado.getString("estado");
            // Otros campos...

            // 6. Crear el objeto CuentaDTO con los datos obtenidos
           // (int id_cuenta, int num_cuenta, String fecha_apertura, int saldo, int id_cliente, String estado) 
            Cuenta cuenta = new Cuenta(idCuenta,num_cuenta, fechaApertura, saldo, idCliente, estado);
            
            // 7. Devolver el objeto CuentaDTO
            return cuenta;
        } else {
            // Manejar el caso donde no se encontró la cuenta
            return null;
        }
    } catch (Exception e) {
        LOG.log(Level.SEVERE, "Error al obtener la cuenta por número", e);
        throw new PersistenciaException("No se pudo obtener la cuenta por número", e);
    }
}

    
}

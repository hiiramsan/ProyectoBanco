/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.bancopersistencia.daos;

import bancoblue.bancodominio.Cliente;
import com.mycompany.bancopersistencia.dtos.ClienteDTO;
import com.mycompany.bancopersistencia.persistencia.PersistenciaException;
import java.util.List;


/**
 *
 * @author PC
 */
public interface IClienteDAO {
    
    public Cliente agregarCliente(ClienteDTO cliente) throws PersistenciaException;
    
    public boolean validarUsuario(String usuario) throws PersistenciaException;
    
    public boolean iniciarSesion(String usuario, String contra) throws PersistenciaException;
    
    public String obtenerIdCliente(String usuario) throws PersistenciaException;
    
}

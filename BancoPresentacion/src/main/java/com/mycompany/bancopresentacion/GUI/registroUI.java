/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.bancopresentacion.GUI;

import bancoblue.bancodominio.Cliente;
import bancoblue.bancodominio.Cuenta;
import com.mycompany.banconegocio.ControladorNegocio;
import com.mycompany.bancopersistencia.dtos.ClienteDTO;
import com.mycompany.bancopersistencia.dtos.CuentaDTO;
import com.mycompany.bancopersistencia.persistencia.PersistenciaException;
import com.mycompany.bancopresentacion.GUI.utils.GeneradorCuentas;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author carlo
 */
public class registroUI extends javax.swing.JFrame {

    ControladorNegocio controladorNegocio = new ControladorNegocio();

    /**
     * Creates new form registroUI
     */
    public registroUI() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        crearBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        nombreTxt = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        apellidoPaternoTxt = new javax.swing.JTextField();
        apellidoMaternoTxt = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        contraTxt = new javax.swing.JPasswordField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        codigoPostalTxt = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        ciudadTxt = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        coloniaTxt = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        calleTxt = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        numeroTxt = new javax.swing.JTextField();
        confirmarContraTxt = new javax.swing.JPasswordField();
        fechaSelected = new com.toedter.calendar.JDateChooser();
        contraAviso = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        usuarioTxt = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(22, 66, 91));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("BankApp");
        jLabel5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI", 1, 24)); // NOI18N
        jLabel2.setText("Crea tu cuenta");

        crearBtn.setBackground(new java.awt.Color(53, 129, 184));
        crearBtn.setForeground(new java.awt.Color(255, 255, 255));
        crearBtn.setText("Crear");
        crearBtn.setBorder(null);
        crearBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        crearBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crearBtnActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(22, 66, 91));
        jLabel1.setText("Datos personales");

        jLabel3.setText("Nombre");

        nombreTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(22, 66, 91)));

        jLabel4.setText("Apellido Paterno");

        jLabel6.setText("Apellido Materno");

        jLabel7.setText("Fecha Nacimiento");

        apellidoPaternoTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(22, 66, 91)));

        apellidoMaternoTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(22, 66, 91)));
        apellidoMaternoTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                apellidoMaternoTxtActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(22, 66, 91));
        jLabel8.setText("Crea tu contraseña");

        jLabel9.setText("Contraseña");

        contraTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(22, 66, 91)));

        jLabel10.setText("Confimar contraseña");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(22, 66, 91));
        jLabel11.setText("Domicilio personal");

        jLabel12.setText("Codigo Postal");

        codigoPostalTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(22, 66, 91)));

        jLabel13.setText("Ciudad");

        ciudadTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(22, 66, 91)));

        jLabel14.setText("Colonia");

        coloniaTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(22, 66, 91)));

        jLabel15.setText("Calle");

        calleTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(22, 66, 91)));

        jLabel16.setText("Num Ext");

        numeroTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(22, 66, 91)));

        confirmarContraTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(22, 66, 91)));
        confirmarContraTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                confirmarContraTxtKeyPressed(evt);
            }
        });

        fechaSelected.setDateFormatString("y-MM-dd");

        contraAviso.setForeground(new java.awt.Color(255, 0, 0));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(22, 66, 91));
        jLabel17.setText("Crea tu usuario");

        jLabel18.setText("Nombre Usuario");

        usuarioTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(22, 66, 91)));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel4)
                            .addComponent(apellidoPaternoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(apellidoMaternoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel2)
                    .addComponent(nombreTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17)
                            .addComponent(jLabel18)
                            .addComponent(usuarioTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(contraTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(confirmarContraTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11)
                                    .addComponent(calleTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel15)
                                    .addComponent(coloniaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel14)
                                    .addComponent(codigoPostalTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel12)))
                            .addComponent(jLabel8)
                            .addComponent(contraAviso, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(fechaSelected, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addComponent(numeroTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ciudadTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(crearBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(66, 66, 66))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombreTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(codigoPostalTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ciudadTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(apellidoPaternoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(apellidoMaternoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(coloniaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(calleTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(numeroTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(fechaSelected, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel17))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel18)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(contraTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(confirmarContraTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(crearBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(usuarioTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(contraAviso, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void crearBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crearBtnActionPerformed
        
        if (!validarCampos()) {
            JOptionPane.showMessageDialog(this, "Por favor, llena todos los campos.", "Campos incompletos", JOptionPane.WARNING_MESSAGE);
            return; // Sale del método si los campos no están llenos
        }
        
        if(!validarContra()) {
         contraAviso.setText("Las contraseñas no coinciden");
         return;
        }
        
        String nombre = nombreTxt.getText();
        String apellidoPaterno = apellidoPaternoTxt.getText();
        String apellidoMaterno = apellidoMaternoTxt.getText();
        String codigoPostal = codigoPostalTxt.getText();
        String ciudad = ciudadTxt.getText();
        String colonia = coloniaTxt.getText();
        String calle = calleTxt.getText();
        String numero = numeroTxt.getText();
        String usuario = usuarioTxt.getText();
        String contra = new String(contraTxt.getPassword());
        String confirmarContra = new String(confirmarContraTxt.getPassword());
        Date fecha = fechaSelected.getDate();
        String fechaNacimiento = (fecha != null) ? new SimpleDateFormat("yyyy-MM-dd").format(fecha) : "Fecha no seleccionada";
        
        
        try {
            ClienteDTO cliente = new ClienteDTO(nombre, apellidoPaterno, apellidoMaterno, fechaNacimiento,usuario, contra, codigoPostal, ciudad, calle, colonia, numero);
            Cliente clienteAgregado = controladorNegocio.agregarCliente(cliente);
            
           

            if (clienteAgregado != null) {
                JOptionPane.showMessageDialog(null, "El cliente y su cuenta inicial ha sido registrado correctamente.");
                limpiarCampos();
                Sesion.setUsuario(usuario);
                clienteUI cUI = new clienteUI();
                cUI.setVisible(true);
                dispose();
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo registrar el cliente.", "Error", JOptionPane.ERROR_MESSAGE);
            }
            
        } catch (PersistenciaException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al agregar el cliente o al agregar la cuenta: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_crearBtnActionPerformed

    public boolean validarCampos() {
       // Validamos que ningún campo esté vacío o contenga solo espacios en blanco
    if (nombreTxt.getText().isBlank() || 
        apellidoPaternoTxt.getText().isBlank() || 
        apellidoMaternoTxt.getText().isBlank() || 
        codigoPostalTxt.getText().isBlank() || 
        ciudadTxt.getText().isBlank() || 
        coloniaTxt.getText().isBlank() || 
        calleTxt.getText().isBlank() || 
        numeroTxt.getText().isBlank() || 
        usuarioTxt.getText().isBlank()||
        contraTxt.getText().isBlank() || 
        confirmarContraTxt.getText().isBlank() || 
        fechaSelected == null) {
        // Si algún campo está vacío o solo contiene espacios en blanco, retorna falso
        return false;
    }
    // Si todos los campos tienen algún valor, retorna verdadero
    return true;
    }
    
    public boolean validarContra() {
        
        String pwd = new String(contraTxt.getPassword());
        String confirmPwd = new String(confirmarContraTxt.getPassword());
        
        if(!pwd.equals(confirmPwd)) {
            return false; //Las contraseñas no coinciden
        }
        return true;
        
        //Las contraseñas coinciden
    }
    

    public void limpiarCampos() {
        // Limpiamos el contenido de cada campo de texto
        nombreTxt.setText("");
        apellidoPaternoTxt.setText("");
        apellidoMaternoTxt.setText("");
        codigoPostalTxt.setText("");
        ciudadTxt.setText("");
        coloniaTxt.setText("");
        calleTxt.setText("");
        numeroTxt.setText("");
        usuarioTxt.setText("");
        contraTxt.setText("");
        confirmarContraTxt.setText("");
        // También puedes limpiar otros campos si los tienes

        // Además, si estás utilizando JDateChooser para la fecha, puedes reiniciar su valor a null
        fechaSelected.setDate(null);
    }
    private void apellidoMaternoTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_apellidoMaternoTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_apellidoMaternoTxtActionPerformed

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        // TODO add your handling code here:
        index i = new index();
        i.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel5MouseClicked

    private void confirmarContraTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_confirmarContraTxtKeyPressed
        // TODO add your handling code here:
        contraAviso.setText("");
    }//GEN-LAST:event_confirmarContraTxtKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField apellidoMaternoTxt;
    private javax.swing.JTextField apellidoPaternoTxt;
    private javax.swing.JTextField calleTxt;
    private javax.swing.JTextField ciudadTxt;
    private javax.swing.JTextField codigoPostalTxt;
    private javax.swing.JTextField coloniaTxt;
    private javax.swing.JPasswordField confirmarContraTxt;
    private javax.swing.JLabel contraAviso;
    private javax.swing.JPasswordField contraTxt;
    private javax.swing.JButton crearBtn;
    private com.toedter.calendar.JDateChooser fechaSelected;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField nombreTxt;
    private javax.swing.JTextField numeroTxt;
    private javax.swing.JTextField usuarioTxt;
    // End of variables declaration//GEN-END:variables

    
    
    
}

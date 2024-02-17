/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.bancopresentacion.GUI;

import bancoblue.bancodominio.Cuenta;
import com.mycompany.banconegocio.ControladorNegocio;
import com.mycompany.bancopersistencia.dtos.CuentaDTO;
import com.mycompany.bancopersistencia.persistencia.PersistenciaException;
import com.mycompany.bancopresentacion.GUI.utils.GeneradorCuentas;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author carlo
 */
public class clienteUI extends javax.swing.JFrame {

    ControladorNegocio cn = new ControladorNegocio();
    SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
    Date fechaActual = new Date();
    String fechaActualFormato = formatoFecha.format(fechaActual);

    String usuario = Sesion.getUsuario();

    /**
     * Creates new form clienteUI
     */
    public clienteUI() {
        initComponents();
        System.out.println("Interfaz programada para el usuario " + usuario);
        actualizarCuentas();
        panelCuenta.setVisible(false);
        cuentaLabel.setVisible(false);
        fechaAperturaLabel.setVisible(false);
        depositarBtn.setVisible(false);
        cancelarCuentaBtn.setVisible(false);
        cuentaSelectedTxt.setVisible(false);
        fechaAperturaTxt.setVisible(false);
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
        transferirBtn = new javax.swing.JLabel();
        historialBtn = new javax.swing.JLabel();
        miCuentaBtn = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        nombreCliente = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        opTransferenciaBtn = new javax.swing.JButton();
        retiroSinTarjetaBtn = new javax.swing.JButton();
        agregarCuenta = new javax.swing.JButton();
        cuentasComboBox = new javax.swing.JComboBox<>();
        panelCuenta = new javax.swing.JPanel();
        ajustesBtn = new javax.swing.JLabel();
        cerrarSesionBtn = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        mostrarCuentaBtn = new javax.swing.JLabel();
        cuentaLabel = new javax.swing.JLabel();
        fechaAperturaLabel = new javax.swing.JLabel();
        depositarBtn = new javax.swing.JButton();
        cuentaSelectedTxt = new javax.swing.JLabel();
        fechaAperturaTxt = new javax.swing.JLabel();
        cancelarCuentaBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(22, 66, 91));
        jLabel5.setText("BankApp");

        transferirBtn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        transferirBtn.setForeground(new java.awt.Color(22, 66, 91));
        transferirBtn.setText("Transferir");
        transferirBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        historialBtn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        historialBtn.setForeground(new java.awt.Color(22, 66, 91));
        historialBtn.setText("Historial");
        historialBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        miCuentaBtn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        miCuentaBtn.setForeground(new java.awt.Color(22, 66, 91));
        miCuentaBtn.setText("Mi cuenta");
        miCuentaBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        miCuentaBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                miCuentaBtnMouseClicked(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Microsoft PhagsPa", 0, 24)); // NOI18N
        jLabel4.setText("Bienvenido de vuelta ");

        nombreCliente.setFont(new java.awt.Font("Microsoft PhagsPa", 0, 24)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(22, 66, 91));
        jLabel6.setText("Mis cuentas");

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(22, 66, 91));
        jLabel17.setText("Operaciones");

        opTransferenciaBtn.setForeground(new java.awt.Color(22, 66, 91));
        opTransferenciaBtn.setText("Transferencia");
        opTransferenciaBtn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(22, 66, 91), 1, true));
        opTransferenciaBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        opTransferenciaBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                opTransferenciaBtnMouseClicked(evt);
            }
        });
        opTransferenciaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opTransferenciaBtnActionPerformed(evt);
            }
        });

        retiroSinTarjetaBtn.setForeground(new java.awt.Color(22, 66, 91));
        retiroSinTarjetaBtn.setText("Retiro sin tarjeta");
        retiroSinTarjetaBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(22, 66, 91)));
        retiroSinTarjetaBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        agregarCuenta.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        agregarCuenta.setForeground(new java.awt.Color(22, 66, 91));
        agregarCuenta.setText("+");
        agregarCuenta.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(22, 66, 91)));
        agregarCuenta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        agregarCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarCuentaActionPerformed(evt);
            }
        });

        cuentasComboBox.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cuentasComboBox.setForeground(new java.awt.Color(0, 102, 255));
        cuentasComboBox.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(22, 66, 91)));
        cuentasComboBox.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cuentasComboBoxMouseClicked(evt);
            }
        });
        cuentasComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cuentasComboBoxActionPerformed(evt);
            }
        });

        panelCuenta.setBackground(new java.awt.Color(22, 66, 91));

        ajustesBtn.setForeground(new java.awt.Color(255, 255, 255));
        ajustesBtn.setText("Ajustes");
        ajustesBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ajustesBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ajustesBtnMouseClicked(evt);
            }
        });

        cerrarSesionBtn.setForeground(new java.awt.Color(255, 255, 255));
        cerrarSesionBtn.setText("Cerrar sesion");
        cerrarSesionBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cerrarSesionBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cerrarSesionBtnMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelCuentaLayout = new javax.swing.GroupLayout(panelCuenta);
        panelCuenta.setLayout(panelCuentaLayout);
        panelCuentaLayout.setHorizontalGroup(
            panelCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCuentaLayout.createSequentialGroup()
                .addGroup(panelCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCuentaLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(ajustesBtn))
                    .addGroup(panelCuentaLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(cerrarSesionBtn)))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        panelCuentaLayout.setVerticalGroup(
            panelCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCuentaLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(ajustesBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cerrarSesionBtn)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 65, Short.MAX_VALUE)
        );

        mostrarCuentaBtn.setText("Mostrar mas");
        mostrarCuentaBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mostrarCuentaBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mostrarCuentaBtnMouseClicked(evt);
            }
        });

        cuentaLabel.setText("Cuenta:");

        fechaAperturaLabel.setText("Fecha Apertura:");

        depositarBtn.setBackground(new java.awt.Color(51, 255, 51));
        depositarBtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        depositarBtn.setForeground(new java.awt.Color(255, 255, 255));
        depositarBtn.setText("Depositar");
        depositarBtn.setBorder(null);
        depositarBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        depositarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                depositarBtnActionPerformed(evt);
            }
        });

        cancelarCuentaBtn.setBackground(new java.awt.Color(255, 102, 102));
        cancelarCuentaBtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cancelarCuentaBtn.setForeground(new java.awt.Color(255, 255, 255));
        cancelarCuentaBtn.setText("Cancelar cuenta");
        cancelarCuentaBtn.setBorder(null);
        cancelarCuentaBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cancelarCuentaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarCuentaBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panelCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(transferirBtn)
                                .addGap(50, 50, 50)
                                .addComponent(historialBtn)
                                .addGap(50, 50, 50)
                                .addComponent(miCuentaBtn)
                                .addGap(34, 34, 34))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addGap(105, 105, 105)
                                        .addComponent(mostrarCuentaBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(agregarCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(cuentasComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 19, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(fechaAperturaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(0, 11, Short.MAX_VALUE)
                                                .addComponent(nombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(fechaAperturaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE))))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(cuentaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cuentaSelectedTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(depositarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(19, 19, 19))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(opTransferenciaBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)
                                .addComponent(retiroSinTarjetaBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(568, Short.MAX_VALUE)
                    .addComponent(cancelarCuentaBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(transferirBtn)
                    .addComponent(historialBtn)
                    .addComponent(miCuentaBtn))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nombreCliente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(mostrarCuentaBtn, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(cuentasComboBox, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(agregarCuenta, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cuentaSelectedTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cuentaLabel)
                                .addComponent(depositarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(1, 1, 1)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fechaAperturaLabel)
                            .addComponent(fechaAperturaTxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(18, 18, 18)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(retiroSinTarjetaBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(opTransferenciaBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(100, 100, 100))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(270, Short.MAX_VALUE)
                    .addComponent(cancelarCuentaBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(177, 177, 177)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 463, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void agregarCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarCuentaActionPerformed
        // TODO add your handling code here:
        int nuevaCuenta = GeneradorCuentas.getNuevoNumCuenta();
        try {
            if (usuario != null) {
                String idCliente = cn.obtenerIdCliente(usuario);

//                String saldoString = JOptionPane.showInputDialog("Ingrese el saldo inicial para la cuenta:");
//                if (saldoString == null || saldoString.isEmpty()) {
//                    return;
//                }
//
//                int saldo = Integer.parseInt(saldoString);
                int cliente = Integer.parseInt(idCliente);
                CuentaDTO cuenta = new CuentaDTO(nuevaCuenta, fechaActualFormato, 0, cliente, "Activa");
                Cuenta cuentaAgregada = cn.agregarCuenta(cuenta);
                actualiarListaCuentas(idCliente);
            } else {
                // usuario no encontrado
            }

        } catch (PersistenciaException ex) {
            Logger.getLogger(clienteUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_agregarCuentaActionPerformed

    private void opTransferenciaBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_opTransferenciaBtnMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_opTransferenciaBtnMouseClicked

    private void opTransferenciaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opTransferenciaBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_opTransferenciaBtnActionPerformed

    private void miCuentaBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_miCuentaBtnMouseClicked
        if (panelCuenta.isVisible()) {
            panelCuenta.setVisible(false);
        } else {
            panelCuenta.setVisible(true);
        }

    }//GEN-LAST:event_miCuentaBtnMouseClicked

    private void ajustesBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ajustesBtnMouseClicked
        // TODO add your handling code here:
        ajustesUI ajustesCuenta = new ajustesUI();
        ajustesCuenta.setVisible(true);
        dispose();
    }//GEN-LAST:event_ajustesBtnMouseClicked

    private void cerrarSesionBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cerrarSesionBtnMouseClicked
        // TODO add your handling code here:
        Sesion.setUsuario(null);
        index i = new index();
        i.setVisible(true);
        dispose();
    }//GEN-LAST:event_cerrarSesionBtnMouseClicked

    private void cuentasComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cuentasComboBoxActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_cuentasComboBoxActionPerformed

    private void cuentasComboBoxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cuentasComboBoxMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_cuentasComboBoxMouseClicked

    private void mostrarCuentaBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mostrarCuentaBtnMouseClicked
        // TODO add your handling code here:

        String cuentaSelect = (String) cuentasComboBox.getSelectedItem();
        String[] partes = cuentaSelect.split(" ");

        String numeroCuenta;
        Cuenta cuentaCargada;
        if (partes.length >= 2) {
            numeroCuenta = partes[0].substring(1);
            cuentaCargada = cargarCuentaSeleccionada(numeroCuenta);

            cuentaSelectedTxt.setText(String.valueOf(cuentaCargada.getNum_cuenta()));
            fechaAperturaTxt.setText(String.valueOf(cuentaCargada.getFecha_apertura()));
        } else {
            //handle err
        }

        if (mostrarCuentaBtn.getText() == "Mostrar mas") {
            mostrarCuentaBtn.setText("Mostrar menos");
            cuentaLabel.setVisible(true);
            fechaAperturaLabel.setVisible(true);
            depositarBtn.setVisible(true);
            cancelarCuentaBtn.setVisible(true);
            cuentaSelectedTxt.setVisible(true);
            fechaAperturaTxt.setVisible(true);
        } else {
            mostrarCuentaBtn.setText("Mostrar mas");
            cuentaLabel.setVisible(false);
            fechaAperturaLabel.setVisible(false);
            depositarBtn.setVisible(false);
            cancelarCuentaBtn.setVisible(false);
            cuentaSelectedTxt.setVisible(false);
            fechaAperturaTxt.setVisible(false);
        }

    }//GEN-LAST:event_mostrarCuentaBtnMouseClicked

    private void depositarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_depositarBtnActionPerformed
        String saldoString = JOptionPane.showInputDialog("Ingrese el saldo a depositar a la cuenta:");
        double nuevoSaldo = Double.parseDouble(saldoString);
        if (nuevoSaldo >= 1 && nuevoSaldo <= 10000 && nuevoSaldo % 100 == 0) {
            String cuentaSelect = (String) cuentasComboBox.getSelectedItem();
            String[] partes = cuentaSelect.split(" ");

            String numeroCuenta;
            Cuenta cuentaCargada;
            if (partes.length >= 2) {
                numeroCuenta = partes[0].substring(1);
                cuentaCargada = cargarCuentaSeleccionada(numeroCuenta);
                System.out.println("tratando de depositar a esta cuenta con id: " + cuentaCargada.getId_cuenta());

                try {
                    cn.modificarSaldoPorId(cuentaCargada.getId_cuenta(), nuevoSaldo);
                } catch (PersistenciaException ex) {
                    // handle error
                }

            } else {
            }

            actualizarCuentas();
        } else {
            JOptionPane.showMessageDialog(null, "El deposito debe estar entre 1 y 10000 y ser múltiplo de 100.", "Error", JOptionPane.ERROR_MESSAGE);
        }


    }//GEN-LAST:event_depositarBtnActionPerformed

    private void cancelarCuentaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarCuentaBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cancelarCuentaBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregarCuenta;
    private javax.swing.JLabel ajustesBtn;
    private javax.swing.JButton cancelarCuentaBtn;
    private javax.swing.JLabel cerrarSesionBtn;
    private javax.swing.JLabel cuentaLabel;
    private javax.swing.JLabel cuentaSelectedTxt;
    private javax.swing.JComboBox<String> cuentasComboBox;
    private javax.swing.JButton depositarBtn;
    private javax.swing.JLabel fechaAperturaLabel;
    private javax.swing.JLabel fechaAperturaTxt;
    private javax.swing.JLabel historialBtn;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel miCuentaBtn;
    private javax.swing.JLabel mostrarCuentaBtn;
    private javax.swing.JLabel nombreCliente;
    private javax.swing.JButton opTransferenciaBtn;
    private javax.swing.JPanel panelCuenta;
    private javax.swing.JButton retiroSinTarjetaBtn;
    private javax.swing.JLabel transferirBtn;
    // End of variables declaration//GEN-END:variables

    private void actualizarCuentas() {
        try {
            if (usuario != null) {
                String idCliente = cn.obtenerIdCliente(usuario);
                actualiarListaCuentas(idCliente);
                Sesion.setIdCliente(idCliente);
            } else {
                System.out.println("usuario null");
            }

        } catch (PersistenciaException ex) {
            Logger.getLogger(clienteUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void actualiarListaCuentas(String id_cliente) {
        List<String> cuentas;
        try {
            cuentas = cn.obtenerCuentas(id_cliente);

            cuentasComboBox.removeAllItems();

            if (cuentas != null && !cuentas.isEmpty()) {
                for (String cuenta : cuentas) {
                    cuentasComboBox.addItem(cuenta);
                }
            }
        } catch (PersistenciaException ex) {
            Logger.getLogger(clienteUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private Cuenta cargarCuentaSeleccionada(String numeroCuenta) {
        try {
            Cuenta cuentaSeleccionada = cn.obtenerCuentaPorNumCuentas(numeroCuenta);
            return cuentaSeleccionada;
        } catch (PersistenciaException ex) {
            //handle err
            return null;
        }
    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.bancopresentacion.GUI;

import bancoblue.bancodominio.Cuenta;
import com.mycompany.banconegocio.ControladorNegocio;
import com.mycompany.bancopersistencia.persistencia.PersistenciaException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Armenta Baca Jose Maria, Carlos Hiram Sanchez Meneses
 */
public class transferenciaUI extends javax.swing.JFrame {

    ControladorNegocio cn = new ControladorNegocio();
    String usuario = Sesion.getUsuario();

    /**
     * Creates new form transferenciaUI
     */
    public transferenciaUI() {
        initComponents();
        actualizarCuentas();
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
        jLabel4 = new javax.swing.JLabel();
        cuentasComboBox = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        cuentaDestinoTxt = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        montoTxt = new javax.swing.JTextField();
        transferirBoton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(22, 66, 91));
        jLabel5.setText("BankApp");
        jLabel5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Microsoft PhagsPa", 0, 24)); // NOI18N
        jLabel4.setText("Transferencia");

        cuentasComboBox.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(22, 66, 91)));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(22, 66, 91));
        jLabel6.setText("Cuenta origen");

        cuentaDestinoTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(22, 66, 91)));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(22, 66, 91));
        jLabel7.setText("Cuenta destino");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(22, 66, 91));
        jLabel9.setText("Importe");

        montoTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(22, 66, 91)));

        transferirBoton.setBackground(new java.awt.Color(53, 129, 184));
        transferirBoton.setFont(new java.awt.Font("Microsoft New Tai Lue", 1, 14)); // NOI18N
        transferirBoton.setForeground(new java.awt.Color(255, 255, 255));
        transferirBoton.setText("Transferir");
        transferirBoton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        transferirBoton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        transferirBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                transferirBotonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(montoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(cuentasComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(jLabel6))
                                .addGap(53, 53, 53)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cuentaDestinoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(277, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(transferirBoton, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel5)
                .addGap(35, 35, 35)
                .addComponent(jLabel4)
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cuentaDestinoTxt)
                    .addComponent(cuentasComboBox, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE))
                .addGap(26, 26, 26)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(montoTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                .addGap(83, 83, 83)
                .addComponent(transferirBoton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46))
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
/**
     * Método ejecutado cuando se hace clic en el botón "Transferir". Intenta
     * realizar una transferencia desde la cuenta de origen seleccionada hacia
     * la cuenta destino ingresada.
     *
     * @param evt El evento de acción asociado al clic del botón "Transferir".
     */
    private void transferirBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_transferirBotonActionPerformed
        try {
            // Obtener la cuenta de origen seleccionada
            String cuentaOrigenSeleccionada = (String) cuentasComboBox.getSelectedItem();

            // Extraer solo el número de cuenta de la cadena completa
            String numeroCuenta = obtenerNumeroCuenta(cuentaOrigenSeleccionada);
            // Verificar si se pudo extraer el número de cuenta

            Cuenta cuentaOrigen = cn.obtenerCuentaPorNumCuentas(numeroCuenta);

            int idCuentaOrigen = cuentaOrigen.getId_cuenta();
            // Obtener la cuenta destino y el monto ingresados
            int cuentaDestino = Integer.parseInt(cuentaDestinoTxt.getText().trim()); // Eliminar espacios en blanco alrededor
            String montoStr = montoTxt.getText().trim(); // Eliminar espacios en blanco alrededor
            int monto = Integer.parseInt(montoStr);

            // Validar que el monto sea un número positivo
            if (monto <= 0) {
                throw new NumberFormatException();

            }

            if (monto > cuentaOrigen.getSaldo()) {
                JOptionPane.showMessageDialog(this, "El monto seleccionado supera el saldo de su cuenta.");
                throw new NumberFormatException();
            }

            // Llamar al método para realizar la transferencia en el controlador de negocio
            boolean transferenciaExitosa = cn.realizarTransferencia(idCuentaOrigen, cuentaDestino, monto);

            // Mostrar un mensaje dependiendo del resultado de la transferencia
            if (transferenciaExitosa) {
                JOptionPane.showMessageDialog(this, "Transferencia realizada con éxito");
            } else {
                JOptionPane.showMessageDialog(this, "Error al realizar la transferencia. La cuenta no existe");
            }

            dispose();

            // Abrir la ventana clienteUI
            clienteUI clienteUI = new clienteUI();
            clienteUI.setVisible(true);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Ingrese un monto o cuenta destino válido");
        } catch (PersistenciaException ex) {
            JOptionPane.showMessageDialog(this, "Error al realizar la transferencia");
        }
    }//GEN-LAST:event_transferirBotonActionPerformed
    /**
     * Método ejecutado cuando se hace clic en el label para volver al inicio.
     * Cierra la ventana actual y abre la ventana clienteUI.
     *
     * @param evt El evento de clic del mouse asociado al jLabel5.
     */
    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        // TODO add your handling code here:
        clienteUI cUI = new clienteUI();
        cUI.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel5MouseClicked
    /**
     * Método utilizado para extraer el número de cuenta de la cadena completa
     * de la cuenta seleccionada.
     *
     * @param cuentaSeleccionadaCompleta La cadena completa que contiene la
     * cuenta seleccionada.
     * @return El número de cuenta extraído.
     */

    private String obtenerNumeroCuenta(String cuentaSeleccionadaCompleta) {
        // Extraer solo el número de cuenta de la cadena completa
        String[] partes = cuentaSeleccionadaCompleta.split("\\s+");
        if (partes.length > 0) {
            String numeroCuenta = partes[0]; // El número de cuenta debería ser la primera parte
            // Eliminar el símbolo '#' del número de cuenta si está presente
            return numeroCuenta.replace("#", "");
        } else {
            return null; // No se pudo extraer el número de cuenta
        }
    }

    /**
     * Método utilizado para actualizar la lista de cuentas del cliente.
     */
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

    /**
     * Método utilizado para actualizar la lista de cuentas del cliente en el
     * comboBox.
     *
     * @param id_cliente El ID del cliente.
     */
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cuentaDestinoTxt;
    private javax.swing.JComboBox<String> cuentasComboBox;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField montoTxt;
    private javax.swing.JButton transferirBoton;
    // End of variables declaration//GEN-END:variables
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package PPPOE;

import UIPrincipal.Dashboard;
import Config.Consultas;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import Config.Conexion;
import java.sql.*;
import Config.InsertarDatos;
import java.util.List;
import java.util.Map;
import javax.swing.table.DefaultTableModel;
import me.legrange.mikrotik.ApiConnection;
import me.legrange.mikrotik.MikrotikApiException;
import microtik.PPoEAuto;
import microtik.taskMicrotik;
/**
 *
 * @author cisco
 */
public class clientActivatePPPoE extends javax.swing.JInternalFrame {

    /**
     * Creates new form clientActivatePPPoE
     */
    public clientActivatePPPoE() {
        initComponents();
        listarMicrotik();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popActiveList = new javax.swing.JPopupMenu();
        click_registro = new javax.swing.JMenuItem();
        click_editar_profile = new javax.swing.JMenuItem();
        click_bloquear = new javax.swing.JMenuItem();
        popBlock = new javax.swing.JPopupMenu();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        click_desbloquear = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        comboMicrotik = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        entryUsername = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        entryPassword = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        entryHost = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaBlock = new javax.swing.JTable();

        click_registro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/flecha-de-circulo-de-disquete-a-la-derecha.png"))); // NOI18N
        click_registro.setText("Registrar en Sistema");
        click_registro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                click_registroActionPerformed(evt);
            }
        });
        popActiveList.add(click_registro);

        click_editar_profile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/bolsa-de-usuario.png"))); // NOI18N
        click_editar_profile.setText("Editar Profile");
        click_editar_profile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                click_editar_profileActionPerformed(evt);
            }
        });
        popActiveList.add(click_editar_profile);

        click_bloquear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/bloquear-hashtag.png"))); // NOI18N
        click_bloquear.setText("Bloquear");
        click_bloquear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                click_bloquearActionPerformed(evt);
            }
        });
        popActiveList.add(click_bloquear);

        click_desbloquear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/desbloquear.png"))); // NOI18N
        click_desbloquear.setText("Desbloquear");
        click_desbloquear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                click_desbloquearActionPerformed(evt);
            }
        });
        jPopupMenu1.add(click_desbloquear);

        setClosable(true);
        setTitle("Client PPPoE Active");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Cuenta"));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/perno-circular-del-tapon.png"))); // NOI18N
        jButton2.setText("Conectar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel7.setText("Microtik");

        jLabel1.setText("Username");

        entryUsername.setEditable(false);

        jLabel2.setText("Password");

        entryPassword.setEditable(false);

        jLabel3.setText("Host");

        entryHost.setEditable(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboMicrotik, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel3)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(entryUsername)
                            .addComponent(entryHost))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(entryPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jLabel7)
                    .addComponent(comboMicrotik, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(entryUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(entryPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(entryHost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addContainerGap(11, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("PPP Active List"));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Name", "Service", "Address", "Uptime"
            }
        ));
        jTable1.setComponentPopupMenu(popActiveList);
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(3).setHeaderValue("Uptime");
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 419, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Client Block"));

        tablaBlock.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "List", "Address", "Creation Time"
            }
        ));
        tablaBlock.setComponentPopupMenu(jPopupMenu1);
        jScrollPane2.setViewportView(tablaBlock);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 403, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public void listarMicrotik() {
        Consultas consultas = new Consultas();
        ArrayList<String> nombreMicrotik = consultas.nombresMicrotiks();
        for (String microtiks : nombreMicrotik) {
            comboMicrotik.addItem(microtiks);
        }
    }
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String microtikSelect = (String) comboMicrotik.getSelectedItem();
        if (microtikSelect == null) {
            JOptionPane.showMessageDialog(null, "Por favor selecciona el microtik a realizar configuracion. Si no aparecen, registra uno");
        } else {
            Conexion conexion = new Conexion();
            Connection cn = conexion.getConnection();
            String sql = "SELECT ip, username, password FROM credenciales_microtik WHERE nombre = ? LIMIT 1";
            if (cn != null) {
                PreparedStatement cursor;
                ResultSet resultado;
                try {
                    cursor = cn.prepareStatement(sql);
                    cursor.setString(1, microtikSelect);

                    resultado = cursor.executeQuery();

                    if (resultado.next()) {
                        String ip = resultado.getString("ip");
                        String username = resultado.getString("username");
                        String password = resultado.getString("password");

                        entryHost.setText(ip);
                        entryUsername.setText(username);
                        entryPassword.setText(password);
                        listClienteActive(username, password, ip);
                        blockList(username, password, ip);
                    }
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "Problemas con la consulta del microtik: " + e, "SpiderNET", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void click_registroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_click_registroActionPerformed
        int rows = jTable1.getSelectedRow();
        if(rows >=0){
            String user = entryUsername.getText();
            String password = entryPassword.getText();
            String host = entryHost.getText();
            String nombre = (String)jTable1.getValueAt(rows, 0);
            String addres = (String)jTable1.getValueAt(rows, 2);
            String microtik = (String)comboMicrotik.getSelectedItem();
            InsertarDatos datos = new InsertarDatos();
            datos.registroClienteSimple(nombre, addres, microtik);
            
            taskMicrotik m = new taskMicrotik();
        }else{
            JOptionPane.showMessageDialog(null, "Selecciona un cliente de la lista");
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_click_registroActionPerformed

    private void click_bloquearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_click_bloquearActionPerformed
        String user = entryUsername.getText();
        String password = entryPassword.getText();
        String host = entryHost.getText();
        if(user.isBlank() && password.isBlank() && host.isBlank()){
            JOptionPane.showMessageDialog(null, "Los campos son obligatorios");
        }else{
            int rows = jTable1.getSelectedRow();
            if(rows>=0){
                String address = (String)jTable1.getValueAt(rows, 2);
                PPoEAuto auto = new PPoEAuto();
//                auto.bloquearClientePPoE(address, user, host, password);
                blockList(user, password, host);
            }else{
                JOptionPane.showMessageDialog(null, "Selecciona un cliente de la lista primero");
        }
      }
        // TODO add your handling code here:
    }//GEN-LAST:event_click_bloquearActionPerformed

    private void click_editar_profileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_click_editar_profileActionPerformed
        String user = entryUsername.getText();
        String password = entryPassword.getText();
        String host = entryHost.getText();
        if(user.isBlank() && password.isBlank() && host.isBlank()){
            JOptionPane.showMessageDialog(null, "Los campos son obligatorios");
        }else{
            int rows = jTable1.getSelectedRow();
            if(rows>=0){
                String nombre = (String)jTable1.getValueAt(rows, 0);
                editProfile p = new editProfile(nombre, user, password, host);
                Dashboard.escritorioInterno.add(p);
                p.show();
            }else{
                JOptionPane.showMessageDialog(null, "Selecciona un cliente de la lista primero");
        }
        }// TODO add your handling code here:

        // TODO add your handling code here:
    }//GEN-LAST:event_click_editar_profileActionPerformed

    private void click_desbloquearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_click_desbloquearActionPerformed
        String user = entryUsername.getText();
        String password = entryPassword.getText();
        String host = entryHost.getText();
        if(user.isBlank() && password.isBlank() && host.isBlank()){
            JOptionPane.showMessageDialog(null, "Los campos son obligatorios");
        }else{
            int rows = tablaBlock.getSelectedRow();
            if(rows>=0){
                String address = (String)tablaBlock.getValueAt(rows, 1);
                PPoEAuto auto = new PPoEAuto();
                auto.desbloquearCliente(address, user, password, host);
                blockList(user, password, host);
            }else{
                JOptionPane.showMessageDialog(null, "Selecciona un cliente de la lista primero");
        }
      }
        // TODO add your handling code here:
    }//GEN-LAST:event_click_desbloquearActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem click_bloquear;
    private javax.swing.JMenuItem click_desbloquear;
    private javax.swing.JMenuItem click_editar_profile;
    private javax.swing.JMenuItem click_registro;
    private javax.swing.JComboBox<String> comboMicrotik;
    private javax.swing.JTextField entryHost;
    private javax.swing.JTextField entryPassword;
    private javax.swing.JTextField entryUsername;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JPopupMenu popActiveList;
    private javax.swing.JPopupMenu popBlock;
    private javax.swing.JTable tablaBlock;
    // End of variables declaration//GEN-END:variables

    public void listClienteActive(String username, String password, String ip) {
        try {
            ApiConnection con = ApiConnection.connect(ip); // Conectar al router
            con.login(username, password); // Iniciar sesión en el router

            // Ejecutar el comando para obtener las leases DHCP bloqueadas
            List<Map<String, String>> results = con.execute("/ppp/active/print");

            // Inicializar el modelo de la tabla
            DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();

            // Limpiar cualquier dato previo en la tabla
            modelo.setRowCount(0);

            // Iterar sobre los resultados y agregar las filas a la tabla
            for (Map<String, String> result : results) {
                Object[] clientesDhcpLeases = new Object[4];

                // Asignar los valores a cada columna
                clientesDhcpLeases[0] = result.get("name");
                clientesDhcpLeases[1] = result.get("service");
                clientesDhcpLeases[2] = result.get("address");
                clientesDhcpLeases[3] = result.get("uptime");

                // Agregar la fila al modelo de la tabla
                modelo.addRow(clientesDhcpLeases);
            }

            // Establecer el modelo actualizado a la tabla
            jTable1.setModel(modelo);

            // Cerrar la conexión con el router
            con.close();
        } catch (MikrotikApiException e) {
            // Mostrar mensaje de error si ocurre una excepción
            JOptionPane.showMessageDialog(null, "Error: " + e, "MikroTik", JOptionPane.ERROR_MESSAGE);
        }
    }
    public void blockList(String username, String password, String ip) {
        try {
            ApiConnection con = ApiConnection.connect(ip); // Conectar al router
            con.login(username, password); // Iniciar sesión en el router

            // Ejecutar el comando para obtener las leases DHCP bloqueadas
            List<Map<String, String>> results = con.execute("/ip/firewall/address-list/print where list=corte");

            // Inicializar el modelo de la tabla
            DefaultTableModel modelo = (DefaultTableModel) tablaBlock.getModel();

            // Limpiar cualquier dato previo en la tabla
            modelo.setRowCount(0);

            // Iterar sobre los resultados y agregar las filas a la tabla
            for (Map<String, String> result : results) {
                Object[] clientesDhcpLeases = new Object[3];

                // Asignar los valores a cada columna
                clientesDhcpLeases[0] = result.get("list");
                clientesDhcpLeases[1] = result.get("address");
                clientesDhcpLeases[2] = result.get("creation-time");

                // Agregar la fila al modelo de la tabla
                modelo.addRow(clientesDhcpLeases);
            }

            // Establecer el modelo actualizado a la tabla
            tablaBlock.setModel(modelo);

            // Cerrar la conexión con el router
            con.close();
        } catch (MikrotikApiException e) {
            // Mostrar mensaje de error si ocurre una excepción
            JOptionPane.showMessageDialog(null, "Error: " + e, "MikroTik", JOptionPane.ERROR_MESSAGE);
        }
    }
}

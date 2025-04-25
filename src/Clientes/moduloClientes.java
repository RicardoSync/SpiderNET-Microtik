package Clientes;

import Config.Conexion;
import Config.Consultas;
import Config.DeleteDatos;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import Recibos.pagoWindows;
import java.awt.Color;
import java.net.ConnectException;
import java.sql.*;
import microtik.cambioVelocidad;
import microtik.lucifer;
import Config.UpdateDatos;
import antenas.NavegadorUtil;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;
import me.legrange.mikrotik.ApiConnectionException;
import microtik.PPoEAuto;
import microtik.actualizaQueueTask;
import microtik.simpleQueue;
import microtik.taskMicrotik;
import microtik.testConnectionAsync;
import UIPrincipal.Dashboard;
import morty.Vustas.crearSimpleQueue;

public class moduloClientes extends javax.swing.JInternalFrame {

    public moduloClientes(String username) {
        initComponents();
        listarClientes();
        insertarUsername(username);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        submenu_clientes = new javax.swing.JPopupMenu();
        clic_asignar_ap = new javax.swing.JMenuItem();
        click_bloquear = new javax.swing.JMenuItem();
        click_desbloquear = new javax.swing.JMenuItem();
        click_agregar_queue = new javax.swing.JMenuItem();
        click_actualizar_velocidad = new javax.swing.JMenuItem();
        clic_asignarr_paquete = new javax.swing.JMenuItem();
        click_editar = new javax.swing.JMenuItem();
        click_refresh = new javax.swing.JMenuItem();
        click_pagar = new javax.swing.JMenuItem();
        click_eliminar = new javax.swing.JMenuItem();
        click_probar_cliente = new javax.swing.JMenuItem();
        click_programar_corte = new javax.swing.JMenuItem();
        click_eliminar_corte = new javax.swing.JMenuItem();
        click_abrir_antenaAP = new javax.swing.JMenuItem();
        clic_dia_de_corte = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        entryNombre = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        entryUsername = new javax.swing.JTextField();

        clic_asignar_ap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/wi-fi-alternativo.png"))); // NOI18N
        clic_asignar_ap.setText("Asignar Antena AP");
        clic_asignar_ap.setActionCommand("ANTENA AP / NAP");
        clic_asignar_ap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clic_asignar_apActionPerformed(evt);
            }
        });
        submenu_clientes.add(clic_asignar_ap);

        click_bloquear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/bloquear-hashtag.png"))); // NOI18N
        click_bloquear.setText("Bloquear");
        click_bloquear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                click_bloquearActionPerformed(evt);
            }
        });
        submenu_clientes.add(click_bloquear);

        click_desbloquear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/desbloquear.png"))); // NOI18N
        click_desbloquear.setText("Desbloquear");
        click_desbloquear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                click_desbloquearActionPerformed(evt);
            }
        });
        submenu_clientes.add(click_desbloquear);

        click_agregar_queue.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/barco.png"))); // NOI18N
        click_agregar_queue.setText("Dar de alta MikroTik");
        click_agregar_queue.setToolTipText("");
        click_agregar_queue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                click_agregar_queueActionPerformed(evt);
            }
        });
        submenu_clientes.add(click_agregar_queue);

        click_actualizar_velocidad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/tacometro-alt-mas-rapido.png"))); // NOI18N
        click_actualizar_velocidad.setText("Actualizar Velocidad");
        click_actualizar_velocidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                click_actualizar_velocidadActionPerformed(evt);
            }
        });
        submenu_clientes.add(click_actualizar_velocidad);

        clic_asignarr_paquete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/mundo.png"))); // NOI18N
        clic_asignarr_paquete.setText("Asignar paquetes");
        clic_asignarr_paquete.setActionCommand("PAQUETES");
        clic_asignarr_paquete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clic_asignarr_paqueteActionPerformed(evt);
            }
        });
        submenu_clientes.add(clic_asignarr_paquete);

        click_editar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/lapiz.png"))); // NOI18N
        click_editar.setText("Editar");
        click_editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                click_editarActionPerformed(evt);
            }
        });
        submenu_clientes.add(click_editar);

        click_refresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/actualizar.png"))); // NOI18N
        click_refresh.setText("Recargar");
        click_refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                click_refreshActionPerformed(evt);
            }
        });
        submenu_clientes.add(click_refresh);

        click_pagar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cartera.png"))); // NOI18N
        click_pagar.setText("Regitrar pago");
        click_pagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                click_pagarActionPerformed(evt);
            }
        });
        submenu_clientes.add(click_pagar);

        click_eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/borrar.png"))); // NOI18N
        click_eliminar.setText("Eliminar");
        click_eliminar.setToolTipText("");
        click_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                click_eliminarActionPerformed(evt);
            }
        });
        submenu_clientes.add(click_eliminar);

        click_probar_cliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/carta-red.png"))); // NOI18N
        click_probar_cliente.setText("Probar cliente");
        click_probar_cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                click_probar_clienteActionPerformed(evt);
            }
        });
        submenu_clientes.add(click_probar_cliente);

        click_programar_corte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/comparar-codigo.png"))); // NOI18N
        click_programar_corte.setText("Programar cortes");
        click_programar_corte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                click_programar_corteActionPerformed(evt);
            }
        });
        submenu_clientes.add(click_programar_corte);

        click_eliminar_corte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/boleto-alternativo.png"))); // NOI18N
        click_eliminar_corte.setText("Eliminar Corte");
        click_eliminar_corte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                click_eliminar_corteActionPerformed(evt);
            }
        });
        submenu_clientes.add(click_eliminar_corte);

        click_abrir_antenaAP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/antena-parabolica.png"))); // NOI18N
        click_abrir_antenaAP.setText("Abrir en Navegador");
        click_abrir_antenaAP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                click_abrir_antenaAPActionPerformed(evt);
            }
        });
        submenu_clientes.add(click_abrir_antenaAP);

        clic_dia_de_corte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ajustes.png"))); // NOI18N
        clic_dia_de_corte.setText("Dia de Corte");
        clic_dia_de_corte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clic_dia_de_corteActionPerformed(evt);
            }
        });
        submenu_clientes.add(clic_dia_de_corte);

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Clientes");
        addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                formAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Clientes"));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Telefono", "Microtik/OLT", "Direccion", "Instalacion", "Paquete", "IP Cliente", "Corte", "Antena AP", "TV", "Strem", "Estado"
            }
        ));
        jTable1.setComponentPopupMenu(submenu_clientes);
        jTable1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setMinWidth(50);
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(50);
            jTable1.getColumnModel().getColumn(0).setMaxWidth(50);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1072, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 458, Short.MAX_VALUE)
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Busqueda"));

        jLabel1.setText("Ingresa nombre, telefono, ip etc");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/busqueda.png"))); // NOI18N
        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/actualizar.png"))); // NOI18N
        jButton2.setText("Refrescar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jButton2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButton2KeyPressed(evt);
            }
        });

        entryUsername.setEnabled(false);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(entryUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(entryNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(entryNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(entryUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void insertarUsername(String username){
        entryUsername.setText(username);
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String busqueda = entryNombre.getText();
        DefaultTableModel modelo = new DefaultTableModel();
        modelo = (DefaultTableModel) jTable1.getModel();
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(modelo);
        jTable1.setRowSorter(sorter);

        if (busqueda.isBlank()) {
            JOptionPane.showMessageDialog(null, "Por favor ingresa un valor");
        } else {
            sorter.setRowFilter(RowFilter.regexFilter("(?i)" + busqueda));
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void click_bloquearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_click_bloquearActionPerformed
        bloquearCliente();
        // TODO add your handling code here:
    }//GEN-LAST:event_click_bloquearActionPerformed

    private void click_desbloquearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_click_desbloquearActionPerformed
        debloquearCliente();
        // TODO add your handling code here:
    }//GEN-LAST:event_click_desbloquearActionPerformed

    private void click_agregar_queueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_click_agregar_queueActionPerformed
      agregarQueue();
        // TODO add your handling code here:
    }//GEN-LAST:event_click_agregar_queueActionPerformed

    private void click_actualizar_velocidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_click_actualizar_velocidadActionPerformed
        cambioVelocidad();
        // TODO add your handling code here:
    }//GEN-LAST:event_click_actualizar_velocidadActionPerformed

    private void click_editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_click_editarActionPerformed
        int filaSeleccionada;
        try {
            filaSeleccionada = jTable1.getSelectedRow();

            if (filaSeleccionada >= 0) {
                int id = (int) jTable1.getValueAt(filaSeleccionada, 0);
                String nombre = (String) jTable1.getValueAt(filaSeleccionada, 1);
                String telefono = (String) jTable1.getValueAt(filaSeleccionada, 2);
                String microtikActual = (String) jTable1.getValueAt(filaSeleccionada, 3);
                String direccion = (String) jTable1.getValueAt(filaSeleccionada, 4);
                String paquete = (String) jTable1.getValueAt(filaSeleccionada, 6);
                String ip_cliente = (String) jTable1.getValueAt(filaSeleccionada, 7);
                String dia_corte = (String) jTable1.getValueAt(filaSeleccionada, 8);
                String antenaAP = (String) jTable1.getValueAt(filaSeleccionada, 9);
                String tv = (String) jTable1.getValueAt(filaSeleccionada, 10);
                String stream = (String) jTable1.getValueAt(filaSeleccionada, 11);
                String correo = "";

                editarCliente eCliente = new editarCliente(id, nombre, telefono, ip_cliente, dia_corte, paquete, antenaAP,
                        stream, tv, correo, direccion, microtikActual);
                Dashboard.escritorioInterno.add(eCliente);
                eCliente.show();
            } else {
                JOptionPane.showMessageDialog(rootPane, "Primero selecciona un elemento", "SpiderNET", JOptionPane.WARNING_MESSAGE);
            }
        } catch (Exception e) {
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_click_editarActionPerformed

    private void click_refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_click_refreshActionPerformed
    listarClientes();
        // TODO add your handling code here:
    }//GEN-LAST:event_click_refreshActionPerformed

    private void click_pagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_click_pagarActionPerformed
        int filaSeleccionada;
        filaSeleccionada = jTable1.getSelectedRow();
        if (filaSeleccionada >= 0) {
            int id = (int) jTable1.getValueAt(filaSeleccionada, 0);
            String nombre = (String) jTable1.getValueAt(filaSeleccionada, 1);
            String paquete = (String) jTable1.getValueAt(filaSeleccionada, 6);
            String direccionIp = (String) jTable1.getValueAt(filaSeleccionada, 7);
            String servicios = (String) jTable1.getValueAt(filaSeleccionada, 11);
            String nombreMicrotik = (String)jTable1.getValueAt(filaSeleccionada, 3);
            String diaCorte = (String)jTable1.getValueAt(filaSeleccionada, 8);
            String username = entryUsername.getText();
            pagoWindows windows = new pagoWindows(id, nombre, paquete, servicios, direccionIp, nombreMicrotik, diaCorte, username);
            Dashboard.escritorioInterno.add(windows);
            windows.show();
        } else {
            JOptionPane.showMessageDialog(null, "Para registrar un pago, seleccione el cliente", "SpiderNET", JOptionPane.WARNING_MESSAGE);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_click_pagarActionPerformed

    private void click_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_click_eliminarActionPerformed
        int filaSeleccionada;
        try {
            filaSeleccionada = jTable1.getSelectedRow();

            if (filaSeleccionada >= 0) {
                int id = (int) jTable1.getValueAt(filaSeleccionada, 0);
                String target = (String)jTable1.getValueAt(filaSeleccionada, 7);
                String mikoritik = (String)jTable1.getValueAt(filaSeleccionada, 3);
                listarClientes();
                DeleteDatos deleteDatos = new DeleteDatos();
                deleteDatos.eliminarCliente(id);
                listarClientes();
                eliminarQueue(mikoritik, target);
            } else {
                JOptionPane.showMessageDialog(rootPane, "Para eliminar un cliente, primero seleccionelo", "SpiderNET", JOptionPane.WARNING_MESSAGE);
            }
        } catch (Exception e) {
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_click_eliminarActionPerformed

    private void click_probar_clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_click_probar_clienteActionPerformed
        testConexion();
        // TODO add your handling code here:
    }//GEN-LAST:event_click_probar_clienteActionPerformed

    private void click_programar_corteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_click_programar_corteActionPerformed
        try {
            programarTarea();
            // TODO add your handling code here:
        } catch (ApiConnectionException ex) {
            Logger.getLogger(moduloClientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_click_programar_corteActionPerformed

    private void click_eliminar_corteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_click_eliminar_corteActionPerformed
        try {
            eliminarTareaALV();
            // TODO add your handling code here:
        } catch (ApiConnectionException ex) {
            Logger.getLogger(moduloClientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_click_eliminar_corteActionPerformed

    private void jButton2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton2KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2KeyPressed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        listarClientes();
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void click_abrir_antenaAPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_click_abrir_antenaAPActionPerformed
        int fila = jTable1.getSelectedRow();
        if (fila >= 0) {
            String ip = (String) jTable1.getValueAt(fila, 7);

            if (ip == null || ip.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Debe existir primero una IP válida");
            } else {
                NavegadorUtil.abrirIPEnNavegador(ip);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Por favor selecciona un elemento primero");
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_click_abrir_antenaAPActionPerformed

    private void clic_dia_de_corteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clic_dia_de_corteActionPerformed
        seleccionarDiaYAplicar();
        // TODO add your handling code here:
    }//GEN-LAST:event_clic_dia_de_corteActionPerformed

    private void formAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_formAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_formAncestorAdded

    private void clic_asignarr_paqueteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clic_asignarr_paqueteActionPerformed
        aplicarPaqueteMultiple();
        // TODO add your handling code here:
    }//GEN-LAST:event_clic_asignarr_paqueteActionPerformed

    private void clic_asignar_apActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clic_asignar_apActionPerformed
        aplicarAntenaAPMultiple();
    }//GEN-LAST:event_clic_asignar_apActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem clic_asignar_ap;
    private javax.swing.JMenuItem clic_asignarr_paquete;
    private javax.swing.JMenuItem clic_dia_de_corte;
    private javax.swing.JMenuItem click_abrir_antenaAP;
    private javax.swing.JMenuItem click_actualizar_velocidad;
    private javax.swing.JMenuItem click_agregar_queue;
    private javax.swing.JMenuItem click_bloquear;
    private javax.swing.JMenuItem click_desbloquear;
    private javax.swing.JMenuItem click_editar;
    private javax.swing.JMenuItem click_eliminar;
    private javax.swing.JMenuItem click_eliminar_corte;
    private javax.swing.JMenuItem click_pagar;
    private javax.swing.JMenuItem click_probar_cliente;
    private javax.swing.JMenuItem click_programar_corte;
    private javax.swing.JMenuItem click_refresh;
    private javax.swing.JTextField entryNombre;
    private javax.swing.JTextField entryUsername;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JPopupMenu submenu_clientes;
    // End of variables declaration//GEN-END:variables

    private void listarClientes() {
        Conexion conexion = new Conexion();
        Connection cn = conexion.getConnection();

        if (cn != null) {
            Statement st = null;
            ResultSet rs = null;

            try {
                String sql = """
                            SELECT 
                             c.id,
                             c.nombre,
                             c.telefono,
                             cm.nombre AS microtik_nombre,
                             c.direccion,
                             DATE_FORMAT(c.fecha_registro, '%d/%m/%Y') AS fecha_registro,
                             p.nombre AS paquete,
                             c.ip_cliente,
                             c.dia_corte,
                             a.nombre AS antena_ap,
                             c.serviciosTV,
                             sp.nombre AS servicio_plataforma,
                             c.estado
                         FROM clientes c
                         LEFT JOIN paquetes p ON c.id_paquete = p.id
                         LEFT JOIN credenciales_microtik cm ON c.id_microtik = cm.id
                         LEFT JOIN antenasap a ON c.id_antena_ap = a.idantenasAp
                         LEFT JOIN serviciosplataforma sp ON c.id_servicio_plataforma = sp.idPlataformas;
                         """;
                DefaultTableModel modelo;
                st = cn.createStatement();
                rs = st.executeQuery(sql);
                Object[] clientes = new Object[13];

                modelo = (DefaultTableModel) jTable1.getModel();
                modelo.setRowCount(0);

                while (rs.next()) {
                    clientes[0] = rs.getInt("id");
                    clientes[1] = rs.getString("nombre");
                    clientes[2] = rs.getString("telefono");
                    clientes[3] = rs.getString("microtik_nombre");
                    clientes[4] = rs.getString("direccion");
                    clientes[5] = rs.getString("fecha_registro");
                    clientes[6] = rs.getString("paquete");
                    clientes[7] = rs.getString("ip_cliente");
                    clientes[8] = rs.getString("dia_corte");
                    clientes[9] = rs.getString("antena_ap");
                    clientes[10] = rs.getString("serviciosTV");
                    clientes[11] = rs.getString("servicio_plataforma");
                    clientes[12] = rs.getString("estado");

                    modelo.addRow(clientes);
                }

                jTable1.setModel(modelo);

                // 🔥 AQUI: Agregar ordenamiento con TableRowSorter
                TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(modelo);
                jTable1.setRowSorter(sorter);

                // (Opcional) Ordenar por nombre alfabéticamente por defecto
                // sorter.setSortKeys(Arrays.asList(new RowSorter.SortKey(1, SortOrder.ASCENDING)));
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(rootPane, "Error al listar los clientes: " + e, "SpiderNET", JOptionPane.ERROR_MESSAGE);
            } finally {
                conexion.closeConnection();
            }

        } else {
            JOptionPane.showMessageDialog(rootPane, "No logramos establecer una conexion", "Modulo Clientes", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void buscarCliente() {
        String nombre = entryNombre.getText();

        if (nombre.isBlank()) {
            JOptionPane.showMessageDialog(null, "Para buscar, ingrese el nombre del cliente primero.");
            return;
        }

        Conexion conexion = new Conexion();
        Connection cn = conexion.getConnection();

        if (cn != null) {
            PreparedStatement ps = null;
            ResultSet rs = null;

            try {
                String sql = """
                            SELECT 
                             c.id,
                             c.nombre,
                             c.telefono,
                             cm.nombre AS microtik_nombre,  -- Obtener el nombre en lugar del id_microtik
                             c.direccion,
                             DATE_FORMAT(c.fecha_registro, '%d/%m/%Y') AS fecha_registro,  -- Formato de la fecha
                             p.nombre AS paquete,  -- Obtener el nombre del paquete
                             c.ip_cliente,
                             c.dia_corte,
                             c.ap_antena,
                             c.serviciosTV,
                             c.serviciosPlataformas
                             FROM clientes c
                             LEFT JOIN paquetes p ON c.id_paquete = p.id
                             LEFT JOIN credenciales_microtik cm ON c.id_microtik = cm.id
                             WHERE c.nombre LIKE ?;  -- Unir con la tabla credenciales_microtik
                         """;

                ps = cn.prepareStatement(sql);
                ps.setString(1, "%" + nombre + "%"); // Buscar nombres que contengan la palabra ingresada
                rs = ps.executeQuery();

                DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
                modelo.setRowCount(0); // Limpiar la tabla antes de agregar los resultados

                while (rs.next()) {
                    Object[] clientes = new Object[12];
                    clientes[0] = rs.getInt("id");
                    clientes[1] = rs.getString("nombre");
                    clientes[2] = rs.getString("telefono");
                    clientes[3] = rs.getString("microtik_nombre");
                    clientes[4] = rs.getString("direccion");
                    clientes[5] = rs.getString("fecha_registro");
                    clientes[6] = rs.getString("paquete");
                    clientes[7] = rs.getString("ip_cliente");
                    clientes[8] = rs.getString("dia_corte");
                    clientes[9] = rs.getString("ap_antena");
                    clientes[10] = rs.getString("serviciosTV");
                    clientes[11] = rs.getString("serviciosPlataformas");

                    modelo.addRow(clientes);
                }
                jTable1.setModel(modelo);
                
                
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al listar los clientes: " + e, "SpiderNET", JOptionPane.ERROR_MESSAGE);
            } finally {
                try {
                    if (rs != null) {
                        rs.close();
                    }
                    if (ps != null) {
                        ps.close();
                    }
                    conexion.closeConnection();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "No logramos establecer una conexión", "Módulo Clientes", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void bloquearCliente() {
        int filaSeleccionada;
        filaSeleccionada = jTable1.getSelectedRow();
        if (filaSeleccionada >= 0) {
            String nombreMicrotik = (String) jTable1.getValueAt(filaSeleccionada, 3);
            String nombreCliente = (String) jTable1.getValueAt(filaSeleccionada, 1);
            String targetIp = (String) jTable1.getValueAt(filaSeleccionada, 7);
            int id = (int) jTable1.getValueAt(filaSeleccionada, 0);

            Conexion conexion = new Conexion();
            Connection cn = conexion.getConnection();

            if (cn != null) {
                PreparedStatement cursor;
                ResultSet resultado;
                String sql = "SELECT ip, username, password FROM credenciales_microtik WHERE nombre = ?";
                try {
                    cursor = cn.prepareStatement(sql);
                    cursor.setString(1, nombreMicrotik);

                    resultado = cursor.executeQuery();

                    if (resultado.next()) {
                        String user = resultado.getString("username");
                        String password = resultado.getString("password");
                        String routerIp = resultado.getString("ip");

                        //lucifer bloqueo = new lucifer();
                       // bloqueo.bloqueoCliente(routerIp, user, password, targetIp);
                        //String routerIp, String user, String password, String targetIp
                        //(String address, String user, String host, String password)
                        PPoEAuto auto = new PPoEAuto();
                        auto.bloquearClientePPoE(id,nombreCliente, targetIp, user, routerIp, password);
                        UpdateDatos datos = new UpdateDatos();
                        String estado = "Bloqueado";
                        datos.bloqueo(id, estado);
                    }

                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "Problema con la base de datos: " + e);
                    System.out.println(e);
                    // TODO: handle exception
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Primero selecciona un cliente para bloquearlo");
        }
    }

    public void debloquearCliente() {
        int filaSeleccionada;
        filaSeleccionada = jTable1.getSelectedRow();
        if (filaSeleccionada >= 0) {
            int id = (int)jTable1.getValueAt(filaSeleccionada, 0);
            String nombreMicrotik = (String) jTable1.getValueAt(filaSeleccionada, 3);
            String targetIp = (String) jTable1.getValueAt(filaSeleccionada, 7);

            Conexion conexion = new Conexion();
            Connection cn = conexion.getConnection();

            if (cn != null) {
                PreparedStatement cursor;
                ResultSet resultado;
                String sql = "SELECT ip, username, password FROM credenciales_microtik WHERE nombre = ?";
                try {
                    cursor = cn.prepareStatement(sql);
                    cursor.setString(1, nombreMicrotik);

                    resultado = cursor.executeQuery();

                    if (resultado.next()) {
                        String user = resultado.getString("username");
                        String password = resultado.getString("password");
                        String routerIp = resultado.getString("ip");

                        //lucifer bloqueo = new lucifer();
                        //bloqueo.desbloqueoCliente(routerIp, user, password, targetIp);
                        //String routerIp, String user, String password, String targetIp
                        //String ipCliente, String user, String password, String host
                        PPoEAuto auto = new PPoEAuto();
                        auto.desbloquearCliente(targetIp, user, password, routerIp);
                        UpdateDatos datos = new UpdateDatos();
                        String estado = "Activo";
                        datos.bloqueo(id, estado);
                    }

                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "Problema con la base de datos: " + e);
                    System.out.println(e);
                    // TODO: handle exception
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Primero selecciona un cliente para bloquearlo");
        }
    }

    public void agregarQueue() {
        int filaSeleccionada;
        filaSeleccionada = jTable1.getSelectedRow();
        if (filaSeleccionada >= 0) {
            String nombreCliente = (String) jTable1.getValueAt(filaSeleccionada, 1);
            String ipCliente = (String) jTable1.getValueAt(filaSeleccionada, 7);
            String paquete = (String) jTable1.getValueAt(filaSeleccionada, 6);
            String nombreMicrotik = (String) jTable1.getValueAt(filaSeleccionada, 3);

            Conexion conexion = new Conexion();
            Connection cn = conexion.getConnection();

            if (cn != null) {
                PreparedStatement cursor;
                ResultSet resultado;
                String sql = "SELECT ip, username, password FROM credenciales_microtik WHERE nombre = ?";
                try {
                    cursor = cn.prepareStatement(sql);
                    cursor.setString(1, nombreMicrotik);

                    resultado = cursor.executeQuery();

                    if (resultado.next()) {
                        String user = resultado.getString("username");
                        String password = resultado.getString("password");
                        String routerIp = resultado.getString("ip");
                        //String nombreCliente, String ipCliente, String paquete, String ipMicrotik, String username, String password)
                        crearSimpleQueue queue = new crearSimpleQueue(nombreCliente, ipCliente, paquete, routerIp, user, password);
                        Dashboard.escritorioInterno.add(queue);
                        queue.show();
                    }

                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "Problema con la base de datos: " + e);
                    System.out.println(e);
                    // TODO: handle exception
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Primero selecciona un cliente para agregarlo");
        }
    }

    public void cambioVelocidad() {
        int filaSeleccionada;
        filaSeleccionada = jTable1.getSelectedRow();

        if (filaSeleccionada >= 0) {
            //String nombreCliente, String ip, String paquete
            String targetIp = (String) jTable1.getValueAt(filaSeleccionada, 7);
            String paquete = (String) jTable1.getValueAt(filaSeleccionada, 6);
            String microtik = (String) jTable1.getValueAt(filaSeleccionada, 3);

            //String routerIp, String user, String password, String targetIp, String maxLimit
            Conexion conexion = new Conexion();
            Connection cn = conexion.getConnection();
            if (cn != null) {
                PreparedStatement cursor;
                PreparedStatement cursorPaquete;
                ResultSet resultado;
                ResultSet resultadoPaquete;
                //obtener las credenciales del microtik primero
                String sql = "SELECT ip, username, password FROM credenciales_microtik WHERE nombre = ?";
                try {
                    cursor = cn.prepareStatement(sql);
                    cursor.setString(1, microtik);
                    resultado = cursor.executeQuery();

                    if (resultado.next()) {
                        String routerIp = resultado.getString("ip");
                        String user = resultado.getString("username");
                        String password = resultado.getString("password");
                        //obtener la velocidad del paquete
                        //esta velocidad se obtiene solo si encontramos el microtik
                        try {
                            String sqlPaquete = "SELECT velocidad FROM paquetes WHERE nombre = ?";
                            cursorPaquete = cn.prepareStatement(sqlPaquete);
                            cursorPaquete.setString(1, paquete);
                            resultadoPaquete = cursorPaquete.executeQuery();

                            if (resultadoPaquete.next()) {
                                String maxLimit = resultadoPaquete.getString("velocidad");
                                String tiempoBurst = "20s";
                                cambioVelocidad cambio = new cambioVelocidad();
                                cambio.cambioVelocidad(routerIp, user, password, targetIp, maxLimit, tiempoBurst);
                            } else {
                                JOptionPane.showMessageDialog(null, "No podemos enctrar los datos de este paquete");
                            }

                        } catch (SQLException e) {
                            JOptionPane.showMessageDialog(rootPane, "Problemas con la consulta del paquete: " + e);
                        }

                    } else {
                        JOptionPane.showMessageDialog(null, "Lo sentimos no encontramos nada");
                    }
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "Tenemos problemas con la bd: " + e);
                }
            }

        } else {
            JOptionPane.showMessageDialog(null, "Por favor selecciona un cliente para el cambio de velocidad");
        }
    }




    public void actualizarQueue(){
        //String address, String newName, String user, String password, String host
        int filaSeleccionada = jTable1.getSelectedRow();
        if(filaSeleccionada>=0){
            
            Conexion conexion = new Conexion();
            Connection cn = conexion.getConnection();
            String sql = "SELECT ip, username, password FROM credenciales_microtik WHERE nombre = ?";
            PreparedStatement cursor;
            ResultSet resultado;
            try {
                String nombreMicrotik = (String)jTable1.getValueAt(filaSeleccionada, 3);
                cursor = cn.prepareStatement(sql);
                cursor.setString(1, nombreMicrotik);
                
                resultado = cursor.executeQuery();
                
                if(resultado.next()){
                    String host = resultado.getString("ip");
                    String user = resultado.getString("username");
                    String password = resultado.getString("password");
                    String newName = (String)jTable1.getValueAt(filaSeleccionada, 1);
                    String address = (String)jTable1.getValueAt(filaSeleccionada, 7);
                    
                    newName = newName.trim();
                    newName = newName.replaceAll("[^a-zA-Z0-9]", "");
                    
                    actualizaQueueTask qt = new actualizaQueueTask();
                    qt.actualizarQueue(address, newName, user, password, host);
                    
                    cn.close();
                }else{
                    JOptionPane.showMessageDialog(null, "No encontramos informacion para este microtik: " + nombreMicrotik);
                }
            } catch (Exception e) {
                System.out.println(e);
                JOptionPane.showMessageDialog(null, "Error al buscar el microtik en base de datos: " + e, "SpiderNET", JOptionPane.ERROR_MESSAGE);
            }
            
        }
    }
    
    public void testConexion(){
        int filaSeleccionada = jTable1.getSelectedRow();
        if(filaSeleccionada>=0){
        Conexion conexion = new Conexion();
        Connection cn = conexion.getConnection();
        String sql = "SELECT ip, username, password FROM credenciales_microtik WHERE nombre = ?";
        PreparedStatement cursor;
            ResultSet resultado;
            try {
                String nombreMicrotik = (String)jTable1.getValueAt(filaSeleccionada, 3);
                String direccion_ip = (String)jTable1.getValueAt(filaSeleccionada, 7);
                cursor = cn.prepareStatement(sql);
                cursor.setString(1, nombreMicrotik);
                
                resultado = cursor.executeQuery();
                
                if(resultado.next()){
                    String host = resultado.getString("ip");
                    String user = resultado.getString("username");
                    String password = resultado.getString("password");
                    testConnectionAsync async = new testConnectionAsync();
                    async.testPingFromMikrotikAsync(user, password, host, direccion_ip);
                    cn.close();
                }else{
                    JOptionPane.showMessageDialog(null, "Sin credenciales para el mikrotik");
                }
        }catch(Exception e){
                System.out.println("error de conexion: " + e);
                JOptionPane.showMessageDialog(null, "Error en conexion: " + e);
        }   
        }
    }
    
    public void eliminarQueue(String mikrotik, String targetIp) {
        Conexion conexion = new Conexion();
        Connection cn = conexion.getConnection();

        if (cn != null) {
            PreparedStatement cursor;
            ResultSet resultado;
            String sql = "SELECT ip, username, password FROM credenciales_microtik WHERE nombre = ?";

            try {
                cursor = cn.prepareStatement(sql);
                cursor.setString(1, mikrotik);
                resultado = cursor.executeQuery();

                if (resultado.next()) {
                    String user = resultado.getString("username");
                    String password = resultado.getString("password");
                    String routerIp = resultado.getString("ip");

                    // Confirmación del usuario
                    int opcion = JOptionPane.showConfirmDialog(
                            null,
                            "¿Estás seguro de que deseas eliminar la Simple Queue del cliente con IP: " + targetIp + "?",
                            "Confirmar eliminación",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.WARNING_MESSAGE
                    );

                    if (opcion == JOptionPane.YES_OPTION) {
                        simpleQueue queue = new simpleQueue();
                        queue.eliminarQueue(user, password, routerIp, targetIp);
                        JOptionPane.showMessageDialog(null, "Simple Queue eliminada con éxito.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Eliminación cancelada por el usuario.");
                    }
                }

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Problema con la base de datos: " + e.getMessage());
                System.out.println(e);
            }
        }
    }

    public void programarTarea() throws ApiConnectionException {
        int fila = jTable1.getSelectedRow();
        if (fila >= 0) {
            String nombre = (String) jTable1.getValueAt(fila, 1);
            String mikrotik = (String) jTable1.getValueAt(fila, 3);
            String target = (String) jTable1.getValueAt(fila, 7);
            String diaCorteStr = (String) jTable1.getValueAt(fila, 8);

            if (nombre == null || mikrotik == null || target == null || diaCorteStr == null || diaCorteStr.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Faltan datos necesarios para programar la tarea.\nVerifica que el nombre, router, IP y día de corte estén completos.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                return;
            }

            int diaCorte = Integer.parseInt(diaCorteStr);
            Conexion conexion = new Conexion();
            Connection cn = conexion.getConnection();
            if (cn != null) {
                String sql = "SELECT ip, username, password FROM credenciales_microtik WHERE nombre = ?";
                try (PreparedStatement cursor = cn.prepareStatement(sql)) {
                    cursor.setString(1, mikrotik);
                    ResultSet resultado = cursor.executeQuery();

                    if (resultado.next()) {
                        String user = resultado.getString("username");
                        String password = resultado.getString("password");
                        String routerIp = resultado.getString("ip");

                        taskMicrotik m = new taskMicrotik();
                        m.createTaskEsteMes(nombre, target, user, password, routerIp, diaCorte);
                    } else {
                        JOptionPane.showMessageDialog(null, "No se encontraron credenciales para el MikroTik: " + mikrotik, "Advertencia", JOptionPane.WARNING_MESSAGE);
                    }
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "Error al consultar la base de datos:\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo establecer conexión con la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecciona una fila de la tabla primero para programar la tarea.", "Información", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    public void eliminarTareaALV() throws ApiConnectionException {
        int fila = jTable1.getSelectedRow();
        if (fila >= 0) {
            String nombre = (String) jTable1.getValueAt(fila, 1);
            String mikrotik = (String) jTable1.getValueAt(fila, 3);
            String target = (String) jTable1.getValueAt(fila, 7);
            String diaCorteStr = (String) jTable1.getValueAt(fila, 8);

            if (nombre == null || mikrotik == null || target == null || diaCorteStr == null || diaCorteStr.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Faltan datos para eliminar la tarea.\nVerifica nombre, router, IP y día de corte.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                return;
            }

            int diaCorte = Integer.parseInt(diaCorteStr);
            Conexion conexion = new Conexion();
            Connection cn = conexion.getConnection();
            if (cn != null) {
                String sql = "SELECT ip, username, password FROM credenciales_microtik WHERE nombre = ?";
                try (PreparedStatement cursor = cn.prepareStatement(sql)) {
                    cursor.setString(1, mikrotik);
                    ResultSet resultado = cursor.executeQuery();

                    if (resultado.next()) {
                        String user = resultado.getString("username");
                        String password = resultado.getString("password");
                        String routerIp = resultado.getString("ip");

                        taskMicrotik m = new taskMicrotik();
                        m.eliminarTareaEnSegundoPlano(nombre, target, user, password, routerIp, diaCorte);
                    } else {
                        JOptionPane.showMessageDialog(null, "No se encontraron credenciales para el MikroTik: " + mikrotik, "Advertencia", JOptionPane.WARNING_MESSAGE);
                    }
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "Error al consultar la base de datos:\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo establecer conexión con la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecciona una fila de la tabla para eliminar la tarea.", "Información", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    public void seleccionarDiaYAplicar() {
        int[] filasSeleccionadas = jTable1.getSelectedRows();

        if (filasSeleccionadas.length == 0) {
            JOptionPane.showMessageDialog(null, "No hay filas seleccionadas.");
            return;
        }

        // Crear opciones de días del 1 al 31
        String[] dias = new String[31];
        for (int i = 0; i < 31; i++) {
            dias[i] = String.valueOf(i + 1);
        }

        // Mostrar un JOptionPane con combo box para elegir el día
        String diaSeleccionado = (String) JOptionPane.showInputDialog(
                null,
                "Selecciona el día de corte:",
                "Día de corte",
                JOptionPane.QUESTION_MESSAGE,
                null,
                dias,
                dias[0]
        );

        if (diaSeleccionado != null) {
            int dia = Integer.parseInt(diaSeleccionado);
            int actualizados = 0;

            // Conexión a base de datos
            Conexion conn = new Conexion();
            Connection cn = conn.getConnection();

            try {
                String sql = "UPDATE clientes SET dia_corte = ? WHERE id = ?";
                PreparedStatement ps = cn.prepareStatement(sql);

                for (int fila : filasSeleccionadas) {
                    // ID del cliente está en la columna 0
                    Object valorID = jTable1.getValueAt(fila, 0);
                    int idCliente = Integer.parseInt(valorID.toString());

                    // Actualizar en base de datos
                    ps.setInt(1, dia);
                    ps.setInt(2, idCliente);
                    ps.executeUpdate();

                    // Actualizar visualmente en tabla (columna 8)
                    jTable1.setValueAt(dia, fila, 8);
                    actualizados++;
                }

                ps.close();
                conn.closeConnection();

                JOptionPane.showMessageDialog(null, "Día de corte actualizado para " + actualizados + " cliente(s).");

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al actualizar día de corte: " + e.getMessage(), "Error BD", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    public void aplicarPaqueteMultiple() {
        int[] filasSeleccionadas = jTable1.getSelectedRows();

        if (filasSeleccionadas.length == 0) {
            JOptionPane.showMessageDialog(null, "No hay clientes seleccionados.");
            return;
        }

        // Obtener mapa de paquetes (nombre → id)
        Consultas consultas = new Consultas();
        Map<String, Integer> paquetes = consultas.consultarPaquetesConID();

        if (paquetes.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay paquetes disponibles.");
            return;
        }

        // Crear JComboBox con los nombres
        JComboBox<String> comboPaquetes = new JComboBox<>();
        for (String nombrePaquete : paquetes.keySet()) {
            comboPaquetes.addItem(nombrePaquete);
        }

        // Mostrar el combo en un JOptionPane
        int opcion = JOptionPane.showConfirmDialog(
                null,
                comboPaquetes,
                "Selecciona el paquete",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE
        );

        if (opcion == JOptionPane.OK_OPTION) {
            String paqueteSeleccionado = (String) comboPaquetes.getSelectedItem();
            int idPaquete = paquetes.get(paqueteSeleccionado);

            Conexion conexion = new Conexion();
            Connection cn = conexion.getConnection();

            try {
                String sql = "UPDATE clientes SET id_paquete = ? WHERE id = ?";
                PreparedStatement ps = cn.prepareStatement(sql);

                for (int fila : filasSeleccionadas) {
                    int idCliente = Integer.parseInt(jTable1.getValueAt(fila, 0).toString());

                    ps.setInt(1, idPaquete);
                    ps.setInt(2, idCliente);
                    ps.executeUpdate();

                    // (Opcional) actualizar visualmente en la tabla si tienes una columna con el nombre del paquete
                    // jTable1.setValueAt(paqueteSeleccionado, fila, COLUMNA_NOMBRE_PAQUETE);
                }

                ps.close();
                conexion.closeConnection();

                JOptionPane.showMessageDialog(null, "Se asignó el paquete \"" + paqueteSeleccionado + "\" a " + filasSeleccionadas.length + " cliente(s).");

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al asignar el paquete: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    public void aplicarAntenaAPMultiple() {
        int[] filasSeleccionadas = jTable1.getSelectedRows();

        if (filasSeleccionadas.length == 0) {
            JOptionPane.showMessageDialog(null, "No hay clientes seleccionados.");
            return;
        }

        // Obtener mapa de antenas (nombre → id)
        Consultas consultas = new Consultas();
        Map<String, Integer> antenas = consultas.consultarAntenasConID();

        if (antenas.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay antenas disponibles.");
            return;
        }

        // Crear JComboBox con los nombres de las antenas
        JComboBox<String> comboAntenas = new JComboBox<>();
        for (String nombreAntena : antenas.keySet()) {
            comboAntenas.addItem(nombreAntena);
        }

        // Mostrar combo en JOptionPane
        int opcion = JOptionPane.showConfirmDialog(
                null,
                comboAntenas,
                "Selecciona la antena AP para los clientes seleccionados",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE
        );

        if (opcion == JOptionPane.OK_OPTION) {
            String antenaSeleccionada = (String) comboAntenas.getSelectedItem();
            int idAntena = antenas.get(antenaSeleccionada);

            Conexion conexion = new Conexion();
            Connection cn = conexion.getConnection();

            try {
                String sql = "UPDATE clientes SET id_antena_ap = ? WHERE id = ?";
                PreparedStatement ps = cn.prepareStatement(sql);

                for (int fila : filasSeleccionadas) {
                    int idCliente = Integer.parseInt(jTable1.getValueAt(fila, 0).toString());

                    ps.setInt(1, idAntena);
                    ps.setInt(2, idCliente);
                    ps.executeUpdate();

                    // (Opcional) Actualiza también la tabla si tienes la columna del nombre de la antena
                    // jTable1.setValueAt(antenaSeleccionada, fila, COLUMNA_NOMBRE_ANTENA);
                }

                ps.close();
                conexion.closeConnection();

                JOptionPane.showMessageDialog(null, "Se asignó la antena \"" + antenaSeleccionada + "\" a " + filasSeleccionadas.length + " cliente(s).");

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al asignar la antena AP: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

}
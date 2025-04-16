package morty.Vustas;

import Config.Conexion;
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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;
import me.legrange.mikrotik.ApiConnectionException;
import microtik.PPoEAuto;
import microtik.actualizaQueueTask;
import microtik.simpleQueue;
import microtik.taskMicrotik;
import microtik.testConnectionAsync;

public class moduloClientes extends javax.swing.JInternalFrame {

    public moduloClientes() {
        initComponents();
        listarClientes();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        submenu_clientes = new javax.swing.JPopupMenu();
        click_bloquear = new javax.swing.JMenuItem();
        click_desbloquear = new javax.swing.JMenuItem();
        click_agregar_queue = new javax.swing.JMenuItem();
        click_actualizar_velocidad = new javax.swing.JMenuItem();
        click_editar = new javax.swing.JMenuItem();
        click_refresh = new javax.swing.JMenuItem();
        click_pagar = new javax.swing.JMenuItem();
        click_eliminar = new javax.swing.JMenuItem();
        click_probar_cliente = new javax.swing.JMenuItem();
        click_programar_corte = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        entryNombre = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        entryIpBusqueda = new javax.swing.JTextField();
        btnBuscarIP = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

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

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/boleto-alternativo.png"))); // NOI18N
        jMenuItem1.setText("Eliminar Corte");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        submenu_clientes.add(jMenuItem1);

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Clientes");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Clientes"));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Telefono", "Microtik/OLT", "Direccion", "Instalacion", "Paquete", "IP Cliente", "Corte", "Antena AP", "TV", "Strem"
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
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 454, Short.MAX_VALUE)
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Busqueda"));

        jLabel1.setText("Nombre del cliente");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/busqueda.png"))); // NOI18N
        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setText("Direccion IP");

        entryIpBusqueda.setText("192.168.30.254");

        btnBuscarIP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/busqueda.png"))); // NOI18N
        btnBuscarIP.setText("Buscar IP");
        btnBuscarIP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarIPActionPerformed(evt);
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

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("AdmiNET");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(entryNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(entryIpBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBuscarIP)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
                    .addComponent(jLabel3)
                    .addComponent(entryIpBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarIP)
                    .addComponent(jButton2)
                    .addComponent(jLabel2))
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
            pagoWindows windows = new pagoWindows(id, nombre, paquete, servicios, direccionIp, nombreMicrotik, diaCorte);
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

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        try {
            eliminarTareaALV();
            // TODO add your handling code here:
        } catch (ApiConnectionException ex) {
            Logger.getLogger(moduloClientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jButton2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton2KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2KeyPressed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        listarClientes();
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnBuscarIPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarIPActionPerformed
        buscarIp();
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBuscarIPActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarIP;
    private javax.swing.JMenuItem click_actualizar_velocidad;
    private javax.swing.JMenuItem click_agregar_queue;
    private javax.swing.JMenuItem click_bloquear;
    private javax.swing.JMenuItem click_desbloquear;
    private javax.swing.JMenuItem click_editar;
    private javax.swing.JMenuItem click_eliminar;
    private javax.swing.JMenuItem click_pagar;
    private javax.swing.JMenuItem click_probar_cliente;
    private javax.swing.JMenuItem click_programar_corte;
    private javax.swing.JMenuItem click_refresh;
    private javax.swing.JTextField entryIpBusqueda;
    private javax.swing.JTextField entryNombre;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenuItem jMenuItem1;
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
                             sp.nombre AS servicio_plataforma
                         FROM clientes c
                         LEFT JOIN paquetes p ON c.id_paquete = p.id
                         LEFT JOIN credenciales_microtik cm ON c.id_microtik = cm.id
                         LEFT JOIN antenasap a ON c.id_antena_ap = a.idantenasAp
                         LEFT JOIN serviciosplataforma sp ON c.id_servicio_plataforma = sp.idPlataformas;
                         """;
                DefaultTableModel modelo;
                st = cn.createStatement();
                rs = st.executeQuery(sql);
                Object[] clientes = new Object[12];

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
                        auto.bloquearClientePPoE(targetIp, user, routerIp, password);
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

    private void buscarIp() {
        String ipCliente = entryIpBusqueda.getText();

        if (ipCliente.isBlank()) {
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
                             WHERE c.ip_cliente LIKE ?;  -- Unir con la tabla credenciales_microtik
                         """;

                ps = cn.prepareStatement(sql);
                ps.setString(1, "%" + ipCliente + "%"); // Buscar nombres que contengan la palabra ingresada
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

    public void bloquearPPPoE() {
        int rows = jTable1.getSelectedRow();
        if (rows >= 0) {
            String addres = (String) jTable1.getValueAt(rows, 7);
            String nombreMicrotik = (String) jTable1.getValueAt(rows, 3);
            String nuevoPerfil = "";
            if (addres.isBlank() && nombreMicrotik.isBlank()) {
                JOptionPane.showConfirmDialog(null, "El campo de microtik e ip no deben estar solos");
            } else {
                String modo = "bloqueo";
                buscarCredencialesPPPoE(modo, addres, nombreMicrotik, nuevoPerfil);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Por favor primero selecciona un cliente");
        }
    }

    public void desbloquearPPPoE() {
        int rows = jTable1.getSelectedRow();
        if (rows >= 0) {
            String addres = (String) jTable1.getValueAt(rows, 7);
            String nombreMicrotik = (String) jTable1.getValueAt(rows, 3);
            String nuevoPerfil = "";
            if (addres.isBlank() && nombreMicrotik.isBlank()) {
                JOptionPane.showConfirmDialog(null, "El campo de microtik e ip no deben estar solos");
            } else {
                String modo = "desbloqueo";
                buscarCredencialesPPPoE(modo, addres, nombreMicrotik, nuevoPerfil);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Por favor primero selecciona un cliente");
        }
    }
    public void actualizarVelocidadPPoE() {
        int rows = jTable1.getSelectedRow();
        if (rows >= 0) {
            String addres = (String) jTable1.getValueAt(rows, 7);
            String nombreMicrotik = (String) jTable1.getValueAt(rows, 3);
            String nuevoPerfil = (String)jTable1.getValueAt(rows, 6);
            if (addres.isBlank() && nombreMicrotik.isBlank() && nuevoPerfil.isBlank()) {
                JOptionPane.showConfirmDialog(null, "El campo de microtik e ip no deben estar solos");
            } else {
                String modo = "cambio_limit";
                buscarCredencialesPPPoE(modo, addres, nombreMicrotik, nuevoPerfil);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Por favor primero selecciona un cliente");
        }
    }
  
    public void buscarCredencialesPPPoE(String modo, String addres, String nombreMicrotik, String nuevoPerfil) {
        Conexion conexion = new Conexion();
        Connection cn = conexion.getConnection();
        if (cn != null) {
            PreparedStatement cursor;
            ResultSet resultado;
            String sql = "SELECT ip, username, password FROM credenciales_microtik WHERE nombre = ? LIMIT 1";
            try {
                cursor = cn.prepareStatement(sql);
                cursor.setString(1, nombreMicrotik);
                resultado = cursor.executeQuery();
                if (resultado.next()) {
                    String user = resultado.getString("username");
                    String password = resultado.getString("password");
                    String host = resultado.getString("ip");

                    if (modo.equals("bloqueo")) {
                        PPoEAuto pPoEAuto = new PPoEAuto();
                        pPoEAuto.bloquearClientePPoE(addres, user, host, password);
                    } else if (modo.equals("desbloqueo")) {
                        PPoEAuto pPoEAuto = new PPoEAuto();
                        pPoEAuto.desbloquearCliente(addres, user, password, host);
                    } else if(modo.equals("cambio_limit")){
                        PPoEAuto auto = new PPoEAuto();
                        auto.actualizarProfilePorIP(addres, nuevoPerfil, user, password, host);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Tenemos problemas al buscar el microtik");
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Problemas con base de datos: " + e);
                // TODO: handle exception
            }
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

                    //lucifer bloqueo = new lucifer();
                    // bloqueo.bloqueoCliente(routerIp, user, password, targetIp);
                    //String routerIp, String user, String password, String targetIp
                    //(String address, String user, String host, String password)
                    simpleQueue queue = new simpleQueue();
                    queue.eliminarQueue(user, password, routerIp, targetIp);
                }

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Problema con la base de datos: " + e);
                System.out.println(e);
                // TODO: handle exception
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

}
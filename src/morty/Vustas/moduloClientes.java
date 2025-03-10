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
import java.sql.*;
import microtik.cambioVelocidad;
import microtik.lucifer;
import Config.UpdateDatos;

public class moduloClientes extends javax.swing.JInternalFrame {

    public moduloClientes() {
        initComponents();
        listarClientes();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnRefrescar = new javax.swing.JButton();
        btnPagar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        btnBloquear = new javax.swing.JButton();
        btnSimpleQueue = new javax.swing.JButton();
        btnCambiarVelocidad = new javax.swing.JButton();
        btnDesbloquear = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        entryNombre = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        entryIpBusqueda = new javax.swing.JTextField();
        btnBuscarIP = new javax.swing.JButton();

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
                .addComponent(jScrollPane1))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Opciones Edicion"));

        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/lapiz.png"))); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/quitar-carpeta.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnRefrescar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/girar-cuadrado.png"))); // NOI18N
        btnRefrescar.setText("Refrescar");
        btnRefrescar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefrescarActionPerformed(evt);
            }
        });

        btnPagar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cartera.png"))); // NOI18N
        btnPagar.setText("Pagar");
        btnPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPagarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnRefrescar, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                    .addComponent(btnPagar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnEditar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRefrescar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPagar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addComponent(btnEliminar)
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Opciones Microtik"));

        btnBloquear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/bloquear-hashtag.png"))); // NOI18N
        btnBloquear.setText("Bloquear Cliente");
        btnBloquear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBloquearActionPerformed(evt);
            }
        });

        btnSimpleQueue.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/lista-de-rectangulos.png"))); // NOI18N
        btnSimpleQueue.setText("Agregar SimpleQueue");
        btnSimpleQueue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpleQueueActionPerformed(evt);
            }
        });

        btnCambiarVelocidad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/tacometro-alt-mas-rapido.png"))); // NOI18N
        btnCambiarVelocidad.setText("Actualizar Velocidad");
        btnCambiarVelocidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCambiarVelocidadActionPerformed(evt);
            }
        });

        btnDesbloquear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/desbloquear.png"))); // NOI18N
        btnDesbloquear.setText("Desbloquear Cliente");
        btnDesbloquear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesbloquearActionPerformed(evt);
            }
        });

        jLabel2.setText("Doblenet 2025");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBloquear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSimpleQueue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCambiarVelocidad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDesbloquear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnBloquear)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnDesbloquear)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSimpleQueue)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCambiarVelocidad)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addContainerGap(22, Short.MAX_VALUE))
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

        btnBuscarIP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/busqueda.png"))); // NOI18N
        btnBuscarIP.setText("Buscar IP");
        btnBuscarIP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarIPActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(entryNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(entryIpBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnBuscarIP)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                    .addComponent(btnBuscarIP))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRefrescarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefrescarActionPerformed
        listarClientes();
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRefrescarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int filaSeleccionada;
        try {
            filaSeleccionada = jTable1.getSelectedRow();

            if (filaSeleccionada >= 0) {
                int id = (int) jTable1.getValueAt(filaSeleccionada, 0);
                listarClientes();
                DeleteDatos deleteDatos = new DeleteDatos();
                deleteDatos.eliminarCliente(id);
                listarClientes();
            } else {
                JOptionPane.showMessageDialog(rootPane, "Para eliminar un cliente, primero seleccionelo", "SpiderNET", JOptionPane.WARNING_MESSAGE);
            }
        } catch (Exception e) {
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
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
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPagarActionPerformed
        int filaSeleccionada;
        filaSeleccionada = jTable1.getSelectedRow();
        if (filaSeleccionada >= 0) {
            int id = (int) jTable1.getValueAt(filaSeleccionada, 0);
            String nombre = (String) jTable1.getValueAt(filaSeleccionada, 1);
            String paquete = (String) jTable1.getValueAt(filaSeleccionada, 6);
            String direccionIp = (String) jTable1.getValueAt(filaSeleccionada, 8);
            String servicios = (String) jTable1.getValueAt(filaSeleccionada, 12);

            pagoWindows windows = new pagoWindows(id, nombre, paquete, servicios, direccionIp);
            Dashboard.escritorioInterno.add(windows);
            windows.show();
        } else {
            JOptionPane.showMessageDialog(null, "Para registrar un pago, seleccione el cliente", "SpiderNET", JOptionPane.WARNING_MESSAGE);
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_btnPagarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        buscarCliente();
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnBloquearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBloquearActionPerformed
        bloquearCliente();
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBloquearActionPerformed

    private void btnDesbloquearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesbloquearActionPerformed
        debloquearCliente();
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDesbloquearActionPerformed

    private void btnSimpleQueueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpleQueueActionPerformed
        agregarQueue();
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSimpleQueueActionPerformed

    private void btnCambiarVelocidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCambiarVelocidadActionPerformed
        cambioVelocidad();
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCambiarVelocidadActionPerformed

    private void btnBuscarIPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarIPActionPerformed
        buscarIp();
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBuscarIPActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBloquear;
    private javax.swing.JButton btnBuscarIP;
    private javax.swing.JButton btnCambiarVelocidad;
    private javax.swing.JButton btnDesbloquear;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnPagar;
    private javax.swing.JButton btnRefrescar;
    private javax.swing.JButton btnSimpleQueue;
    private javax.swing.JTextField entryIpBusqueda;
    private javax.swing.JTextField entryNombre;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
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
                             LEFT JOIN credenciales_microtik cm ON c.id_microtik = cm.id;  -- Unir con la tabla credenciales_microtik
                             """;
                DefaultTableModel modelo;
                st = cn.createStatement();
                rs = st.executeQuery(sql); //ejecutamos para obtener el resultado
                Object[] clientes = new Object[12];
                String estados = "Activo";
                String bloqueado = "Bloqueado";
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
                    clientes[9] = rs.getString("ap_antena");
                    clientes[10] = rs.getString("serviciosTV");
                    clientes[11] = rs.getString("serviciosPlataformas");

                    modelo.addRow(clientes);
                }
                jTable1.setModel(modelo);
                

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
            String targetIp = (String) jTable1.getValueAt(filaSeleccionada, 8);
            int id = (int)jTable1.getValueAt(filaSeleccionada, 0);

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

                        lucifer bloqueo = new lucifer();
                        bloqueo.bloqueoCliente(routerIp, user, password, targetIp);
                        //String routerIp, String user, String password, String targetIp
                        UpdateDatos datos = new UpdateDatos();
                        datos.bloqueo(id);
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
            String nombreMicrotik = (String) jTable1.getValueAt(filaSeleccionada, 3);
            String targetIp = (String) jTable1.getValueAt(filaSeleccionada, 8);

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

                        lucifer bloqueo = new lucifer();
                        bloqueo.desbloqueoCliente(routerIp, user, password, targetIp);
                        //String routerIp, String user, String password, String targetIp
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
            String ipCliente = (String) jTable1.getValueAt(filaSeleccionada, 8);
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
            String targetIp = (String) jTable1.getValueAt(filaSeleccionada, 8);
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
                                cambioVelocidad cambio = new cambioVelocidad();
                                cambio.cambioVelocidad(routerIp, user, password, targetIp, maxLimit);
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
}

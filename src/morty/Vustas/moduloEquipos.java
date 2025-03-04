package morty.Vustas;

import Config.Conexion;
import Config.DeleteDatos;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import morty.Vustas.editarEquipo;

public class moduloEquipos extends javax.swing.JInternalFrame {

    public moduloEquipos() {
        initComponents();
        listarEquipos();
    }

    public void listarEquipos() {
        Conexion conexion = new Conexion();
        Connection cn = conexion.getConnection();
        DefaultTableModel modelo;
        if (cn != null) {
            PreparedStatement cursor = null;
            ResultSet resultado = null;

            try {
                modelo = (DefaultTableModel) jTable1.getModel();
                String sql = """
                            SELECT e.id, e.nombre, e.tipo, e.marca, e.modelo, e.mac, e.serial, e.estado, c.nombre AS nombre_cliente
                             FROM equipos e LEFT JOIN clientes c ON e.id_cliente = c.id;
                             """;
                cursor = cn.prepareStatement(sql);

                resultado = cursor.executeQuery();
                Object[] equipos = new Object[9];
                modelo.setRowCount(0);
                while (resultado.next()) {
                    equipos[0] = resultado.getInt("id");
                    equipos[1] = resultado.getString("nombre_cliente");
                    equipos[2] = resultado.getString("nombre");
                    equipos[3] = resultado.getString("tipo");
                    equipos[4] = resultado.getString("marca");
                    equipos[5] = resultado.getString("modelo");
                    equipos[6] = resultado.getString("mac");
                    equipos[7] = resultado.getString("serial");
                    equipos[8] = resultado.getString("estado");
                    modelo.addRow(equipos);
                }
                jTable1.setModel(modelo);

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al consultar la tabla de los equipos", "SpiderNET", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public void obtenerElementos() {
        int filaSeleccionada;
        filaSeleccionada = jTable1.getSelectedRow();
        if (filaSeleccionada >= 0) {
            int id = (int) jTable1.getValueAt(filaSeleccionada, 0);
            String cliente = (String) jTable1.getValueAt(filaSeleccionada, 1);
            String nombre = (String) jTable1.getValueAt(filaSeleccionada, 2);
            String tipo = (String) jTable1.getValueAt(filaSeleccionada, 3);
            String marca = (String) jTable1.getValueAt(filaSeleccionada, 4);
            String modelo = (String) jTable1.getValueAt(filaSeleccionada, 5);
            String mac = (String) jTable1.getValueAt(filaSeleccionada, 6);
            String serial = (String) jTable1.getValueAt(filaSeleccionada, 7);
            String estado = (String) jTable1.getValueAt(filaSeleccionada, 8);
            editarEquipo equipo = new editarEquipo(id, nombre, tipo, marca, modelo, mac, serial, estado, cliente);
            Dashboard.escritorioInterno.add(equipo);
            equipo.show();
        } else {
            JOptionPane.showMessageDialog(null, "Antes de poder editar un equipo, debe seleccionarlo", "SpiderNET", JOptionPane.WARNING_MESSAGE);
        }

    }

    public void obtenerTipo() {
        String tipo = (String) comboTipo.getSelectedItem();

        if (tipo == "Router" || tipo == "Antena" || tipo == "ONU" || tipo == "Otro") {
            Conexion conexion = new Conexion();
            Connection cn = conexion.getConnection();
            DefaultTableModel modelo;
            if (cn != null) {
                PreparedStatement cursor = null;
                ResultSet resultado = null;

                try {
                    modelo = (DefaultTableModel) jTable1.getModel();
                    String sql = """
                            SELECT e.id, e.nombre, e.tipo, e.marca, e.modelo, e.mac, e.serial, e.estado, c.nombre AS nombre_cliente
                             FROM equipos e LEFT JOIN clientes c ON e.id_cliente = c.id WHERE tipo = ?;
                             """;
                    cursor = cn.prepareStatement(sql);
                    cursor.setString(1, tipo);

                    resultado = cursor.executeQuery();
                    Object[] equipos = new Object[9];
                    modelo.setRowCount(0);
                    while (resultado.next()) {
                        equipos[0] = resultado.getInt("id");
                        equipos[1] = resultado.getString("nombre_cliente");
                        equipos[2] = resultado.getString("nombre");
                        equipos[3] = resultado.getString("tipo");
                        equipos[4] = resultado.getString("marca");
                        equipos[5] = resultado.getString("modelo");
                        equipos[6] = resultado.getString("mac");
                        equipos[7] = resultado.getString("serial");
                        equipos[8] = resultado.getString("estado");
                        modelo.addRow(equipos);
                    }
                    jTable1.setModel(modelo);

                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "Error al consultar la tabla de los equipos", "SpiderNET", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        comboTipo = new javax.swing.JComboBox<>();
        btnFIltrar = new javax.swing.JButton();
        btnRefrescar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Equipos");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Opciones"));

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(235, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEditar)
                    .addComponent(btnEliminar))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Tabla Equipos"));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Cliente", "Nombre", "Tipo", "Marca", "Modelo", "Mac", "Serial", "Estado"
            }
        ));
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setMinWidth(30);
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(30);
            jTable1.getColumnModel().getColumn(0).setMaxWidth(30);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE)
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Filtraciones"));
        jPanel3.setToolTipText("");

        comboTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Router", "Antena", "ONU", "Otro" }));

        btnFIltrar.setText("Filtrar");
        btnFIltrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFIltrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(comboTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnFIltrar)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFIltrar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnRefrescar.setText("Refrescar");
        btnRefrescar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefrescarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 33, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnRefrescar)
                .addGap(16, 16, 16))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRefrescar)
                .addGap(13, 13, 13))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        obtenerElementos();
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnRefrescarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefrescarActionPerformed
        listarEquipos();
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRefrescarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int obtenerFila = 0;
        obtenerFila = jTable1.getSelectedRow();

        if (obtenerFila >= 0) {
            int id = (int) jTable1.getValueAt(obtenerFila, 0);
            DeleteDatos datos = new DeleteDatos();
            datos.eliminarEquipo(id);
            listarEquipos();
        } else {
            JOptionPane.showMessageDialog(null, "No podemos eliminar un equipo, primero seleccione uno", "SpiderNET", JOptionPane.WARNING_MESSAGE);
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnFIltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFIltrarActionPerformed
        obtenerTipo();
        // TODO add your handling code here:
    }//GEN-LAST:event_btnFIltrarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnFIltrar;
    private javax.swing.JButton btnRefrescar;
    private javax.swing.JComboBox<String> comboTipo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}

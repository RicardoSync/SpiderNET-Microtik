package morty.Vustas;

import UIPrincipal.Dashboard;
import Config.Conexion;
import Config.DeleteDatos;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import morty.Vustas.editarEquipo;
import javax.swing.ImageIcon;
import java.awt.Image;

public class asignacionRick extends javax.swing.JInternalFrame {

    public asignacionRick(int id, String nombreCliente) {

        initComponents();
        listarEquipos();
        insertarElementos(id, nombreCliente);
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
                            FROM equipos e
                            LEFT JOIN clientes c ON e.id_cliente = c.id
                            WHERE e.id_cliente IS NULL;
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

    public void insertarElementos(int id, String nombreCliente) {
        entryID.setText(String.valueOf(id));
        entryNombre.setText(nombreCliente);

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

    public void asignarCliente(int idCliente, int idEquipo) {
        Conexion conexion = new Conexion();
        Connection cn = conexion.getConnection();
        String nombre = entryNombre.getText();

        if (cn != null) {
            PreparedStatement cursor;
            String sql = "UPDATE equipos SET id_cliente = ? WHERE id = ?";
            try {
                cursor = cn.prepareStatement(sql);
                cursor.setInt(1, idCliente);
                cursor.setInt(2, idEquipo);

                int resultado = cursor.executeUpdate();

                if (resultado > 0) {
                    JOptionPane.showMessageDialog(null, "Se asigno de manera correcta el equipo: " + nombre, "SpiderNET", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Tenemos un error en la base de datos: " + e, "SpiderNET", JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        entryID = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        entryNombre = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setTitle("Equipos");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Opciones"));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/asignar.png"))); // NOI18N
        jButton1.setText("Asignar a cliente");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 788, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 339, Short.MAX_VALUE)
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Informacion"));

        jLabel1.setText("ID");

        entryID.setEditable(false);

        jLabel2.setText("Nombre");

        entryNombre.setEditable(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(entryID, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(entryNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(entryID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(entryNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        int filaSeleccionada = jTable1.getSelectedRow();
        if(filaSeleccionada >=0){
            int idEquipo = (int)jTable1.getValueAt(filaSeleccionada, 0);
            int idCliente = Integer.parseInt(entryID.getText());
            asignarCliente(idCliente, idEquipo);
        }else{
            JOptionPane.showMessageDialog(null, "Primero selecciona el equipo que deseas asignar");
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField entryID;
    private javax.swing.JTextField entryNombre;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}

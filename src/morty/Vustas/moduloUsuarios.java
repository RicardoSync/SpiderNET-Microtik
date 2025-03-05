/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package morty.Vustas;

import Config.Conexion;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ricardo
 */
public class moduloUsuarios extends javax.swing.JInternalFrame {

    /**
     * Creates new form moduloUsuarios
     */
    public moduloUsuarios() {
        initComponents();
        listarUsuarios();
    }

    public void listarUsuarios() {
        Conexion conexion = new Conexion();
        Connection cn = conexion.getConnection();
        if (cn != null) {
            PreparedStatement cursor;
            ResultSet resultado;
            String sql = "SELECT id, nombre, usuario, password FROM usuarios";
            try {
                DefaultTableModel modelo;
                cursor = cn.prepareStatement(sql);
                resultado = cursor.executeQuery();

                Object[] usuarios = new Object[4];
                modelo = (DefaultTableModel) tablaUsuarios.getModel();
                modelo.setRowCount(0);
                while (resultado.next()) {
                    usuarios[0] = resultado.getInt("id");
                    usuarios[1] = resultado.getString("nombre");
                    usuarios[2] = resultado.getString("usuario");
                    usuarios[3] = resultado.getString("password");
                    modelo.addRow(usuarios);
                }
                tablaUsuarios.setModel(modelo);
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Tenemos un error en base de datos: " + e);
            }
        }
    }

    public void eliminarCliente() {
        int resultado = JOptionPane.showConfirmDialog(null, "Eliminar el usuario?", "SpiderNET", JOptionPane.YES_NO_OPTION);

        if (resultado == JOptionPane.YES_OPTION) {
            int id = Integer.parseInt(entryID.getText());

            Conexion conexion = new Conexion();
            Connection cn = conexion.getConnection();

            if (cn != null) {
                PreparedStatement cursor;
                String sql = "DELETE FROM usuarios WHERE id = ?";
                try {
                    cursor = cn.prepareStatement(sql);
                    cursor.setInt(1, id);

                    int filas = cursor.executeUpdate();

                    if (filas > 0) {
                        JOptionPane.showMessageDialog(null, "Usuario eliminado");
                        listarUsuarios();
                    } else {
                        JOptionPane.showMessageDialog(null, "Usuario no eliminado");
                    }
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "Tenemos error en la base de datos: " + e);
                }

            }
        }
    }

    public void guardarCliente() {
        String nombre = entryNombre.getText();
        String usuario = entryUsuario.getText();

        if (nombre.isBlank() && usuario.isBlank()) {
            JOptionPane.showMessageDialog(null, "No podemos crear un usuario sin contraseña ni nombre");
        } else {
            String password = entryPassword.getText();
            int rol = 0;

            Conexion conexion = new Conexion();
            Connection cn = conexion.getConnection();

            if (cn != null) {
                PreparedStatement cursor;
                ResultSet resultado;
                String sql = "INSERT INTO usuarios(nombre, usuario, password, rol) VALUES (?,?,?,?)";

                try {
                    cursor = cn.prepareStatement(sql);
                    cursor.setString(1, nombre);
                    cursor.setString(2, usuario);
                    cursor.setString(3, password);
                    cursor.setInt(4, rol);

                    int filas = cursor.executeUpdate();

                    if (filas > 0) {
                        JOptionPane.showMessageDialog(null, "Se registro de manera exitosa el usuario: " + usuario + " y clave: " + password);
                        listarUsuarios();
                    }
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "Error en base de datos: " + e);
                }
            }
        }
    }

    public void actualizar() {
        int rol = 0;
        int id = Integer.parseInt(entryID.getText());
        String nombre = entryNombre.getText();
        String usuario = entryUsuario.getText();
        String password = entryPassword.getText();

        if (nombre.length() > 0 && usuario.length() > 0) {
            Conexion conexion = new Conexion();
            Connection cn = conexion.getConnection();

            if (cn != null) {
                String sql = "UPDATE usuarios SET nombre = ?, usuario = ?, password = ?, rol = ? WHERE id = ?";
                PreparedStatement cursor;
                ResultSet resultado;

                try {
                    cursor = cn.prepareStatement(sql);
                    cursor.setString(1, nombre);
                    cursor.setString(2, usuario);
                    cursor.setString(3, password);
                    cursor.setInt(4, rol);
                    cursor.setInt(5, id);

                    int filas = cursor.executeUpdate();

                    if (filas > 0) {
                        JOptionPane.showMessageDialog(null, "Usuario: " + usuario + " se actualizo de manera correcta");
                        listarUsuarios();
                    }

                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "Tenemos un problema en base de datos: " + e);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Sin conexion");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Falta nombre y/o usuario por defecto");
        }
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
        jLabel1 = new javax.swing.JLabel();
        entryNombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        entryUsuario = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        entryPassword = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaUsuarios = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        entryID = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setTitle("Usuarios");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos"));

        jLabel1.setText("Nombre");

        jLabel2.setText("Usuario");

        jLabel3.setText("Contraseña");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(entryNombre)
                    .addComponent(entryUsuario)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(entryPassword))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(entryNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(entryUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(entryPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Usuarios"));

        tablaUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Nombre", "Usuario", "Contraseña"
            }
        ));
        tablaUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaUsuariosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaUsuarios);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 621, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 494, Short.MAX_VALUE)
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Opciones"));

        jButton1.setText("Guardar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Actualizar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Eliminar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addGap(18, 18, 18)
                .addComponent(jButton3)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jLabel4.setText("ID");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(entryID)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(11, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(entryID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(17, 17, 17))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tablaUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaUsuariosMouseClicked
        int filaSeleccionada;

        filaSeleccionada = tablaUsuarios.getSelectedRow();
        if (filaSeleccionada >= 0) {
            entryID.setText(String.valueOf(tablaUsuarios.getValueAt(filaSeleccionada, 0)));
            entryNombre.setText(String.valueOf(tablaUsuarios.getValueAt(filaSeleccionada, 1)));
            entryUsuario.setText(String.valueOf(tablaUsuarios.getValueAt(filaSeleccionada, 2)));
            entryPassword.setText(String.valueOf(tablaUsuarios.getValueAt(filaSeleccionada, 3)));
        }

// TODO add your handling code here:
    }//GEN-LAST:event_tablaUsuariosMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        guardarCliente();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        eliminarCliente();
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        actualizar();
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField entryID;
    private javax.swing.JTextField entryNombre;
    private javax.swing.JTextField entryPassword;
    private javax.swing.JTextField entryUsuario;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaUsuarios;
    // End of variables declaration//GEN-END:variables
}

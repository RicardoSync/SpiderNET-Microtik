/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
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
/**
 *
 * @author ricardo
 */
public class moduloEmpresa extends javax.swing.JInternalFrame {
    
    Conexion conexion = new Conexion();
    Connection conet;
    DefaultTableModel modelo;
    Statement st;
    ResultSet rs;
    int idc;
    
    public moduloEmpresa() {
        initComponents();
        modelo = (DefaultTableModel) tablaEmpresa.getModel();
        consultarEmpresas();
    }
    
    public void limpiarTabla() {
        modelo.setRowCount(0);
    }

    public void consultarEmpresas() {
        String sql = "SELECT * FROM datosEmpresa";
        limpiarTabla();  // Asegúrate de limpiar la tabla antes de cargar nuevos datos

        try {
            conet = conexion.getConnection();
            PreparedStatement pst = conet.prepareStatement(sql);
            rs = pst.executeQuery();  // Usa la variable global rs

            while (rs.next()) {
                Object empresa[] = {
                    rs.getInt("id"),
                    rs.getString("nombreWisp"),
                    rs.getString("cp"),
                    rs.getString("telefono"),
                    rs.getString("rfc"),
                    rs.getString("direccion")
                };
                modelo.addRow(empresa);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al consultar la tabla de empresas: " + e.getMessage(), "SpiderNET", JOptionPane.ERROR_MESSAGE);
            System.out.println(e);
        }
    }
 
    void guardar() {
        String nombreEmpresa = txtNombreEmpresa.getText();
        String codigoPostal = txtCP.getText();
        String telefono = entryTelefono.getText();
        String rfc = txtRFC.getText();
        String direccion = txtDireccion.getText();

        if (nombreEmpresa.isEmpty() || codigoPostal.isEmpty() || telefono.isEmpty() || rfc.isEmpty() || direccion.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Hace falta llenar algunos campos.");
            return;
        }

        try {
            conet = conexion.getConnection();

            // Verificar si la empresa ya existe
            String checkSql = "SELECT COUNT(*) FROM datosEmpresa WHERE nombreWisp = ? OR rfc = ?";
            PreparedStatement checkPst = conet.prepareStatement(checkSql);
            checkPst.setString(1, nombreEmpresa);
            checkPst.setString(2, rfc);
            ResultSet rs = checkPst.executeQuery();
            rs.next();

            if (rs.getInt(1) > 0) {
                JOptionPane.showMessageDialog(null, "La empresa ya está registrada.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Insertar nueva empresa
            String sql = "INSERT INTO datosEmpresa(nombreWisp, cp, telefono, rfc, direccion) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement pst = conet.prepareStatement(sql);
            pst.setString(1, nombreEmpresa);
            pst.setString(2, codigoPostal);
            pst.setString(3, telefono);
            pst.setString(4, rfc);
            pst.setString(5, direccion);

            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Datos guardados exitosamente.");
            consultarEmpresas();  // Recarga la tabla automáticamente después de guardar

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al guardar los datos: " + e.getMessage(), "SpiderNET", JOptionPane.ERROR_MESSAGE);
        }
    }

    
    void editar(){
        String nombreEmpresa = txtNombreEmpresa.getText();
        String codigoPostal = txtCP.getText();
        String telefono = entryTelefono.getText();
        String rfc = txtRFC.getText();
        String direccion = txtDireccion.getText();

        if (nombreEmpresa.isEmpty() || codigoPostal.isEmpty() || telefono.isEmpty() || rfc.isEmpty() || direccion.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Hace falta llenar algunos campos.");
            return;
        }

        String sql = "UPDATE datosEmpresa SET nombreWisp = ?, cp = ?, telefono = ?, rfc = ?, direccion = ? WHERE id = ?";

        try {
            conet = conexion.getConnection();
            PreparedStatement pst = conet.prepareStatement(sql);
            pst.setString(1, nombreEmpresa);
            pst.setString(2, codigoPostal);
            pst.setString(3, telefono);
            pst.setString(4, rfc);
            pst.setString(5, direccion);
            pst.setInt(6, idc);

            int filasAfectadas = pst.executeUpdate();
            
            if(filasAfectadas > 0){
                JOptionPane.showMessageDialog(null, "Datos actualizados exitosamente.");
                consultarEmpresas();
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró el registro para actualizar.", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar los datos: " + e.getMessage(), "SpiderNET", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    void eliminar() {
        int fila = tablaEmpresa.getSelectedRow();  // Obtener la fila seleccionada
        if (fila < 0) {
            JOptionPane.showMessageDialog(null, "Empresa no seleccionada.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            String sql = "DELETE FROM datosEmpresa WHERE id = ?";
            conet = conexion.getConnection();
            PreparedStatement pst = conet.prepareStatement(sql);
            pst.setInt(1, idc);  // Usar parámetro seguro

            int filasAfectadas = pst.executeUpdate();
            if (filasAfectadas > 0) {
                JOptionPane.showMessageDialog(null, "Se eliminó la empresa correctamente.");
                limpiarTabla();
                consultarEmpresas();
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró la empresa para eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar la empresa: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
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
        txtId = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtCP = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtRFC = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtNombreEmpresa = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        entryTelefono = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaEmpresa = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        btnGuardar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Empresas");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Crear Empresa"));

        jLabel1.setText("ID:");

        txtId.setEditable(false);
        txtId.setEnabled(false);

        jLabel2.setText("CP:");

        jLabel3.setText("RFC:");

        jLabel4.setText("Nombre:");

        jLabel5.setText("Tefelono:");

        jLabel6.setText("Dirección:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtId, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
                    .addComponent(txtCP)
                    .addComponent(txtRFC))
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtNombreEmpresa)
                    .addComponent(entryTelefono)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtNombreEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtCP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(entryTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtRFC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos de la empresa"));

        tablaEmpresa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre de la empresa", "CP", "Telefono", "RFC", "Dirección"
            }
        ));
        tablaEmpresa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaEmpresaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaEmpresa);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 570, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Opciones"));

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnEditar.setText("Actualizar");
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

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(53, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnEditar)
                    .addComponent(btnEliminar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        guardar();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void tablaEmpresaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaEmpresaMouseClicked
        // TODO add your handling code here:
        int fila = tablaEmpresa.getSelectedRow();
        if (fila == -1){
            JOptionPane.showMessageDialog(null, "No se selecciono fila.");
        }else{
            idc = Integer.parseInt((String) tablaEmpresa.getValueAt(fila,0) .toString());
            String nombreEmpresa = (String) tablaEmpresa.getValueAt(fila, 1);
            String codigoPostal = (String) tablaEmpresa.getValueAt(fila, 2);
            String telefono = (String) tablaEmpresa.getValueAt(fila, 3);
            String rfc = (String) tablaEmpresa.getValueAt(fila, 4);
            String direccion = (String) tablaEmpresa.getValueAt(fila, 5);
            
            txtId.setText(""+idc);
            txtNombreEmpresa.setText(""+nombreEmpresa);
            txtCP.setText(""+codigoPostal);
            entryTelefono.setText(""+telefono);
            txtRFC.setText(""+rfc);
            txtDireccion.setText(""+direccion);
        }
    }//GEN-LAST:event_tablaEmpresaMouseClicked

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // TODO add your handling code here:
        editar();
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int resultado = JOptionPane.showConfirmDialog(null, "¿Deseas eliminar esta empresa?", "Eliminar empresa", JOptionPane.YES_NO_OPTION);
            if(resultado == JOptionPane.YES_OPTION){
                eliminar();
            }
    }//GEN-LAST:event_btnEliminarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JTextField entryTelefono;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaEmpresa;
    private javax.swing.JTextField txtCP;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNombreEmpresa;
    private javax.swing.JTextField txtRFC;
    // End of variables declaration//GEN-END:variables
}

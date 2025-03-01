package morty.Vustas;

import Config.Conexion;
import Config.DeleteDatos;
import Config.InsertarDatos;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.Statement;
import java.sql.Connection;
import Config.UpdateDatos;

public class creacionPaquetes extends javax.swing.JInternalFrame {
    public creacionPaquetes() {
        initComponents();
        listarPaquetes();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        entryNombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        entryVelocidad = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        entryPrecio = new javax.swing.JTextField();
        entryID = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btnGuardar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaPaquetes = new javax.swing.JTable();
        btnObtener = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Registrar Paquetes");
        setToolTipText("Registrar Paquetes");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos Antena AP"));

        jLabel1.setText("Nombre");

        jLabel2.setText("Velocidad (Subida/Bajada)");

        entryVelocidad.setText("10M/10M");
        entryVelocidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                entryVelocidadActionPerformed(evt);
            }
        });

        jLabel3.setText("Precio");

        entryID.setEditable(false);

        jLabel4.setText("ID");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(entryID, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(entryNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(entryVelocidad, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(entryPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(10, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(entryID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel1)
                    .addComponent(entryNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(entryVelocidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(entryPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Opciones"));

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Antenas Regitradas"));

        tablaPaquetes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Velocidad", "Precio"
            }
        ));
        jScrollPane1.setViewportView(tablaPaquetes);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 824, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        btnObtener.setText("Editar");
        btnObtener.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObtenerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnObtener, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnActualizar)
                    .addComponent(btnEliminar)
                    .addComponent(btnObtener))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        guardarPaquetes();
        listarPaquetes();
        // TODO add your handling code here:
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void entryVelocidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_entryVelocidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_entryVelocidadActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        enviarActualizacion();
        // TODO add your handling code here:
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnObtenerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObtenerActionPerformed
        int filaSeleccionada;
        try {
            filaSeleccionada = tablaPaquetes.getSelectedRow();
            if(filaSeleccionada==-1){
                JOptionPane.showMessageDialog(null, "Primero selecciona un elemento", "Modulo Paquetes", JOptionPane.ERROR_MESSAGE);
            }else{
                obtenerDatosFila();
            }
        } catch (Exception e) {
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btnObtenerActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int filaSeleccionada;
        try {
            filaSeleccionada = tablaPaquetes.getSelectedRow();
            if(filaSeleccionada == -1){
               JOptionPane.showMessageDialog(null, "Primero selecciona un elemento", "Modulo Paquetes", JOptionPane.ERROR_MESSAGE);
            }else{
                int id = (int) tablaPaquetes.getValueAt(filaSeleccionada, 0);
                DeleteDatos deleteDatos = new DeleteDatos();
                deleteDatos.eliminarPaquete(id);
                listarPaquetes();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnObtener;
    private javax.swing.JTextField entryID;
    private javax.swing.JTextField entryNombre;
    private javax.swing.JTextField entryPrecio;
    private javax.swing.JTextField entryVelocidad;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaPaquetes;
    // End of variables declaration//GEN-END:variables

    public void listarPaquetes(){
        //Declaracion de las variables
        Statement st = null;
        ResultSet rs = null;
        Conexion conexion = new Conexion();
        Connection con = conexion.getConnection();

        String sql = "SELECT id, nombre, velocidad, precio FROM paquetes";

        try {
            DefaultTableModel modelo;
            st = con.createStatement();
            // Ejecutar la consulta y obtener el resultado
            rs = st.executeQuery(sql);
            Object[] paquetes = new Object[4];
            modelo = (DefaultTableModel)tablaPaquetes.getModel();
            //eliminar los datos para insertar nuevos y no tener datos empalmados
            modelo.setRowCount(0);
            while (rs.next()){
                paquetes[0] = rs.getInt("id");
                paquetes[1] = rs.getString("nombre");
                paquetes[2] = rs.getString("velocidad");
                paquetes[3] = rs.getString("precio");

                modelo.addRow(paquetes);
            }
            tablaPaquetes.setModel(modelo);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al listar los paquetes", "Modulo Paquetes", JOptionPane.ERROR_MESSAGE);
        }
        finally{
            try {
                if (rs != null) rs.close();
                if (st != null) st.close();
                conexion.closeConnection();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al cerrar la conexión: " + e, "Error", JOptionPane.ERROR_MESSAGE);
                
            }
        }
        
    }
  
    public void guardarPaquetes(){
      String nombre = entryNombre.getText();
      String velocidad = entryVelocidad.getText();
      String precio = entryPrecio.getText();
      
      InsertarDatos insertarDatos = new InsertarDatos();
      insertarDatos.insertarPaquetes(nombre, velocidad, precio);

  }

    public void obtenerDatosFila(){
      int filaSeleccionada = tablaPaquetes.getSelectedRow();
      int id = (int) tablaPaquetes.getValueAt(filaSeleccionada, 0);
      String nombre = (String)tablaPaquetes.getValueAt(filaSeleccionada, 1);
      String velocidad = (String)tablaPaquetes.getValueAt(filaSeleccionada, 2);
      String precio = (String)tablaPaquetes.getValueAt(filaSeleccionada, 3);
      
      entryID.setText(String.valueOf(id));
      entryNombre.setText(nombre);
      entryVelocidad.setText(velocidad);
      entryPrecio.setText(precio);
    }
    
    public void enviarActualizacion(){
        String id_paquete = entryID.getText();
        if(id_paquete.length()>0){
            int id = Integer.parseInt(id_paquete);
            String nombre = entryNombre.getText();
            String velocidad = entryVelocidad.getText();
            String precio = entryPrecio.getText();
            
            UpdateDatos updateDatos = new UpdateDatos();
            updateDatos.actualizarPaquetes(id, nombre, velocidad, precio);
            listarPaquetes();
        }else{
            JOptionPane.showMessageDialog(null, "Para actualizar seleccione un elemento", "Modulo Paquetes", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public void enviarEliminar(){
        String id_paquete = entryID.getText();
        if(id_paquete.length()>0){
            int id = Integer.parseInt(id_paquete);
            String nombre = entryNombre.getText();
            String velocidad = entryVelocidad.getText();
            String precio = entryPrecio.getText();
            DeleteDatos deleteDatos = new DeleteDatos();
            deleteDatos.eliminarPaquete(id);
            listarPaquetes();
        }else{
           JOptionPane.showMessageDialog(null, "Para eliminar seleccione un elemento", "Modulo Paquetes", JOptionPane.WARNING_MESSAGE);
        }
    }
}

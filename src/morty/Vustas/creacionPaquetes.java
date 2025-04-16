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
        jLabel3 = new javax.swing.JLabel();
        entryPrecio = new javax.swing.JTextField();
        entryID = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        velocidadBajada = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        velocidadSubifa = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        btnGuardar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaPaquetes = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setTitle("Registrar Paquetes");
        setToolTipText("Registrar Paquetes");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos Paquetes"));

        jLabel1.setText("Nombre");

        jLabel3.setText("Precio");

        entryID.setEditable(false);

        jLabel4.setText("ID");

        jLabel2.setText("Velocidad Bajada");

        velocidadBajada.setText("10M");
        velocidadBajada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                velocidadBajadaActionPerformed(evt);
            }
        });

        jLabel5.setText("Velocidad subida");

        velocidadSubifa.setText("10M");
        velocidadSubifa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                velocidadSubifaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(entryID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(entryNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(entryPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(velocidadSubifa, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(velocidadBajada)))
                .addContainerGap(63, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(entryID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(entryNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(entryPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(velocidadSubifa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(velocidadBajada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Opciones"));

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/flecha-de-circulo-de-disquete-a-la-derecha.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/girar-cuadrado.png"))); // NOI18N
        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/quitar-carpeta.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Paquetes Registrados"));

        tablaPaquetes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Velocidad", "Precio"
            }
        ));
        tablaPaquetes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaPaquetesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaPaquetes);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 558, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnActualizar)
                    .addComponent(btnEliminar))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        guardarPaquetes();
        listarPaquetes();
        // TODO add your handling code here:
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void velocidadBajadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_velocidadBajadaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_velocidadBajadaActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        enviarActualizacion();
        // TODO add your handling code here:
    }//GEN-LAST:event_btnActualizarActionPerformed

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

    private void tablaPaquetesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaPaquetesMouseClicked
        int filaSeleccionada;
        
        filaSeleccionada = tablaPaquetes.getSelectedRow();
        if(filaSeleccionada >= 0){
            entryID.setText(String.valueOf(tablaPaquetes.getValueAt(filaSeleccionada, 0)));
            entryNombre.setText(String.valueOf(tablaPaquetes.getValueAt(filaSeleccionada, 1)));
            entryPrecio.setText(String.valueOf(tablaPaquetes.getValueAt(filaSeleccionada, 3)));
        }else{
            JOptionPane.showMessageDialog(null, closable);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_tablaPaquetesMouseClicked

    private void velocidadSubifaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_velocidadSubifaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_velocidadSubifaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JTextField entryID;
    private javax.swing.JTextField entryNombre;
    private javax.swing.JTextField entryPrecio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaPaquetes;
    private javax.swing.JTextField velocidadBajada;
    private javax.swing.JTextField velocidadSubifa;
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
      String velociadBajada = velocidadBajada.getText();
      String velocidadSubida = velocidadSubifa.getText();
      String precio = entryPrecio.getText();
      String velocidad = velocidadSubida + "/" + velociadBajada;
        System.out.println("Velocidad enviada es: " + velocidad);
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
      velocidadBajada.setText(velocidad);
      entryPrecio.setText(precio);
    }
    
    public void enviarActualizacion(){
        String id_paquete = entryID.getText();
        if(id_paquete.length()>0){
            int id = Integer.parseInt(id_paquete);
            String nombre = entryNombre.getText();
            String velocidadBajaAda = velocidadBajada.getText();
            String velocidadSubida = velocidadSubifa.getText();
            String precio = entryPrecio.getText();
            String velocidad = velocidadSubida + "/" + velocidadBajaAda;
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
            String velocidad = velocidadBajada.getText();
            String precio = entryPrecio.getText();
            DeleteDatos deleteDatos = new DeleteDatos();
            deleteDatos.eliminarPaquete(id);
            listarPaquetes();
        }else{
           JOptionPane.showMessageDialog(null, "Para eliminar seleccione un elemento", "Modulo Paquetes", JOptionPane.WARNING_MESSAGE);
        }
    }
}

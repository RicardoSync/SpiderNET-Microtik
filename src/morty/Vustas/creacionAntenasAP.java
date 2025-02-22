package morty.Vustas;

import Config.Conexion;
import Config.DeleteDatos;
import Config.InsertarDatos;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.Statement;
import Config.UpdateDatos;

public class creacionAntenasAP extends javax.swing.JInternalFrame {
    public creacionAntenasAP() {
        initComponents();
        listarAntenas();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        entryNombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        entryModelo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        entryUsername = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        entryPassword = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        entryIp = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        entryId = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaAtenasAp = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        btnGuardar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        entryObtener = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Registrar Antenas AP");
        setToolTipText("Agregar AP");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos Antena AP"));

        jLabel1.setText("Nombre");

        jLabel2.setText("Modelo");

        jLabel3.setText("Usuario");

        jLabel4.setText("Password");

        jLabel5.setText("Direccion IP");

        jLabel6.setText("ID");

        entryId.setEditable(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(entryUsername))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(entryId, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(entryNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addComponent(entryModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(entryPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(entryIp)))
                .addGap(34, 34, 34))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(entryId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(entryNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(entryModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(entryUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(entryPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(entryIp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(65, 65, 65))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Antenas Regitradas"));

        tablaAtenasAp.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Modelo", "Usuario", "Password", "Direcccion IP"
            }
        ));
        jScrollPane1.setViewportView(tablaAtenasAp);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        entryObtener.setText("Editar");
        entryObtener.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                entryObtenerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(entryObtener, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnActualizar)
                    .addComponent(btnEliminar)
                    .addComponent(entryObtener))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        guardarAntena();
        listarAntenas();
        // TODO add your handling code here:
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void entryObtenerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_entryObtenerActionPerformed
        int filaSeleccionada;
        try {
            filaSeleccionada = tablaAtenasAp.getSelectedRow();
            if(filaSeleccionada == -1){
                JOptionPane.showMessageDialog(null, "No selecciono ningun elemento de la tabla", "Modulo AntenasAP", JOptionPane.ERROR_MESSAGE);
            }else{
                obtenerDatosFila();
            }
            
        } catch (Exception e) {
            System.out.println(e);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_entryObtenerActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        enviarActualizacion();
        // TODO add your handling code here:
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int filaSeleccionada;
        try {
            filaSeleccionada = tablaAtenasAp.getSelectedRow();
            if(filaSeleccionada == -1){
               JOptionPane.showMessageDialog(null, "Primero selecciona un elemento", "Modulo Paquetes", JOptionPane.ERROR_MESSAGE);
            }else{
                int id = (int) tablaAtenasAp.getValueAt(filaSeleccionada, 0);
                DeleteDatos deleteDatos = new DeleteDatos();
                deleteDatos.eliminarAntenaAp(id);
                listarAntenas();
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
    private javax.swing.JTextField entryId;
    private javax.swing.JTextField entryIp;
    private javax.swing.JTextField entryModelo;
    private javax.swing.JTextField entryNombre;
    private javax.swing.JButton entryObtener;
    private javax.swing.JTextField entryPassword;
    private javax.swing.JTextField entryUsername;
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
    private javax.swing.JTable tablaAtenasAp;
    // End of variables declaration//GEN-END:variables

  public void listarAntenas(){
        // Declaración de las variables
        Statement st = null;
        ResultSet rs = null;
        Conexion conexion = new Conexion(); // Obtener la conexión
        java.sql.Connection con = conexion.getConnection(); // Obtener el objeto Connection

                
        String sql = "SELECT idantenasAp, nombre, modelo, usuario, password, ip FROM antenasap";
        
        try {
            DefaultTableModel modelo;
            st = con.createStatement();
            // Ejecutar la consulta y obtener el resultado
            rs = st.executeQuery(sql);
            Object[] microtiks = new Object[6];
            modelo = (DefaultTableModel)tablaAtenasAp.getModel();
            modelo.setRowCount(0);

            while (rs.next()){
                microtiks[0] = rs.getInt("idantenasAp");
                microtiks[1] = rs.getString("nombre");
                microtiks[2] = rs.getString("modelo");
                microtiks[3] = rs.getString("usuario");
                microtiks[4] = rs.getString("password");
                microtiks[5] = rs.getString("ip");
                modelo.addRow(microtiks);
            }
              tablaAtenasAp.setModel(modelo);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al listar las antenas, modulo Crear Antena: " + e, "Modulo Antenas", JOptionPane.ERROR_MESSAGE);
        }
        finally{
            // Cerrar el ResultSet, Statement y Connection
            try {
                if (rs != null) rs.close();
                if (st != null) st.close();
                conexion.closeConnection();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al cerrar la conexión: " + e, "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
  }
  
  public void guardarAntena(){
      String nombre = entryNombre.getText();
      String username = entryUsername.getText();
      String password = entryPassword.getText();
      String modelo = entryModelo.getText();
      String ip = entryIp.getText();
      
      InsertarDatos insertarDatos = new InsertarDatos();
      
      insertarDatos.insertarAntenasAP(nombre, modelo, username, password, ip);
  }

  public void obtenerDatosFila(){
      int filaSeleccionada = tablaAtenasAp.getSelectedRow();
      int id = (int) tablaAtenasAp.getValueAt(filaSeleccionada, 0);
      String nombre = (String)tablaAtenasAp.getValueAt(filaSeleccionada, 1);
      String modelo = (String)tablaAtenasAp.getValueAt(filaSeleccionada, 2);
      String usuario = (String)tablaAtenasAp.getValueAt(filaSeleccionada, 3);
      String password = (String)tablaAtenasAp.getValueAt(filaSeleccionada, 4);
      String direccion_ip = (String)tablaAtenasAp.getValueAt(filaSeleccionada, 5);
       //convierto el id entero a texto
      entryId.setText(String.valueOf(id));
      entryNombre.setText(nombre);
      entryIp.setText(direccion_ip);
      entryModelo.setText(modelo);
      entryUsername.setText(usuario);
      entryPassword.setText(password);
 }

    public void enviarActualizacion() {
        String id_antena = entryId.getText();

        if (id_antena.length() > 0) {
            try {
                int id = Integer.parseInt(id_antena);
                String nombre = entryNombre.getText();
                String modelo = entryModelo.getText();
                String usuario = entryUsername.getText();
                String password = entryPassword.getText();
                String ip = entryIp.getText();

                UpdateDatos updateDatos = new UpdateDatos();
                updateDatos.actualizarAntena(id, nombre, modelo, usuario, password, ip);
                listarAntenas();
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "El ID debe ser un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "El ID de la antena es obligatorio.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }


}

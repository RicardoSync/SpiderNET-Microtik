package morty.Vustas;

import Config.Conexion;
import Config.InsertarDatos;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.Statement;
import java.sql.Connection;
import Config.UpdateDatos;
import Config.DeleteDatos;
import java.util.List;
import java.util.Map;
import javax.swing.JTree;
import me.legrange.mikrotik.ApiConnection;
import me.legrange.mikrotik.MikrotikApiException;
import microtik.enableDisableQueue;
import microtik.lucifer;
import microtik.queueRafagas;
import microtik.taskMicrotik;
import microtik.testConnectionAsync;
public class creacionMicrotik extends javax.swing.JInternalFrame {

    public creacionMicrotik() {
        initComponents();
        listarMicrotiks();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        entryNombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        entryIp = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        entryUsername = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        entryPassword = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        entryId = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaMicrotik = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        btnGuardar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/carta-red.png"))); // NOI18N
        jMenuItem1.setText("Probar conexion");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem1);

        setClosable(true);
        setIconifiable(true);
        setResizable(true);
        setTitle("Registrar Microtik");
        setToolTipText("Registrar Microtik");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos"));

        jLabel1.setText("Identificador");

        entryNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                entryNombreActionPerformed(evt);
            }
        });

        jLabel2.setText("Direccion IP");

        entryIp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                entryIpActionPerformed(evt);
            }
        });

        jLabel3.setText("Username");

        jLabel4.setText("Password");

        jLabel5.setText("ID");

        entryId.setEditable(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(entryUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(entryPassword))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(entryNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                            .addComponent(entryId))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(entryIp, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(entryId, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(entryNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(entryIp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(entryUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(entryPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(8, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Microtiks"));

        tablaMicrotik.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Direccion IP", "Username", "Password"
            }
        ));
        tablaMicrotik.setComponentPopupMenu(jPopupMenu1);
        tablaMicrotik.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaMicrotikMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaMicrotik);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 412, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 4, Short.MAX_VALUE))
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

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/marca-x-rectangular.png"))); // NOI18N
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(123, 123, 123))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnActualizar)
                    .addComponent(btnEliminar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        guardarMicrotik();
        listarMicrotiks();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void entryIpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_entryIpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_entryIpActionPerformed

    private void entryNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_entryNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_entryNombreActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        enviarActualizacion();
        // TODO add your handling code here:
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int filaSeleccionada;
        try {
            filaSeleccionada = tablaMicrotik.getSelectedRow();
            if (filaSeleccionada == -1) {
                JOptionPane.showMessageDialog(null, "Primero selecciona un elemento", "Modulo Paquetes", JOptionPane.ERROR_MESSAGE);
            } else {
                int id = (int) tablaMicrotik.getValueAt(filaSeleccionada, 0);
                DeleteDatos deleteDatos = new DeleteDatos();
                deleteDatos.eliminarMicrotik(id);
                listarMicrotiks();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void tablaMicrotikMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMicrotikMouseClicked
        int filaSeleccionada = tablaMicrotik.getSelectedRow();

        if (filaSeleccionada >= 0) {
            int id = (int) tablaMicrotik.getValueAt(filaSeleccionada, 0);
            entryNombre.setText(String.valueOf(tablaMicrotik.getValueAt(filaSeleccionada, 1)));
            entryIp.setText(String.valueOf(tablaMicrotik.getValueAt(filaSeleccionada, 2)));
            entryUsername.setText(String.valueOf(tablaMicrotik.getValueAt(filaSeleccionada, 3)));
            entryPassword.setText(String.valueOf(tablaMicrotik.getValueAt(filaSeleccionada, 4)));

            entryId.setText(String.valueOf(id));
        } else {
            JOptionPane.showMessageDialog(null, "Selecciona un elemento primero");
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_tablaMicrotikMouseClicked

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        int fila = tablaMicrotik.getSelectedRow();
        if (fila >=0){
            testConnectionAsync async = new testConnectionAsync();
            String user = (String)tablaMicrotik.getValueAt(fila, 3);
            String password = (String)tablaMicrotik.getValueAt(fila, 4);
            String routerIp = (String)tablaMicrotik.getValueAt(fila, 2);
            async.testConnectionAsync(user, password, routerIp);            
        }else{
            JOptionPane.showMessageDialog(null, "Selecciona primero un microtik");
        }

        
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JTextField entryId;
    private javax.swing.JTextField entryIp;
    private javax.swing.JTextField entryNombre;
    private javax.swing.JTextField entryPassword;
    private javax.swing.JTextField entryUsername;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaMicrotik;
    // End of variables declaration//GEN-END:variables

    public void listarMicrotiks() {
        //Declaracion de las variables
        Statement st = null;
        ResultSet rs = null;
        Conexion conexion = new Conexion();
        Connection con = conexion.getConnection();

        String sql = "SELECT id, nombre, ip, username, password FROM credenciales_microtik ";

        try {
            DefaultTableModel modelo;
            st = con.createStatement();
            // Ejecutar la consulta y obtener el resultado
            rs = st.executeQuery(sql);
            Object[] paquetes = new Object[5];
            modelo = (DefaultTableModel) tablaMicrotik.getModel();
            //eliminar los datos para insertar nuevos y no tener datos empalmados
            modelo.setRowCount(0);
            while (rs.next()) {
                paquetes[0] = rs.getInt("id");
                paquetes[1] = rs.getString("nombre");
                paquetes[2] = rs.getString("ip");
                paquetes[3] = rs.getString("username");
                paquetes[4] = rs.getString("password");

                modelo.addRow(paquetes);
            }
            tablaMicrotik.setModel(modelo);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al listar los microtiks", "Modulo Microtiks", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }
                conexion.closeConnection();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al cerrar la conexión: " + e, "Error", JOptionPane.ERROR_MESSAGE);

            }
        }

    }

    public void guardarMicrotik() {
        String nombre = entryNombre.getText();
        String ip = entryIp.getText();
        String username = entryUsername.getText();
        String password = entryPassword.getText();

        InsertarDatos insertarDatos = new InsertarDatos();
        insertarDatos.insertarDatos(nombre, ip, username, password);

    }

    public void obtenerDatosFila() {
        int filaSeleccionada = tablaMicrotik.getSelectedRow();
        int id = (int) tablaMicrotik.getValueAt(filaSeleccionada, 0);
        String nombre = (String) tablaMicrotik.getValueAt(filaSeleccionada, 1);
        String ip = (String) tablaMicrotik.getValueAt(filaSeleccionada, 2);
        String username = (String) tablaMicrotik.getValueAt(filaSeleccionada, 3);
        String password = (String) tablaMicrotik.getValueAt(filaSeleccionada, 4);
        //convierto el id entero a texto
        entryId.setText(String.valueOf(id));
        entryNombre.setText(nombre);
        entryIp.setText(ip);
        entryUsername.setText(username);
        entryPassword.setText(password);

    }

    public void enviarActualizacion() {
        String id_equipo = entryId.getText();

        if (id_equipo.length() > 0) {
            int id = Integer.parseInt(id_equipo);
            String nombre = entryNombre.getText();
            String ip = entryIp.getText();
            String username = entryUsername.getText();
            String password = entryPassword.getText();
            UpdateDatos updateDatos = new UpdateDatos();
            updateDatos.actualizarMicrotik(id, nombre, ip, username, password);
            listarMicrotiks();

        } else {
            JOptionPane.showMessageDialog(null, "Para actualiza, primero selecciona un elemento", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }


}

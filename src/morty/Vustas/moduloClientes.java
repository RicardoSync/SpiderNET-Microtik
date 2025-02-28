package morty.Vustas;
import Config.Conexion;
import Config.DeleteDatos;
import java.awt.Color;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import Recibos.pagoWindows;
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
                "ID", "Nombre", "Telefono", "Correo", "Direccion", "Instalacion", "Paquete", "Estado", "IP Cliente", "Corte", "Antena AP", "TV", "Strem"
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 846, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 458, Short.MAX_VALUE)
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Opciones Edicion"));

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

        btnRefrescar.setText("Refrescar");
        btnRefrescar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefrescarActionPerformed(evt);
            }
        });

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

        btnBloquear.setText("Bloquear Cliente");

        btnSimpleQueue.setText("Agregar SimpleQueue");

        btnCambiarVelocidad.setText("Cambiar Velocidad");

        btnDesbloquear.setText("Desbloquear Cliente");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBloquear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSimpleQueue, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                    .addComponent(btnCambiarVelocidad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDesbloquear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addContainerGap(58, Short.MAX_VALUE))
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
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
            
            if(filaSeleccionada >0){
                int id = (int) jTable1.getValueAt(filaSeleccionada, 0);
                listarClientes();
                DeleteDatos deleteDatos = new DeleteDatos();
                deleteDatos.eliminarCliente(id);
                listarClientes();
            }else{
                JOptionPane.showMessageDialog(rootPane, "Para eliminar un cliente, primero seleccionelo","SpiderNET", JOptionPane.WARNING_MESSAGE);
            }
        } catch (Exception e) {
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        int filaSeleccionada;
        try {
            filaSeleccionada = jTable1.getSelectedRow();
            
            if(filaSeleccionada >= 0){
                int id = (int)jTable1.getValueAt(filaSeleccionada, 0);
                String nombre = (String) jTable1.getValueAt(filaSeleccionada, 1);
                String telefono = (String) jTable1.getValueAt(filaSeleccionada, 2);
                String correo = (String)jTable1.getValueAt(filaSeleccionada, 3);
                String direccion = (String)jTable1.getValueAt(filaSeleccionada, 4);
                String paquete = (String)jTable1.getValueAt(filaSeleccionada, 6);
                String ip_cliente = (String)jTable1.getValueAt(filaSeleccionada, 8);
                String dia_corte = (String)jTable1.getValueAt(filaSeleccionada, 9);
                String antenaAP = (String)jTable1.getValueAt(filaSeleccionada, 10);
                String tv = (String)jTable1.getValueAt(filaSeleccionada, 11);
                String stream = (String)jTable1.getValueAt(filaSeleccionada, 12);
                
                editarCliente eCliente = new editarCliente(id, nombre, telefono, ip_cliente, dia_corte, paquete, antenaAP,
                        stream, tv, correo, direccion);
                Dashboard.escritorioInterno.add(eCliente);
                eCliente.show();
            }
            else{
                JOptionPane.showMessageDialog(rootPane, "Primero selecciona un elemento", "SpiderNET", JOptionPane.WARNING_MESSAGE);
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPagarActionPerformed
        int filaSeleccionada;
        filaSeleccionada = jTable1.getSelectedRow();
        if (filaSeleccionada >= 0){
            int id = (int)jTable1.getValueAt(filaSeleccionada, 0);
            String nombre = (String)jTable1.getValueAt(filaSeleccionada, 1);
            String paquete = (String)jTable1.getValueAt(filaSeleccionada, 6);
            String direccionIp = (String)jTable1.getValueAt(filaSeleccionada, 8);
            String servicios = (String)jTable1.getValueAt(filaSeleccionada, 12);

            pagoWindows windows = new pagoWindows(id, nombre, paquete, servicios, direccionIp);
            Dashboard.escritorioInterno.add(windows);
            windows.show();
        }else{
            JOptionPane.showMessageDialog(null, "Para registrar un pago, seleccione el cliente", "SpiderNET", JOptionPane.WARNING_MESSAGE);
        }
        
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPagarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBloquear;
    private javax.swing.JButton btnCambiarVelocidad;
    private javax.swing.JButton btnDesbloquear;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnPagar;
    private javax.swing.JButton btnRefrescar;
    private javax.swing.JButton btnSimpleQueue;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
    
    private void listarClientes(){
        Conexion conexion = new Conexion();
        Connection cn = conexion.getConnection();
        
        if(cn != null){
            Statement st = null;
            ResultSet rs = null;
            
            try {
                String sql = """
                             SELECT 
                                 c.id,
                                 c.nombre,
                                 c.telefono,
                                 c.email,
                                 c.direccion,
                                 DATE_FORMAT(c.fecha_registro, '%d/%m/%Y') AS fecha_registro,  -- Formato de la fecha
                                 p.nombre AS paquete,  -- Obtener el nombre del paquete
                                 c.estado,
                                 c.ip_cliente,
                                 c.dia_corte,
                                 c.ap_antena,
                                 c.serviciosTV,
                                 c.serviciosPlataformas
                             FROM clientes c
                             LEFT JOIN paquetes p ON c.id_paquete = p.id;
                             """;
                DefaultTableModel modelo;
                st = cn.createStatement();
                rs = st.executeQuery(sql); //ejecutamos para obtener el resultado
                Object[] clientes = new Object[13];
                String estados = "Activo";
                String bloqueado = "Bloqueado";
                modelo = (DefaultTableModel)jTable1.getModel();
                modelo.setRowCount(0);
                
                while(rs.next()){
                    clientes[0] = rs.getInt("id");
                    clientes[1] = rs.getString("nombre");
                    clientes[2] = rs.getString("telefono");
                    clientes[3] = rs.getString("email");
                    clientes[4] = rs.getString("direccion");
                    clientes[5] = rs.getString("fecha_registro");
                    clientes[6] = rs.getString("paquete");
                    clientes[7] = rs.getString("estado");
                    clientes[8] = rs.getString("ip_cliente");
                    clientes[9] = rs.getString("dia_corte");
                    clientes[10] = rs.getString("ap_antena");
                    clientes[11] = rs.getString("serviciosTV");
                    clientes[12] = rs.getString("serviciosPlataformas");


                    modelo.addRow(clientes);
                }    
                jTable1.setModel(modelo);

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(rootPane, "Error al listar los clientes: " + e, "SpiderNET", JOptionPane.ERROR_MESSAGE);
            }finally{
                conexion.closeConnection();
            }
            
        }else{
            JOptionPane.showMessageDialog(rootPane, "No logramos establecer una conexion", "Modulo Clientes", JOptionPane.ERROR_MESSAGE);
        }
    }


}
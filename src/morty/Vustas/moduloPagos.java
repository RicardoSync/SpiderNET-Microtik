/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package morty.Vustas;

import Config.Conexion;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import javax.swing.JOptionPane;

/*
Debemos listar todos los pagos de manera general y mostrarlos en la tabla, ademas 
debemos poder buscar los pagos de un cliente usando su nombre o bien, filtrarlo por fechas
con mes y annio.

 */
public class moduloPagos extends javax.swing.JInternalFrame {

    public moduloPagos() {
        initComponents();
        consultarPagos();
    }

    public void consultarPagos() {
        Conexion conexion = new Conexion();
        Connection cn = conexion.getConnection();

        if (cn != null) {
            PreparedStatement cursor;
            ResultSet resultado;

            try {
                String sql = """
                             SELECT c.nombre, p.monto, p.fecha_pago, p.metodo_pago
                             FROM pagos p
                             LEFT JOIN clientes c ON p.id_cliente = c.id;
                             """;
                cursor = cn.prepareCall(sql);
                resultado = cursor.executeQuery();

                DefaultTableModel modelo;

                Object[] pagos = new Object[4];
                modelo = (DefaultTableModel) jTable1.getModel();
                modelo.setRowCount(0);

                while (resultado.next()) {
                    pagos[0] = resultado.getString("nombre");
                    pagos[1] = resultado.getString("monto");
                    pagos[2] = resultado.getString("fecha_pago");
                    pagos[3] = resultado.getString("metodo_pago");
                    modelo.addRow(pagos);
                }
                jTable1.setModel(modelo);
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "No podemos listar los pagos");
            }
        }
    }

    public void buscarNombreCliente() {
        String nombreCliente = entryNombre.getText().trim();  // Eliminar espacios extra

        if (!nombreCliente.isEmpty()) {
            Conexion conexion = new Conexion();
            Connection cn = conexion.getConnection();

            if (cn != null) {
                PreparedStatement cursor;
                ResultSet resultado;
                String sql = """
                         SELECT c.nombre, p.monto, p.fecha_pago, p.metodo_pago
                         FROM pagos p
                         LEFT JOIN clientes c ON p.id_cliente = c.id
                         WHERE c.nombre LIKE ?;
                         """;

                try {
                    DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
                    modelo.setRowCount(0);

                    cursor = cn.prepareStatement(sql);
                    cursor.setString(1, nombreCliente + "%");  // Agregar el "%" en el parámetro
                    resultado = cursor.executeQuery();

                    Object[] pagos = new Object[4];
                    boolean hayResultado = false;

                    while (resultado.next()) {
                        hayResultado = true;
                        pagos[0] = resultado.getString("nombre");
                        pagos[1] = resultado.getString("monto");
                        pagos[2] = resultado.getString("fecha_pago");
                        pagos[3] = resultado.getString("metodo_pago");
                        modelo.addRow(pagos);
                    }

                    jTable1.setModel(modelo);

                    if (!hayResultado) {
                        JOptionPane.showMessageDialog(null, "No se encontraron pagos de este cliente: " + nombreCliente + " verifica su nombre", "SpiderNET", JOptionPane.WARNING_MESSAGE);
                    }

                    resultado.close();
                    cursor.close();
                    cn.close();
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "No podemos encontrar y/o listar este cliente", "SpiderNET", JOptionPane.ERROR_MESSAGE);
                    e.printStackTrace();
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "No podemos buscar un cliente sin nombre, no seas imbecil!!", "SpiderNET", JOptionPane.WARNING_MESSAGE);
        }
    }

    public void filtradoFecha() {
        int mes = Integer.parseInt((String) comboMes.getSelectedItem());
        int annio = Integer.parseInt(entryAnnio.getText());
        Conexion conexion = new Conexion();
        Connection cn = conexion.getConnection();

        if (cn != null) {
            PreparedStatement cursor;
            ResultSet resultado;
            String sql = """
                     SELECT c.nombre, p.monto, DATE_FORMAT(p.fecha_pago, '%m-%Y') AS mes_anio, p.metodo_pago
                     FROM pagos p
                     LEFT JOIN clientes c ON p.id_cliente = c.id
                     WHERE YEAR(p.fecha_pago) = ? AND MONTH(p.fecha_pago) = ?;
                     """;

            try {
                DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
                modelo.setRowCount(0); // Limpiar la tabla antes de insertar nuevos datos

                cursor = cn.prepareStatement(sql);
                cursor.setInt(1, annio);
                cursor.setInt(2, mes);

                resultado = cursor.executeQuery();
                boolean hayResultados = false;

                while (resultado.next()) {
                    hayResultados = true;
                    Object[] cliente = new Object[4];
                    cliente[0] = resultado.getString("nombre");
                    cliente[1] = resultado.getString("monto");
                    cliente[2] = resultado.getString("mes_anio");
                    cliente[3] = resultado.getString("metodo_pago");
                    modelo.addRow(cliente);
                }

                jTable1.setModel(modelo);

                // Si no hay resultados, mostrar una notificación
                if (!hayResultados) {
                    JOptionPane.showMessageDialog(null, "No hay pagos registrados para " + mes + "-" + annio, "SpiderNET", JOptionPane.INFORMATION_MESSAGE);
                }

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al filtrar los pagos: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        entryNombre = new javax.swing.JTextField();
        btnNombre = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        comboMes = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        entryAnnio = new javax.swing.JTextField();
        btnFechas = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setClosable(true);
        setMaximizable(true);
        setTitle("Modulo Pagos");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Opciones"));

        jLabel1.setText("Nombre cliente");

        btnNombre.setText("Buscar nombre");
        btnNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNombreActionPerformed(evt);
            }
        });

        jLabel2.setText("Mes");

        comboMes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));

        jLabel3.setText("Año");

        entryAnnio.setText("2025");

        btnFechas.setText("Buscar por fecha");
        btnFechas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFechasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(entryNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnNombre)
                .addGap(30, 30, 30)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboMes, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(entryAnnio, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnFechas)
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(entryNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNombre)
                    .addComponent(jLabel2)
                    .addComponent(comboMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(entryAnnio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFechas))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Cantidad", "Fecha", "Metodo"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 352, Short.MAX_VALUE)
                .addContainerGap())
        );

        jButton1.setText("Refrescar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        consultarPagos();
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNombreActionPerformed
        buscarNombreCliente();
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNombreActionPerformed

    private void btnFechasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFechasActionPerformed
        filtradoFecha();
        // TODO add your handling code here:
    }//GEN-LAST:event_btnFechasActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFechas;
    private javax.swing.JButton btnNombre;
    private javax.swing.JComboBox<String> comboMes;
    private javax.swing.JTextField entryAnnio;
    private javax.swing.JTextField entryNombre;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}

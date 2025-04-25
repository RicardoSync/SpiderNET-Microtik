package Clientes;

import Config.Conexion;
import Config.Consultas;
import Config.DeleteDatos;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import Config.InsertarDatos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;
import Config.UpdateDatos;
import GoogleMaps.GoogleMaps;
import java.awt.Desktop;
import java.net.URI;
import java.sql.*;
import UIPrincipal.Dashboard;
import morty.Vustas.asignacionRick;
import morty.Vustas.crearEquipo;
import morty.Vustas.editarEquipo;

public class detallesCliente extends javax.swing.JInternalFrame {

    public detallesCliente(int id, String nombre, String telefono, String ip_cliente, String dia_corte, String paqueteActual, String apActual,
            String plataformaActual, String tvActual, String correo, String direccion, String microtikActual) {
        initComponents();
        insertarElementos(id, nombre, telefono, ip_cliente, dia_corte, paqueteActual, apActual, plataformaActual, tvActual, correo, direccion, microtikActual);
        obtenerDireccionGoogleMaps(id);
        obtenerApiKey(id);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        entryTelefono = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        entryCorreo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        entryDireccion = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        comboPaquetes = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        entryID = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        entryDireccionUrlGoogleMaps = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        comboAntenasAP = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        entryIpCliente = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        entryDiaCorte = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        comboMicrotik = new javax.swing.JComboBox<>();
        entryApiKey = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        comboTV = new javax.swing.JComboBox<>();
        jLabel26 = new javax.swing.JLabel();
        comboEntretenimiento = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaEquipos = new javax.swing.JTable();
        entryNombre = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setTitle("Detales del Cliente");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos Personales"));

        jLabel2.setText("Telefono");

        entryTelefono.setEnabled(false);
        entryTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                entryTelefonoActionPerformed(evt);
            }
        });

        jLabel3.setText("Correo");

        entryCorreo.setEnabled(false);

        jLabel4.setText("Direccion");

        entryDireccion.setEnabled(false);

        jLabel7.setText("Paquete");

        comboPaquetes.setEnabled(false);

        jLabel11.setText("ID");

        entryID.setEditable(false);

        jLabel12.setText("Google Maps");

        entryDireccionUrlGoogleMaps.setEnabled(false);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/modo-retrato.png"))); // NOI18N
        jButton2.setText("Consultar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel11)
                        .addGap(11, 11, 11)
                        .addComponent(entryID, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(263, 263, 263))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(entryCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(entryTelefono))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(comboPaquetes, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(entryDireccion))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(entryDireccionUrlGoogleMaps, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(entryID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(entryCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(entryTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(comboPaquetes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(entryDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(entryDireccionUrlGoogleMaps, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addGap(15, 15, 15))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos Tecnicos"));

        jLabel5.setText("Antena AP");

        comboAntenasAP.setEnabled(false);

        jLabel8.setText("IP Cliente");

        entryIpCliente.setEnabled(false);

        jLabel9.setText("Dia de Corte");

        entryDiaCorte.setEnabled(false);

        jLabel10.setText("ApiKey");

        jLabel6.setText("Microtik / OLT");

        comboMicrotik.setEnabled(false);

        entryApiKey.setEnabled(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(comboMicrotik, 0, 158, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(entryDiaCorte)
                            .addComponent(comboAntenasAP, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(entryIpCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                    .addComponent(entryApiKey))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(comboAntenasAP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(entryIpCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9)
                        .addComponent(entryDiaCorte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(entryApiKey, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(comboMicrotik, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos Servicios"));

        jLabel18.setText("Servicio de TV");

        comboTV.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "Digital", "Analogico", "Mayonesa" }));
        comboTV.setEnabled(false);

        jLabel26.setText("Servicios de entretenimiento");

        comboEntretenimiento.setEnabled(false);
        comboEntretenimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboEntretenimientoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel26)
                        .addGap(18, 18, 18)
                        .addComponent(comboEntretenimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboTV, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(comboTV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(comboEntretenimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Equipos Instalados"));

        tablaEquipos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Tipo", "Marca", "Modelo", "MAC", "Serial", "Estado"
            }
        ));
        tablaEquipos.setEnabled(false);
        jScrollPane1.setViewportView(tablaEquipos);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 590, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        entryNombre.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Detalles del Cliente:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(entryNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(entryNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void entryTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_entryTelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_entryTelefonoActionPerformed

    private void comboEntretenimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboEntretenimientoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboEntretenimientoActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
//        try {
//            String url = entryDireccionUrlGoogleMaps.getText();
//            if (url.startsWith("http")) {
//                Desktop.getDesktop().browse(new URI(url));
//            }
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
        String nombreCliente = entryNombre.getText();
        String coordenadas = entryDireccionUrlGoogleMaps.getText();
        String url = "https://www.google.com/maps?q=" + coordenadas;
        GoogleMaps gm = new GoogleMaps(url, nombreCliente);
        Dashboard.escritorioInterno.add(gm);
        gm.setVisible(true);


        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    public void listarNombrePaquetes(String paqueteActual) {
        Consultas consultasNombres = new Consultas();

        ArrayList<String> nombrePaquetes = consultasNombres.consultarPaquetes();

        // Insertar el paquete actual en la primera posición
        nombrePaquetes.add(0, paqueteActual);

        // Agregar una opción vacía al final
        nombrePaquetes.add("");

        // Llenar el JComboBox con los paquetes
        for (String paquete : nombrePaquetes) {
            comboPaquetes.addItem(paquete);
        }
    }


    public void listarNombreAntenas(String apActual) {
        Consultas consultasAntenasAp = new Consultas();
        ArrayList<String> nombreAntenas = consultasAntenasAp.consultarAntenasAp();

        nombreAntenas.add(0, apActual);
        nombreAntenas.add("");
        for (String antenas : nombreAntenas) {
            comboAntenasAP.addItem(antenas);
        }
    }

    public void listarMicrotik(String microtikActual){
        Consultas consultas = new Consultas();
        ArrayList<String> nombreMicrotik = consultas.nombresMicrotiks();
        
        nombreMicrotik.add(0, microtikActual);
        nombreMicrotik.add("");
        for(String microtiks : nombreMicrotik){
            comboMicrotik.addItem(microtiks);
        }

    }

    public void listarPlataformas(String plataformaActual) {
        Consultas consultas = new Consultas();
        ArrayList<String> nombrePlataformas = consultas.consultarPlataformas();

        nombrePlataformas.add(0, plataformaActual); // Agregar la plataforma actual al inicio
        nombrePlataformas.add("");
        for (String plataformas : nombrePlataformas) {
            comboEntretenimiento.addItem(plataformas);
        }

    }

    public void insertarElementos(int id, String nombre, String telefono, String ip_cliente, String dia_corte, String paqueteActual,
            String apActual, String plataformaActual, String tvActual, String correo, String direccion, String microtikActual) {
        entryID.setText(String.valueOf(id));
        entryNombre.setText(nombre);
        entryTelefono.setText(telefono);
        entryIpCliente.setText(ip_cliente);
        entryDiaCorte.setText(dia_corte);
        comboTV.addItem(tvActual);
        entryCorreo.setText(correo);
        entryDireccion.setText(direccion);

        listarNombrePaquetes(paqueteActual);
        listarNombreAntenas(apActual);
        listarPlataformas(plataformaActual);
        listarMicrotik(microtikActual);
        equiposInstalados(id);

    }

    public void equiposInstalados(int id_cliente) {
        Conexion conexion = new Conexion();
        Connection cn = conexion.getConnection();

        if (cn != null) {
            PreparedStatement cursosr = null;
            try {
                DefaultTableModel modelo;
                ResultSet rs = null;
                PreparedStatement cursor;

                String sql = """
                             SELECT id, nombre, tipo, marca, modelo, mac, serial, estado FROM equipos
                             WHERE id_cliente = ?
                             """;
                cursor = cn.prepareStatement(sql);
                cursor.setInt(1, id_cliente);
                rs = cursor.executeQuery();
                modelo = (DefaultTableModel) tablaEquipos.getModel();
                modelo.setRowCount(0);
                Object[] equipos = new Object[8];

                while (rs.next()) {
                    equipos[0] = rs.getInt("id");
                    equipos[1] = rs.getString("nombre");
                    equipos[2] = rs.getString("tipo");
                    equipos[3] = rs.getString("marca");
                    equipos[4] = rs.getString("modelo");
                    equipos[5] = rs.getString("mac");
                    equipos[6] = rs.getString("serial");
                    equipos[7] = rs.getString("estado");
                    modelo.addRow(equipos);
                }
                tablaEquipos.setModel(modelo);
            } catch (Exception e) {
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> comboAntenasAP;
    private javax.swing.JComboBox<String> comboEntretenimiento;
    private javax.swing.JComboBox<String> comboMicrotik;
    private javax.swing.JComboBox<String> comboPaquetes;
    private javax.swing.JComboBox<String> comboTV;
    private javax.swing.JTextField entryApiKey;
    private javax.swing.JTextField entryCorreo;
    private javax.swing.JTextField entryDiaCorte;
    private javax.swing.JTextField entryDireccion;
    private javax.swing.JTextField entryDireccionUrlGoogleMaps;
    private javax.swing.JTextField entryID;
    private javax.swing.JTextField entryIpCliente;
    private javax.swing.JTextField entryNombre;
    private javax.swing.JTextField entryTelefono;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaEquipos;
    // End of variables declaration//GEN-END:variables
    public void obtenerDireccionGoogleMaps(int id_cliente) {
        System.out.println("Método llamado para Google Maps. ID cliente: " + id_cliente);
        Conexion conexion = new Conexion();
        Connection cn = conexion.getConnection();

        if (cn != null) {
            try {
                String sqlUbicacion = "SELECT ubicacion_maps FROM clientes WHERE id = ?";
                try (PreparedStatement stmt = cn.prepareStatement(sqlUbicacion)) {
                    stmt.setInt(1, id_cliente);
                    ResultSet rs = stmt.executeQuery();

                    if (rs.next()) {
                        String ubicacion = rs.getString("ubicacion_maps");
                        System.out.println("Ubicación en BD: " + ubicacion);

                        if (ubicacion != null && !ubicacion.trim().isEmpty()) {
                            entryDireccionUrlGoogleMaps.setText(ubicacion);
                        } else {
                            entryDireccionUrlGoogleMaps.setText("Sin dirección URL");
                        }
                    } else {
                        System.out.println("⚠ No se encontró el cliente con ID " + id_cliente);
                        entryDireccionUrlGoogleMaps.setText("No tiene dirección en Google Maps");
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
                entryDireccionUrlGoogleMaps.setText("Error al obtener dirección");
            }
        } else {
            entryDireccionUrlGoogleMaps.setText("Sin conexión a la base de datos");
        }
    }
    public void obtenerApiKey(int id_cliente) {
        System.out.println("🔐 Método llamado para obtener API Key. ID cliente: " + id_cliente);
        Conexion conexion = new Conexion();
        Connection cn = conexion.getConnection();

        if (cn != null) {
            try {
                String sql = "SELECT apikey FROM clientes_apikeys WHERE id_cliente = ?";
                try (PreparedStatement stmt = cn.prepareStatement(sql)) {
                    stmt.setInt(1, id_cliente);
                    ResultSet rs = stmt.executeQuery();

                    if (rs.next()) {
                        String apiKey = rs.getString("apikey");
                        System.out.println("✅ API Key encontrada: " + apiKey);

                        if (apiKey != null && !apiKey.trim().isEmpty()) {
                            entryApiKey.setText(apiKey); // Puedes cambiar esto si quieres mostrarlo en otro campo
                        } else {
                            entryApiKey.setText("API Key vacía");
                        }
                    } else {
                        System.out.println("⚠ No hay API Key para el cliente con ID " + id_cliente);
                        entryApiKey.setText("No tiene API Key");
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
                entryApiKey.setText("Error al obtener API Key");
            }
        } else {
            entryApiKey.setText("Sin conexión a la base de datos");
        }
    }

}

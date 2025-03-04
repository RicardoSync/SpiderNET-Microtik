package morty.Vustas;

import Config.Conexion;
import Config.Consultas;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import Config.InsertarDatos;
import java.sql.*;

public class creacionCliente extends javax.swing.JInternalFrame {

    public creacionCliente() {
        initComponents();
        listarNombrePaquetes();
        listarNombreAntenas();
        listarPlataformas();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        entryNombre = new javax.swing.JTextField();
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
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        comboAntenasAP = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        entryIpCliente = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        entryDiaCorte = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btnGuardar = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        entryNombreEquipoExtra = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        comboTipoEquipoExtra = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        entryMarcaEquipoExtra = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        entryModeloEquipoExtra = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        entryMacEquipoExtra = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        entrySerialEquipoExtra = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        comboEstadoExtra = new javax.swing.JComboBox<>();
        jPanel5 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        entryNombreEquipo1 = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        comboTipoEquipo1 = new javax.swing.JComboBox<>();
        jLabel21 = new javax.swing.JLabel();
        entryMarcaEquipo1 = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        entryModeloEquipo1 = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        entryMacEquipo1 = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        entrySerialEquipo1 = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        comboEstado1 = new javax.swing.JComboBox<>();
        jPanel6 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        comboTV = new javax.swing.JComboBox<>();
        jLabel26 = new javax.swing.JLabel();
        comboEntretenimiento = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(0, 0, 0));
        setClosable(true);
        setIconifiable(true);
        setTitle("Crear Cliente");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos Personales"));

        jLabel1.setText("Nombre");

        jLabel2.setText("Telefono");

        entryTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                entryTelefonoActionPerformed(evt);
            }
        });

        jLabel3.setText("Correo");

        jLabel4.setText("Direccion");

        jLabel7.setText("Paquete");

        jLabel11.setText("ID");

        entryID.setEditable(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(entryNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboPaquetes, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel11)
                                        .addGap(37, 37, 37))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(18, 18, 18)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(entryID, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(entryCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(entryTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(entryDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(entryID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(entryNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(entryCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(entryTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(comboPaquetes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(entryDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos Tecnicos"));

        jLabel5.setText("Conexion");

        jLabel8.setText("IP Cliente");

        jLabel9.setText("Dia de Corte");

        entryDiaCorte.setText("30");

        jLabel10.setText("Ejemplo 10, 15, 20, 30 etc");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboAntenasAP, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(entryDiaCorte)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(entryIpCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel10))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(entryDiaCorte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Opciones"));

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnGuardar)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Equipos Extra"));

        jLabel12.setText("Nombre Equipos:");

        jLabel6.setText("Tipo");

        comboTipoEquipoExtra.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Router", "Antena", "ONU", "Otro" }));

        jLabel13.setText("Marca");

        jLabel14.setText("Modelo");

        jLabel15.setText("MAC");

        jLabel16.setText("Serial");

        jLabel17.setText("Estado");

        comboEstadoExtra.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Rentado", "Vendido", "Propio", " " }));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(entryNombreEquipoExtra))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addGap(18, 18, 18)
                        .addComponent(entrySerialEquipoExtra, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(comboEstadoExtra, 0, 115, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(comboTipoEquipoExtra, 0, 150, Short.MAX_VALUE)
                            .addComponent(entryModeloEquipoExtra))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel15))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jLabel13)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(entryMarcaEquipoExtra)
                            .addComponent(entryMacEquipoExtra))))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(entryNombreEquipoExtra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(comboTipoEquipoExtra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(entryMarcaEquipoExtra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(entryModeloEquipoExtra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(entryMacEquipoExtra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(entrySerialEquipoExtra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17)
                    .addComponent(comboEstadoExtra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Equipos Instalados"));

        jLabel19.setText("Nombre Equipos:");

        jLabel20.setText("Tipo");

        comboTipoEquipo1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Router", "Antena", "ONU", "Otro" }));

        jLabel21.setText("Marca");

        jLabel22.setText("Modelo");

        jLabel23.setText("MAC");

        jLabel24.setText("Serial");

        jLabel25.setText("Estado");

        comboEstado1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Rentado", "Vendido", "Propio", " " }));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(entryNombreEquipo1))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel24)
                        .addGap(18, 18, 18)
                        .addComponent(entrySerialEquipo1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel25)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(comboEstado1, 0, 115, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel22)
                            .addComponent(jLabel20))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(comboTipoEquipo1, 0, 150, Short.MAX_VALUE)
                            .addComponent(entryModeloEquipo1))
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel23))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jLabel21)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(entryMarcaEquipo1)
                            .addComponent(entryMacEquipo1))))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(entryNombreEquipo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(comboTipoEquipo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21)
                    .addComponent(entryMarcaEquipo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(entryModeloEquipo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23)
                    .addComponent(entryMacEquipo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(entrySerialEquipo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25)
                    .addComponent(comboEstado1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos Servicios"));

        jLabel18.setText("Servicio de TV");

        comboTV.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "Analogico", "Digital", "" }));

        jLabel26.setText("Servicios de entretenimiento");

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
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel26)
                        .addGap(18, 18, 18)
                        .addComponent(comboEntretenimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboTV, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)))
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 11, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void entryTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_entryTelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_entryTelefonoActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        guardarCliente();
        // TODO add your handling code here:
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void comboEntretenimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboEntretenimientoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboEntretenimientoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<String> comboAntenasAP;
    private javax.swing.JComboBox<String> comboEntretenimiento;
    private javax.swing.JComboBox<String> comboEstado1;
    private javax.swing.JComboBox<String> comboEstadoExtra;
    private javax.swing.JComboBox<String> comboPaquetes;
    private javax.swing.JComboBox<String> comboTV;
    private javax.swing.JComboBox<String> comboTipoEquipo1;
    private javax.swing.JComboBox<String> comboTipoEquipoExtra;
    private javax.swing.JTextField entryCorreo;
    private javax.swing.JTextField entryDiaCorte;
    private javax.swing.JTextField entryDireccion;
    private javax.swing.JTextField entryID;
    private javax.swing.JTextField entryIpCliente;
    private javax.swing.JTextField entryMacEquipo1;
    private javax.swing.JTextField entryMacEquipoExtra;
    private javax.swing.JTextField entryMarcaEquipo1;
    private javax.swing.JTextField entryMarcaEquipoExtra;
    private javax.swing.JTextField entryModeloEquipo1;
    private javax.swing.JTextField entryModeloEquipoExtra;
    private javax.swing.JTextField entryNombre;
    private javax.swing.JTextField entryNombreEquipo1;
    private javax.swing.JTextField entryNombreEquipoExtra;
    private javax.swing.JTextField entrySerialEquipo1;
    private javax.swing.JTextField entrySerialEquipoExtra;
    private javax.swing.JTextField entryTelefono;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
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
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    // End of variables declaration//GEN-END:variables

    public void listarNombrePaquetes() {
        Consultas consultasNombres = new Consultas();
        ArrayList<String> nombrePaquetes = consultasNombres.consultarPaquetes();
        nombrePaquetes.add(0, "");
        for (String paquete : nombrePaquetes) {
            comboPaquetes.addItem(paquete);
        }
    }

    public void listarNombreAntenas() {
        Consultas consultasAntenasAp = new Consultas();
        ArrayList<String> nombreAntenas = consultasAntenasAp.consultarAntenasAp();
        nombreAntenas.add(0, "");
        for (String antenas : nombreAntenas) {
            comboAntenasAP.addItem(antenas);
        }
    }

    public void listarPlataformas() {
        Consultas consultas = new Consultas();
        ArrayList<String> nombrePlataformas = consultas.consultarPlataformas();
        nombrePlataformas.add(0, "");
        for (String plataformas : nombrePlataformas) {
            comboEntretenimiento.addItem(plataformas);
        }
    }

    public void almacenarUnCliente() {
        String nombre = entryNombre.getText();
        if (nombre.length() > 0) {
            String telefono = entryTelefono.getText();
            String correo = entryCorreo.getText();
            String direccion = entryDireccion.getText();
            String paquete = (String) comboPaquetes.getSelectedItem();
            String ip_cliente = entryIpCliente.getText();
            String dia_corte = entryDiaCorte.getText();
            String ap_cliente = (String) comboAntenasAP.getSelectedItem();
            String serviciosPlataformas = (String)comboEntretenimiento.getSelectedItem();
            String servicioTV = (String)comboTV.getSelectedItem();
            
            InsertarDatos datos = new InsertarDatos();
            datos.insertarUnSoloCLienteALV(nombre, telefono, correo, direccion, paquete, ip_cliente, dia_corte, ap_cliente, servicioTV, serviciosPlataformas);

        }
        else{
            JOptionPane.showMessageDialog(null, "No podemos registrar un cliente sin nombre");
        }

    }

    public void guardarCliente() {
        String nombreCliente = entryNombre.getText();
        String primerEquipo = entryNombreEquipo1.getText();
        String segundoEquipo = entryNombreEquipoExtra.getText();
        creacionCliente cliente = new creacionCliente();

        if (nombreCliente.length() > 0) {
            // Obtener datos del cliente
            String telefono = entryTelefono.getText();
            String correo = entryCorreo.getText();
            String direccion = entryDireccion.getText();
            String paquete = (String) comboPaquetes.getSelectedItem();
            String ip_cliente = entryIpCliente.getText();
            String dia_corte = entryDiaCorte.getText();
            String ap_cliente = (String) comboAntenasAP.getSelectedItem();

            if (primerEquipo.length() > 0 && segundoEquipo.length() > 0) {
                // Si tenemos ambos equipos
                String tipo = (String) comboTipoEquipo1.getSelectedItem();
                String marca = entryMarcaEquipo1.getText();
                String modelo = entryModeloEquipo1.getText();
                String mac = entryMacEquipo1.getText();
                String serial = entrySerialEquipo1.getText();
                String estado = (String) comboEstado1.getSelectedItem();

                // Segundo equipo
                String tipoExtra = (String) comboTipoEquipoExtra.getSelectedItem();
                String marcaExtra = entryMarcaEquipoExtra.getText();
                String modeloExtra = entryModeloEquipoExtra.getText();
                String macExtra = entryMacEquipoExtra.getText();
                String serialExtra = entrySerialEquipoExtra.getText();
                String estadoExtra = (String) comboEstadoExtra.getSelectedItem();
                String serviciosTV = (String) comboTV.getSelectedItem();
                String serviciosPlataformas = (String) comboEntretenimiento.getSelectedItem();
                InsertarDatos insertarDatos = new InsertarDatos();
                insertarDatos.insertarClienteDosEquipos(nombreCliente, telefono, correo, direccion, paquete, ip_cliente, dia_corte, ap_cliente,
                        serviciosTV, serviciosPlataformas,
                        primerEquipo, tipo, marca, modelo, mac, serial, estado,
                        segundoEquipo, tipoExtra, marcaExtra, modeloExtra, macExtra, serialExtra, estadoExtra);
            } else if (primerEquipo.length() > 0) {
                // Si solo tenemos el primer equipo
                String tipoUno = (String) comboTipoEquipo1.getSelectedItem();
                String marcaUno = entryMarcaEquipo1.getText();
                String modeloUno = entryModeloEquipo1.getText();
                String macUno = entryMacEquipo1.getText();
                String serialUno = entrySerialEquipo1.getText();
                String estadoUno = (String) comboEstado1.getSelectedItem();
                String serviciosTV = (String) comboTV.getSelectedItem();
                String serviciosPlataformas = (String) comboEntretenimiento.getSelectedItem();

                InsertarDatos insertarDatos = new InsertarDatos();
                insertarDatos.insertarCliente(nombreCliente, telefono, correo, direccion, paquete, ip_cliente, dia_corte, ap_cliente, serviciosTV, serviciosPlataformas,
                        primerEquipo, tipoUno, marcaUno, modeloUno, macUno, serialUno, estadoUno);

            } else if (primerEquipo.isBlank() && segundoEquipo.isBlank()) {
                almacenarUnCliente();
            } else {
                JOptionPane.showMessageDialog(cliente, "No podemos registrar un cliente sin paquete", "SpiderNET", JOptionPane.WARNING_MESSAGE);

            }
        } else {
            JOptionPane.showMessageDialog(cliente, "No podemos registrar un cliente sin nombre", "SpiderNET", JOptionPane.WARNING_MESSAGE);
        }
    }
}

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
import me.legrange.mikrotik.ApiConnection;
import me.legrange.mikrotik.MikrotikApiException;
import microtik.enableDisableQueue;
import microtik.lucifer;

public class creacionMicrotik extends javax.swing.JInternalFrame {

    public creacionMicrotik() {
        initComponents();
        listarMicrotiks();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

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
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        btnEliminarQueu = new javax.swing.JButton();
        btnDesabilitar = new javax.swing.JButton();
        btnHabilitar = new javax.swing.JButton();
        btnRegistroDB = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaSimpleQueue = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        btnObtenerDhcp = new javax.swing.JButton();
        bnMakeStatic = new javax.swing.JButton();
        btnBlock = new javax.swing.JButton();
        btnRegistroDBDhcp = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaDhcp = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        btnObtenerBlock = new javax.swing.JButton();
        btnDesbloquear = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tablaBlock = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setResizable(true);
        setTitle("Registrar Microtik");
        setToolTipText("Registrar Microtik");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos"));

        jLabel1.setText("Idnetificador");

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

        jTabbedPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/busqueda.png"))); // NOI18N
        jButton1.setText("Obtener");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnEliminarQueu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/quitar-carpeta.png"))); // NOI18N
        btnEliminarQueu.setText("Eliminar");
        btnEliminarQueu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarQueuActionPerformed(evt);
            }
        });

        btnDesabilitar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/detengase.png"))); // NOI18N
        btnDesabilitar.setText("Desabilitar");
        btnDesabilitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesabilitarActionPerformed(evt);
            }
        });

        btnHabilitar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/tocar.png"))); // NOI18N
        btnHabilitar.setText("Habilitar");
        btnHabilitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHabilitarActionPerformed(evt);
            }
        });

        btnRegistroDB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/flecha-de-circulo-de-disquete-a-la-derecha.png"))); // NOI18N
        btnRegistroDB.setText("Registrar");
        btnRegistroDB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistroDBActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDesabilitar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnHabilitar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnRegistroDB)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnEliminarQueu)
                .addGap(14, 14, 14))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(btnEliminarQueu)
                    .addComponent(btnDesabilitar)
                    .addComponent(btnHabilitar)
                    .addComponent(btnRegistroDB))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        tablaSimpleQueue.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Nombre", "Target", "Max Limit", "Parent", "#"
            }
        ));
        jScrollPane2.setViewportView(tablaSimpleQueue);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );

        jTabbedPane1.addTab("Simple Queue", jPanel4);

        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnObtenerDhcp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/busqueda.png"))); // NOI18N
        btnObtenerDhcp.setText("Obtener");
        btnObtenerDhcp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObtenerDhcpActionPerformed(evt);
            }
        });

        bnMakeStatic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/flechas-para-rodear.png"))); // NOI18N
        bnMakeStatic.setText("Make Static");
        bnMakeStatic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnMakeStaticActionPerformed(evt);
            }
        });

        btnBlock.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/bloquear-hashtag.png"))); // NOI18N
        btnBlock.setText("Bloquear");
        btnBlock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBlockActionPerformed(evt);
            }
        });

        btnRegistroDBDhcp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/flecha-de-circulo-de-disquete-a-la-derecha.png"))); // NOI18N
        btnRegistroDBDhcp.setText("Registrar");
        btnRegistroDBDhcp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistroDBDhcpActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(btnObtenerDhcp, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bnMakeStatic)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnBlock)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnRegistroDBDhcp)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnObtenerDhcp)
                    .addComponent(bnMakeStatic)
                    .addComponent(btnBlock)
                    .addComponent(btnRegistroDBDhcp))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        tablaDhcp.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "IP", "MAC", "Host", "Server", "#"
            }
        ));
        jScrollPane3.setViewportView(tablaDhcp);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 581, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(24, 24, 24))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Dhcp Leases", jPanel6);

        jPanel11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnObtenerBlock.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/busqueda.png"))); // NOI18N
        btnObtenerBlock.setText("Obtener");
        btnObtenerBlock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObtenerBlockActionPerformed(evt);
            }
        });

        btnDesbloquear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/desbloquear.png"))); // NOI18N
        btnDesbloquear.setText("Desbloquear");
        btnDesbloquear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesbloquearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(btnObtenerBlock, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnDesbloquear)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnObtenerBlock)
                    .addComponent(btnDesbloquear))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        tablaBlock.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "IP", "MAC", "Host", "Server", "#"
            }
        ));
        jScrollPane4.setViewportView(tablaBlock);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 504, Short.MAX_VALUE)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(24, 24, 24))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 626, Short.MAX_VALUE)
            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel8Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 493, Short.MAX_VALUE)
            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel8Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Clientes bloqueados", jPanel8);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String username = entryUsername.getText();
        String password = entryPassword.getText();
        String ip = entryIp.getText();

        if (username.isBlank() && password.isBlank() && ip.isBlank()) {
            JOptionPane.showMessageDialog(null, "Para poder consular, primero selecciona un microtik");
        } else {
            dhcpSimpleQueue(username, password, ip);
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnObtenerDhcpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObtenerDhcpActionPerformed
        String username = entryUsername.getText();
        String password = entryPassword.getText();
        String ip = entryIp.getText();

        if (username.isBlank() && password.isBlank() && ip.isBlank()) {
            JOptionPane.showMessageDialog(null, "Para poder consular, primero selecciona un microtik");
        } else {
            dhcpLeases(username, password, ip);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btnObtenerDhcpActionPerformed

    private void btnDesabilitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesabilitarActionPerformed
        String user = entryUsername.getText();
        String password = entryPassword.getText();
        String host = entryIp.getText();

        if (user.isBlank() && password.isBlank() && host.isBlank()) {
            JOptionPane.showMessageDialog(null, "Primero selecicona un microtik en la lista");
        } else {
            int row;
            row = tablaSimpleQueue.getSelectedRow();
            if (row >= 0) {
                String id = (String) tablaSimpleQueue.getValueAt(row, 4);
                enableDisableQueue disableQueue = new enableDisableQueue();
                disableQueue.deshabilitar(id, host, user, password);
            } else {
                JOptionPane.showMessageDialog(null, "Selecciona un Queue de la tabla primero");
            }
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDesabilitarActionPerformed

    private void btnHabilitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHabilitarActionPerformed
        String user = entryUsername.getText();
        String password = entryPassword.getText();
        String host = entryIp.getText();

        if (user.isBlank() && password.isBlank() && host.isBlank()) {
            JOptionPane.showMessageDialog(null, "Primero selecicona un microtik en la lista");
        } else {
            int row;
            row = tablaSimpleQueue.getSelectedRow();
            if (row >= 0) {
                String id = (String) tablaSimpleQueue.getValueAt(row, 4);
                enableDisableQueue disableQueue = new enableDisableQueue();
                disableQueue.enable(id, host, user, password);
            } else {
                JOptionPane.showMessageDialog(null, "Selecciona un Queue de la tabla primero");
            }
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btnHabilitarActionPerformed

    private void btnRegistroDBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistroDBActionPerformed
        String user = entryUsername.getText();
        String password = entryPassword.getText();
        String host = entryIp.getText();
        String nombreMicrotik = entryNombre.getText();

        if (user.isBlank() && password.isBlank() && host.isBlank()) {
            JOptionPane.showMessageDialog(null, "Primero selecicona un microtik en la lista");
        } else {
            int row;
            row = tablaSimpleQueue.getSelectedRow();
            if (row >= 0) {
                String nombre = (String) tablaSimpleQueue.getValueAt(row, 0);
                String ip = (String) tablaSimpleQueue.getValueAt(row, 1);
                InsertarDatos datos = new InsertarDatos();
                datos.registroClienteSimple(nombre, ip, nombreMicrotik);

            } else {
                JOptionPane.showMessageDialog(null, "Selecciona un Queue de la tabla primero");
            }
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRegistroDBActionPerformed

    private void btnEliminarQueuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarQueuActionPerformed
        String user = entryUsername.getText();
        String password = entryPassword.getText();
        String routerIp = entryIp.getText();
        
        if(user.isBlank() && password.isBlank() && routerIp.isBlank()){
            JOptionPane.showMessageDialog(null, "Primero selecciona un microtik de la lista");
        }else{
            int row;
            row = tablaSimpleQueue.getSelectedRow();
            if(row >=0){
                String id = (String)tablaSimpleQueue.getValueAt(row, 4);
                enableDisableQueue disableQueue = new enableDisableQueue();
                disableQueue.removeQueue(user, password, routerIp, id);
            }else{
                JOptionPane.showMessageDialog(null, "Primero selecciona un Queue de la tabla");
            }
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarQueuActionPerformed

    private void bnMakeStaticActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnMakeStaticActionPerformed
        String user = entryUsername.getText();
        String password = entryPassword.getText();
        String host = entryIp.getText();
        
        if(user.isBlank() && password.isBlank() && host.isBlank()){
            JOptionPane.showMessageDialog(null, "Primero selecciona un microtik de la lista");
        }else{
            int rows = tablaDhcp.getSelectedRow();
            if(rows >= 0 ){
                String id = (String)tablaDhcp.getValueAt(rows, 4);
                enableDisableQueue queue = new enableDisableQueue();
                queue.makeStatic(user, password, host, id);
            }else{
                JOptionPane.showMessageDialog(null, "Primero selecciona un cliente de la tabla");
            }
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_bnMakeStaticActionPerformed

    private void btnBlockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBlockActionPerformed
        String routerIp = entryIp.getText();
        String user = entryUsername.getText();
        String password = entryPassword.getText();
        
        
                //tring routerIp, String user, String password, String targetI
        if(user.isBlank() && password.isBlank() && routerIp.isBlank()){
            JOptionPane.showMessageDialog(null, "Primero selecciona un microtik de la lista");
        }else{
            int rows = tablaDhcp.getSelectedRow();
            if(rows >= 0 ){
                String targetI = (String)tablaDhcp.getValueAt(rows, 0);
                lucifer lc = new lucifer();
                lc.bloqueoCliente(routerIp, user, password, targetI);
            }else{
                JOptionPane.showMessageDialog(null, "Primero selecciona un cliente de la tabla");
            }
        }
    }//GEN-LAST:event_btnBlockActionPerformed

    private void btnRegistroDBDhcpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistroDBDhcpActionPerformed
        String user = entryUsername.getText();
        String password = entryPassword.getText();
        String host = entryIp.getText();
        String nombreMicrotik = entryNombre.getText();

        if (user.isBlank() && password.isBlank() && host.isBlank()) {
            JOptionPane.showMessageDialog(null, "Primero selecicona un microtik en la lista");
        } else {
            int row;
            row = tablaDhcp.getSelectedRow();
            if (row >= 0) {
                String nombre = (String) tablaDhcp.getValueAt(row, 2);
                String ip = (String) tablaDhcp.getValueAt(row, 0);
                InsertarDatos datos = new InsertarDatos();
                datos.registroClienteSimple(nombre, ip, nombreMicrotik);

            } else {
                JOptionPane.showMessageDialog(null, "Selecciona un Queue de la tabla primero");
            }
        }     
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRegistroDBDhcpActionPerformed

    private void btnObtenerBlockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObtenerBlockActionPerformed
        String username = entryUsername.getText();
        String password = entryPassword.getText();
        String ip = entryIp.getText();

        if (username.isBlank() && password.isBlank() && ip.isBlank()) {
            JOptionPane.showMessageDialog(null, "Para poder consular, primero selecciona un microtik");
        } else {
            dhcpBlock(username, password, ip);
        }
        
        // TODO add your handling code here:
    }//GEN-LAST:event_btnObtenerBlockActionPerformed

    private void btnDesbloquearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesbloquearActionPerformed
        String routerIp = entryIp.getText();
        String user = entryUsername.getText();
        String password = entryPassword.getText();
        
        
                //tring routerIp, String user, String password, String targetI
        if(user.isBlank() && password.isBlank() && routerIp.isBlank()){
            JOptionPane.showMessageDialog(null, "Primero selecciona un microtik de la lista");
        }else{
            int rows = tablaBlock.getSelectedRow();
            if(rows >= 0 ){
                String targetI = (String)tablaBlock.getValueAt(rows, 0);
                lucifer lc = new lucifer();
                lc.desbloqueoCliente(routerIp, user, password, targetI);
            }else{
                JOptionPane.showMessageDialog(null, "Primero selecciona un cliente de la tabla");
            }
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDesbloquearActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bnMakeStatic;
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnBlock;
    private javax.swing.JButton btnDesabilitar;
    private javax.swing.JButton btnDesbloquear;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnEliminarQueu;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnHabilitar;
    private javax.swing.JButton btnObtenerBlock;
    private javax.swing.JButton btnObtenerDhcp;
    private javax.swing.JButton btnRegistroDB;
    private javax.swing.JButton btnRegistroDBDhcp;
    private javax.swing.JTextField entryId;
    private javax.swing.JTextField entryIp;
    private javax.swing.JTextField entryNombre;
    private javax.swing.JTextField entryPassword;
    private javax.swing.JTextField entryUsername;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tablaBlock;
    private javax.swing.JTable tablaDhcp;
    private javax.swing.JTable tablaMicrotik;
    private javax.swing.JTable tablaSimpleQueue;
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

// Método para convertir bits a una representación más legible (Ejemplo: 100M en vez de 100000000)
    private String formatBandwidth(String bandwidth) {
        if (bandwidth == null || !bandwidth.contains("/")) {
            return bandwidth; // Si es nulo o no tiene "/", devolver como está
        }

        String[] parts = bandwidth.split("/"); // Divide el string en "descarga/subida"
        return convertToReadable(parts[0]) + "/" + convertToReadable(parts[1]);
    }

// Método auxiliar para convertir bits a una unidad más legible
    private String convertToReadable(String value) {
        try {
            long bps = Long.parseLong(value);
            if (bps >= 1_000_000) {
                return (bps / 1_000_000) + "M"; // Convertir a Megabits por segundo
            } else if (bps >= 1_000) {
                return (bps / 1_000) + "K"; // Convertir a Kilobits por segundo
            } else {
                return bps + "bps"; // Si es menor a 1K, mostrar como está
            }
        } catch (NumberFormatException e) {
            return value; // Si no es un número válido, devolver el original
        }
    }

    public void dhcpSimpleQueue(String username, String password, String ip) {
        try {
            ApiConnection con = ApiConnection.connect(ip);
            con.login(username, password);

            // Ejecutamos el comando
            List<Map<String, String>> results = con.execute("/queue/simple/print");

            // Iniciamos el modelo
            DefaultTableModel modelo = (DefaultTableModel) tablaSimpleQueue.getModel();

            // Limpiamos cualquier dato previo
            modelo.setRowCount(0);

            // Iterar sobre los resultados y agregar las filas a la tabla
            for (Map<String, String> result : results) {
                Object[] clientesDhcpLeases = new Object[5];

                // Asignar los valores a cada columna
                clientesDhcpLeases[0] = result.get("name");
                clientesDhcpLeases[1] = removeSubnetMask(result.get("target")); // Separa IP de la máscara
                clientesDhcpLeases[2] = formatBandwidth(result.get("max-limit"));
                clientesDhcpLeases[3] = result.get("parent");
                clientesDhcpLeases[4] = result.get(".id");

                // Agregar la fila al modelo de la tabla
                modelo.addRow(clientesDhcpLeases);
            }

            // Establecer el modelo actualizado a la tabla (opcional si el modelo ya está enlazado)
            tablaSimpleQueue.setModel(modelo);

            // Cerrar la conexión con el router
            con.close();
        } catch (MikrotikApiException e) {
            JOptionPane.showMessageDialog(null, "Error de MikroTik: " + e, "MikroTik", JOptionPane.ERROR_MESSAGE);
        }
    }

// Método para eliminar la máscara de subred de la IP
    private String removeSubnetMask(String target) {
        if (target == null) {
            return "";
        }
        return target.split("/")[0]; // Divide por "/" y toma solo la IP
    }

    public void dhcpLeases(String username, String password, String ip) {
        try {
            ApiConnection con = ApiConnection.connect(ip); // Conectar al router
            con.login(username, password); // Iniciar sesión en el router

            // Ejecutar el comando para obtener las leases DHCP
            List<Map<String, String>> results = con.execute("/ip/dhcp-server/lease/print");

            // Inicializar el modelo de la tabla
            DefaultTableModel modelo = (DefaultTableModel) tablaDhcp.getModel();

            // Limpiar cualquier dato previo en la tabla
            modelo.setRowCount(0);

            // Iterar sobre los resultados y agregar las filas a la tabla
            for (Map<String, String> result : results) {
                Object[] clientesDhcpLeases = new Object[5];

                // Asignar los valores a cada columna
                clientesDhcpLeases[0] = result.get("address");
                clientesDhcpLeases[1] = result.get("mac-address");
                clientesDhcpLeases[2] = result.get("host-name");
                clientesDhcpLeases[3] = result.get("server");
                clientesDhcpLeases[4] = result.get(".id");

                // Agregar la fila al modelo de la tabla
                modelo.addRow(clientesDhcpLeases);
            }

            // Establecer el modelo actualizado a la tabla (opcional si el modelo ya está enlazado)
            tablaDhcp.setModel(modelo);

            // Cerrar la conexión con el router
            con.close();
        } catch (MikrotikApiException e) {
            // Mostrar mensaje de error si ocurre una excepción
            JOptionPane.showMessageDialog(null, "Error: " + e, "Microtik", JOptionPane.ERROR_MESSAGE);
        }
    }
public void dhcpBlock(String username, String password, String ip) {
    try {
        ApiConnection con = ApiConnection.connect(ip); // Conectar al router
        con.login(username, password); // Iniciar sesión en el router

        // Ejecutar el comando para obtener las leases DHCP bloqueadas
        List<Map<String, String>> results = con.execute("/ip/dhcp-server/lease/print where blocked=yes");

        // Inicializar el modelo de la tabla
        DefaultTableModel modelo = (DefaultTableModel) tablaBlock.getModel();

        // Limpiar cualquier dato previo en la tabla
        modelo.setRowCount(0);

        // Iterar sobre los resultados y agregar las filas a la tabla
        for (Map<String, String> result : results) {
            Object[] clientesDhcpLeases = new Object[5];

            // Asignar los valores a cada columna
            clientesDhcpLeases[0] = result.get("address");
            clientesDhcpLeases[1] = result.get("mac-address");
            clientesDhcpLeases[2] = result.get("host-name");
            clientesDhcpLeases[3] = result.get("server");
            clientesDhcpLeases[4] = result.get(".id"); // ID del lease

            // Agregar la fila al modelo de la tabla
            modelo.addRow(clientesDhcpLeases);
        }

        // Establecer el modelo actualizado a la tabla
        tablaBlock.setModel(modelo);

        // Cerrar la conexión con el router
        con.close();
    } catch (MikrotikApiException e) {
        // Mostrar mensaje de error si ocurre una excepción
        JOptionPane.showMessageDialog(null, "Error: " + e, "MikroTik", JOptionPane.ERROR_MESSAGE);
    }
}

}

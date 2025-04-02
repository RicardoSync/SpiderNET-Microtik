package Recibos;

import Config.Conexion;
import Config.Consultas;
import Config.InsertarDatos;
import java.sql.*;
import javax.swing.JOptionPane;
import Recibos.generarRecibo;
import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import me.legrange.mikrotik.MikrotikApiException;
import microtik.PPoEAuto;
import microtik.taskMicrotik;
import microtik.unlockClient;

public class pagoWindows extends javax.swing.JInternalFrame {

    public pagoWindows(int id, String nombre, String paquete, String servicios, String direccionIp, String nombreMicrotik) {
        initComponents();
        insertarElementos(id, nombre, paquete, servicios, direccionIp, nombreMicrotik);

    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        entryID = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        entryNombre = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        entryDireccionIP = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        entryPaquete = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        entryMonto = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        entryServicios = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        entryPrecioServicios = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        entryMicrotikNombre = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        comboMetodo = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        entryCantidad = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        entryDescuento = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        comboMeses = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Registrar pago");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos Cliente"));

        jLabel1.setText("ID");

        entryID.setEditable(false);

        jLabel2.setText("Nombre");

        entryNombre.setEditable(false);

        jLabel11.setText("Direccion IP:");

        entryDireccionIP.setEditable(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(entryID, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(entryNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(entryDireccionIP)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(entryID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(entryNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(entryDireccionIP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos tecnicos"));

        jLabel3.setText("Paquete");

        entryPaquete.setEditable(false);

        jLabel4.setText("Precio");

        entryMonto.setEditable(false);

        jLabel7.setText("Servicios");

        entryServicios.setEditable(false);

        jLabel8.setText("Precio");

        entryPrecioServicios.setEditable(false);
        entryPrecioServicios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                entryPrecioServiciosActionPerformed(evt);
            }
        });

        jLabel10.setText("Microtik Administrador");

        entryMicrotikNombre.setEditable(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(entryMicrotikNombre)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(entryPaquete))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(entryServicios)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(entryMonto, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                    .addComponent(entryPrecioServicios)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(entryPaquete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(entryMonto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(entryServicios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(entryPrecioServicios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(entryMicrotikNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(9, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos de pago"));

        jLabel5.setText("Meotdo");

        comboMetodo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Efectivo", "Transferencia", "Tarjeta", "Otro" }));

        jLabel6.setText("Cantidad $");

        jLabel12.setText("Descuento %");

        entryDescuento.setText("0");

        jLabel13.setText("Meses pagados");

        comboMeses.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(entryDescuento))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboMetodo, 0, 145, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(entryCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboMeses, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(comboMetodo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(entryCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(entryDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(comboMeses, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/gastos.png"))); // NOI18N
        jButton1.setText("Pagar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/marca-x-rectangular.png"))); // NOI18N
        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(74, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void entryPrecioServiciosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_entryPrecioServiciosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_entryPrecioServiciosActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            obtenerInformacion();
            // TODO add your handling code here:
        } catch (MikrotikApiException ex) {
            Logger.getLogger(pagoWindows.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(pagoWindows.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    public void listarMicrotiks(String nombreMicrotik) {
        Consultas consultas = new Consultas();
        ArrayList<String> microtiks = consultas.nombresMicrotiks();
        
        entryMicrotikNombre.setText(nombreMicrotik);
        
//        for (String plataformas : microtiks) {
//            comboMicrotik.addItem(plataformas);
//        }
    }

    public void insertarElementos(int id, String nombre, String paquete, String servicios, String direccionIp,String nombreMicrotik) {
        listarMicrotiks(nombreMicrotik);
        Conexion conexion = new Conexion();
        Connection cn = conexion.getConnection();
        if (cn != null) {

            entryID.setText(String.valueOf(id));
            entryNombre.setText(nombre);
            entryPaquete.setText(paquete);
            entryDireccionIP.setText(direccionIp);

            PreparedStatement cursor;
            ResultSet resultado;
            try {
                String precio = null;
                String sql = "SELECT precio FROM paquetes WHERE nombre = ?";
                cursor = cn.prepareStatement(sql);
                cursor.setString(1, paquete);

                resultado = cursor.executeQuery();

                if (resultado.next()) {
                    precio = resultado.getString(1);
                    entryMonto.setText(precio);
                } else {
                    entryPaquete.setText("Sin paquete internet");
                    entryMonto.setText("0.0");
                }
                precioServicio(servicios);
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "No pudimos obtener el precio del paquete, error: " + e, "SpiderNET", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public void precioServicio(String nombreServicio) {
        Conexion conexion = new Conexion();
        Connection cn = conexion.getConnection();
        entryServicios.setText(nombreServicio);
        if (cn != null) {
            String sql = "SELECT precio FROM serviciosplataforma WHERE nombre = ?";
            PreparedStatement cursorDos;
            ResultSet resultadoDos;
            String precioDos = null;
            try {
                cursorDos = cn.prepareStatement(sql);
                cursorDos.setString(1, nombreServicio);

                resultadoDos = cursorDos.executeQuery();

                if (resultadoDos.next()) {
                    precioDos = resultadoDos.getString(1);
                    entryPrecioServicios.setText(precioDos);
                } else {
                    precioDos = "0.0";
                    entryServicios.setText("Sin servicios");
                    entryPrecioServicios.setText(precioDos);
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "No pudimos obtener el precio del servicio, error: " + e, "SpiderNET", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public void obtenerInformacion() throws MikrotikApiException, IOException {
        //obtener los datos de la empresa - listo
        //obtener los datos de la ventana = listo
        //llamar al metodo de los recibos = listo
        //desbloquear cliente 
        //enviar whatsapp
        Conexion conexion = new Conexion();
        Connection cn = conexion.getConnection();

        if (cn != null) {
            PreparedStatement cursor;
            ResultSet resultado;
            String sql = "SELECT nombreWisp, cp, telefono, rfc, direccion FROM datosEmpresa";

            try {
                cursor = cn.prepareStatement(sql);
                resultado = cursor.executeQuery();
                String nombreWisp = null;
                String cp = null;
                String telefono = null;
                String rfc = null;
                String direccion = null;

                if (resultado.next()) {
                    nombreWisp = resultado.getString(1);
                    cp = resultado.getString(2);
                    telefono = resultado.getString(3);
                    rfc = resultado.getString(4);
                    direccion = resultado.getString(5);
                }else{
                    JOptionPane.showMessageDialog(null, "No podemos crear el ticket sin los datos de la empresa");
                    JOptionPane.showMessageDialog(null, "Por favor ve al menu SoftwareEscobedo y a Empresas");
                }
                Calendar calendar = Calendar.getInstance();
                LocalTime horaActual = LocalTime.now();
                DateTimeFormatter formato = DateTimeFormatter.ofPattern("HH:mm:ss");

                String hora = horaActual.format(formato);
                int annio = calendar.get(Calendar.YEAR);
                int mes = calendar.get(Calendar.MONTH) + 1; // Sumar 1 para que enero sea 1, febrero 2, etc.
                int dia = calendar.get(Calendar.DAY_OF_MONTH); // Obtener el día del mes

                // Obtener el nombre del mes en español
                String mesTexto = calendar.getDisplayName(Calendar.MONTH, Calendar.LONG, new Locale("es", "ES"));

                // Formatear la fecha correctamente
                String mesAnio = mesTexto + "." + annio;
                String fecha = dia + "/" + mes + "/" + annio;
                String concepto = "";
                String nombre = entryNombre.getText();
                String plan = entryPaquete.getText();

                double mensualidad = Double.parseDouble(entryMonto.getText());
                double paquete = Double.parseDouble(entryMonto.getText());
                double streming = Double.parseDouble(entryPrecioServicios.getText());
                double tv = 0.0;
                double efectivo = Double.parseDouble(entryCantidad.getText());
                String cajero = "admin";
                String servicios = entryServicios.getText();
                generarRecibo recibo = new generarRecibo();
                String direccionIp = entryDireccionIP.getText();
//                String nombreMicrotik = (String) comboMicrotik.getSelectedItem();
                int id_cliente = Integer.parseInt(entryID.getText());
                String metodo_pago = (String) comboMetodo.getSelectedItem();
                String cantidad = entryCantidad.getText();
                String monto = entryMonto.getText();
                String stremdeck = entryPrecioServicios.getText();
                int descuentoPorcentaje = Integer.parseInt(entryDescuento.getText());
                int mesesPagados = Integer.parseInt((String) comboMeses.getSelectedItem());
                
                int cambio = 0;
                //si la mensualidad es mayor a 0 proceder como lo hacemos
                //si la mensualidad es 0 y los servicios son mayor a 0 entonces iniciar el segundo
                if (mensualidad > 0.0) {
                    InsertarDatos insertarDatos = new InsertarDatos();
                    insertarDatos.insertarPago(id_cliente, nombre, monto, metodo_pago, efectivo, cambio);

                    recibo.generarRecibo(nombreWisp, cp, telefono, rfc, direccion, concepto, mesAnio, nombre, cp, plan, mensualidad, fecha, hora, paquete, streming, tv, efectivo, cajero, descuentoPorcentaje, mesesPagados);
                    InsertarDatos datos = new InsertarDatos();
                    //String ipCliente, String user, String password, String host
                    obtenerDatosMicrotik();
                } else {
                    InsertarDatos insertarDatos = new InsertarDatos();
                    insertarDatos.insertarPago(id_cliente, nombre, stremdeck, metodo_pago, efectivo, cambio);
                    recibo.generarRecibo(nombreWisp, cp, telefono, rfc, direccion, concepto, mesAnio, nombre, cp, plan, mensualidad, fecha, hora, paquete, streming, tv, efectivo, cajero, descuentoPorcentaje, mesesPagados);
                    obtenerDatosMicrotik();

                    InsertarDatos datos = new InsertarDatos();
                }

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "No podemos obtener los datos de la empresa", "SpiderNET", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "No logramos establecer una conexion", "SpiderNET", JOptionPane.ERROR);
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> comboMeses;
    private javax.swing.JComboBox<String> comboMetodo;
    private javax.swing.JTextField entryCantidad;
    private javax.swing.JTextField entryDescuento;
    private javax.swing.JTextField entryDireccionIP;
    private javax.swing.JTextField entryID;
    private javax.swing.JTextField entryMicrotikNombre;
    private javax.swing.JTextField entryMonto;
    private javax.swing.JTextField entryNombre;
    private javax.swing.JTextField entryPaquete;
    private javax.swing.JTextField entryPrecioServicios;
    private javax.swing.JTextField entryServicios;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables

    public void obtenerDatosMicrotik(){
        String nombreMicrotik = entryMicrotikNombre.getText();
        Conexion conexion = new Conexion();
        Connection cn = conexion.getConnection();
        String sql = "SELECT ip, username, password FROM credenciales_microtik WHERE nombre = ?";
        try {
            PreparedStatement cursor;
            ResultSet resultado;
            
            cursor = cn.prepareStatement(sql);
            cursor.setString(1, nombreMicrotik);
            
            resultado = cursor.executeQuery();
            
            if(resultado.next()){
                String user = resultado.getString("username");
                String password = resultado.getString("password");
                String host = resultado.getString("ip");
                String direccionIp = entryDireccionIP.getText();
                String nameCliente = entryNombre.getText();
                
                nameCliente = nameCliente.trim();
                nameCliente = nameCliente.replaceAll("[^a-zA-Z0-9]", "");
                
                
                PPoEAuto auto = new PPoEAuto();
                auto.desbloquearCliente(direccionIp, user, password, host);
                
                taskMicrotik m = new taskMicrotik();
                m.eliminarTask(nameCliente, direccionIp, user, password, host);
            }else{
                JOptionPane.showMessageDialog(null, "No encotramos datos para ese microtik asociado, corrobora!. Por ahora desbloquea el cliente manuealmente");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al buscar los datos del microtik en base de datos: " + e);
        }
            
        
    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package caja;

import Config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author cisco
 */
public class insetEgresos {

    public void insertarElementos(String descripcion, double monto, String metodo) {
        Conexion conexion = new Conexion();
        Connection cn = conexion.getConnection();

        String sql = "INSERT INTO egresos (descripcion, monto, metodo_pago) VALUES (?,?,?)";

        if (cn != null) {
            PreparedStatement cursor;
            ResultSet resultado;

            try {
                cursor = cn.prepareStatement(sql);
                cursor.setString(1, descripcion);
                cursor.setDouble(2, monto);
                cursor.setString(3, metodo);

                int rows = cursor.executeUpdate();
                if (rows > 0) {
                    JOptionPane.showMessageDialog(null, "Se registro el gasto de manera exitosa");
                }
            } catch (Exception e) {
                System.out.println(e);
                JOptionPane.showMessageDialog(null, "Tenemos un problema durante el registro: " + e);
            }
        }
    }

}

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
 * @author ricardo
 */
public class verificadorCodigo {
    public void verificarCodigoEnBD() {
        String codigo = JOptionPane.showInputDialog(null, "🔎 Ingresa el código de verificación del recibo:", "Verificar Código", JOptionPane.QUESTION_MESSAGE);

        if (codigo == null || codigo.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "⚠ No ingresaste ningún código.", "Atención", JOptionPane.WARNING_MESSAGE);
            return;
        }

        Conexion conexion = new Conexion();
        Connection cn = conexion.getConnection();

        if (cn != null) {
            try {
                String sql = "SELECT nombre, monto, fecha_pago FROM pagos WHERE codigo_barras = ?";
                PreparedStatement ps = cn.prepareStatement(sql);
                ps.setString(1, codigo);
                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    String nombre = rs.getString("nombre");
                    String monto = rs.getString("monto");
                    String fecha = rs.getString("fecha_pago"); // Asegúrate de tener esta columna en tu tabla

                    String mensaje = "✅ Código válido\n"
                            + "Cliente: " + nombre + "\n"
                            + "Monto: $" + monto + "\n"
                            + "Fecha: " + fecha;

                    JOptionPane.showMessageDialog(null, mensaje, "Verificación Exitosa", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "❌ Código no encontrado o inválido.", "Verificación Fallida", JOptionPane.ERROR_MESSAGE);
                }

                cn.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al verificar código:\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo conectar a la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
}

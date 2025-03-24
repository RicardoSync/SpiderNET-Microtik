/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package caja;
import Config.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.*;
/**
 *
 * @author cisco
 */
public class corteCajaClass {
    int mesInicio;
    int annioIncio;
    int mesFin;
    int annioFin;
    
    public void filtadoYCalculo(int mesIncio, int annioInicio, int mesFin, int annioFin) throws SQLException{
        Conexion conexion = new Conexion();
        Connection cn = conexion.getConnection();
        String sql = """
                        SELECT 
                         (SELECT IFNULL(SUM(monto), 0) FROM pagos WHERE  MONTH(fecha_pago) = ? AND year(fecha_pago) = ?) AS total_ingresos,
                         (SELECT IFNULL(SUM(monto), 0) FROM egresos WHERE MONTH(fecha_egreso) = ? AND year(fecha_egreso) = ?) AS total_egresos,
                         (
                             (SELECT IFNULL(SUM(monto), 0) FROM pagos WHERE MONTH(fecha_pago) = ? AND year(fecha_pago) = ?) - 
                             (SELECT IFNULL(SUM(monto), 0) FROM egresos WHERE MONTH(fecha_egreso) = ? AND year(fecha_egreso) = ?)
                         ) AS balance
                     """;
        if(cn!=null){
            PreparedStatement cursor = cn.prepareStatement(sql);
            ResultSet resultado;
            
            try {
                cursor.setInt(1, mesIncio);
                cursor.setInt(2, annioInicio);
                cursor.setInt(3, mesFin);
                cursor.setInt(4, annioFin);
                
                resultado = cursor.executeQuery();
                
                if(resultado.next()){
                    String total_ingreso = resultado.getString("total_ingresos");
                    String total_egresos = resultado.getString("total_egresos");
                    String balance = resultado.getString("balance");
                    
                    System.out.println("Total ingresos: " + total_ingreso + " total egresos: " + total_egresos + " balance final: " + balance);
                }else{
                    System.out.println("Sin informacion");
                }
            } catch (Exception e) {
                System.out.println(e);
            }
            
        }
    }
    
}

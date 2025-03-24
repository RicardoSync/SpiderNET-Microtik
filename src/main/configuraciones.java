/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;
import Config.Conexion;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
import java.sql.*;
/**
 *
 * @author cisco
 */
public class configuraciones {
    private static final String URL = "jdbc:mysql://localhost:3306/";
    private static final String USER = "root";  // Cambia según tu configuración
    private static final String PASSWORD = "tu_contraseña"; // Cambia según tu configuración

      public static void ejecutarScript() {
        String scriptSQL = """
            CREATE DATABASE IF NOT EXISTS spidernet;
            USE spidernet;

            DROP TABLE IF EXISTS antenasap;
            CREATE TABLE antenasap (
                idantenasAp INT NOT NULL AUTO_INCREMENT,
                nombre VARCHAR(100) DEFAULT NULL,
                modelo VARCHAR(100) DEFAULT NULL,
                usuario VARCHAR(100) DEFAULT NULL,
                password VARCHAR(100) DEFAULT NULL,
                ip VARCHAR(100) DEFAULT NULL,
                PRIMARY KEY (idantenasAp)
            ) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

            DROP TABLE IF EXISTS clientes;
            CREATE TABLE clientes (
                id INT NOT NULL AUTO_INCREMENT,
                nombre VARCHAR(100) NOT NULL,
                telefono VARCHAR(20) DEFAULT NULL,
                email VARCHAR(100) DEFAULT NULL,
                direccion TEXT NOT NULL,
                fecha_registro DATETIME DEFAULT CURRENT_TIMESTAMP,
                id_paquete INT DEFAULT NULL,
                ip_cliente VARCHAR(100) DEFAULT NULL,
                dia_corte INT DEFAULT NULL,
                estado ENUM('Activo','Bloqueado','Suspendido','Cancelado') DEFAULT NULL,
                ap_antena VARCHAR(100) DEFAULT NULL,
                serviciosTV VARCHAR(100) DEFAULT NULL,
                serviciosPlataformas VARCHAR(100) DEFAULT NULL,
                id_antena_ap INT DEFAULT NULL,
                id_servicio_plataforma INT DEFAULT NULL,
                id_microtik INT NOT NULL,
                PRIMARY KEY (id)
            ) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
            
            INSERT INTO usuarios (nombre, usuario, password, rol) VALUES ("spidernet", "spidernet", "spidernet123", 0);
        """;

        Conexion conexionDB = new Conexion();
        try (Connection conn = conexionDB.getConnection();
             Statement stmt = conn.createStatement()) {

            // Ejecutar cada sentencia SQL separada por ";"
            String[] comandos = scriptSQL.split(";");
            for (String sql : comandos) {
                if (!sql.trim().isEmpty()) {
                    stmt.execute(sql.trim());
                }
            }

            System.out.println("Script ejecutado con éxito.");

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Error al ejecutar el script: " + e.getMessage());
        } finally {
            conexionDB.closeConnection();
        }
    }
    
}

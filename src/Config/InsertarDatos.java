package Config;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import Config.Conexion;
import java.sql.ResultSet;
import java.sql.Statement;

public class InsertarDatos {
    
    public void insertarDatos(String nombre, String ip, String username, String password) {
        //establecemos conexion
        Conexion conexion = new Conexion();
        Connection con = conexion.getConnection();
        
        if (con != null) {
            //Si la conexion es exitosa
            PreparedStatement cursor = null;
            
            try {
                String sql = """
                             INSERT INTO credenciales_microtik (nombre, ip, username, password) VALUES
                             (?,?,?,?)""";
                
                cursor = con.prepareStatement(sql);
                
                cursor.setString(1, nombre);
                cursor.setString(2, ip);
                cursor.setString(3, username);
                cursor.setString(4, password);
                
                int filasAfectadas = cursor.executeUpdate();
                
                if (filasAfectadas > 0) {
                    JOptionPane.showMessageDialog(null, "Se actualizaron las filas" + filasAfectadas, "Modulo Insertar Datos", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "No logramos ingresar los datos en la base", "Modulo Insertar Datos", JOptionPane.ERROR_MESSAGE);
                }
                
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Tenemos problemas con la base de datos: " + e, "Modulo Insertar Datos", JOptionPane.ERROR_MESSAGE);
            }
            
        }
    }
    
    public void insertarAntenasAP(String nombre, String modelo, String usuario, String password, String ip) {
        ///establecemos la conexion
        Conexion conexion = new Conexion();
        Connection con = conexion.getConnection();
        
        if (con != null) {
            PreparedStatement cursor = null;
            
            try {
                String sql = "INSERT INTO antenasap (nombre, modelo, usuario, password, ip) VALUES (?,?,?,?,?)";
                cursor = con.prepareCall(sql);
                
                cursor.setString(1, nombre);
                cursor.setString(2, modelo);
                cursor.setString(3, usuario);
                cursor.setString(4, password);
                cursor.setString(5, ip);
                
                int filasAfectadas = cursor.executeUpdate();
                
                if (filasAfectadas > 0) {
                    JOptionPane.showMessageDialog(null, "Se registro de manera exitosa la antena", "Modulo Insertar", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "No logramos insertar ningun elemento", "Modulo Insertar", JOptionPane.ERROR_MESSAGE);
                }
                
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Tenemos problemas con la base de datos: " + e, "Modulo Insertar", JOptionPane.ERROR_MESSAGE);
            }
        }
        
    }
    
    public void insertarPaquetes(String nombre, String velocidad, String precio) {
        Conexion conexion = new Conexion();
        Connection con = conexion.getConnection();
        
        if (con != null) {
            PreparedStatement cursor = null;
            
            try {
                String sql = "INSERT INTO paquetes (nombre, velocidad, precio) VALUES (?,?,?)";
                cursor = con.prepareCall(sql);
                
                cursor.setString(1, nombre);
                cursor.setString(2, velocidad);
                cursor.setString(3, precio);
                
                int filasAfectadas = cursor.executeUpdate();
                
                if (filasAfectadas > 0) {
                    JOptionPane.showMessageDialog(null, "Se registro de manera exitosa el paquete", "Modulo Insertar", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Tenemos un error al insertar el elemento", "Modulo Insertar", JOptionPane.ERROR_MESSAGE);
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Tenemos problemas con la base de datos: " + e, "Modulo Insertar", JOptionPane.ERROR_MESSAGE);
                
            }
            
        }
    }
    
    public void insertarCliente(String nombre, String telefono, String correo, String direccion, String paquete, String ip_cliente, String dia_corte, String ap_antena,
            String serviciosTV, String serviciosPlataformas,
            String nombreEquipo, String tipoEquipo, String marcaEquipo, String modeloEquipo, String macEquipo, String serialEquipo, String estado) {
        Conexion conexion = new Conexion();
        Connection cn = conexion.getConnection();
        
        if (cn != null) {
            PreparedStatement cursor;
            PreparedStatement pstmt2 = null;
            try {
                String sql = """
                            INSERT INTO clientes (nombre, telefono, email, direccion, ip_cliente, dia_corte, estado, ap_antena, serviciosTV, serviciosPlataformas, id_paquete)
                            VALUES (?,?,?,?,?,?, 'Activo', ?, ?, ?, 
                            (SELECT id FROM paquetes WHERE nombre = ? LIMIT 1));
                            """;
                cursor = cn.prepareStatement(sql);

                // Asignar los valores
                cursor.setString(1, nombre);
                cursor.setString(2, telefono);
                cursor.setString(3, correo);
                cursor.setString(4, direccion);
                cursor.setString(5, ip_cliente);
                cursor.setString(6, dia_corte);
                cursor.setString(7, ap_antena);
                cursor.setString(8, serviciosTV);
                cursor.setString(9, serviciosPlataformas);
                cursor.setString(10, paquete);
                
                int filasAfectadas = cursor.executeUpdate();
                
                if (filasAfectadas > 0) {
                    
                    String sqlGetIdCliente = "SELECT LAST_INSERT_ID()";
                    Statement stmt = cn.createStatement();
                    ResultSet rs = stmt.executeQuery(sqlGetIdCliente);
                    int idCliente = 0;
                    if (rs.next()) {
                        idCliente = rs.getInt(1); // Obtener el id del cliente
                    }

                    // SQL para insertar el equipo
                    String sqlEquipo = """
                        INSERT INTO equipos (nombre, tipo, marca, modelo, mac, serial, estado, id_cliente)
                        VALUES (?, ?, ?, ?, ?, ?, ?, ?);
                    """;
                    
                    pstmt2 = cn.prepareStatement(sqlEquipo);
                    pstmt2.setString(1, nombreEquipo);
                    pstmt2.setString(2, tipoEquipo);
                    pstmt2.setString(3, marcaEquipo);
                    pstmt2.setString(4, modeloEquipo);
                    pstmt2.setString(5, macEquipo);
                    pstmt2.setString(6, serialEquipo);
                    pstmt2.setString(7, estado);
                    pstmt2.setInt(8, idCliente);  // Usar el id del cliente insertado

                    // Ejecutar el segundo insert (insertar el equipo)
                    int equiposAfectados = pstmt2.executeUpdate();
                    
                    if (equiposAfectados > 0) {
                        JOptionPane.showMessageDialog(null, "Cliente y equpos agregados al sistema", "SpiderNET", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "No fue posible registrar el equipo", "SpiderNET", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "No logramos insertar ningun cliente", "SpiderNET", JOptionPane.ERROR_MESSAGE);
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Problemas con la base de datos: " + e, "SpiderNET", JOptionPane.ERROR_MESSAGE);
                System.out.println(e);
            }
        }
    }
    
    public void insertarClienteDosEquipos(String nombre, String telefono, String correo, String direccion, String paquete, String ip_cliente, String dia_corte, String ap_antena,
            String serviciosTV, String serviciosPlataformas,
            String nombreEquipo, String tipoEquipo, String marcaEquipo, String modeloEquipo, String macEquipo, String serialEquipo, String estado,
            String nombreEquipoExtra, String tipoEquipoExtra, String marcaEquipoExtra, String modeloEquipoExtra, String macEquipoExtra, String serialEquipoExtra, String estadoExtra) {
        Conexion conexion = new Conexion();
        Connection cn = conexion.getConnection();
        
        if (cn != null) {
            PreparedStatement cursor;
            PreparedStatement pstmt2 = null;
            PreparedStatement pstmt3 = null; // Para el segundo equipo

            try {
                // Iniciar la transacción
                cn.setAutoCommit(false);
                
                String sqlCliente = """
                INSERT INTO clientes (nombre, telefono, email, direccion, ip_cliente, dia_corte, estado, ap_antena, serviciosTV, serviciosPlataformas, id_paquete)
                VALUES (?,?,?,?,?,?, ?, ?, ?, ?, 
                        (SELECT id FROM paquetes WHERE nombre = ? LIMIT 1));
            """;
                
                cursor = cn.prepareStatement(sqlCliente);

                // Asignar los valores a los parámetros
                cursor.setString(1, nombre);
                cursor.setString(2, telefono);
                cursor.setString(3, correo);
                cursor.setString(4, direccion);
                cursor.setString(5, ip_cliente);
                cursor.setString(6, dia_corte);
                cursor.setString(7, "Activo");  // Ahora 'Activo' como parámetro
                cursor.setString(8, ap_antena);
                cursor.setString(9, serviciosTV);
                cursor.setString(10, serviciosPlataformas);
                cursor.setString(11, paquete);  // Para el valor de id_paquete (subconsulta)

                int filasAfectadas = cursor.executeUpdate();
                
                if (filasAfectadas > 0) {
                    // Obtener el id del cliente insertado
                    String sqlGetIdCliente = "SELECT LAST_INSERT_ID()";
                    Statement stmt = cn.createStatement();
                    ResultSet rs = stmt.executeQuery(sqlGetIdCliente);
                    int idCliente = 0;
                    if (rs.next()) {
                        idCliente = rs.getInt(1); // Obtener el id del cliente
                    }

                    // Insertar el primer equipo
                    String sqlEquipo1 = """
                    INSERT INTO equipos (nombre, tipo, marca, modelo, mac, serial, estado, id_cliente)
                    VALUES (?, ?, ?, ?, ?, ?, ?, ?);
                """;
                    pstmt2 = cn.prepareStatement(sqlEquipo1);
                    pstmt2.setString(1, nombreEquipo);
                    pstmt2.setString(2, tipoEquipo);
                    pstmt2.setString(3, marcaEquipo);
                    pstmt2.setString(4, modeloEquipo);
                    pstmt2.setString(5, macEquipo);
                    pstmt2.setString(6, serialEquipo);
                    pstmt2.setString(7, estado);
                    pstmt2.setInt(8, idCliente); // Usar el id del cliente insertado
                    int equiposAfectados1 = pstmt2.executeUpdate();

                    // Insertar el segundo equipo
                    String sqlEquipo2 = """
                    INSERT INTO equipos (nombre, tipo, marca, modelo, mac, serial, estado, id_cliente)
                    VALUES (?, ?, ?, ?, ?, ?, ?, ?);
                """;
                    pstmt3 = cn.prepareStatement(sqlEquipo2);
                    pstmt3.setString(1, nombreEquipoExtra);
                    pstmt3.setString(2, tipoEquipoExtra);
                    pstmt3.setString(3, marcaEquipoExtra);
                    pstmt3.setString(4, modeloEquipoExtra);
                    pstmt3.setString(5, macEquipoExtra);
                    pstmt3.setString(6, serialEquipoExtra);
                    pstmt3.setString(7, estadoExtra);
                    pstmt3.setInt(8, idCliente); // Usar el mismo id_cliente
                    int equiposAfectados2 = pstmt3.executeUpdate();
                    
                    if (equiposAfectados1 > 0 && equiposAfectados2 > 0) {
                        // Si ambos equipos se insertaron correctamente
                        JOptionPane.showMessageDialog(null, "Cliente y equipos agregados al sistema", "SpiderNET", JOptionPane.INFORMATION_MESSAGE);
                        cn.commit(); // Confirmar la transacción
                    } else {
                        // Si algún equipo no se insertó correctamente
                        JOptionPane.showMessageDialog(null, "No fue posible registrar uno o más equipos", "SpiderNET", JOptionPane.ERROR_MESSAGE);
                        cn.rollback(); // Deshacer la transacción si hubo un error
                    }
                } else {
                    // Si no se insertó el cliente
                    JOptionPane.showMessageDialog(null, "No logramos insertar ningún cliente", "SpiderNET", JOptionPane.ERROR_MESSAGE);
                }
            } catch (SQLException e) {
                try {
                    // Si ocurre algún error, revertir la transacción
                    cn.rollback();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                JOptionPane.showMessageDialog(null, "Problemas con la base de datos: " + e, "SpiderNET", JOptionPane.ERROR_MESSAGE);
            } finally {
                try {
                    // Restaurar el autocommit al estado original
                    cn.setAutoCommit(true);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    public void insertarEquipos(int id_cliente, String nombre, String tipo, String marca, String modelo, String mac, String serial, String estado) {
        Conexion conexion = new Conexion();
        Connection cn = conexion.getConnection();
        
        if (cn != null) {
            PreparedStatement cursor;
            
            try {
                String sql = "INSERT INTO equipos (nombre, tipo, marca, modelo, mac, serial, estado, id_cliente) VALUES (?,?,?,?,?,?,?,?)";
                cursor = cn.prepareStatement(sql);
                cursor.setString(1, nombre);
                cursor.setString(2, tipo);
                cursor.setString(3, marca);
                cursor.setString(4, modelo);
                cursor.setString(5, mac);
                cursor.setString(6, serial);
                cursor.setString(7, estado);
                cursor.setInt(8, id_cliente);
                
                int rows = cursor.executeUpdate();
                
                if (rows > 0) {
                    JOptionPane.showMessageDialog(null, "Se agrego de manera correcta el equipo al sistema", "SpiderNET", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Tenemos problemas con la base de datos: " + e, "Modulo Insertar", JOptionPane.ERROR_MESSAGE);
                // TODO: handle exception
            }
        }
    }
    
    public void insertarPlataformas(String nombre, String descripcion, String precio) {
        Conexion conexion = new Conexion();
        Connection cn = conexion.getConnection();
        
        if (cn != null) {
            PreparedStatement cursor;
            String sql = "INSERT INTO serviciosplataforma (nombre, descripcion, precio) VALUES (?,?,?)";
            
            try {
                cursor = cn.prepareStatement(sql);
                cursor.setString(1, nombre);
                cursor.setString(2, descripcion);
                cursor.setString(3, precio);
                
                int rows = cursor.executeUpdate();
                
                if (rows > 0) {
                    JOptionPane.showMessageDialog(null, "Se registro de manera exitosa el servicio", "SpiderNET", JOptionPane.INFORMATION_MESSAGE);
                }
                
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Tenemos problemas con la base de datos: " + e, "Modulo Insertar", JOptionPane.ERROR_MESSAGE);
                // TODO: handle exception
            }
        }
    }
    
    public void insertarPago(int id_cliente, String nombre, String monto, String metodo_pago, double cantidad, int cambio) {
        Conexion conexion = new Conexion();
        Connection cn = conexion.getConnection();
        
        if (cn != null) {
            PreparedStatement cursor;
            String sql = "INSERT INTO pagos (id_cliente, nombre, monto, metodo_pago, cantidad, cambio) VALUES (?,?,?,?,?,?)";
            try {
                cursor = cn.prepareStatement(sql);
                cursor.setInt(1, id_cliente);
                cursor.setString(2, nombre);
                cursor.setString(3, monto);
                cursor.setString(4, metodo_pago);
                cursor.setDouble(5, cantidad);
                cursor.setInt(6, cambio);
                
                int rows = cursor.executeUpdate();
                
                if (rows > 0) {
                    JOptionPane.showMessageDialog(null, "Pago registrado");
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Tenemos problemas con la base de datos: " + e, "Modulo Insertar", JOptionPane.ERROR_MESSAGE);
                
            }
        }
    }
    
    public void insertarUnSoloCLienteALV(String nombre, String telefono, String correo, String direccion, String paquete, String ip_cliente, String dia_corte, String ap_antena,
            String serviciosTV, String serviciosPlataformas) {
        Conexion conexion = new Conexion();
        Connection cn = conexion.getConnection();
        
        if (cn != null) {
            PreparedStatement cursor;
            PreparedStatement pstmt2 = null;
            try {
                String sql = """
                            INSERT INTO clientes (nombre, telefono, email, direccion, ip_cliente, dia_corte, estado, ap_antena, serviciosTV, serviciosPlataformas, id_paquete)
                            VALUES (?,?,?,?,?,?, 'Activo', ?, ?, ?, 
                            (SELECT id FROM paquetes WHERE nombre = ? LIMIT 1));
                            """;
                cursor = cn.prepareStatement(sql);

                // Asignar los valores
                cursor.setString(1, nombre);
                cursor.setString(2, telefono);
                cursor.setString(3, correo);
                cursor.setString(4, direccion);
                cursor.setString(5, ip_cliente);
                cursor.setString(6, dia_corte);
                cursor.setString(7, ap_antena);
                cursor.setString(8, serviciosTV);
                cursor.setString(9, serviciosPlataformas);
                cursor.setString(10, paquete);
                
                int filasAfectadas = cursor.executeUpdate();
                
                if (filasAfectadas > 0) {
                    JOptionPane.showMessageDialog(null, "Cliente registrado de manera exitosa");
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Problemas con la base de datos: " + e, "SpiderNET", JOptionPane.ERROR_MESSAGE);
                System.out.println(e);
            }
        }
    }
    
}

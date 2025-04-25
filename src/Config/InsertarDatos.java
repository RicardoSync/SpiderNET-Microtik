package Config;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import Config.Conexion;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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
                    con.close();
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
                    con.close();
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
                    con.close();
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
            String serviciosTV, String serviciosPlataformas, String nombreEquipo, String tipoEquipo, String marcaEquipo, String modeloEquipo,
            String macEquipo, String serialEquipo, String estado, String microtikNombre) {
        Conexion conexion = new Conexion();
        Connection cn = conexion.getConnection();

        if (cn != null) {
            PreparedStatement pstmtCliente = null;
            PreparedStatement pstmtEquipo = null;
            PreparedStatement pstmtMicrotik = null;
            PreparedStatement pstmtPaquete = null;
            ResultSet rsMicrotik = null;
            ResultSet rsPaquete = null;
            ResultSet rsCliente = null;

            try {
                // Obtener el ID del Microtik
                String sqlMicrotik = "SELECT id FROM credenciales_microtik WHERE nombre = ? LIMIT 1";
                pstmtMicrotik = cn.prepareStatement(sqlMicrotik);
                pstmtMicrotik.setString(1, microtikNombre);
                rsMicrotik = pstmtMicrotik.executeQuery();

                int idMicrotik = 0;
                if (rsMicrotik.next()) {
                    idMicrotik = rsMicrotik.getInt("id");
                } else {
                    JOptionPane.showMessageDialog(null, "No se encontró el Microtik con nombre: " + microtikNombre, "Error", JOptionPane.ERROR_MESSAGE);
                    return; // Salir del método si no se encontró el Microtik
                }

                // Obtener el ID del Paquete
                String sqlPaquete = "SELECT id FROM paquetes WHERE nombre = ? LIMIT 1";
                pstmtPaquete = cn.prepareStatement(sqlPaquete);
                pstmtPaquete.setString(1, paquete);
                rsPaquete = pstmtPaquete.executeQuery();

                int idPaquete = 0;
                if (rsPaquete.next()) {
                    idPaquete = rsPaquete.getInt("id");
                } else {
                    JOptionPane.showMessageDialog(null, "No se encontró el paquete: " + paquete, "Error", JOptionPane.ERROR_MESSAGE);
                    return; // Salir del método si no se encontró el paquete
                }

                // Insertar cliente con el ID de Microtik
                String sqlCliente = """
                INSERT INTO clientes (nombre, telefono, email, direccion, ip_cliente, dia_corte, estado, ap_antena, serviciosTV, serviciosPlataformas, id_paquete, id_microtik)
                VALUES (?, ?, ?, ?, ?, ?, 'Activo', ?, ?, ?, ?, ?);
            """;

                pstmtCliente = cn.prepareStatement(sqlCliente, Statement.RETURN_GENERATED_KEYS);
                pstmtCliente.setString(1, nombre);
                pstmtCliente.setString(2, telefono);
                pstmtCliente.setString(3, correo);
                pstmtCliente.setString(4, direccion);
                pstmtCliente.setString(5, ip_cliente);
                pstmtCliente.setString(6, dia_corte);
                pstmtCliente.setString(7, ap_antena);
                pstmtCliente.setString(8, serviciosTV);
                pstmtCliente.setString(9, serviciosPlataformas);
                pstmtCliente.setInt(10, idPaquete);
                pstmtCliente.setInt(11, idMicrotik);

                int filasAfectadas = pstmtCliente.executeUpdate();

                if (filasAfectadas > 0) {
                    rsCliente = pstmtCliente.getGeneratedKeys();
                    int idCliente = 0;
                    if (rsCliente.next()) {
                        idCliente = rsCliente.getInt(1);
                    }

                    // Insertar equipo asociado al cliente
                    String sqlEquipo = """
                    INSERT INTO equipos (nombre, tipo, marca, modelo, mac, serial, estado, id_cliente)
                    VALUES (?, ?, ?, ?, ?, ?, ?, ?);
                """;

                    pstmtEquipo = cn.prepareStatement(sqlEquipo);
                    pstmtEquipo.setString(1, nombreEquipo);
                    pstmtEquipo.setString(2, tipoEquipo);
                    pstmtEquipo.setString(3, marcaEquipo);
                    pstmtEquipo.setString(4, modeloEquipo);
                    pstmtEquipo.setString(5, macEquipo);
                    pstmtEquipo.setString(6, serialEquipo);
                    pstmtEquipo.setString(7, estado);
                    pstmtEquipo.setInt(8, idCliente);

                    int equiposAfectados = pstmtEquipo.executeUpdate();

                    if (equiposAfectados > 0) {
                        JOptionPane.showMessageDialog(null, "Cliente y equipo agregados correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Error al registrar el equipo", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "No se pudo insertar el cliente", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Problemas con la base de datos: " + e, "Error", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            } finally {
                try {
                    if (rsMicrotik != null) {
                        rsMicrotik.close();
                    }
                    if (rsPaquete != null) {
                        rsPaquete.close();
                    }
                    if (rsCliente != null) {
                        rsCliente.close();
                    }
                    if (pstmtMicrotik != null) {
                        pstmtMicrotik.close();
                    }
                    if (pstmtPaquete != null) {
                        pstmtPaquete.close();
                    }
                    if (pstmtCliente != null) {
                        pstmtCliente.close();
                    }
                    if (pstmtEquipo != null) {
                        pstmtEquipo.close();
                    }
                    if (cn != null) {
                        cn.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void insertarClienteDosEquipos(String nombre, String telefono, String correo, String direccion, String paquete, String ip_cliente, String dia_corte, String ap_antena,
            String serviciosTV, String serviciosPlataformas, String nombreEquipo, String tipoEquipo, String marcaEquipo, String modeloEquipo, String macEquipo, String serialEquipo, String estado,
            String nombreEquipoExtra, String tipoEquipoExtra, String marcaEquipoExtra, String modeloEquipoExtra, String macEquipoExtra, String serialEquipoExtra, String estadoExtra,
            String microtikNombre) {

        Conexion conexion = new Conexion();
        Connection cn = conexion.getConnection();

        if (cn != null) {
            PreparedStatement cursor = null;
            PreparedStatement pstmt2 = null;
            PreparedStatement pstmt3 = null;
            try {
                cn.setAutoCommit(false);

                // Obtener el ID del MikroTik
                String sqlMicrotik = "SELECT id FROM credenciales_microtik WHERE nombre = ? LIMIT 1";
                PreparedStatement pstmtMicrotik = cn.prepareStatement(sqlMicrotik);
                pstmtMicrotik.setString(1, microtikNombre);
                ResultSet rsMicrotik = pstmtMicrotik.executeQuery();

                int idMicrotik = 0;
                if (rsMicrotik.next()) {
                    idMicrotik = rsMicrotik.getInt("id");
                } else {
                    JOptionPane.showMessageDialog(null, "No se encontró un MikroTik con ese nombre", "Error", JOptionPane.ERROR_MESSAGE);
                    cn.rollback();
                    return;
                }

                // Insertar cliente
                String sqlCliente = """
                INSERT INTO clientes (nombre, telefono, email, direccion, ip_cliente, dia_corte, estado, ap_antena, 
                                     serviciosTV, serviciosPlataformas, id_paquete, id_microtik)
                VALUES (?, ?, ?, ?, ?, ?, 'Activo', ?, ?, ?, 
                        (SELECT id FROM paquetes WHERE nombre = ? LIMIT 1), ?);
            """;
                cursor = cn.prepareStatement(sqlCliente, Statement.RETURN_GENERATED_KEYS);
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
                cursor.setInt(11, idMicrotik);

                int filasAfectadas = cursor.executeUpdate();

                if (filasAfectadas > 0) {
                    ResultSet rs = cursor.getGeneratedKeys();
                    int idCliente = 0;
                    if (rs.next()) {
                        idCliente = rs.getInt(1);
                    }

                    // Insertar equipos
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
                    pstmt2.setInt(8, idCliente);

                    pstmt3 = cn.prepareStatement(sqlEquipo);
                    pstmt3.setString(1, nombreEquipoExtra);
                    pstmt3.setString(2, tipoEquipoExtra);
                    pstmt3.setString(3, marcaEquipoExtra);
                    pstmt3.setString(4, modeloEquipoExtra);
                    pstmt3.setString(5, macEquipoExtra);
                    pstmt3.setString(6, serialEquipoExtra);
                    pstmt3.setString(7, estadoExtra);
                    pstmt3.setInt(8, idCliente);

                    if (pstmt2.executeUpdate() > 0 && pstmt3.executeUpdate() > 0) {
                        cn.commit();
                        cn.close();
                        JOptionPane.showMessageDialog(null, "Cliente y equipos agregados al sistema", "SpiderNET", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        cn.rollback();
                    }
                } else {
                    cn.rollback();
                }
            } catch (SQLException e) {
                try {
                    cn.rollback();
                } catch (SQLException ignored) {
                }
                JOptionPane.showMessageDialog(null, "Error en la BD: " + e, "SpiderNET", JOptionPane.ERROR_MESSAGE);
            } finally {
                try {
                    cn.setAutoCommit(true);
                } catch (SQLException ignored) {
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
                    cn.close();
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
                    cn.close();
                    JOptionPane.showMessageDialog(null, "Se registro de manera exitosa el servicio", "SpiderNET", JOptionPane.INFORMATION_MESSAGE);
                }

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Tenemos problemas con la base de datos: " + e, "Modulo Insertar", JOptionPane.ERROR_MESSAGE);
                // TODO: handle exception
            }
        }
    }

    public void insertarPago(int id_cliente, String nombre, String monto, String metodo_pago, double cantidad, int cambio, String codigoVerificacion, int diaCorte, int mesesPagados) {
        Conexion conexion = new Conexion();
        Connection cn = conexion.getConnection();

        if (cn != null) {
            PreparedStatement cursor;
            String sql = "INSERT INTO pagos (id_cliente, nombre, monto, metodo_pago, cantidad, cambio, codigo_barras, proximo_pago) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

            try {
                // 📅 Calcular la fecha del próximo pago
                LocalDate hoy = LocalDate.now();
                LocalDate base = hoy.getDayOfMonth() >= diaCorte
                        ? LocalDate.of(hoy.getYear(), hoy.getMonthValue(), 1).plusMonths(1).withDayOfMonth(diaCorte)
                        : LocalDate.of(hoy.getYear(), hoy.getMonthValue(), 1).withDayOfMonth(diaCorte);

                LocalDate proximoPago = base.plusMonths(mesesPagados - 1);
                java.sql.Date fechaSQL = java.sql.Date.valueOf(proximoPago);

                cursor = cn.prepareStatement(sql);
                cursor.setInt(1, id_cliente);
                cursor.setString(2, nombre);
                cursor.setString(3, monto);
                cursor.setString(4, metodo_pago);
                cursor.setDouble(5, cantidad);
                cursor.setInt(6, cambio);
                cursor.setString(7, codigoVerificacion);
                cursor.setDate(8, fechaSQL); // ⬅️ Nueva columna proximo_pago

                int rows = cursor.executeUpdate();

                if (rows > 0) {
                    cn.close();
                    JOptionPane.showMessageDialog(null, "Pago registrado correctamente.\nPróximo pago: " + proximoPago.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                }
            } catch (SQLException e) {
                System.out.println(e);
                JOptionPane.showMessageDialog(null, "Tenemos problemas con la base de datos: " + e, "Modulo Insertar", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public void insertarUnSoloCLienteALV(String nombre, String telefono, String correo, String direccion, String paquete,
            String ip_cliente, String dia_corte, String ap_antena, String serviciosTV,
            String serviciosPlataformas, String nombreMicrotik) {
        Conexion conexion = new Conexion();
        Connection cn = conexion.getConnection();

        if (cn != null) {
            PreparedStatement pstmtBuscarMicrotik = null;
            PreparedStatement pstmtInsertarCliente = null;
            ResultSet rsMicrotik = null;

            try {
                cn.setAutoCommit(false); // 🔹 Iniciar transacción

                // 🔹 Buscar ID del Microtik según su nombre
                String sqlBuscarMicrotik = "SELECT id FROM credenciales_microtik WHERE nombre = ? LIMIT 1";
                pstmtBuscarMicrotik = cn.prepareStatement(sqlBuscarMicrotik);
                pstmtBuscarMicrotik.setString(1, nombreMicrotik);
                rsMicrotik = pstmtBuscarMicrotik.executeQuery();

                int idMicrotik = -1;
                if (rsMicrotik.next()) {
                    idMicrotik = rsMicrotik.getInt("id");
                } else {
                    JOptionPane.showMessageDialog(null, "Error: No se encontró el Microtik con nombre: " + nombreMicrotik,
                            "SpiderNET", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // 🔹 Insertar cliente en la base de datos
                String sqlInsertarCliente = """
                    INSERT INTO clientes (nombre, telefono, email, direccion, ip_cliente, dia_corte, estado, ap_antena, 
                                          serviciosTV, serviciosPlataformas, id_paquete, id_microtik)
                    VALUES (?, ?, ?, ?, ?, ?, 'Activo', ?, ?, ?, 
                            (SELECT id FROM paquetes WHERE nombre = ? LIMIT 1), ?);
                """;

                pstmtInsertarCliente = cn.prepareStatement(sqlInsertarCliente);
                pstmtInsertarCliente.setString(1, nombre);
                pstmtInsertarCliente.setString(2, telefono);
                pstmtInsertarCliente.setString(3, correo);
                pstmtInsertarCliente.setString(4, direccion);
                pstmtInsertarCliente.setString(5, ip_cliente);
                pstmtInsertarCliente.setString(6, dia_corte);
                pstmtInsertarCliente.setString(7, ap_antena);
                pstmtInsertarCliente.setString(8, serviciosTV);
                pstmtInsertarCliente.setString(9, serviciosPlataformas);
                pstmtInsertarCliente.setString(10, paquete);
                pstmtInsertarCliente.setInt(11, idMicrotik);

                int filasAfectadas = pstmtInsertarCliente.executeUpdate();

                if (filasAfectadas > 0) {
                    JOptionPane.showMessageDialog(null, "Cliente registrado exitosamente", "SpiderNET", JOptionPane.INFORMATION_MESSAGE);
                }

                cn.commit(); // 🔹 Confirmar la transacción

            } catch (SQLException e) {
                try {
                    if (cn != null) {
                        cn.rollback(); // 🔹 Revertir cambios en caso de error
                    }
                } catch (SQLException rollbackEx) {
                    rollbackEx.printStackTrace();
                }
                JOptionPane.showMessageDialog(null, "Error en la base de datos: " + e, "SpiderNET", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            } finally {
                // 🔹 Cerrar recursos
                try {
                    if (rsMicrotik != null) {
                        rsMicrotik.close();
                    }
                    if (pstmtBuscarMicrotik != null) {
                        pstmtBuscarMicrotik.close();
                    }
                    if (pstmtInsertarCliente != null) {
                        pstmtInsertarCliente.close();
                    }
                    if (cn != null) {
                        cn.setAutoCommit(true); // 🔹 Restaurar auto-commit
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    public void registroClienteSimple(String nombre, String ip, String nombreMicrotik) {
        Conexion conexion = new Conexion();
        Connection cn = conexion.getConnection();
        PreparedStatement cursorUno, cursorDos;
        ResultSet resultado;

        if (cn != null) {
            String sql = "SELECT id FROM credenciales_microtik WHERE nombre = ?";
            try {
                cursorUno = cn.prepareStatement(sql);
                cursorUno.setString(1, nombreMicrotik);

                resultado = cursorUno.executeQuery();

                if (resultado.next()) {
                    int id = resultado.getInt("id");

                    try {
                        String sqlDos = "INSERT INTO clientes (nombre, direccion, ip_cliente, estado, id_microtik) VALUES (?,?,?,?,?)";
                        cursorDos = cn.prepareStatement(sqlDos);
                        cursorDos.setString(1, nombre);
                        cursorDos.setString(2, "");
                        cursorDos.setString(3, ip);
                        cursorDos.setString(4, "Activo");
                        cursorDos.setInt(5, id);

                        int resultadoDos = cursorDos.executeUpdate();

                        if (resultadoDos >= 0) {
                            cn.close();
                            JOptionPane.showMessageDialog(null, "Cliente registrado de manera exitosa");
                        }
                    } catch (SQLException e) {
                        System.out.println(e);
                        JOptionPane.showMessageDialog(null, "Tenemos un error al insetar el cliente");
                    }
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al insertar los datos: " + e);
            }
        }
    }

}

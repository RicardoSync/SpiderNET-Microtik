package Config;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.ResultSet;

public class UpdateDatos {

    public void actualizarAntena(int id, String nombre, String modelo, String usuario, String password, String ip) {
        Conexion conexion = new Conexion();
        Connection cn = conexion.getConnection();

        if (cn != null) {
            // Si la conexión es exitosa procedemos
            PreparedStatement cursor = null;
            try {
                // SQL corregido, con WHERE para actualizar solo el id correspondiente
                String sql = "UPDATE antenasap SET nombre = ?, modelo = ?, usuario = ?, password = ?, ip = ? WHERE idantenasAp = ?";

                cursor = cn.prepareStatement(sql);

                // Asignamos los parámetros
                cursor.setString(1, nombre);      // Para columna 'nombre'
                cursor.setString(2, modelo);      // Para columna 'modelo'
                cursor.setString(3, usuario);    // Para columna 'usuario'
                cursor.setString(4, password);   // Para columna 'password'
                cursor.setString(5, ip);         // Para columna 'ip'
                cursor.setInt(6, id);            // Para la condición WHERE (id)

                // Ejecutamos la actualización
                int filasAfectadas = cursor.executeUpdate();

                if (filasAfectadas > 0) {
                    JOptionPane.showMessageDialog(null, "Se actualizó con éxito", "Módulo Update", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "No logramos realizar la actualización", "Módulo Update", JOptionPane.INFORMATION_MESSAGE);
                }

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Tenemos un error con la base de datos", "Módulo Update", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();  // Imprime la traza de la excepción para depuración
            }
        }
    }

    public void actualizarPaquetes(int id, String nombre, String velocidad, String precio) {
        Conexion conexion = new Conexion();
        Connection cn = conexion.getConnection();

        if (cn != null) {
            PreparedStatement cursor;

            try {
                String sql = """
                         UPDATE paquetes SET nombre = ?, velocidad = ?, precio = ? WHERE id = ?
                         """;
                cursor = cn.prepareCall(sql);
                //Asignamos los parametros
                cursor.setString(1, nombre);
                cursor.setString(2, velocidad);
                cursor.setString(3, precio);
                cursor.setInt(4, id);
                int rows = cursor.executeUpdate();
                if (rows > 0) {
                    JOptionPane.showMessageDialog(null, "Se actualizó con éxito", "Módulo Update", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "No logramos realizar la actualización", "Módulo Update", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Tenemos un error con la base de datos", "Módulo Update", JOptionPane.ERROR_MESSAGE);

            }
        }
    }

    public void actualizarMicrotik(int id, String nombre, String ip, String username, String password) {
        Conexion conexion = new Conexion();
        Connection cn = conexion.getConnection();

        if (cn != null) {
            PreparedStatement cursor;

            try {
                String sql = """
                         UPDATE credenciales_microtik SET nombre = ?, ip = ?, username = ?, password = ? WHERE id = ?
                         """;
                cursor = cn.prepareCall(sql);
                //Asignamos los parametros
                cursor.setString(1, nombre);
                cursor.setString(2, ip);
                cursor.setString(3, username);
                cursor.setString(4, password);
                cursor.setInt(5, id);
                int rows = cursor.executeUpdate();
                if (rows > 0) {
                    JOptionPane.showMessageDialog(null, "Se actualizó con éxito", "Módulo Update", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "No logramos realizar la actualización", "Módulo Update", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Tenemos un error con la base de datos", "Módulo Update", JOptionPane.ERROR_MESSAGE);

            }
        }
    }

    public void actualizarCliente(int id_cliente, String nombre, String correo, String telefono, String paquete, String direccion,
            String antenaAp, String ipCliente, String diaCorte, String servicioTV, String servicioStream) {
        Conexion conexion = new Conexion();
        Connection cn = conexion.getConnection();

        if (cn != null) {
            //obtenemos el nombre del paquete de la variable
            String nombrePaquete = paquete;
            //hacemos el comando de consulta
            String sqlUno = "SELECT id FROM paquetes WHERE nombre = ?";

            try (PreparedStatement stmtPaquete = cn.prepareStatement(sqlUno)) {
                stmtPaquete.setString(1, nombrePaquete);  // Asegurarse de pasar el nombre del paquete como parámetro
                ResultSet rsPaquete = stmtPaquete.executeQuery();

                if (rsPaquete.next()) {
                    int idPaquete = rsPaquete.getInt("id");

                    // Ahora que tienes el id_paquete, puedes hacer la actualización
                    String sqlUpdate = """
                                   UPDATE clientes 
                                   SET nombre = ?, telefono = ?, email = ?, direccion = ?, id_paquete = ?, 
                                   ip_cliente = ?, dia_corte = ?, ap_antena = ?, serviciosTV = ?, serviciosPlataformas = ?
                                   WHERE id = ?;
                                   """;

                    try (PreparedStatement stmtUpdate = cn.prepareStatement(sqlUpdate)) {
                        // Aquí puedes establecer los valores para la actualización
                        stmtUpdate.setString(1, nombre);
                        stmtUpdate.setString(2, telefono);
                        stmtUpdate.setString(3, correo);
                        stmtUpdate.setString(4, direccion);
                        stmtUpdate.setInt(5, idPaquete);  // El id_paquete obtenido
                        stmtUpdate.setString(6, ipCliente);

                        // Asegúrate de convertir diaCorte a entero
                        int diaCorteInt = Integer.parseInt(diaCorte);
                        stmtUpdate.setInt(7, diaCorteInt);  // Convertimos diaCorte a entero
                        stmtUpdate.setString(8, antenaAp);
                        stmtUpdate.setString(9, servicioTV);
                        stmtUpdate.setString(10, servicioStream);
                        stmtUpdate.setInt(11, id_cliente); // Asumiendo que el cliente tiene un id único

                        // Ejecutas la actualización
                        stmtUpdate.executeUpdate();
                        JOptionPane.showMessageDialog(null, "Cliente actualizado", "SpiderNET", JOptionPane.INFORMATION_MESSAGE);
                    }
                } else {
                    System.out.println("No se encontró el paquete con ese nombre.");
                    JOptionPane.showMessageDialog(null, "No encontramos el paquete con ese nombre", "Modulo Update", JOptionPane.ERROR_MESSAGE);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Conexión a la base de datos fallida.");
            JOptionPane.showMessageDialog(null, "Conexion a la base de datos fallida", "Modulo Update", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void actualizarEquipo(int id, String nombre, String tipo, String marca, String modelo, String mac, String serial, String estado, String cliente) {
        Conexion conexion = new Conexion();
        Connection cn = conexion.getConnection();

        int idCliente = 0;

        if (cn != null) {
            PreparedStatement cursor;
            PreparedStatement cursorCliente;
            ResultSet resultadoCliente;

            // SQL para actualizar los datos del equipo
            String sql = """
                UPDATE equipos SET nombre = ?, tipo = ?, marca = ?, modelo = ?, mac = ?, serial = ?, estado = ?, id_cliente = ?
                WHERE id = ?
                """;

            // SQL para obtener el ID del cliente por nombre
            String sqlDos = "SELECT id FROM clientes WHERE nombre = ?";

            try {
                // Primero obtenemos el ID del cliente
                cursorCliente = cn.prepareStatement(sqlDos);
                cursorCliente.setString(1, cliente);
                resultadoCliente = cursorCliente.executeQuery();

                if (resultadoCliente.next()) {
                    idCliente = resultadoCliente.getInt("id"); // Recuperamos el id del cliente

                    // Ahora preparamos la actualización del equipo
                    cursor = cn.prepareStatement(sql);
                    cursor.setString(1, nombre);
                    cursor.setString(2, tipo);
                    cursor.setString(3, marca);
                    cursor.setString(4, modelo);
                    cursor.setString(5, mac);
                    cursor.setString(6, serial);
                    cursor.setString(7, estado);
                    cursor.setInt(8, idCliente);  // Asignamos el ID del cliente encontrado
                    cursor.setInt(9, id); // El ID del equipo a actualizar

                    // Ejecutamos la actualización
                    cursor.executeUpdate();
                    JOptionPane.showMessageDialog(null, "El equipo de: " + cliente + " se actualizo de manera correcta", "SpiderNET", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "No se encontró el cliente con el nombre proporcionado.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Tenemos error con la base de datos: " + e, "Modulo Update", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public void actualizarServicios(int id, String nombre, String descripcion, String precio) {
        Conexion conexion = new Conexion();
        Connection cn = conexion.getConnection();

        if (cn != null) {
            PreparedStatement cursor;
            String sql = "UPDATE serviciosplataforma SET nombre = ?,  descripcion = ?,  precio = ? WHERE idPlataformas = ?";

            try {
                cursor = cn.prepareStatement(sql);
                cursor.setString(1, nombre);
                cursor.setString(2, descripcion);
                cursor.setString(3, precio);
                cursor.setInt(4, id);

                int filas = 0;
                filas = cursor.executeUpdate();
                if (filas > 0) {
                    JOptionPane.showMessageDialog(null, "Se actualizo de manera el serivicio: " + nombre, "SpiderNET", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "No logramos almacenar ninguna actulizacion", "SpiderNET", JOptionPane.WARNING_MESSAGE);
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Tenemos problemas con la base de datos: " + e, "SpiderNET", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}

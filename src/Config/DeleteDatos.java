package Config;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import Config.Conexion;

/**
 *
 * @author cisco
 */
public class DeleteDatos {

    public void eliminarAntenaAp(int id) {
        Conexion conexion = new Conexion();
        Connection cn = conexion.getConnection();

        if (cn != null) {
            PreparedStatement cursor = null;

            try {
                // Sentencia SQL para eliminar el registro
                String sql = "DELETE FROM antenasap WHERE idantenasAp = ?";
                cursor = cn.prepareStatement(sql);  // Usamos prepareStatement, no prepareCall

                // Establecer el valor del parámetro en la sentencia SQL
                cursor.setInt(1, id);

                // Ejecutamos la sentencia SQL de eliminación
                int rows = cursor.executeUpdate();  // Usamos executeUpdate() para la eliminación

                if (rows > 0) {
                    cn.close();
                    JOptionPane.showMessageDialog(null, "Se eliminó el elemento de manera correcta", "Módulo Eliminar", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "No logramos eliminar ningún elemento", "Módulo Eliminar", JOptionPane.ERROR_MESSAGE);
                }

            } catch (SQLException e) {
                // Mostrar el error de la base de datos
                JOptionPane.showMessageDialog(null, "Tenemos un error con la base de datos: " + e.getMessage(), "Módulo Eliminar", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public void eliminarPaquete(int id) {
        Conexion conexion = new Conexion();
        Connection cn = conexion.getConnection();

        if (cn != null) {
            PreparedStatement cursor = null;

            try {
                // Sentencia SQL para eliminar el registro
                String sql = "DELETE FROM paquetes WHERE id = ?";
                cursor = cn.prepareStatement(sql);  // Usamos prepareStatement, no prepareCall

                // Establecer el valor del parámetro en la sentencia SQL
                cursor.setInt(1, id);

                // Ejecutamos la sentencia SQL de eliminación
                int rows = cursor.executeUpdate();  // Usamos executeUpdate() para la eliminación

                if (rows > 0) {
                    cn.close();
                    JOptionPane.showMessageDialog(null, "Se eliminó el elemento de manera correcta", "Módulo Eliminar", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "No logramos eliminar ningún elemento", "Módulo Eliminar", JOptionPane.ERROR_MESSAGE);
                }

            } catch (SQLException e) {
                // Mostrar el error de la base de datos
                JOptionPane.showMessageDialog(null, "Tenemos un error con la base de datos: " + e.getMessage(), "Módulo Eliminar", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public void eliminarMicrotik(int id) {
        Conexion conexion = new Conexion();
        Connection cn = conexion.getConnection();

        if (cn != null) {
            PreparedStatement cursor = null;

            try {
                // Sentencia SQL para eliminar el registro
                String sql = "DELETE FROM credenciales_microtik WHERE id = ?";
                cursor = cn.prepareStatement(sql);  // Usamos prepareStatement, no prepareCall

                // Establecer el valor del parámetro en la sentencia SQL
                cursor.setInt(1, id);

                // Ejecutamos la sentencia SQL de eliminación
                int rows = cursor.executeUpdate();  // Usamos executeUpdate() para la eliminación

                if (rows > 0) {
                    cn.close();
                    JOptionPane.showMessageDialog(null, "Se eliminó el elemento de manera correcta", "Módulo Eliminar", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "No logramos eliminar ningún elemento", "Módulo Eliminar", JOptionPane.ERROR_MESSAGE);
                }

            } catch (SQLException e) {
                // Mostrar el error de la base de datos
                JOptionPane.showMessageDialog(null, "Tenemos un error con la base de datos: " + e.getMessage(), "Módulo Eliminar", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public void eliminarCliente(int id) {
        Conexion conexion = new Conexion();
        Connection cn = conexion.getConnection();

        if (cn != null) {
            PreparedStatement cursor = null;

            try {
                String sql = "DELETE FROM clientes WHERE id = ?";
                cursor = cn.prepareStatement(sql);

                cursor.setInt(1, id);

                int rows = cursor.executeUpdate();
                if (rows > 0) {
                    PreparedStatement crs = null;
                    
                    String scriptEquipos = "DELETE FROM equipos WHERE id_cliente = ?";
                    
                    crs = cn.prepareStatement(scriptEquipos);
                    crs.setInt(1, id);
                    crs.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Se eliminó el elemento de manera correcta", "Módulo Eliminar", JOptionPane.INFORMATION_MESSAGE);
                    cn.close();
                } else {
                    JOptionPane.showMessageDialog(null, "No logramos eliminar ningún elemento", "Módulo Eliminar", JOptionPane.ERROR_MESSAGE);
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Tenemos un error con la base de datos: " + e.getMessage(), "Módulo Eliminar", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public void eliminarEquipo(int id) {
        Conexion conexion = new Conexion();
        Connection cn = conexion.getConnection();

        if (cn != null) {
            PreparedStatement cursor;
            String sql = "DELETE FROM equipos WHERE id = ?";

            try {
                cursor = cn.prepareStatement(sql);
                cursor.setInt(1, id);

                int filasAfectadas = cursor.executeUpdate();

                if (filasAfectadas > 0) {
                    cn.close();
                    JOptionPane.showMessageDialog(null, "Se elimino de manera exitosa el equipo", "SpiderNET", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Tenemos un error con la base de datos: " + e.getMessage(), "Módulo Eliminar", JOptionPane.ERROR_MESSAGE);
                // TODO: handle exception
            }
        }
    }

    public void eliminarServicio(int id) {
        Conexion conexion = new Conexion();
        Connection cn = conexion.getConnection();

        if (cn != null) {
            PreparedStatement cursor;
            String sql = "DELETE FROM serviciosplataforma WHERE idPlataformas = ?";

            try {
                cursor = cn.prepareStatement(sql);
                cursor.setInt(1, id);

                int filasAfectadas = cursor.executeUpdate();

                if (filasAfectadas > 0) {
                    cn.close();
                    JOptionPane.showMessageDialog(null, "Se elimino de manera exitosa el servicio", "SpiderNET", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Tenemos un error con la base de datos: " + e.getMessage(), "Módulo Eliminar", JOptionPane.ERROR_MESSAGE);
                // TODO: handle exception
            }
        }
    }
}

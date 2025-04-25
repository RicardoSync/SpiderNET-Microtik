package CallMeBot;

import Config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClienteDAO {

    public static class DatosClienteEmpresa {
        public String nombreCliente;
        public String telefonoCliente;
        public String apiKey;
        public String nombreEmpresa;
        public String telefonoEmpresa;
        public String direccionEmpresa;
    }

    public static DatosClienteEmpresa obtenerDatosParaMensaje(int idCliente) {
        DatosClienteEmpresa datos = new DatosClienteEmpresa();

        Conexion conexion = new Conexion();
        Connection conn = conexion.getConnection();

        if (conn == null) {
            System.out.println("❌ No se pudo establecer conexión con la base de datos.");
            return null;
        }

        try {
            // 1. Obtener datos del cliente y su apikey
            String sqlCliente = "SELECT c.nombre, c.telefono, a.apikey " +
                                "FROM clientes c " +
                                "JOIN clientes_apikeys a ON c.id = a.id_cliente " +
                                "WHERE c.id = ? AND a.activo = 1 LIMIT 1";

            try (PreparedStatement ps = conn.prepareStatement(sqlCliente)) {
                ps.setInt(1, idCliente);
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        datos.nombreCliente = rs.getString("nombre");
                        datos.telefonoCliente = rs.getString("telefono");
                        datos.apiKey = rs.getString("apikey");
                    } else {
                        System.out.println("❌ No se encontró al cliente con ID: " + idCliente);
                        return null;
                    }
                }
            }

            // 2. Obtener datos de la empresa
            String sqlEmpresa = "SELECT nombreWisp, telefono, direccion FROM datosEmpresa LIMIT 1";
            try (PreparedStatement ps = conn.prepareStatement(sqlEmpresa);
                 ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    datos.nombreEmpresa = rs.getString("nombreWisp");
                    datos.telefonoEmpresa = rs.getString("telefono");
                    datos.direccionEmpresa = rs.getString("direccion");
                }
            }

        } catch (SQLException e) {
            System.out.println("❌ Error al consultar los datos: " + e.getMessage());
            return null;
        } finally {
            conexion.closeConnection();
        }

        return datos;
    }
}

package CallMeBot;

import Config.Conexion;
import java.sql.*;

public class PagoDAO {

    public static class InfoPagoCliente {

        public String nombreCliente;
        public String apiKey; // <- ya está bien así, asegúrate que NO tenga "private"
        public String telefonoCliente;
        public String nombrePaquete;
        public double precio;
        public String fechaPago;
        public int diaCorte;
        public String nombreEmpresa;
        public String telefonoEmpresa;
        public String direccionEmpresa;
    }


    public static InfoPagoCliente obtenerInfoPagoCliente(int idCliente) {
        InfoPagoCliente datos = new InfoPagoCliente();

        Conexion conexion = new Conexion();
        Connection conn = conexion.getConnection();
        if (conn == null) {
            return null;
        }

        try {
            String sql = "SELECT c.nombre AS nombreCliente, c.telefono, c.dia_corte, "
                    + "p.nombre AS paquete, p.precio, "
                    + "a.apikey, "
                    + "DATE_FORMAT(pg.fecha_pago, '%d/%m/%Y') AS fechaPago "
                    + "FROM clientes c "
                    + "JOIN paquetes p ON c.id_paquete = p.id "
                    + "LEFT JOIN pagos pg ON c.id = pg.id_cliente "
                    + "JOIN clientes_apikeys a ON c.id = a.id_cliente AND a.activo = 1 "
                    + "WHERE c.id = ? "
                    + "ORDER BY pg.fecha_pago DESC LIMIT 1";

            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setInt(1, idCliente);
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        datos.nombreCliente = rs.getString("nombreCliente");
                        datos.telefonoCliente = rs.getString("telefono");
                        datos.nombrePaquete = rs.getString("paquete");
                        datos.precio = rs.getDouble("precio");
                        datos.fechaPago = rs.getString("fechaPago");
                        datos.diaCorte = rs.getInt("dia_corte");
                        datos.apiKey = rs.getString("apikey");
                    } else {
                        return null;
                    }
                }
            }

            String sqlEmpresa = "SELECT nombreWisp, telefono, direccion FROM datosEmpresa LIMIT 1";
            try (PreparedStatement ps = conn.prepareStatement(sqlEmpresa); ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    datos.nombreEmpresa = rs.getString("nombreWisp");
                    datos.telefonoEmpresa = rs.getString("telefono");
                    datos.direccionEmpresa = rs.getString("direccion");
                }
            }

        } catch (SQLException e) {
            System.out.println("❌ Error SQL: " + e.getMessage());
            return null;
        } finally {
            conexion.closeConnection();
        }

        return datos;
    }


}

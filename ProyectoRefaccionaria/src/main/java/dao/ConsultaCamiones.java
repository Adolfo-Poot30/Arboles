package dao;

import bo.Camion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ConsultaCamiones {

    private Connection conn;
    private List<Camion> camiones = new ArrayList<>();

    public ConsultaCamiones() {
        conn = new Conexion().conectar();
    }

    public List<Camion> obtenerCamiones() {
        Statement stmt = null;
        ResultSet rs = null;

        try {
            stmt = conn.createStatement();
            String sql = "SELECT * FROM Camion";

            // Ejecutar la consulta
            rs = stmt.executeQuery(sql);

            // Procesar los resultados y llenar la lista de camiones
            while (rs.next()) {
                int idCamion = rs.getInt("IdCamion");
                String nombre = rs.getString("Nombre");
                double totalAlmacenaje = rs.getDouble("TotalAlmacenaje");
                String placas = rs.getString("Placas");
                String marca = rs.getString("Marca");

                // Crear un objeto Camion y agregarlo a la lista
                Camion camion = new Camion(idCamion, nombre, totalAlmacenaje, placas, marca);
                camiones.add(camion);
            }

        } catch (SQLException e) {
            System.out.print(e);
        } finally {
            // Cerrar ResultSet, Statement y Connection
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                System.out.print(e);
            }
        }

        return camiones;
    }
}

package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    public Connection conectar() {
        String url = "jdbc:mysql://localhost:3306/refaccionaria";
        String usuario = "root";
        String contrasena = "G&5!YADqnft@.57";

        Connection conexion = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            conexion = DriverManager.getConnection(url, usuario, contrasena);
            System.out.println("Conexión exitosa a la base de datos.");
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Error al conectar con la base de datos.");
        }

        return conexion;
    }
}

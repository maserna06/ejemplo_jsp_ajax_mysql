package clases;

import java.sql.*;

public class UsuarioDatos {
    
    public static Connection conectar() {
        Conexion conexion = new Conexion();
        Connection conn = conexion.conectar();
        return conn;
    }
    
    public static int crear(Usuario u) {
        int estado = 0;
        try {
            Connection conn = conectar();

            PreparedStatement ps = conn.prepareStatement(
            "INSERT INTO usuario(nombres, apellidos, email, contrasenia) " +
            "VALUES (?, ?, ?, ?)");
            ps.setString(1, u.getNombres());
            ps.setString(2, u.getApellidos());
            ps.setString(3, u.getEmail());
            ps.setString(4, u.getContrasenia());
            estado = ps.executeUpdate();
        } catch(Exception e) {
            System.out.println("ERROR AL EJECUTAR LA CONSULTA: " + e);
        }
        return estado;
    }
}

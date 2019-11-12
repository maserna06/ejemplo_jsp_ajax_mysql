package clases;

import java.sql.*;

public class UsuarioDatos {
    public static Connection conectar() {
        return Conexion.conectar();
    }
    
    public static int crear(Usuario u) {
        int estado = 0;
        try {
            Connection conn = conectar();

            PreparedStatement ps = conn.prepareStatement(
            "INSERT INTO usuarios(nombres, apellidos, email, contrasenia) " +
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
    
    public static Usuario login(String email, String contrasenia) {
        Usuario u = null;
        
        try {
            Connection conn = conectar();
            
            PreparedStatement ps = conn.prepareStatement(
            "SELECT * FROM usuarios WHERE email=? AND contrasenia=?");
            
            ps.setString(1, email);
            ps.setString(2, contrasenia);
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()) {
                u = new Usuario();
                u.setId(rs.getInt("id"));
                u.setNombres(rs.getString("nombres"));
                u.setApellidos(rs.getString("apellidos"));
                u.setEmail(rs.getString("email"));
            }
        } catch(Exception e) {
            System.out.println("ERROR AL EJECUTAR LA CONSULTA: " + e);
        }
        return u;
    }
}

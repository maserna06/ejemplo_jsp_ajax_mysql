package clases;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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
    
    public static List<Usuario> listarUsuarios() {
        List<Usuario> lista = new ArrayList<>();
        
        try {
            Connection conn = conectar();
            
            PreparedStatement ps = conn.prepareStatement(
            "SELECT * FROM usuarios"
            );
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()) {
                Usuario u = new Usuario();
                u.setId(rs.getInt("id"));
                u.setNombres(rs.getString("nombres"));
                u.setApellidos(rs.getString("apellidos"));
                u.setEmail(rs.getString("email"));
                
                lista.add(u);
            }
        } catch(Exception e) {
            System.out.println("ERROR AL EJECUTAR LA CONSULTA: " + e);
        }
        return lista;
    }
    
    public static Usuario getUsuarioPorId(int id) {
        Usuario u = null;
        
        try {
            Connection conn = conectar();
            
            PreparedStatement ps = conn.prepareStatement(
            "SELECT * FROM usuarios WHERE id=?");
            
            ps.setInt(1, id);
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()) {
                u = new Usuario();
                u.setId(rs.getInt("id"));
                u.setNombres(rs.getString("nombres"));
                u.setApellidos(rs.getString("apellidos"));
                u.setEmail(rs.getString("email"));
                u.setContrasenia(rs.getString("contrasenia"));
            }
        } catch(Exception e) {
            System.out.println("ERROR AL EJECUTAR LA CONSULTA: " + e);
        }
        return u;
    }
}

package clases;

import java.sql.*;

public class Conexion {
    private String usr;
    private String pwd;
    private String bd;
    private Connection conn;
    
    public Conexion() {
        usr = "root";
        pwd = "123456";
        bd = "ejemplo_jsp_ajax_mysql";
    }
    
    public Connection conectar() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+bd, usr, pwd);
        } catch(Exception e) {
            System.out.println("ERROR AL CONECTARSE A LA BD: " + e);
        }
        return conn;
    }
}

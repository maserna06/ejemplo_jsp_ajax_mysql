package clases;

import java.sql.*;

public class Datos {
    private String usr;
    private String pwd;
    private String bd;
    
    public Datos() {
        usr = "root";
        pwd = "123456";
        bd = "ejemplo_jsp_ajax_mysql";
    }
    
    public String conectar() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+bd, usr, pwd);
//            conn.createStatement();
            return "CONEXION A LA BD EXITOSA";
        } catch(Exception e) {
            return "ERROR AL CONECTARSE A LA BD: " + e;
        }
    }
}

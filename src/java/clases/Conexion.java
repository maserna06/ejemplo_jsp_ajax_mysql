package clases;

import java.sql.*;

public class Conexion {
    private static Connection conn;

    public static Connection conectar() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ejemplo_jsp_ajax_mysql", "root", "123456");
        } catch(Exception e) {
            System.out.println("ERROR AL CONECTARSE A LA BD: " + e);
        }
        return conn;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

import java.sql.*;

/**
 *
 * @author HOME
 */
public class Conexion {
    
    Connection cn = null;
    static String bd = "nominas";
    static String user = "snow";
    static String pass = "12345";
    static String path = "jdbc:mysql://localhost:3306/" + bd;

    public Conexion() {
    }

    public Connection conectar() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            cn = DriverManager.getConnection(path, user, pass);
        } catch (Exception e) {
            System.out.println("ERROR:" + e);
        }
        return cn;
    }

    public void desconectar() {
        try {
            cn.close();
        } catch (Exception e) {
            System.out.println("Error al cerrar la conexión : "+e);
        }
    }
}

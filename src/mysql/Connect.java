/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Predator
 */
public class Connect {
    public static Connection conn;
    public static Statement stm;
    
    public static Connection ConfigDB() throws SQLException {
        try {
            String url = "jdbc:mysql://localhost/db_perpustakaan";
            String user = "root";
            String pass = "";
            
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            conn = DriverManager.getConnection(url, user, pass);
            stm = conn.createStatement();
        } catch (Exception e) {
            System.err.println ("Koneksi Gagal, Periksa File mysql/Connect.java "+e.getMessage());
        }
        
        return conn;
    }
}

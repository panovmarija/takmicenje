/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baza;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author USER
 */
public class Konekcija {
    private static Konekcija instance;
    private Connection conn;
    private Konekcija() {
        try {
            conn=DriverManager.getConnection("jdbc:mysql://localhost:3316/prosoftjul21", "root", "root");
            conn.setAutoCommit(false);
        } catch (SQLException ex) {
            Logger.getLogger(Konekcija.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static Konekcija getInstance() {
    if(instance==null)
        instance=new Konekcija();
        return instance;
    }

    public Connection getConn() {
        return conn;
    }
    
}

package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Koneksi {
    private static Connection koneksi;
    
    public static Connection ambilKoneksi(){
        try {
            DriverManager.registerDriver(new org.sqlite.JDBC());
            
            koneksi = DriverManager.getConnection("jdbc:sqlite:muridbaru_db_1.sqlite");
            System.out.println("Sukses");
        } catch (SQLException ex) {   
            Logger.getLogger(Koneksi.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Gagal");
        }
        return koneksi;
    }
}
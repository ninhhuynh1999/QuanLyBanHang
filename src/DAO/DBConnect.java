/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ninhh
 */
public class DBConnect {
    public static Connection getConnection() {
        try {
            Connection cons= null;
//            Class.forName("com.mysql.jdbc");    
            cons=DriverManager.getConnection("jdbc:mysql://localhost/qlcuahang","root","");
            return cons;
        } catch (Exception ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public static void main(String[] args)   {
        Connection c=getConnection();
        if (c != null) {
  System.out.println("Kết nối thành công");
 }
        System.out.println(c.toString());
       
    }
}

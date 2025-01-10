/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package singleton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class singletonConnection {
    private static Connection conn;
   
    
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:4306/lms","root","");
            System.out.println("connected");
        
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        } 
    }
    
    public static Connection getCon() {
        return conn;
    }
}

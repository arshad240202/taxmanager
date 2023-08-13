/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Arshad
 */
public class DB_FUNCTIONS {
    
    public static boolean insertContactDetailsToDb(String name, String email, String comment) {
         try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            Connection connection = DriverManager.getConnection(DB_CONFIG.URL, DB_CONFIG.USERNAME,DB_CONFIG.PASSWORD);
            
            String sql = "INSERT INTO tblcontact (name, email, comment) VALUES (?,?,?) ";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, name);
            statement.setString(2,email);
            statement.setString(3, comment);
            
            int rowInserted = statement.executeUpdate();
            if(rowInserted > 0) {
                System.out.println("Data inserted successfully");
            }
            
            System.out.println("Connected to database");
            connection.close();
            return true;
            
        }catch(SQLException e) {
            System.out.println("Error connecting to database: " + e.getMessage());
        }catch(ClassNotFoundException e) {
            System.out.println("JDBC driver not found: " + e.getMessage());
        }
         return false;
    }
    
    
    
}

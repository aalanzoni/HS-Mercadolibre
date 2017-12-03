/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testing;

import java.sql.DriverManager;
import java.sql.*;

/**
 *
 * @author Andres Lanzoni
 */
public class test {
    public static void main (String a[]){
        
        try {
          String connectionUrl = "jdbc:sqlserver://;database=ml-hs;integratedSecurity=false;";
          Connection c = DriverManager.getConnection(connectionUrl, "sa","admin");
          System.out.println("Conectado.");
        } 
        catch (SQLException ex) 
        {
          System.out.println("Error.");
          ex.printStackTrace();
        }
    }
}

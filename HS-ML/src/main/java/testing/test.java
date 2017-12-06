/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testing;

import hs.ml.Configuracion;
import java.math.BigDecimal;
import java.sql.DriverManager;
import java.sql.*;

/**
 *
 * @author Andres Lanzoni
 */
public class test {
    public static void main (String a[]){
        
        try {
            Configuracion config = new Configuracion();
            
            config.setConf("./config.ini");
            
            System.out.println("Leido config.ini");
            
            String base = config.getBase();
            String instance = config.getInstancename();
            String baseName = config.getDatabasename();        
            String user = config.getUsername();
            String pass = config.getPassword();
            
            String connectionUrl = "jdbc:sqlserver://"+base +
                  ";instanceName="+ instance +
                  ";databaseName="+ baseName +  
                  ";integratedSecurity=false;";
          
            Connection c = DriverManager.getConnection(connectionUrl, user, pass);
          
            
          
            System.out.println("Conectado.");
          
            PreparedStatement stmt = null;

            stmt = c.prepareStatement("INSERT INTO ITEM VALUES " +
                    "(?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"); 
          
            int empresa_item = 1;
            java.math.BigDecimal cuit_item = new BigDecimal("20302269999");
            java.math.BigDecimal codigo_item = new BigDecimal("3");
            String nombre_item = "Item de testing3";
            String descripcion_item = "Desc testing";
            String categoria_item = "Item de testing";
            double precio_item = 100.5;
            double precio_item2 = 100.5;
            double precio_item3 = 100.5;
            String moneda_item = "PES";
            int stock_item = 150;
            int stock_disponible_item = 250;
            int garantia_item = 12;
            String idml_item = "";
          
            stmt.setInt(1, empresa_item);
            stmt.setBigDecimal(2, cuit_item);
            stmt.setBigDecimal(3, codigo_item);
            stmt.setString(4, nombre_item);
            stmt.setString(5, descripcion_item);
            stmt.setString(6, categoria_item);
            stmt.setDouble(7, precio_item);
            stmt.setDouble(8, precio_item2);
            stmt.setDouble(9, precio_item3);
            stmt.setString(10, moneda_item);
            stmt.setInt(11, stock_item);
            stmt.setInt(12, stock_disponible_item);
            stmt.setInt(13, garantia_item);
            stmt.setString(14, idml_item);          
          
            stmt.execute();
          
/**
 * // La consulta es un String con código SQL
String sql1 = "SELECT * FROM cuentas";

// Ejecuta una consulta que devuelve resultados                
ResultSet rs = st.executeQuery(sql1);   
while (rs.next()) {
    System.out.println (rs.getString ("propietario") + " " + rs.getString (2)+ " " + rs.getInt(saldo));
}             
**/
           
          c.close();
        } 
        catch (SQLException ex) 
        {
          System.out.println("Error.");
          ex.printStackTrace();
        }
        
        
    }
}

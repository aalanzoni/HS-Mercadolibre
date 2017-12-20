/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hs.ml;

import java.math.BigDecimal;
import java.sql.*;
import java.util.LinkedList;

/**
 *
 * @author Windows-7
 */
public class DbHandler {
    
    public Connection DbConnection(){
        Connection c = null;
        try {
            String base = Configuracion.getBase();
            String instance = Configuracion.getInstancename();
            String baseName = Configuracion.getDatabasename();        
            String user = Configuracion.getUsername();
            String pass = Configuracion.getPassword();
            
            String connectionUrl = "jdbc:sqlserver://"+base +
                                   ";instanceName="+ instance +
                                   ";databaseName="+ baseName +  
                                   ";integratedSecurity=false;";
          
            c = DriverManager.getConnection(connectionUrl, user, pass);
        } 
        catch (SQLException ex){
        }        
        return c;
    }
    
    public Boolean DbInsert(Connection c){
        try {        
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
            c.close();            
            return true;
        } 
        catch (SQLException ex) 
        {
          return false;          
        }                
    }
    
    public LinkedList DbSelect(Connection c) throws SQLException{
        LinkedList result = new LinkedList();
        try { 
            PreparedStatement stmt = c.prepareStatement("SELECT * FROM ITEM"); 
            stmt.execute(); 
            ResultSet rs = stmt.getResultSet();
            
            while(rs.next()){
                Item item = new Item (rs.getInt(1),        rs.getBigDecimal(2),
                                      rs.getBigDecimal(3), rs.getString(4),
                                      rs.getString(5),     rs.getString(6),
                                      rs.getDouble(7),     rs.getDouble(8),
                                      rs.getDouble(9),     rs.getString(10),
                                      rs.getInt(11),       rs.getInt(12),
                                      rs.getInt(13),       rs.getString(14)
                                     );
                result.add(item);               
            }

            if (stmt != null) {
		stmt.close();
            }

            if (c != null) {
		c.close();
            }            
            return result;
        } 
        catch (SQLException ex) 
        {
            return result;          
        }               
    }    
}

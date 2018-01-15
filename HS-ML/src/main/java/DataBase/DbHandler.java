/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBase;

import Config.Configuracion;
import hs.ml.Item;
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
            
            String connectionUrl = "jdbc:sqlserver://"+ base +
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
    
    public LinkedList<Item>  DbSelect(Connection c) throws SQLException{
        LinkedList<Item> result = new LinkedList<>();
        try { 
            PreparedStatement stmt = c.prepareStatement("SELECT * FROM ITEM"); 
            stmt.execute(); 
            ResultSet rs = stmt.getResultSet();
            
            while(rs.next()){
                Item item = new Item (rs.getString(1),  rs.getString(2),
                                      rs.getString(3),  rs.getString(4),
                                      rs.getDouble(5),  rs.getString(6),
                                      rs.getInt(7),     rs.getString(8),
                                      rs.getString(9),  rs.getString(10),
                                      rs.getString(11), rs.getString(12),
                                      rs.getInt(13),    rs.getString(14),
                                      rs.getString(15), rs.getString(16),
                                      rs.getString(17)
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

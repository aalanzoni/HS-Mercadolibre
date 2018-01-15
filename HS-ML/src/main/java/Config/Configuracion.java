/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Config;

/**
 *
 * @author Andres Lanzoni
 */
public class Configuracion {
    // Variable para la Base de Datos 
    private static String base="";
    private static String instancename="";
    private static String databasename="";
    private static String username = "";
    private static String password = "";
    
    // Variable para la Info de la App HS
    private static String app_url = "";
    private static Long app_id;
    private static String app_pass = "";       

    public static String getBase() {
        return base;
    }

    public static String getInstancename() {
        return instancename;
    }

    public static String getDatabasename() {
        return databasename;
    }    
    
    public static String getUsername() {
        return username;
    }

    public static String getPassword() {
        return password;
    }
    
    public static String getApp_url() {
        return app_url;
    }
    
    public static Long getApp_id() {
        return app_id;
    }
        
    public static String getApp_pass() {
        return app_pass;
    }        

    public static void setConf (String nameFile ){
        if ((nameFile == null)||(nameFile.trim().length() == 0)){
                nameFile = "./config.ini";
        }
        IniFile ini = new IniFile(nameFile);
        
        // Variable para la Base de Datos 
        base = ini.getParameters("base");
        instancename = ini.getParameters("instancename");
        databasename = ini.getParameters("databasename");
        username = ini.getParameters("username");
        password = ini.getParameters("password"); 
        // Variable para la Info de la App HS
        app_url = ini.getParameters("app_url");
        app_id = new Long(ini.getParameters("app_id"));
        app_pass = ini.getParameters("app_pass");
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hs.ml;

/**
 *
 * @author Andres Lanzoni
 */
public class Configuracion {
    private static String base="";
    private static String instancename="";
    private static String databasename="";
    private static String username = "";
    private static String password = "";

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

    public static void setConf (String nameFile ){
        if ((nameFile == null)||(nameFile.trim().length() == 0)){
                nameFile = "./config.ini";
        }
        IniFile ini = new IniFile(nameFile);
        base = ini.getParameters("base");
        instancename = ini.getParameters("instancename");
        databasename = ini.getParameters("databasename");
        username = ini.getParameters("username");
        password = ini.getParameters("password");        
    }
}

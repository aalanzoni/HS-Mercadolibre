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
import Meli.Meli;
import com.ning.http.client.FluentStringsMap;
import com.ning.http.client.Response;

public class Main {

    public static void main(String[] args) throws Exception {           
        Configuracion.setConf("./config.ini");
        
        AppHandler appHandler = new AppHandler();
        Meli app_Meli = appHandler.getMeli_App();
        String user_token = app_Meli.getAccessToken();
       
        //muestra los datos del usuario
	FluentStringsMap params = new FluentStringsMap();
	params.add("access_token", app_Meli.getAccessToken());
	Response response = app_Meli.get("/users/me", params);
 
        System.out.println(response.getResponseBody()); 

        //pone en venta un producto
        
    }
} 

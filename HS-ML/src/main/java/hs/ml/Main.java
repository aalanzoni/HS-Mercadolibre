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
        
        long user_id = 288530762;
        String user_pass = "qatest3744";
        
        AppHandler appHandler = new AppHandler();               
        String user_token = appHandler.getAccessToken();
        
        //muestra los datos del usuario
        Meli m = new Meli(user_id, user_pass, user_token);
	FluentStringsMap params = new FluentStringsMap();
	params.add("access_token", m.getAccessToken());
	Response response = m.get("/users/me", params);
 
        System.out.println(response.getResponseBody());         
    }
} 

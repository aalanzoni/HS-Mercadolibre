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
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) throws Exception {           
        Configuracion.setConf("./config.ini");
        
        AppHandler appHandler = new AppHandler();
        Meli app_Meli = appHandler.getMeli_App();
        String user_token = app_Meli.getAccessToken();
       
        // obtengo el token
	FluentStringsMap params = new FluentStringsMap();
	params.add("access_token", app_Meli.getAccessToken());
        
        //muestra los datos del usuario        
	Response response = app_Meli.get("/users/me", params);
        System.out.println(response.getResponseBody()); 

        //pone en venta los productos te esten en la base de datos
        DbHandler dbHandler = new DbHandler();
        LinkedList itemList = dbHandler.DbSelect(dbHandler.DbConnection());
        
        int i = 0; 
        while(itemList.size() != i){
            Item currentItem = (Item) itemList.get(i);
            String body = currentItem.PrepareItem();
            System.out.println(currentItem.toString());
            
            response = app_Meli.post("/items", params, body); 
            currentItem.setIdml_item(response.getHeader("id"));
            System.out.println(response.getResponseBody());
            
            itemList.set(i, currentItem);
            i++;
        }
        
        //pausa los productos vendidos
        i = 0;
        while(itemList.size() != i){
            Item currentItem = (Item) itemList.get(i);
            String apiFuntion = "/items/" + currentItem.getIdml_item();
            String body = "{\"status\":\"paused\"}";
            
            response = app_Meli.post(apiFuntion, params, body);
            System.out.println(response.getResponseBody());

            i++;
        }        
    }
} 

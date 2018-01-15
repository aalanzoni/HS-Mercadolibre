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
import DataBase.DbHandler;
import Config.Configuracion;
import Meli.MeliHandler;
import com.ning.http.client.Response;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) throws Exception {           
        Configuracion.setConf("./config.ini");
        
        MeliHandler meli_Handler = new MeliHandler();
              
        //muestra los datos del usuario        
	Response response = meli_Handler.getUserInfo();
        System.out.println(response.getResponseBody()); 
        
        
        //pone en venta los productos te esten en la base de datos
        DbHandler dbHandler = new DbHandler();
        LinkedList itemList = dbHandler.DbSelect(dbHandler.DbConnection());
        
        int i = 0; 
        while(itemList.size() != i){
            Item currentItem = (Item) itemList.get(i);
            String body = currentItem.PrepareItem();
            System.out.println(currentItem.toString());
            
            response = meli_Handler.postNewItem(body); 
            currentItem.setML_Id(response.getHeader("id"));
            System.out.println(response.getResponseBody());
            
            itemList.set(i, currentItem);
            i++;
        }
        
        //pausa los productos vendidos
        i = 0;
        while(itemList.size() != i){
            Item currentItem = (Item) itemList.get(i);           
            response = meli_Handler.postPauseItem(currentItem);     
            System.out.println(response.getResponseBody());

            i++;
        }       
    }
} 

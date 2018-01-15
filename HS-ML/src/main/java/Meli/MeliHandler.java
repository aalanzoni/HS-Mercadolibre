/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Meli;

import Windows.Browser;
import com.ning.http.client.FluentStringsMap;
import com.ning.http.client.Response;
import Config.Configuracion;
import hs.ml.Item;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Windows-7
 */
public class MeliHandler {
    private Meli meli_App;
    
    private String code_app;
    private String app_url = Configuracion.getApp_url();
    private Long app_id = Configuracion.getApp_id();
    private String app_pass = Configuracion.getApp_pass();
    
    public MeliHandler(){
        try{
            meli_App = new Meli(app_id, app_pass);
            String auth_Url = meli_App.getAuthUrl(app_url, Meli.AuthUrls.MLA);
                    
            Browser.main(auth_Url);           
            String[] code_Auth = Browser.url_Code.split("="); 
            code_app = code_Auth[1];

            meli_App.authorize(code_app, app_url);       
       }catch (AuthorizationFailure e){
       }
    }

    public Response getUserInfo(){     
        try {
            FluentStringsMap params = new FluentStringsMap();
            params.add("access_token", meli_App.getAccessToken());
            Response response = meli_App.get("/users/me", params); 
            return response;
        } catch (MeliException ex) {
            Logger.getLogger(MeliHandler.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public Response postNewItem(String body){
        try {
            FluentStringsMap params = new FluentStringsMap();
            params.add("access_token", meli_App.getAccessToken());
            Response response = meli_App.post("/items", params, body);
            return response;
        } catch (MeliException ex) {
            Logger.getLogger(MeliHandler.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }        
    }
    
    public Response postPauseItem(Item changed_item){   
        try {
            String apiFuntion = "/items/" + changed_item.getML_Id();
            String body = "{\"status\":\"paused\"}";            
            FluentStringsMap params = new FluentStringsMap();
            params.add("access_token", meli_App.getAccessToken());
            Response response = meli_App.post(apiFuntion, params, body);
            return response;
        } catch (MeliException ex) {
            Logger.getLogger(MeliHandler.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }       
    }

}

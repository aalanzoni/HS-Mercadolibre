/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hs.ml;

import Browser.Browser;
import Meli.AuthorizationFailure;
import Meli.Meli;

/**
 *
 * @author Windows-7
 */
public class AppHandler {
    private Meli meli_App; 
    private String code_app;
    private String app_url = Configuracion.getApp_url();
    private Long app_id = Configuracion.getApp_id();
    private String app_pass = Configuracion.getApp_pass();
    
    public AppHandler(){
        try{
            meli_App = new Meli(app_id, app_pass);
            String auth_Url = meli_App.getAuthUrl(app_url, Meli.AuthUrls.MLA);
                    
            Browser.main(auth_Url);           
            String[] code_Auth = Browser.url_Code.split("="); 
            code_app = code_Auth[1];

            meli_App.authorize(code_app, app_url);
            /*System.out.println("user_id = " + meli_App.getUserId() +
                               " / tokenType = " + meli_App.getTokenType() +
                               " / accessToken = " + meli_App.getAccessToken() + 
                               " / refreshToken = " + meli_App.getRefreshToken() + 
                               " / expiresIn = " + meli_App.getExpiresIn().toString() + 
                               " / scope = " + meli_App.getScope()
                               ); */        
       }catch (AuthorizationFailure e){
       }
    }

    public Meli getMeli_App() {
        return meli_App;
    }
    
}

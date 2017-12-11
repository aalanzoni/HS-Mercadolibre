/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hs.ml;

import Meli.AuthorizationFailure;
import Meli.Meli;
import com.panamahitek.webbrowserexample.JFrameWindow;

/**
 *
 * @author Windows-7
 */
public class AppHandler {
    Meli meli_App; 
    String code_app;
    
    public AppHandler(long app_id, String app_pass, String api_url){
        try{
            meli_App = new Meli(app_id, app_pass);
            String auth_Url = meli_App.getAuthUrl(api_url, Meli.AuthUrls.MLA);
        
            //URI uri = new URI(auth_Url);
            //java.awt.Desktop.getDesktop().browse(uri);
            JFrameWindow window = new JFrameWindow(auth_Url);
            window.setVisible(true);

            code_app = "TG-5a2e7233e4b08147b98a3f1f-288530762";

            meli_App.authorize(code_app, api_url);
            //System.out.println("user_id = " + meli_App.getUserId() +
            //                   " / tokenType = " + meli_App.getTokenType() +
            //                   " / accessToken = " + meli_App.getAccessToken() + 
            //                   " / refreshToken = " + meli_App.getRefreshToken() + 
            //                   " / expiresIn = " + meli_App.getExpiresIn().toString() + 
            //                   " / scope = " + meli_App.getScope()
            //              );           
       }catch (AuthorizationFailure e){
       }
    }
    
    public String getAccessToken(){
        return meli_App.getAccessToken();
    }
      
    public Long getExpiresIn(){
       return meli_App.getExpiresIn(); 
    }
}

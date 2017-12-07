/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hs.ml;

import Meli.AuthorizationFailure;
import Meli.Meli;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 *
 * @author Windows-7
 */
public class AppHandler {
    String auth_Url;
    String[] parts_Url;
    String code_app;
    
    public AppHandler(long app_id, String app_pass, String api_url) throws AuthorizationFailure, URISyntaxException, IOException{
        Meli meli_App = new Meli(app_id, app_pass);
        auth_Url = meli_App.getAuthUrl(api_url, Meli.AuthUrls.MLA);
        
        URI uri = new URI(auth_Url);
        java.awt.Desktop.getDesktop().browse(uri);
        
        parts_Url = auth_Url.split("code=");
        code_app = parts_Url[1];

        meli_App.authorize(code_app, api_url);
        System.out.println("user_id = " + meli_App.getUserId() +
                           "tokenType = " + meli_App.getTokenType() +
                           "accessToken = " + meli_App.getAccessToken() + 
                           "refreshToken = " + meli_App.getRefreshToken() + 
                           "expiresIn = " + meli_App.getExpiresIn().toString() + 
                           "scope = " + meli_App.getScope()
                          );
    }
}

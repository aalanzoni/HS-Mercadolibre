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
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
       
        // muestra todos los sites de MELI
        /*
        final List<Site> sites = SiteHandler.getInstance().getAllMeliSite();

        for (final Site site: sites) {
            System.out.println(site);
        }
        */
        
        String api_url = "http://localhost/hs"; 
        Long app_id = new Long("4532553168555750");
        String app_pass = "CaVD3Vt6MEYMPcFH81TYxxm3ZPTzEjBK";
        
        long user_id = 288530762;
        String user_pass = "qatest3744";
        
        AppHandler appHandler = new AppHandler(app_id, app_pass, api_url);
        
        
        String user_token = appHandler.getAccessToken();
        
        /* muestra los datos del usuario
        Meli m = new Meli(user_id, user_pass, user_token);
	FluentStringsMap params = new FluentStringsMap();
	params.add("access_token", m.getAccessToken());
	Response response = m.get("/users/me", params);
        System.out.println(response.getResponseBody());
        */
           
    }
} 

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
import com.google.gson.Gson;
import com.google.gson.internal.StringMap;
import com.mercadolibre.sdk.Meli;
import com.ning.http.client.FluentStringsMap;
import com.ning.http.client.Response;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
       
        final List<Site> sites = SiteHandler.getInstance().getAllMeliSite();

        for (final Site site: sites) {
            System.out.println(site);
        }
         
        
        long user_id = 288530762;
        String user_pass = "qatest3744";
        String user_token = "APP_USR-4532553168555750-120617-8d79201f7b25a9c66ca59dbadc557b11__B_D__-288530762";
                
	Meli m = new Meli(user_id, user_pass, user_token);

	FluentStringsMap params = new FluentStringsMap();
	params.add("access_token", m.getAccessToken());
	Response response = m.get("/users/me", params);
        System.out.println(response.getResponseBody());
        
        final List<Site> newSites = new ArrayList<>();
        final Gson gson = new Gson();
        
        //final List<StringMap<String>> sites = gson.fromJson(response.getResponseBody(), List.class);

        //Convertimos los objectos StringMap a Site.
        //for (final StringMap<String> entries : sites) {
          //  System.out.println(entries.toString());
            //System.out.println(new Site(entries.get("id"), entries.get("nickname")));
        //}
            
    }
} 

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
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.internal.StringMap;
import Meli.Meli;
import Meli.MeliException;
import com.ning.http.client.Response;

public class SiteHandler {

    private static final String ID_KEY = "id";
    private static final String NAME_KEY = "name";
    private final Meli meli;

    private static final SiteHandler instance = new SiteHandler();

    private SiteHandler() {
        meli = new Meli(11111L, "clientSecret");
    }

    public static SiteHandler getInstance() {
        return instance;
    }

    public List<Site> getAllMeliSite() throws MeliException {
        final List<Site> newSites = new ArrayList<Site>();
        try {
            final Response response = meli.get("/sites/");

            final Gson gson = new Gson();
            final List<StringMap<String>> sites = gson.fromJson(response.getResponseBody(), List.class);

            //Convertimos los objectos StringMap a Site.
            for (final StringMap<String> entries : sites) {
                newSites.add(new Site(entries.get(ID_KEY), entries.get(NAME_KEY)));
            }
        } catch (MeliException ex) {
            //Logger error en la respuesta
            System.out.println("Error " + ex.getMessage());
        } catch (IOException e) {
            //Logger error en la transformacion usando de gson.
            System.out.println("Error " + e.getMessage());
        }
        return newSites;
    }
} 
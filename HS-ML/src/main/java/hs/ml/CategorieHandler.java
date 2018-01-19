/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * source = https://static.javadoc.io/com.google.code.gson/gson/2.6.2/com/google/gson/stream/JsonReader.html
 */
package hs.ml;

import Meli.Meli;
import Meli.MeliException;
import com.google.gson.stream.JsonReader;
import com.ning.http.client.FluentStringsMap;
import com.ning.http.client.Response;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Windows-7
 */
public class CategorieHandler {
    
    public List<Categorie> getHeadCategorie(){
        Meli meli_App = null;
        FluentStringsMap params = new FluentStringsMap();
        
        Response response = null;
        InputStream responseBody;
        JsonReader reader = null;
        
        List<Categorie> listCategorie = new ArrayList<Categorie>();
        
        try {
            response = meli_App.get("/sites/MLA/categories", params);
            responseBody = response.getResponseBodyAsStream();
            reader = new JsonReader(new InputStreamReader(responseBody, "UTF-8"));
            if (response.getStatusCode() == 200) { 
                reader.beginArray();
                while (reader.hasNext()) {
                    listCategorie.add(readCategorie(reader));
                }
                reader.endArray();
            } 
            reader.close();
        } catch (MeliException | IOException ex) {
            Logger.getLogger(CategorieHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listCategorie;
    }
   /*
    public Categorie[] getChildrenCategorie(String id_father){
        
    }
    
    public Categorie[] getPathFromRoot(String id_categorie){
        
    }
    
    public Categori categoriPreditor(String title){
        
    }*/
    

    private Categorie readCategorie(JsonReader reader) throws IOException {
        String id = null;
        String name = null;
        Boolean leaf = false;
        Categorie categori = null;

        reader.beginObject();
        while (reader.hasNext()) {
            String readerName = reader.nextName();
            switch (readerName) {
                case "id": id = reader.nextString();
                case "name": name = reader.nextString();
                case "children_categories" : leaf  = reader.nextString().compareTo("[\n" + "  ]") == 0;
                                             categori = new Categorie(id, name, leaf);
                case "settings" : categori = readSetting(reader, categori);
                default : reader.skipValue();
            }
         }
         reader.endObject();
         return categori;
    }

    private Categorie readSetting(JsonReader reader, Categorie cat){
        return cat;
    }
   /*
    private List<Double> readDoublesArray(JsonReader reader) throws IOException {
        List<Double> doubles = new ArrayList<Double>();

        reader.beginArray();
        while (reader.hasNext()) {
            doubles.add(reader.nextDouble());
        }
        reader.endArray();
        return doubles;
    }

    private User readUser(JsonReader reader) throws IOException {
        String username = null;
        int followersCount = -1;

        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (name.equals("name")) {
                username = reader.nextString();
            } else if (name.equals("followers_count")) {
                followersCount = reader.nextInt();
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return new User(username, followersCount);
   }  */  
}

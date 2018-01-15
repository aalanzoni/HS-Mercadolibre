/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hs.ml;

import java.util.Arrays;

/**
 *
 * @author flavi
 */
public class Item {
    String ml_id;
    String hs_id;
    String title;
    String category;
    double price;
    String coin;
    int    stock;
    String buying_mode;
    String listing_type;
    String condition;
    String description;
    String video;
    int    warranty;
    String[] picture;
    String shipping;
    String payment_metod;
    String status;
    
    String one_picture;
    
    public Item(String ml_id, String hs_id, String title, String category, double price, String coin, 
                int stock, String buying_mode, String listing_type, String condition, String description,
                String video, int warranty, String picture, String shipping, String payment_metod, String status) {
        
        this.ml_id = ml_id;
        this.hs_id = hs_id;
        this.title = title;
        this.category = category;
        this.price = price;
        this.coin = coin;
        this.stock = stock;
        this.buying_mode = buying_mode;
        this.listing_type = listing_type;
        this.condition = condition;
        this.description = description;
        this.video = video;
        this.warranty = warranty;
        this.picture = picture.split(";");
        this.shipping = shipping;
        this.payment_metod = payment_metod;
        this.status = status;
    } 
    
    public String PrepareItem(){
        String body;
        body = "{" + 
               "\"title\":\"" + title + "\"," +
               "\"category_id\":\"" + category + "\"," + 
               "\"price\":" + price + "," +
               "\"currency_id\":\"" + coin + "\"," + 
               "\"available_quantity\":" + stock + "," +
               "\"buying_mode\":\"" + buying_mode + "\"," +
               "\"listing_type_id\":\"" + listing_type + "\"," +     //publicacion gratuita
               "\"condition\":\"" + condition + "\"," +
               "\"description\":\"" + description + "\"," +
               "\"video_id\":\"" + video + "\"," +
               "\"warranty\":\"" + warranty + " months\"," +
               "\"pictures\":[" +
               "{\"source\":\"" + picture[1] + "\"}" +
               "]}";
        return body;
    }
    
    public void setML_Id(String new_ml_id){
        this.ml_id = new_ml_id;
    }
    
    public String getML_Id(){
        return ml_id;
    }

    @Override
    public String toString() {
        return "Item{" + "ml_id=" + ml_id + "hs_id=" + hs_id + "title=" + title + 
               ", category_id=" + category + ", price=" + price + 
               ", currency_id=" + coin + ", available_quantity=" + stock + ", buying_mode=" + buying_mode + 
               ", listing_type_id=" + listing_type + ", condition=" + condition + 
               ", description=" + description + ", video_id=" + video + ", warranty=" + warranty + 
               ", pictures=" + Arrays.toString(picture) + '}';
    }
    
    
}

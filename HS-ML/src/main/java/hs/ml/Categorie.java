/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hs.ml;

import java.util.List;

/**
 *
 * @author Windows-7
 */
public class Categorie {
    private String id;
    private String name;
    private Boolean leaf;
    private List<String> buying_mode;
    private String currencie;
    private String inmediate_payment;
    private List<String> item_condition;
    private int max_desc_length;
    private int max_pic_per_item;
    private int max_title_length;
    private List<String> shipping_modes;
    private List<String> shipping_options;
    private double min_price;
    private double max_price;
    
    public Categorie(String id, String name, Boolean leaf){
        this.id = id;
        this.name = name;
        this.leaf = leaf;     
    }    
    
    public Categorie(String id, String name, Boolean leaf, List buying_mode, String currencie, 
                      String inmediate_payment, List item_condition, int max_desc_length,
                      int max_pic_per_item, int max_title_length, List shipping_modes,
                      List  shipping_options, double min_price, double max_price){
        this.id = id;
        this.name = name;
        this.leaf = leaf;
        this.buying_mode = buying_mode;
        this.currencie = currencie;
        this.inmediate_payment = inmediate_payment;
        this.item_condition = item_condition;
        this.max_desc_length = max_desc_length;
        this.max_pic_per_item = max_pic_per_item;
        this.max_title_length = max_title_length;
        this.shipping_modes = shipping_modes;
        this.shipping_options = shipping_options;
        this.min_price = min_price;
        this.max_price = max_price;      
    }   
    
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Boolean getLeaf() {
        return leaf;
    }

    public List<String> getBuying_mode() {
        return buying_mode;
    }

    public String getCurrencie() {
        return currencie;
    }

    public String getInmediate_payment() {
        return inmediate_payment;
    }

    public List<String> getItem_condition() {
        return item_condition;
    }

    public int getMax_desc_length() {
        return max_desc_length;
    }

    public int getMax_pic_per_item() {
        return max_pic_per_item;
    }

    public int getMax_title_length() {
        return max_title_length;
    }

    public List<String> getShipping_modes() {
        return shipping_modes;
    }

    public List<String> getShipping_options() {
        return shipping_options;
    }

    public double getMin_price() {
        return min_price;
    }

    public double getMax_price() {
        return max_price;
    }  

    public void setBuying_mode(List<String> buying_mode) {
        this.buying_mode = buying_mode;
    }

    public void setCurrencie(String currencie) {
        this.currencie = currencie;
    }

    public void setInmediate_payment(String inmediate_payment) {
        this.inmediate_payment = inmediate_payment;
    }

    public void setItem_condition(List<String> item_condition) {
        this.item_condition = item_condition;
    }

    public void setMax_desc_length(int max_desc_length) {
        this.max_desc_length = max_desc_length;
    }

    public void setMax_pic_per_item(int max_pic_per_item) {
        this.max_pic_per_item = max_pic_per_item;
    }

    public void setMax_title_length(int max_title_length) {
        this.max_title_length = max_title_length;
    }

    public void setShipping_modes(List<String> shipping_modes) {
        this.shipping_modes = shipping_modes;
    }

    public void setShipping_options(List<String> shipping_options) {
        this.shipping_options = shipping_options;
    }

    public void setMin_price(double min_price) {
        this.min_price = min_price;
    }

    public void setMax_price(double max_price) {
        this.max_price = max_price;
    }
    
    
}


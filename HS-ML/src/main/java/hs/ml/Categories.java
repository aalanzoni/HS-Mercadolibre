/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hs.ml;

/**
 *
 * @author Windows-7
 */
public class Categories {
    private final String id;
    private final String name;
    private final Boolean leaf;
            
    public Categories(String id, String name, Boolean leaf){
        this.id = id;
        this.name = name;
        this.leaf = leaf;
    }   
}
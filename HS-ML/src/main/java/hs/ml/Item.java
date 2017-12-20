/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hs.ml;

import java.math.BigDecimal;

/**
 *
 * @author flavi
 */
public class Item {
    /*
    String id;
    String idSitio;
    String titulo;
    String subtitulo;
    String idCategoria;
    double precio;
    String moneda;
    String idCorriente = "ARS";
    int stock;
    String metodoPago;
    String metodoEnvio;
    String idTipoPublicacion;
    String estado = "new";
    String descripcion;
    String idVideo;
    String tags; //"immediate_payment"(solo Mercado Pago)
    String garantia;
    String[] imagenes;
    String campoCustom; //guardar el codigo interno de cobol
    */    
    
    int empresa_id;
    BigDecimal cuit_item;
    BigDecimal codigo_item;
    String nombre_item;
    String descripcion_item;
    String categoria_item;
    double precio_item;
    double precio_item2;
    double precio_item3;
    String moneda_item;
    int stock_item;
    int stock_disponible_item;
    int garantia_item;
    String idml_item;

    public Item(int empresa_id, BigDecimal cuit_item, BigDecimal codigo_item, String nombre_item, String descripcion_item, String categoria_item, double precio_item, double precio_item2, double precio_item3, String moneda_item, int stock_item, int stock_disponible_item, int garantia_item, String idml_item) {
        this.empresa_id = empresa_id;
        this.cuit_item = cuit_item;
        this.codigo_item = codigo_item;
        this.nombre_item = nombre_item;
        this.descripcion_item = descripcion_item;
        this.categoria_item = categoria_item;
        this.precio_item = precio_item;
        this.precio_item2 = precio_item2;
        this.precio_item3 = precio_item3;
        this.moneda_item = moneda_item;
        this.stock_item = stock_item;
        this.stock_disponible_item = stock_disponible_item;
        this.garantia_item = garantia_item;
        this.idml_item = idml_item;
    }    
}

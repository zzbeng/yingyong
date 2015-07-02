package com.xiekeer.entity;

import android.content.res.Resources;

import java.util.List;
import java.util.Vector;

/**
 * Created by zheng_cao on 7/2/2015.
 */
public class ShoppingCartHelper {

    public static final String PRODUCT_INDEX = "PRODUCT_INDEX";

    private static List<Product> catalog;
    private static List<Product> cart;

    public static List<Product> getCatalog(Resources res) {
        if (catalog == null) {
            catalog = new Vector<Product>();
            catalog.add(new Product("harry potter", res.getDrawable(R.drawable.deadoralive), "book", 29.9));
        }
        return catalog;
    }

    public static List<Product> getCart() {
        if(cart == null) {cart = new Vector<Product> ();}
        return cart;
    }

}

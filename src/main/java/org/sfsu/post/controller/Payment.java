package org.sfsu.post.controller;

/**
 * Created by ivanyu on 2/7/17.
 *
 * Used by POST to determine payment type and product price
 *
 */
public class Payment {
    String type;
    float price;

    public Payment(String type, float price){
        this.type = type;
        this.price = price;
    }

    public String getType(){
        return type;
    }

    public double getPrice(){
        return price;
    }
}

package org.sfsu.post.controller;

/**
 * Created by ivanyu on 2/7/17.
 *
 * Used by POST to determine payment type and product price
 *
 */
public abstract class Payment {
    private String type;
    private float amount;
    private int id;
    /*float price;

    public Payment(String type, float price){
        this.type = type;
        this.price = price;
    }*/

    //new codes here---
    public Payment(String type){ this.type = type;}
    public Payment(String type, int id) { this.type = type; this.id = id;}
    public Payment(String type, float amount) { this.type = type; this.amount = amount;}
    public abstract void setAmount(float amount);
    public abstract float getAmount();
    public abstract int getId();
    public abstract void setId(int id);

    //end of new codes ---
    public String getType(){
        return type;
    }
    //public double getPrice(){ return price;}
}

package org.sfsu.post.controller;

/**
 * Created by ivanyu on 2/16/17.
 */
public class Check extends Payment{
    private float amount;
    public Check(float amount){
        super("CHECK");
        this.amount = amount;
    }

    public float getAmount() { return amount; }
    public void setAmount(float amount) { this.amount = amount;}
    public int getId() { return 0; }
    public void setId(int id) { }
}

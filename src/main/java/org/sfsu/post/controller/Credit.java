package org.sfsu.post.controller;

/**
 * Created by ivanyu on 2/16/17.
 */
public class Credit extends Payment {
    private int id;

    public Credit(int id){
        super("CREDIT");
        this.id = id;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id;}
    public void setAmount(float amount) { }
    public float getAmount() { return 0;}
}

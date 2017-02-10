package org.sfsu.post.controller;

/**
 * Created by ivanyu on 2/7/17.
 *
 * TransactionItem used by Transactions class to obtain product UPC and Quantity
 *
 */
public class TransactionItem {
    String upc;
    int quantity;

    TransactionItem(String upc){
        this.upc = upc;
        this.quantity = 1;
    }

    TransactionItem(String upc, int quantity){
        this.upc= upc;
        this.quantity = quantity;
    }

    public String getUPC(){
        return upc;
    }

    public int getQuantity(){
        return quantity;
    }

    public void setUPC(String upc){
        this.upc = upc;
    }

    public void setQuantity(int quantity){
        this.quantity = quantity;
    }

}

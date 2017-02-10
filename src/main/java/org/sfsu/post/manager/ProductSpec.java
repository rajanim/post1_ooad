package org.sfsu.post.manager;


/**
 * Created by Vivian on 2/7/17.
 *
 * Used by ProductCatalog class to obtain product UPC, Description, and Price
 */
public class ProductSpec {

    private String itemUPC;
    private String itemDescription;
    private double itemPrice;

    // default constructor
    ProductSpec()
    {
        itemUPC = "0000";
        itemDescription = "N/A";
        itemPrice = 0000.00;
    }

    // constructor
    ProductSpec(String upc, String description, double price)
    {
        itemUPC = upc;
        itemDescription = description;
        itemPrice = price;
    }

    // accessor for a product's UPC
    public String getItemUPC()
    {
        return itemUPC;
    }

    // accessor for product's Description
    public String getItemDescription()
    {
        return itemDescription;
    }

    // accessor method for product's Price
    public double getItemPrice()
    {
        return itemPrice;
    }
}


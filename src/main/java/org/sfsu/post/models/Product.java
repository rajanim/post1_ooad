package org.sfsu.post.models;

/**
 * Created by rajanishivarajmaski1 on 2/8/17.
 */
public class Product {


    String productCode;
    String productName;
    public String getProductCode() {
        return productCode;
    }
    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }
    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    double price;

}



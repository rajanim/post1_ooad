package org.sfsu.post.views;

import org.sfsu.post.models.Customer;

import java.util.HashMap;

/**
 * Created by rajanishivarajmaski1 on 2/8/17.
 */
public class Sale {

    Customer customer;
    HashMap<String, Integer> productQty;
    TransactionType type;
    public Customer getCustomer() {
        return customer;
    }
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    public HashMap<String, Integer> getProductQty() {
        return productQty;
    }
    public void setProductQty(HashMap<String, Integer> productQty) {
        this.productQty = productQty;
    }
    public TransactionType getType() {
        return type;
    }
    public void setType(TransactionType type) {
        this.type = type;
    }
    public TransactionInfo getTransactionInfo() {
        return transactionInfo;
    }
    public void setTransactionInfo(TransactionInfo transactionInfo) {
        this.transactionInfo = transactionInfo;
    }
    TransactionInfo transactionInfo;


}

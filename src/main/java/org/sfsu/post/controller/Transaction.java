package org.sfsu.post.controller;

import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * Ivan Yu
 *
 * Used by POST class to record transactions onto an invoice
 *
 */
public class Transaction {


    private TransactionItem[] transItems;
    private int numTransItems;
    private Payment payment;

    public TransactionItem[] getTransItems() {
        return transItems;
    }

    public int getNumTransItems() {
        return numTransItems;
    }

    public Payment getPayment() {
        return payment;
    }

    public Customer getCustomer() {
        return customer;
    }

    private Customer customer;

    Transaction(){
        transItems = new TransactionItem[100];
        numTransItems = 0;
        customer = new Customer();
    }

    public void setCustomer(Customer customer){
        this.customer = customer;
    }

    public void addTransactionItem(TransactionItem transactionItem){
        if(numTransItems<100) {
            transItems[numTransItems++] = transactionItem;
        }else{
            System.out.println("");
        }
    }

    public boolean notFull(){
        return numTransItems < transItems.length;
    }

    public void setPayment(Payment payment){
        this.payment = payment;
    }

    private int transactionIndex = 0;
    private int flag = 0;
    public String getTransItemsUPC() {
        return transItems[transactionIndex].getUPC();
    }
    public int getTransItemsQuantity(){

        return transItems[transactionIndex].getQuantity();

    }

    public boolean nextTransactionItem() {
        if (numTransItems == 1 && flag == 0){
            flag = 1;
            return true;
        }else if (transactionIndex < (numTransItems - 1) && flag == 0){
            flag = 1;
            return true;
        } else if (transactionIndex < (numTransItems - 1) && flag == 1) {
            transactionIndex++;
            return true;
        }
        return false;
    }

    @Override
    public String toString(){
        //String result = customer.getFirstName() + " " + customer.getLastName() + "\n";
        String result = customer.getFullName() + "\n";
        for(int index = 0; index<numTransItems; index++){
            result += transItems[index].getUPC() + "     " + transItems[index].getQuantity() + "\n";
        }
        DecimalFormat df = new DecimalFormat("#.00");
        //System.out.println(df.format(322.239321));
        return getPayment().getType().equalsIgnoreCase("CREDIT") ?  (result + payment.getType() + " " + df.format(payment.getId())) : (result + payment.getType() + " " + df.format(payment.getAmount()));
    }
}

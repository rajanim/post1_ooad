package org.sfsu.post.views;

/**
 * Created by rajanishivarajmaski1 on 2/8/17.
 */
public class TransactionInfo {

    public TransactionType getType() {
        return type;
    }
    public void setType(TransactionType type) {
        this.type = type;
    }
    TransactionType type;
    private double cash;
    public double getCash() {
        return cash;
    }
    public void setCash(double cash) {
        this.cash = cash;
    }
    public long getCreditCard() {
        return creditCard;
    }
    public void setCreditCard(long creditCard) {
        this.creditCard = creditCard;
    }
    private long creditCard;
    //todo : check?




}

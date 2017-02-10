package org.sfsu.post.controller;

/**
 * Created by ivanyu on 2/7/17.
 *
 * Used by Transaction class to associate customer to a transaction
 *
 */
public class Customer {
    String firstName;
    String lastName;
    String fullName;

    Customer(String fullName){
        this.fullName = fullName;
    }

    Customer(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    Customer(){

    }

    public String getFirstName(){
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public String getFullName(){
        return fullName;
    }
}

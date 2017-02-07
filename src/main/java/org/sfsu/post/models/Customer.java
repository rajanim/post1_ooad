package org.sfsu.post.models;

/**
 * Created by rajanishivarajmaski1 on 2/6/17.
 * 
 */
public class Customer {
    
    
    private String name;
    
    
    /* Default and main constructors */
    public Customer(){
        this.name = "";
    }
    
    public Customer(String name){
        this.name = name;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }
   
    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    } 
}

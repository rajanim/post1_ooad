package org.sfsu.post.controller;

import java.util.Scanner;
import org.sfsu.post.models.Customer;
import org.sfsu.post.models.Payment;


/**
 *
 * @author Steve Tan 2/8/16
 */
public class FrontEndController {
    
    
    private Transaction trans = new Transaction();
    
    
    public FrontEndController(){
        Scanner sc = new Scanner(System.in);
        System.out.println(" Welcome to S-Mart. \n Please enter your name ");
        
        //create customer object;
        String name = sc.nextLine();
        Customer cust = new Customer(name);
        trans.setCustomer(cust);
        
        Boolean repeat = true;
        
        
        //loop ask user for a code or exit        
        while(repeat){
            
            if (trans.numTransItems == 0)
            {
                System.out.println(" Welcome " + name + "! \n Please enter the UPC to get started");
            } else {
                System.out.println(" Please enter the UPC Code or type 'exit' to finish scanning");
            }
            
            // exit clause when user types quit
            String code = sc.nextLine();
            if(code.equals("exit")) {
                repeat = false;
                break;
            }
            
            //create a new transaction item
            TransactionItem item = new TransactionItem(code); 
            
            //Ask user for quantity and set it
            System.out.println(" How many would you like to buy?");
            item.setQuantity(sc.nextInt());
            sc.nextLine();         
            
            //add item to trans
            trans.addTransactionItem(item);        
        }
        
        System.out.println("How would you like to pay? Type 'cash' or 'credit'");
        String type = sc.nextLine();
        
        Payment pay = new Payment(type, trans.getTotal());
        trans.setPayment(pay);

        
    }
    
    
    public Transaction getTransaction(){
        return trans;
    }
    
    
}

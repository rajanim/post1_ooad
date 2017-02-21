package org.sfsu.post.controller;
import java.util.*;
import java.io.*;

/**
 * Created by ivanyu on 2/7/17.
 *
 * TransactionReader is used to read Transactions.txt (for now) to obtain
 * list of transactions used to create an invoice
 *
 */
public class TransactionReader {

    private Scanner sc;
    public TransactionReader(String filename){
        try{
        sc = new Scanner(new File(filename));
        }catch(Exception e){
            System.out.println("File not found");
        }
    }

    public boolean hasMoreTransaction(){
        return sc.hasNextLine();
    }

    // getNextTransaction gets the full transaction of the next customer.
    public Transaction getNextTransaction(){
        String line = "";
        Transaction transaction = new Transaction();

        try{
            // Gets the next customer, then breaks to start a new while loop to gather items.
            while(sc.hasNext()) {
                // if the line corresponds to te customer's name.
                if ((line=sc.nextLine()).matches("[a-zA-Z]+\\s+[a-zA-Z]+")) {
                    transaction.setCustomer(new Customer(line));
                    break;
                }
            }

            // This adds the transaction items to the Transaction object, but stops if the transaction item limit (100) is reached.
            // Note: the  UPC and the quantity can be separated by 5 spaces, or 1 tab and 1 space.
            while(sc.hasNext() &&  (line = sc.nextLine()).matches("([0-9]{4}((\\s{5})|(\t{1}\\s{1}))[0-9]+((\\s+$)|$))|([0-9]{4}(\\s*$|$))"/*[a-zA-Z]+\\s+[0-9]+(\\.)?[0-9]+"*/) && transaction.notFull()){
                //System.out.println("Line: " + line);
                // if the line matches the format: UPC Quantity (where UPC and Quantity are just integers)
                // the last set of number (the quantity) may be followed by \n or spaces followed by \n
                if(line.matches("([0-9]{4}((\\s{5})|(\t{1}\\s{1}))[0-9]+((\\s+$)|$))")){
                    //System.out.println("Line: " + line);
                    String[] lineSplit = line.split("\\s+");
                    if(lineSplit.length < 3){
                        transaction.addTransactionItem(new TransactionItem(lineSplit[0].trim(), Integer.parseInt(lineSplit[1])));
                    }else{
                        System.out.println("Transaction UPC " + lineSplit[0].trim() + " not added because of formatting error");
                    }
                // if line matches the format: UPC (where quantity is not specified so by default it's just 1)
                } else if(line.matches("[0-9]{4}(\\s*$|$)")){
                    //System.out.println("Line (no q): " + line.trim());
                    transaction.addTransactionItem(new TransactionItem(line.trim(), 1));
                } else {
                    //System.out.print("Line: " + line + " | ");
                    System.out.println("Transaction cannot be processed due to formatting error. Line: " + line);
                }
                /*// skip lines only containing spaces.
                if(!(line = sc.nextLine()).matches(".*\\w.*"))
                    continue;
                }*/
            }
            //RETURN HERE AFTER MAKING CASH, CREDIT AND CHECK CLASSES.
            if(line.matches("(((CASH|CREDIT|CHECK)){1}\\s+\\${0,1}[0-9]+\\.{0,1}[0-9]+((\\s+$)|$))"/*|(/CASH/i)\\s+\\${1}[0-9]+\\.{1}[0-9]+")*/)) {
                //System.out.println("Line: " + line);
                if(line.contains("CASH")) {
                    String[] lineSplit = line.split("\\$");
                    transaction.setPayment(new Cash(Float.parseFloat(lineSplit[1])));
                } else if(line.contains("CHECK")) {
                    String[] lineSplit = line.split("\\$");
                    transaction.setPayment(new Check(Float.parseFloat(lineSplit[1])));
                } else if(line.contains("CREDIT")) {
                    String[] lineSplit = line.split("\\s+");
                    transaction.setPayment(new Credit(Integer.parseInt(lineSplit[1])));
                }
                /*
                if (line.contains("CASH") || line.contains("CHECK")) {
                    // splits the entire line by the $ sign, then trim the first string to erase the trailing whitespaces.
                    String[] lineSplit = line.split("\\$");
                    //System.out.println("The cash is " + lineSplit[1]);
                    transaction.setPayment(new Payment(lineSplit[0].trim(), Float.parseFloat(lineSplit[1])));
                } else {
                    //System.out.println("Line: " + line);
                    String[] lineSplit = line.split("\\s+");
                    transaction.setPayment((new Payment(lineSplit[0].trim(), Float.parseFloat(lineSplit[1]))));
                }*/
            }
        }catch(Exception e){
            System.out.println("Error occurred during transaction processing");
            e.printStackTrace();
        }
        return transaction;
    }
}

class TransactionReaderTest{
    public static void main(String[] args){
        try {
            testGetNextTransaction();
        }catch(Exception e){
            System.out.println("TEST FAILED");
            e.printStackTrace();
        }
    }

    private static void testGetNextTransaction(){
        TransactionReader tr = new TransactionReader("/Users/ivanyu/IdeaProjects/post1_subgroup1/src/main/java/org/sfsu/post/controller/transactionExample.txt");
        while(tr.hasMoreTransaction()){
            System.out.println(tr.getNextTransaction() + "\n");
        }
    }
}

import java.io.*;
import java.util.Scanner;

public class TransactionReader {
   public Scanner sc;
   public String curLine;
   
   //Constructor 
   public TransactionReader(String filename){
	  
	   try{
		   sc=new Scanner(new FileReader(filename));
		   
	   }catch(Exception e){
		   System.err.println(e.getMessage());
	   }
   }
   
   //Check if there is more items on the Transaction
   public boolean hasMoreTransaction(){
	  
	   try{
		   curLine= sc.nextLine();
		   
		   if(curLine == null || (curLine.contains("CASH") &&
				   curLine.contains("CHECK") &&
				   curLine.contains("CARD"))){
			   
			   return false;
		   }
	   }catch(Exception e){
		   System.err.println(e.getMessage());
	   }  
	   
	   return true;
   }
   
   //Setting up Transaction Object
   public Transaction getNextTransaction(){
	   Transaction nextTrans= new Transaction();
	   
	   try{
		   //Set Customer Names 
		   Customer person= new Customer(sc.nextLine());
		   nexTtrans.setCustomer(person);  
		   
		   //Set Items
		   while(hasMoreTransaction()){
			   
			   //Reading Item and UPC from file
			   TransactionItem item;
			   String itemAndUPC[]= curLine.split("\\s{2,}");
			   
			   if(itemAndUPC.length == 2){
				   item= new TransactionItem(itemAndUPC[0], 
						   Integer.parseInt(itemAndUPC[1]));
			   }else{
				   item= new TransactionItem(itemAndUPC[0],1);
			   }
			   
			   nextTrans.addTransactionItem(item);
		   }
		   
		   curLine= sc.nextLine();
		   //Set Payment
		   Payment pay;
		   //Reading Payment Type
		   String payType[]= curLine.split(" +");
		   String type= payType[0];
		   switch (type){
		        case "CARD":
		           pay = new Payment(type,Double.parseDouble(paymentSplit[1]));
		        default:
		           pay = new Payment(type, Double.parseDouble(paymentSplit[1]));

	       }
		   nextTrans.setPayment(pay);
		   
		   
	   }catch(Exception e){
		  System.err.println(e.getMessage());
	   }
	   
	   sc.close();
	   return nextTrans;
   }
}


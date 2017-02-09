
public class Transaction {
   public TransactionItem[] transItems;
   public int size= 100;
   public int numTransItems;
   // private Payment payment;
   // private Customer customer;
   
   //Constructor
   public Transaction(){
	   this.transItems= new TransactionItem[size];
	   this.numTransItems=0;
	   //this.payment= new Payment(null, 0.0);
	   //this.customer=new Customer(null);
   }
   
   //Set Customer Object
   /*public void setCustomer(Customer customer){
	   this.customer= customer;
   }*/
   
   //Add items to TransactionItem's object array
   public void addTransactionItem(TransactionItem items){
	   this.transItems[numTransItems]= items;
	   this.numTransItems++;
   }
   
   //???
   /*public boolean notFull(){
	   return true;
   }*/
   
   //Set Payment Object
   /*public void setPayment(Payment pay){
	   payment=pay;
   }*/
   
   //???
   /*public void toString(){
	   
   }*/
   
}

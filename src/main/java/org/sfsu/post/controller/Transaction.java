
public class Transaction {
   public TransactionItem[] transItems;
   public int size= 100;
   public int numTransItems;
   public Payment payment;
   public Customer customer;
   
   //Constructor
   public Transaction(){
	   this.transItems= new TransactionItem[size];
	   this.numTransItems=0;
	   this.payment= new Payment(null, 0.0);
	   this.customer=new Customer(null);
   }
   
   //Set Customer Object
   public void setCustomer(Customer customer){
	   this.customer= customer;
   }
   
   //Add items to TransactionItem's object array
   public void addTransactionItem(TransactionItem items){
	   this.transItems[numTransItems]= items;
	   this.numTransItems++;
   }
   
   //Not Needed for Now
   /*public boolean notFull(){
	   return true;
   }*/
   
   //Set Payment Object
   public void setPayment(Payment pay){
	   payment=pay;
   }
   
   //Not Needed for Now
   /*public void toString(){
	   
   }*/
   
}

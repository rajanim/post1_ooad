
public class TransactionItem {
   public String UPC;
   public int quantity;
   
   //Constructor 1
   public TransactionItem(String UPC){
	   this.UPC= UPC;
   }
   
   //Constructor 2
   public TransactionItem(String UPC, int quantity){
	   this.UPC=UPC;
	   this.quantity=quantity;
   }
   
   //*** Getter and Setter for UPC and quantity ***//
   public String getUPC(){
	   return UPC;
   }
   
   public int getQuantity(){
      return quantity;   
   }
   
   public void setUPC(String UPC){
	  this.UPC= UPC;
   }
   
   public void setQuantity(int quantity){
	  this.quantity=quantity;
   }
   
}
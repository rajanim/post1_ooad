
package org.sfsu.post.util;

import org.sfsu.post.manager.*;
import org.sfsu.post.controller.*;
import org.sfsu.post.controller.Transaction;

import java.io.*;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * Rainier Hui
 * Vivian Lee
 *
 * POST: Point Of Sale Terminal
 *
 * Init by Manager class
 *
 * POST class creates invoice (invoice.txt) for customer
 *
 */
public class POST {
    private Store store;
    private File invoicetxt;
    private ProductCatalog productCatalog;
    private ProductReader productReader;
    String invoiceLog = "";

    private TransactionReader transactionReader;

    public POST (Store store, TransactionReader transactionReader){
        this.store = store;
        this.productCatalog = store.makeCatalog();
        this.transactionReader = transactionReader;

        try {
            invoice(store);
            invoiceMaker();
        }catch (IOException e) {
            e.printStackTrace();
        }

    }

    // Formats the string for compiling all receipts produced from Transaction.txt.
    private void invoice(Store store) throws IOException {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

        while (transactionReader.hasMoreTransaction() == true){
            Date date = new Date();
            Transaction tempTransaction = transactionReader.getNextTransaction();

            String transactionLog = (store.getStoreName() +"\n\n" +
                    String.format("%-15s %-6s",
                    tempTransaction.getCustomer().getFullName(), dateFormat.format(date) +"\n"));

            String[] currentUPC = new String[100];
            String[] currentItem = new String[100];
            int[] currentItemQuantity = new int[100];
            Double[] currentItemPrice = new Double[100];
            Double[] subTotal = new Double[100];
            Double realTotal = 0.0;
            NumberFormat formatter = new DecimalFormat("#0.00");

            int i = 0;

            // Store UPC and Quantity into arrays
            while (tempTransaction.nextTransactionItem() == true){
                currentUPC[i] = tempTransaction.getTransItemsUPC();
                currentItemQuantity[i] = tempTransaction.getTransItemsQuantity();
                i++;
            }

            // Get Item Names and Name Price
            for (int j = 0; currentUPC[j] != null; j++){
                if (productCatalog.validUPC(currentUPC[j])) {
                    currentItem[j] = productCatalog.getProduct(currentUPC[j]).getItemDescription();
                    currentItemPrice[j] = productCatalog.getProduct(currentUPC[j]).getItemPrice();
                } else {
                    currentItem[j] = "Invalid UPC";
                    currentItemPrice[j] = 0.0;
                }

                // Calculate Subtotals of items
                subTotal[j] = (currentItemPrice[j] * currentItemQuantity[j]);
                if (currentItemPrice[j] != 0.0) {
                    transactionLog = transactionLog + String.format("%-15s %6s @ %8s %8s\n",
                            currentItem[j], currentItemQuantity[j], formatter.format(currentItemPrice[j]),
                            formatter.format((subTotal[j])));
                }else if (currentItemPrice[j] == 0.0) {
                    transactionLog += String.format("%-15s\n",
                            currentItem[j]);
                }
            }

            // Get the total amount due
            for (int k = 0; subTotal[k] != null; k++) {
                realTotal += subTotal[k];
            }

            transactionLog = String.format("%s------------\n%16s %25s", transactionLog, "Total:","$" + formatter.format(realTotal));

            // Differentiate between different types of payments
            Payment paymentType = tempTransaction.getPayment();
            if (paymentType.getType().toUpperCase().equals("CASH")) {
                transactionLog += String.format("\nAmount Tendered: %25s",formatter.format(tempTransaction.getPayment().getAmount()));
                transactionLog += String.format("\nAmount Returned: %28s", formatter.format((tempTransaction.getPayment().getAmount() - realTotal)) +"\n\n\n");

            } else if (paymentType.getType().equals("CHECK")) {
                transactionLog += String.format("\n%45s", "Paid by Check\n\n\n");
            } else if (paymentType.getType().equals("CREDIT")) {

                transactionLog += validateCredit(tempTransaction) +"\n\n\n";
            }


            invoiceLog += transactionLog;
            System.out.print(transactionLog);
        }
        invoiceMaker();
    }

    // Simulate 10% decline for Credit cards
    public String validateCredit(Transaction transaction) {
        Random rand = new Random();
        int n = rand.nextInt(10);

        if (n == 1) {
            return String.format("\n%16s %25s", "Credit Card#:", "Declined");
        }

        DecimalFormat df = new DecimalFormat("#");

        return String.format("\n%16s %25s", "Credit Card#:", df.format((transaction.getPayment().getAmount())));
    }

    //Copies the contents of invoiceLog into invoice.txt
    public void invoiceMaker()throws  IOException{
        //File invoice = new File("src/invoice.txt");
        File invoice = new File("/Users/ivanyu/Documents/fe.txt");
        try {
            FileOutputStream stream = new FileOutputStream(invoice);
        } catch (FileNotFoundException e) {
            System.out.println("Failed to create invoice file");
            e.printStackTrace();
        }
        FileWriter fw = null;
        fw = new FileWriter(invoice);

        BufferedWriter bw = new BufferedWriter(fw);
        // write in file

        bw.write(invoiceLog);
        // close connection
        bw.close();
    }

    public static void main(String[] args) throws IOException{
        POST p = new POST(new Store(), new TransactionReader("/Users/ivanyu/IdeaProjects/post1_subgroup1/src/main/java/org/sfsu/post/controller/transactionExample.txt"));
        p.invoiceMaker();
    }

}
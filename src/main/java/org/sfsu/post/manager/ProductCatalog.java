package org.sfsu.post.manager;

/**
 * Created by adisonlee on 2/7/17.
 *
 * Init by Store
 *
 * ProductCatalog used by Store to create a product catalog
 **/
public class ProductCatalog
{
    private ProductSpec productCatalog[];
    private int productLineCount;
    private int maxProductsInCatalog = 100;

    // default constructor
    ProductCatalog()
    {
        productCatalog = new ProductSpec[maxProductsInCatalog];
        productLineCount = 0;
    }

    // adds one product w/ specs into catalog
    void addProduct(ProductSpec product)
    {
        if(productLineCount < maxProductsInCatalog)
        {
            productCatalog[productLineCount++] = product;
        }
        else
        {
            System.out.println("Catalog is full.");
        }
    }

    // check if given UPC exist in product catalog
    public boolean validUPC(String productUPC)
    {
        for(int i = 0; i < productLineCount; i++)
        {
            if(productCatalog[i].getItemUPC().equals(productUPC))
            {
                return true;
            }
        }
        return false;
    }

    // V: added method to retrieve ProductSpec
    public ProductSpec getProduct(String productUPC){
        for(int i = 0; i < productLineCount; i++){
            if(productUPC.equals(productCatalog[i].getItemUPC())){
                return productCatalog[i];
            }
        }
        return null;
    }

    // returns true if catalog reaches 100 lines
    boolean productCatalogIsFull()
    {
        return productLineCount == maxProductsInCatalog;
    }

    // prints formatted catalog onto console
    void displayProductCatalog()
    {
        ProductSpec printProductSpecs;
        for(int i = 0; i < productLineCount; i++)
        {
            printProductSpecs = productCatalog[i];
            System.out.printf("%-10s%-15s%-10s\n", printProductSpecs.getItemUPC(), printProductSpecs.getItemDescription(), printProductSpecs.getItemPrice());
        }
    }

}

package org.sfsu.post.manager;

/**
 * Vivian Lee
 *
 * Used by Manager class to make product catalog
 *
 */
public class Store {

    private String storeName;
    private String storeAddr;

    public Store() {
        storeName = "My Store";
        storeAddr = "My Address";
    }

    public String getStoreName() {
        return storeName;
    }

    public String getStoreAddr() {
        return storeAddr;
    }

    public ProductCatalog makeCatalog() {
        ProductReader productReader = new ProductReader();
        ProductCatalog productCatalog = new ProductCatalog();

        while(productReader.hasMoreProducts()) {
           productCatalog.addProduct(productReader.getNextProduct());
        }

        return productCatalog;
    }

}

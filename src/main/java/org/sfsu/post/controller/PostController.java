package org.sfsu.post.controller;

import org.sfsu.post.manager.PostManager;
import org.sfsu.post.views.Sale;

/**
 * Created by rajanishivarajmaski1 on 2/6/17.
 */
public class PostController {

    PostManager manager;
    public static void main(String[] args) {

        //assuming front end method will provide Sale object.
        Sale saleInfo = PostController.getSaleInfo();
        org.sfsu.post.models.Sale sale = getSaleModel(saleInfo);
        PostController controller = new PostController();
        controller.logNewSale(sale);
    }
    private static org.sfsu.post.models.Sale getSaleModel(Sale saleInfo) {
        //todo parse sales view and convert to sale model.
        return null;
    }
    private static Sale getSaleInfo() {
        //todo create a dummy sale info object which is suppose to come from UI layer in future
        return null;

    }
    public void logNewSale(org.sfsu.post.models.Sale sale) {
         manager = new PostManager();
        manager.recordSale(sale);
    }

    public void generateInvoice(){
        manager = new PostManager();
        manager.writeInvoiceToFile();

    }
}

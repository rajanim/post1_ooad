package org.sfsu.post.manager;

import org.sfsu.post.controller.TransactionReader;
import org.sfsu.post.util.POST;

/**
 * Created by Vivian on 2/8/17.
 *
 * Program starts here; Manager initializes Store and Post.
 */
public class Manager {
    private Store store;
    private POST post;
    private TransactionReader tr;


    public void openStore() {
        store = new Store();
        store.makeCatalog();

        tr = new TransactionReader("src/Transactions.txt");

        post = new POST(store, tr);
    }

    public static void main (String args[]) {
        Manager manager = new Manager();
        manager.openStore();
    }
}

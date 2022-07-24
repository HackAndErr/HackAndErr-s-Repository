package Marketplace;

import java.util.HashMap;

public class Storage {
    static HashMap<Integer, User> users = new HashMap<>();
    static {
        //Test cases
//        users.put(0, new User(0, "Tom", "Smith", 32));
//        users.put(1, new User(1, "Josef", "Shakespear", 700));
//        users.put(2, new User(2, "Ivan", "Mazepa", 2408));
    }

    static HashMap<Integer, Product> products = new HashMap<>();
    static {
        //Test cases
//        products.put(0, new Product(0, "Apple", 17));
//        products.put(1, new Product(1, "Banana", 25));
//        products.put(2, new Product(2, "Peach", 30));
    }
}

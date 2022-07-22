package Marketplace;

import java.util.ArrayList;

public class Lists {
    static ArrayList<User> userList = new ArrayList<>();
    static {
        userList.add(new User(0, "Tom", "Smith", 32));
        userList.add(new User(1, "Josef", "Shakespear", 700));
        userList.add(new User(2, "Ivan", "Mazepa", 2408));
    }

    static ArrayList<Product> productList = new ArrayList<>();
    static {
        productList.add(new Product(0, "Apple", 17));
        productList.add(new Product(1, "Banana", 25));
        productList.add(new Product(2, "Peach", 30));
    }
}

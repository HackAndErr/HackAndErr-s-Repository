package Marketplace;

import java.util.HashMap;
import java.util.Scanner;

public class Menu {

        static HashMap<Integer, User> users = Storage.users;
        static HashMap<Integer, Product> products = Storage.products;




    public static void openMenu(){


        Scanner scanner = new Scanner(System.in);

        loop: while(true){

            System.out.println("Choose your operation:");
            System.out.println("1. Display list of all users");
            System.out.println("2. Display list of all products");
            System.out.println("3. Buy a product");
            System.out.println("4. Display list of user products by user id");
            System.out.println("5. Display list of users that bought product by product id");
            System.out.println("q. Stop the program");
            System.out.print("Enter an operation's number (or q): ");

            String chosen = scanner.nextLine();

            switch (chosen){
                case "1": show("List of all users:", users); break;
                case "2": show("List of all products", products); break;
                case "3":
                    System.out.print("Enter user's id: ");
                    int uid = Integer.parseInt(scanner.nextLine());
                    System.out.print("Enter product's id: ");
                    int pid = Integer.parseInt(scanner.nextLine());
                    buyProduct(uid, pid);
                    break;
                case "4":
                    System.out.print("Enter user's id: ");
                    uid = Integer.parseInt(scanner.nextLine());
                    displayUserShoppingCart(uid);
                    break;
                case "5":
                    System.out.print("Enter product's id: ");
                    pid = Integer.parseInt(scanner.nextLine());
                    displayListOfUsersThatBoughtProduct(pid);
                    break;
                case "q": break loop;
            }
        }

    }

    public static <T> void show(String message, HashMap<Integer, T> map){
        System.out.println(message);
        for(int elem : map.keySet()){
            System.out.println(map.get(elem));
        }

        System.out.println();
    }

    public static void buyProduct(int userId, int productId){


        if(!users.containsKey(userId)){
            System.out.println("User hasn't been found. Check your id\n");
            return;
        }

        if(!products.containsKey(productId)){
            System.out.println("Product hasn't been found. Check your id\n");
            return;
        }

        User curUser = users.get(userId);
        Product curProduct = products.get(productId);

        try {
            curUser.setAmountOfMoney(curUser.getAmountOfMoney() - curProduct.getPrice());
            curUser.addNewProductToShoppingCart(curProduct);
            System.out.println("Purchase successful\n");
        } catch (NotEnoughMoneyException e) {
            System.out.println("Not enough money\n");
        }

    }

    public static void displayUserShoppingCart(int userId){
        if(!users.containsKey(userId)){
            System.out.println("User hasn't been found. Check your id\n");
            return;
        }
        User curUser = users.get(userId);

        HashMap<Product, Integer> shoppingCart = curUser.getShoppingCart();
        for(Product product : shoppingCart.keySet()){
            String productStr = product.toString();
            String amountStr = shoppingCart.get(product).toString();
            System.out.println(productStr + " ✕ " + amountStr);
        }
        System.out.println();
    }

    public static void displayListOfUsersThatBoughtProduct(int productId){
        if(!products.containsKey(productId)){
            System.out.println("Product hasn't been found. Check your id\n");
            return;
        }
        Product curProduct = products.get(productId);

        for(int user : users.keySet()){
            if(users.get(user).getShoppingCart().containsKey(curProduct)){
                System.out.println(users.get(user));
            }
        }
        System.out.println();
    }
}

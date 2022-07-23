package Marketplace;

import java.util.HashMap;
import java.util.Random;
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
            System.out.println("6. Add new user");
            System.out.println("7. Add new product");
            System.out.println("8. Delete the user");
            System.out.println("9. Delete the product");
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
                case "6":
                    addNewUser("", "", 1);
                    break;
                case "7":
                    addNewProduct("", 1);
                    break;
                case "8":
                    System.out.print("Enter user's id: ");
                    uid = Integer.parseInt(scanner.nextLine());
                    deleteUser(uid);
                    break;
                case "9":
                    System.out.print("Enter product's id: ");
                    pid = Integer.parseInt(scanner.nextLine());
                    deleteProduct(pid);
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

    public static void addNewUser(String firstName, String lastName, double amountOfMoney){

        if(firstName == null || lastName == null){
            System.out.println("The name is incorrect");
            return;
        }

        if(amountOfMoney < 0){
            System.out.println("An amount of money cannot be below zero");
            return;
        }

        int id = users.size(); //Giving the id next after last element of users map

        users.put(id, new User(id, firstName, lastName, amountOfMoney));
    }

    public static void addNewProduct(String name, double price){

        if(name == null){
            System.out.println("The name is incorrect");
            return;
        }

        if(price < 0){
            System.out.println("A price cannot be below zero");
            return;
        }

        int id = products.size(); //Giving the id next after last element of products map

        products.put(id, new Product(id, name, price));
    }

    public static void deleteUser(int userId){
        if(!users.containsKey(userId)){
            System.out.println("User hasn't been found\n");
            return;
        }

        users.remove(userId);
        System.out.println("User has been successfully deleted\n");
    }

    public static  void deleteProduct(int productId){
        if(!products.containsKey(productId)){
            System.out.println("Product hasn't been found\n");
            return;
        }

        products.remove(productId);

//        for(int user : users.keySet()){
//            HashMap<Integer, Product> shoppingCart = users.get(user).getShoppingCart();
//        }

        System.out.println("Product has been successfully deleted\n");
    }
}

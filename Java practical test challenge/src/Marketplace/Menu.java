package Marketplace;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;
import java.util.Scanner;

public class Menu {

        private static ArrayList<User> userList = Lists.userList;
        private static ArrayList<Product> productList = Lists.productList;




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
                case "1": show("List of all users:", userList); break;
                case "2": show("List of all products", productList); break;
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

    public static <T> void show(String message, ArrayList<T> list){
        System.out.println(message);
        for(T elem : list){
            System.out.println(elem);
        }

        System.out.println();
    }

    public static void buyProduct(int userId, int productId){

        Optional<User> curUserOpt = Util.findObjectById(userId, userList);
        if(!curUserOpt.isPresent()){
            System.out.println("User hasn't been found. Check your id.");
            return;
        }
        User curUser = curUserOpt.get();

        Optional<Product> curProductOpt = Util.findObjectById(productId, productList);
        if(!curProductOpt.isPresent()){
            System.out.println("Product hasn't been found. Check your id.");
            return;
        }
        Product curProduct = curProductOpt.get();

        try {
            curUser.setAmountOfMoney(curUser.getAmountOfMoney() - curProduct.getPrice());
            curUser.addNewProductToShoppingCart(curProduct);
            System.out.println("Purchase successful\n");
        } catch (NotEnoughMoneyException e) {
            System.out.println("Not enough money\n");
        }

    }

    public static void displayUserShoppingCart(int userId){
        Optional<User> curUserOpt = Util.findObjectById(userId, userList);
        if(!curUserOpt.isPresent()){
            System.out.println("User hasn't been found. Check your id.");
            return;
        }
        User curUser = curUserOpt.get();

        HashMap<Product, Integer> shoppingCart = curUser.getShoppingCart();
        for(Product product : shoppingCart.keySet()){
            String productStr = product.toString();
            String amountStr = shoppingCart.get(product).toString();
            System.out.println(productStr + " ✕ " + amountStr);
        }
        System.out.println();
    }

    public static void displayListOfUsersThatBoughtProduct(int productId){
        Optional<Product> curProductOpt = Util.findObjectById(productId, productList);
        if(!curProductOpt.isPresent()){
            System.out.println("Product hasn't been found. Check your id.");
            return;
        }
        Product curProduct = curProductOpt.get();

        for(User user : userList){
            if(user.getShoppingCart().containsKey(curProduct)){
                System.out.println(user);
            }
        }
        System.out.println();
    }
}

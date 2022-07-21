package Marketplace;


import java.util.ArrayList;
import java.util.Scanner;

public class Menu {


        static ArrayList<Product> productList = new ArrayList<>();
        static {
            productList.add(new Product(1, "Apple", 17));
            productList.add(new Product(2, "Banana", 25));
            productList.add(new Product(3, "Peach", 30));
        }

        static ArrayList<User> userList = new ArrayList<>();
        static {
            userList.add(new User(1, "Tom", "Smith", 350));
            userList.add(new User(2, "Josef", "Shakespear", 700));
            userList.add(new User(3, "Ivan", "Mazepa", 2408));
        }

    public static void openMenu(){


        Scanner scanner = new Scanner(System.in);

        loop: while(true){

            System.out.println("Choose your operation:");
            System.out.println("1. Display list of all users");
            System.out.println("2. Display list of all products");
            System.out.println("3. Buy a product");
            System.out.println("q. Stop the program");

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
        User curUser = null;
        Product curProduct = null;

        for(User user : userList){
            if(user.getId() == userId){
                curUser = user;
                break;
            }
        }

        if(curUser == null){
            System.out.println("User hasn't been found. Check your id.");
            return;
        }

        for(Product product : productList){
            if(product.getId() == productId){
                curProduct = product;
                break;
            }
        }

        if(curProduct == null){
            System.out.println("Product hasn't been found. Check your id.");
            return;
        }



        if(curUser.getAmountOfMoney() < curProduct.getPrice()){
            System.out.println("Not enough money\n");
            return;
        }

        curUser.setAmountOfMoney(curUser.getAmountOfMoney() - curProduct.getPrice());
        System.out.println("Purchase successful\n");


    }

}

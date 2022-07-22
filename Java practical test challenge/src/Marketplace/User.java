package Marketplace;

import java.util.ArrayList;
import java.util.HashMap;

public class User implements Id{
    private int id;
    private String firstName;
    private String lastName;
    private double amountOfMoney;
    private HashMap<Product, Integer> shoppingCart = new HashMap<>();

//Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getAmountOfMoney() {
        return amountOfMoney;
    }

    public void setAmountOfMoney(double amountOfMoney) throws NotEnoughMoneyException {

        if(amountOfMoney < 0) throw new NotEnoughMoneyException();

        this.amountOfMoney = amountOfMoney;
    }

    public HashMap<Product, Integer> getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(HashMap<Product, Integer> shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public void addNewProductToShoppingCart(Product product){
        if(!shoppingCart.containsKey(product)){
            shoppingCart.put(product, 1);
            return;
        }

        int amount = shoppingCart.get(product);
        amount++;
        shoppingCart.put(product, amount);
    }

//Constructor
    public User(int id, String firstName, String lastName, double amountOfMoney){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.amountOfMoney = amountOfMoney;
    }

    @Override
    public String toString(){
        return firstName + " " + lastName;
    }

}

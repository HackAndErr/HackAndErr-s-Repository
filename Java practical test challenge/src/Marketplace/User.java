package Marketplace;

import java.util.ArrayList;

public class User {
    private int id;
    private String firstName;
    private String lastName;
    private double amountOfMoney;
    private ArrayList<Product> shoppingCart;

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

    public void setAmountOfMoney(double amountOfMoney) {
        this.amountOfMoney = amountOfMoney;
    }

    public ArrayList<Product> getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ArrayList<Product> shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

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

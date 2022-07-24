package Marketplace;

import java.util.HashMap;

public class User{
    private int id;
    private String firstName;
    private String lastName;
    private double amountOfMoney;

    /*Initialising a shopping cart as a map: key is product's id and value is
    amount of this product that user has bought
     */
    private HashMap<Integer, Integer> shoppingCart = new HashMap<>();

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

    public HashMap<Integer, Integer> getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(HashMap<Integer, Integer> shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public void addNewProductToShoppingCart(int productId){
        //Buying the current product for a first time
        if(!shoppingCart.containsKey(productId)){
            shoppingCart.put(productId, 1);
            return;
        }

        //As user buys the same product again, an amount of it in his shopping cart increases
        int amount = shoppingCart.get(productId);
        amount++;
        shoppingCart.put(productId, amount);
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

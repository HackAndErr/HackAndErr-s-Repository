package Marketplace;

public class NotEnoughMoneyException extends Exception{
    NotEnoughMoneyException(){
        super("Not enough money");
    }
}

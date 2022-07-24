package Marketplace;

public class Util {

    //If scanner entry is illegal, an exception will be thrown
    static int getNumber(String input) throws NumberFormatException{
            try{
                return Integer.parseInt(input);
            } catch(NumberFormatException e){
                System.out.println("Wrong type of input. Enter an integer number");
                return -1;
            }
    }
}

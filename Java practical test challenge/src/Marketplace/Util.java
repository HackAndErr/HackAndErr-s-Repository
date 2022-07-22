package Marketplace;

import java.util.ArrayList;
import java.util.Optional;

public class Util {
    public static <T extends Id> Optional<T> findObjectById(int id, ArrayList<T> list){
        for(T obj : list){
            if(obj.getId() == id) return Optional.of(obj);
        }
        return Optional.empty();
    }

}

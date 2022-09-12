package org.algorithms;

import java.util.Arrays;
import java.util.Comparator;

public class PersonArrays {
    enum SortingTypes {
        BY_AGE,
        BY_HEIGHT,
        BY_WEIGHT
    }

    public static void sort(Person[] people, SortingTypes sortBy){
        switch (sortBy) {
            case BY_AGE:
                Arrays.sort(people, Comparator.comparingInt(Person::getAge));
                break;
            case BY_HEIGHT:
                Arrays.sort(people, Comparator.comparingInt(Person::getHeight));
                break;
            case BY_WEIGHT:
                Arrays.sort(people, Comparator.comparingInt(Person::getWeight));
                break;
        }
    }

    public static int countSameWeightDifHeight(Person[] people){
        int res = 0;
        Person[] arr = Arrays.copyOf(people, people.length);

        //Спочатку позбавимося від користувачів у масиві, що повторюються за зростом та вагою
        for(int i = 0; i<arr.length; i++){
            if(arr[i] == null) continue;
            for(int j = i+1; j<arr.length; j++){
                if(arr[j] != null  &&
                arr[i].getWeight() == arr[j].getWeight() &&
                arr[i].getHeight() == arr[j].getHeight()){
                    arr[j] = null;
                }
            }

        }

        for(int i = 0; i<arr.length; i++){
            if(arr[i] == null) continue;
            boolean found = false;
            for(int j = i+1; j<arr.length; j++){
                if(arr[j] != null &&  arr[i].getWeight() == arr[j].getWeight() ){
                    found = true;
                    res++;
                    arr[j] = null;
                }
            }
            if(found) res++;
        }
        return res;
    }


}



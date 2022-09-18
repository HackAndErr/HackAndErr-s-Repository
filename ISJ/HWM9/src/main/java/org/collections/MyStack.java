package org.collections;

import java.util.Arrays;

public class MyStack <T>{
    private T[] array = (T[]) new Object[0];

    public void push(T value){
        array = Arrays.copyOf(array, array.length+1);
        array[array.length-1] = value;
    }

    public void remove(int index){
        for(int i = index; i < array.length-1; i++){
            array[i] = array[i+1];
        }
        array[array.length-1] = null;
        array = Arrays.copyOf(array, array.length-1);
    }

    public void clear(){
        for(int i = 0; i < array.length; i++){
            array[i] = null;
        }
        array = Arrays.copyOf(array, 0);
    }

    public int size(){
        return array.length;
    }

    public T peek(){
        return array[array.length-1];
    }

    public T pop(){
        T res = peek();
        array[array.length-1] = null;
        array = Arrays.copyOf(array, array.length-1);
        return res;
    }
}

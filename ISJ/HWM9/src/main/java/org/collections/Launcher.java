package org.collections;

import java.util.*;

public class Launcher {
    public static void main(String[] args) {

//        MyArrayList<String> mal = new MyArrayList<>();
//        mal.add("Lol");
//        mal.add("Sus");
//        mal.add("Amogus");
//        mal.add("SusAmogus");
//        mal.add("AmogusLol");
//        mal.add("AmoSusGus");
//
//        System.out.println(mal.get(3));
//
//        mal.remove(3);
//
//        System.out.println(mal.get(3));
//        System.out.println(mal.size());
//        mal.clear();
//        System.out.println(mal.size());
//
//
//
//        MyStack<Person> stack = new MyStack<>();
//        stack.push(new Person("John", 25));
//        stack.push(new Person("Ben", 45));
//        stack.push(new Person("Snoop", 21));
//
//        stack.remove(1);
//        System.out.println(stack.pop());
//        stack.peek();
//
//
//        MyLinkedList<String> mll = new MyLinkedList<>();
//        mll.add("Welp");
//        mll.add("Lolp");
//        mll.add("Okay3");
//        mll.add("Okay4");
//        mll.add("Okay5");
//        mll.add("Okay6");
//        mll.add("Okay7");
//        mll.add("Okay8");
//
//        for(int i = 0; i < mll.size(); i++){
//            System.out.println(mll.get(i));
//        }
//
//        System.out.println();
//        mll.remove(2);
//        mll.remove(5);
//
//        for(int i = 0; i < mll.size(); i++){
//            System.out.println(mll.get(i));
//        }
//
//        mll.clear();
//
//        System.out.println(mll.get(0));
//
//        System.out.println();
//
        MyHashMap<String, String> mhm = new MyHashMap<>();


        mhm.put("Lol", "Kek");
        mhm.put("Lol", "Well");
        mhm.put("Lolp", "Wellp");
        mhm.put("Lolp", "Wellpppp");

        mhm.remove("Lol");

        System.out.println(mhm.get("Lol"));
        System.out.println(mhm.get("Lolp"));

        mhm.put("Lol", "Test");
        System.out.println(mhm.get("Lol"));

        mhm.put("Lolol", "Welp");
        mhm.put("Test", "TestTest");
        System.out.println("TestTest456".hashCode());
        mhm.put("TestTest456", "TestTestTest");

        System.out.println(mhm.size());
        mhm.clear();
        System.out.println(mhm.size());

//        MyQueue<String> mq = new MyQueue<>();
//
//        mq.add("1");
//        mq.add("12");
//        mq.add("123");
//        mq.add("1234");
//        mq.add("12345");
//        mq.add("123456");
//
//        while (mq.size() != 0){
//            System.out.println("Size is " + mq.size());
//            System.out.println(mq.pop());
//        }





    }
}

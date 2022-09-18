package org.collections;

import java.util.Iterator;

public class MyLinkedList <T>{

    private Node <T> firstEl = null;
    private Node<T> lastEl = null;
    private int iterator = 0;
    private int size = 0;

    private class Node <T> {
        private T curEl;
        private Node<T> prevNode;
        private Node<T> nextNode;

        Node(T curEl, Node<T> prevNode){
            this.curEl = curEl;
            this.prevNode = prevNode;
            this.nextNode = null;
        }

        Node(T curEl){
            this.curEl = curEl;
        }
    }
    
    private Node<T> findNode(int index){
        Node<T> temp = firstEl;
        for(int i = 0; i<index; i++){
            temp = temp.nextNode;
        }
        return temp;
    }

    public void add(T value){
        if(size == 0){
            firstEl = new Node<>(value);
            lastEl = firstEl;
        } else{
            Node<T> newNode = new Node<>(value, lastEl);
            lastEl.nextNode = newNode;
            lastEl = newNode;
        }

        size++;
    }

    public void remove(int index){
        Node<T> toRemove = findNode(index);
        Node<T> prev = toRemove.prevNode;
        Node<T> next = toRemove.nextNode;

        prev.nextNode = next;

        size--;
    }

    public void clear(){
        Node<T> temp = firstEl;
        for(int i = 0; i < size; i++){
            Node<T> next = temp.nextNode;
            temp.prevNode = null;
            temp.curEl = null;
            temp.nextNode = null;
            temp = next;
        }
        size = 0;
    }

    public int size(){
        return size;
    }

    public T get(int index){
        
        return findNode(index).curEl;
    }

}

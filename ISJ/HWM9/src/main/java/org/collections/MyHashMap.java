package org.collections;

public class MyHashMap <K,V> {
    private final int BUCKETS_AMOUNT = 16;

    private final Node[] buckets = new Node[BUCKETS_AMOUNT];

    public MyHashMap(){

    }

    private class Node <K,V>{
        K key;
        V value;
        Node<K,V> next;

        Node(K key, V value){
            this.key = key;
            this.value = value;
        }
    }

    private boolean checkKeysEquality(K key1, K key2){
        //Так як оператор if - "лінивий", то спочатку перевіримо хеш-коди, якщо вони
        //збігаються, то застосуємо також equals. Таким чином ми забезпечуємо економію часу.
        return key1.hashCode() == key2.hashCode() && key1.equals(key2);
    }

    private void clearNode(Node<K,V> node){
        node.key = null;
        node.value = null;
        node.next = null;
    }

    public void put(K key, V value){
        int bucketNumber = Math.abs(key.hashCode() % (BUCKETS_AMOUNT-1));

        if(buckets[bucketNumber] == null){
            buckets[bucketNumber] = new Node(key, value);
        } else{
            Node<K,V> curNode = buckets[bucketNumber];
            boolean foundSameKey = false;
            K curKey = null;
            while(curNode != null){
                curKey = curNode.key;

                if(checkKeysEquality(curKey, key)){
                    curNode.value = value;
                    foundSameKey = true;
                    break;
                }
                curNode = curNode.next;
            }
            if(!foundSameKey){
                curNode.next = new Node<>(key, value);
            }
        }
    }

    public void remove(K key){
        int bucketNumber = key.hashCode() % (BUCKETS_AMOUNT-1);
        Node<K,V> curNode = buckets[bucketNumber];
        Node<K,V> prevNode = null;
        K curKey = curNode.key;

        if(checkKeysEquality(curKey, key)){
            buckets[bucketNumber] = curNode.next;
            curNode.value = null;
            curNode.next = null;
            curNode = null;
        }

        while(curNode != null){
            curKey = curNode.key;

            if(checkKeysEquality(curKey, key)){
                prevNode.next = curNode.next;
                curNode.value = null;
                curNode.next = null;
            }

            prevNode = curNode;
            curNode = curNode.next;

        }
    }

    public void clear(){
        for(int i = 0; i < buckets.length; i++){
//            Node<K,V> curNode = buckets[i];
//            if(curNode == null) continue;
//            Node<K,V> next = curNode.next;
//            clearNode(curNode);
            buckets[i] = null;

//            while(next != null){
//                Node<K,V> temp = next.next;
//                clearNode(next);
//                next = temp;
//            }
        }
    }

    public int size(){
        int res = 0;
        for(int i = 0; i < buckets.length; i++){
            Node<K,V> curNode = buckets[i];
            while (curNode != null){
                res++;
                curNode = curNode.next;
            }
        }
        return res;
    }

    public V get(K key){
        int bucketNumber = key.hashCode() % (BUCKETS_AMOUNT-1);
        Node<K,V> curNode = buckets[bucketNumber];

        while(curNode != null){
            K curKey = curNode.key;

            if(checkKeysEquality(curKey, key)){
                return curNode.value;
            }

            curNode = curNode.next;
        }
        return null;
    }

}

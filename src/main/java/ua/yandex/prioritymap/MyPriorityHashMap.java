/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.yandex.prioritymap;

import java.util.Iterator;
import java.util.Map;


/**
 *
 * @author Ольга
 * @param <K>
 * @param <V>
 */
public class MyPriorityHashMap<K extends Comparable,V> implements Iterable<Map.Entry<K, V>>{
    final int SIZE = 50000;
    final int MAX = 2147483647;
    final int MIN = -2147483648;
    SortedList<K> keys;
    private Pair<K,V>[] mainArray;
    
    public boolean put(K key, V value){
       if(mainArray==null){
           mainArray = new Pair[SIZE];
           keys = new SortedList<>();
       }
       boolean answer = keys.add(key);
       if(answer==false) return false;
       Pair <K,V>added = new Pair<>(key, value);
       added.next = mainArray[hashIndex(key.hashCode())];
       mainArray[hashIndex(key.hashCode())] = added;
       return true;
   
    } 
    public V get(K key){
        Pair temp = mainArray[hashIndex(key.hashCode())];
        while(temp!=null){
           if(temp.key.equals(key)) return (V) temp.value;
           temp = temp.next;
        }
        return null;
    }
    public V peekValueWithProrityKey(){// not delete
      K biggerKey = keys.getFirst();
      return get(biggerKey); 
    }
    public V pollValueWithProrityKey(){//delete
      K biggerKey = keys.removeFirst();
      return get(biggerKey);   
    }
    private int hashIndex(int hash){
        int temp = Math.abs(hash);
        return temp&SIZE;
    }
    public Iterator EntrySet() { 
        return new MyPriorityHashMap.MyHashIterator(); 
    }
    
    @Override
    public Iterator<Map.Entry<K, V>> iterator() {
        return new MyHashIterator();
    }
    class MyHashIterator implements Iterator{
        private final Iterator iteratorKeys;
        public MyHashIterator(){
            iteratorKeys = keys.iterator();
        }
        @Override
        public boolean hasNext() {
            return iteratorKeys.hasNext();
        }

        @Override
        public Pair<K,V> next() {
           K key = (K) iteratorKeys.next();
           return new Pair(key, get(key));
        }
    }
}
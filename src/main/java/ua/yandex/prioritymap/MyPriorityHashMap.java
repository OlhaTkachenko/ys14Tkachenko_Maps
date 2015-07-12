/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.yandex.prioritymap;

import java.util.Iterator;
import java.util.Map;

public class MyPriorityHashMap<K extends Comparable, V> implements Iterable<Map.Entry<K, V>> {

    final int SIZE = 500;
    SortedList<K> keys;

    public class Pair<K, V> implements Map.Entry<K, V> {

        final int hash;
        Pair next;
        K key;
        V value;

        Pair(K k, V v) {
            hash = k.hashCode();
            key = k;
            value = v;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public V setValue(V value) {
            V temp = value;
            this.value = value;
            return temp;
        }
    }

    private Pair<K, V>[] mainArray;

    public boolean put(K key, V value) {
        if (mainArray == null) {
            mainArray = new Pair[SIZE];
            keys = new SortedList<>();
        }
        boolean answer = keys.add(key);
        if (answer == false) {
            return false;
        }
        Pair<K, V> added = new Pair<>(key, value);
        added.next = mainArray[hashIndex(key.hashCode())];
        mainArray[hashIndex(key.hashCode())] = added;
        return true;

    }

    public V get(K key) {
        Pair<K, V> temp = mainArray[hashIndex(key.hashCode())];
        while (temp != null) {
            if (temp.key.equals(key)) {
                return temp.value;
            }
            temp = temp.next;
        }
        return null;
    }

    public V peekValueWithProrityKey() {// not delete
        K biggerKey = keys.getFirst();
        return get(biggerKey);
    }

    public V pollValueWithProrityKey() {//delete
        K biggerKey = keys.removeFirst();
        return get(biggerKey);
    }

    private int hashIndex(int hash) {
        return hash % SIZE;
    }

    public Iterator EntrySet() {
        return new MyPriorityHashMap.MyHashIterator();
    }

    @Override
    public Iterator<Map.Entry<K, V>> iterator() {
        return new MyHashIterator();
    }

    class MyHashIterator implements Iterator<Map.Entry<K, V>> {

        private final Iterator<K> iteratorKeys;

        public MyHashIterator() {
            iteratorKeys = keys.iteratorK();
        }

        @Override
        public boolean hasNext() {
            return iteratorKeys.hasNext();
        }

        @Override
        public Pair<K, V> next() {
            K key = iteratorKeys.next();
            return new Pair(key, get(key));
        }
    }
}

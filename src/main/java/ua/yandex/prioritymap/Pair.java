/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.yandex.prioritymap;

import java.util.Map;

/**
 *
 * @author Ольга
 */
public class Pair<K,V> implements Map.Entry<K,V> {
     final int hash;   
     Pair next;
     K key;
     V value;
    Pair(K k,V v){
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

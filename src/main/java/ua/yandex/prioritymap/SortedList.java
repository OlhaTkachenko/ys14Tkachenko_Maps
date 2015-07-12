package ua.yandex.prioritymap;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SortedList<K extends Comparable> implements Iterable<Comparable>{
    private Node<K> head;

    static private class Node<K> {

        private Node<K> next;
        private K data;
    }

    public boolean add(K e) {
        Node<K> added = new Node<>();
        added.data = e;
        if(head==null) {
          head = added; 
          return true;  
        }
        if(e.compareTo(head.data)>0){
          added.next = head;
          head = added; 
          return true;
        }
        Node<K>temp = head;
        while(temp.next!=null){
            if(e.compareTo(temp.data)==0 || e.compareTo(temp.next.data)==0) return false;
            if(e.compareTo(temp.next.data)> 0){
                added.next = temp.next;
                temp.next = added;
                return true;
            }
            temp = temp.next;
        }
        temp.next =added;
        return true;
    }
    public K getFirst() {
        if(head==null) return null;
        return head.data;
    }
    public K removeFirst() {
        if(head==null) return null;
        K temp = head.data;
        head = head.next;
        return temp;
    }
    @Override
     public String toString() {
        StringBuilder buf = new StringBuilder();
        Node temp = head;
        while(temp!=null){
            buf.append(temp.data);
            buf.append(',');
            temp = temp.next;
        }
        return buf.toString();
    }

        @Override
    public Iterator<Comparable> iterator() {
         return new MyIterator(); 
    }
    public Iterator<K> iteratorK() {
         return new MyIterator(); 
    }
   class MyIterator<K> implements Iterator<K>{
       private Node headIterator;
       public MyIterator(){
           headIterator = head;
       }
        @Override
        public boolean hasNext() {
           return (headIterator!=null);
        }
        @Override
        public K next() {
            if (!hasNext()) throw new NoSuchElementException();
            Node<K> temp = headIterator;
            headIterator = headIterator.next;
            return  temp.data;
        }
       
   }
}

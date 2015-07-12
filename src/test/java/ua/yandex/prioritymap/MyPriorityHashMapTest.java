/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.yandex.prioritymap;

import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ольга
 */
public class MyPriorityHashMapTest {
    
    public MyPriorityHashMapTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of put method, of class MyPriorityHashMap.
     */
    @Test
    public void testPut_Get() {
        System.out.println("put_get");
        Integer key = 12;
        Object value = "rr";
        MyPriorityHashMap instance = new MyPriorityHashMap();
        Object expResult = "rr";
        instance.put(key, value);
        Object result = instance.get(key);
        assertEquals(expResult, result);
    }


    /**
     * Test of peekValueWithProrityKey method, of class MyPriorityHashMap.
     */
    @Test
    public void testPeekValueWithProrityKey() {
        System.out.println("peekValueWithProrityKey");
        Integer key = 12;
        Object value = "rr";
        Integer key1 = 1;
        Object value1 = "e";
        Integer key2 = 2;
        Object value2 = "r";
        MyPriorityHashMap instance = new MyPriorityHashMap();
        instance.put(key, value);
        instance.put(key1, value1);
        instance.put(key2, value2);       
        Object result = instance.peekValueWithProrityKey();
        Object expResult = "rr";
        assertEquals(expResult, result);
    }

    /**
     * Test of pollValueWithProrityKey method, of class MyPriorityHashMap.
     */
    @Test
    public void testPollValueWithProrityKey() {
        System.out.println("pollValueWithProrityKey");
        Integer key = 12;
        Object value = "rr";
        Integer key1 = 1;
        Object value1 = "e";
        MyPriorityHashMap instance = new MyPriorityHashMap();
        instance.put(key, value);
        instance.put(key1, value1);     
        instance.pollValueWithProrityKey();
        Object result = instance.pollValueWithProrityKey();
        Object expResult = "e";
        assertEquals(expResult, result);
    }

    /**
     * Test of iterator method, of class MyPriorityHashMap.
     */
    @Test
    public void testIterator() {
        System.out.println("iterator");
        MyPriorityHashMap <Integer, Integer> map=  new MyPriorityHashMap<>();
        Integer key = 12;
        Integer value = 6;
        Integer key1 = 100;
        Integer value1 = 7;
        map.put(key, value);
        map.put(key1, value1);
        String result = "";
        for (Map.Entry<Integer, Integer> e: map) {
            System.out.println(e.getKey() + ":" + e.getValue());
            result+= e.getKey() + ":" + e.getValue() + " ";
        }
        String expResult = "100:7 12:6 ";
        assertEquals(expResult, result);
    }
    
}

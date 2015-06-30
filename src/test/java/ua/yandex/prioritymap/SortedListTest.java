/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.yandex.prioritymap;

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
public class SortedListTest {
    
    public SortedListTest() {
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
     * Test of add method, of class SortedList.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        Integer e1 = 1;
        Integer e2 = 5;
        Integer e3 = 2;
        SortedList <Integer> instance = new SortedList<> () ;
        instance.add(e1);
        instance.add(e2);
        instance.add(e3);
        String expectedResult = "5,2,1,";
        String actualResult = instance.toString();
        assertEquals(expectedResult, actualResult);
    }

    /**
     * Test of removeFirst method, of class SortedList.
     */
    @Test
    public void testRemoveFirst() {
        System.out.println("removeFirst");
        Integer e1 = 1;
        Integer e2 = 5;
        Integer e3 = 2;
        SortedList <Integer> instance = new SortedList<> () ;
        instance.add(e1);
        instance.add(e2);
        instance.add(e3);
        instance.removeFirst();
        String expectedResult = "2,1,";
        String actualResult = instance.toString();
        assertEquals(expectedResult, actualResult);
    }
    /**
     * Test of getFirst method, of class SortedList.
     */
    @Test
    public void testGetFirst() {
        System.out.println("getFirst");
        Integer e1 = 1;
        Integer e2 = 5;
        Integer e3 = 2;
        SortedList <Integer> instance = new SortedList<> () ;
        instance.add(e1);
        instance.add(e2);
        instance.add(e3);
        Integer expResult = 5;
        Integer result = instance.getFirst();
        assertEquals(expResult, result);
    }
    
}

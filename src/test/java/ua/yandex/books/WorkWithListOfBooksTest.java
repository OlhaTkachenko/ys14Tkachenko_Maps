/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.yandex.books;

import java.util.Map;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.SortedMap;
import javafx.util.Pair;
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
public class WorkWithListOfBooksTest {
    
    public WorkWithListOfBooksTest() {
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
     * Test of groupBooksByAuthors method, of class WorkWithListOfBooks.
     */
    @Test
    public void testGroupBooksByAuthors() {
        System.out.println("groupBooksByAuthors");       
        List<Book> books = new LinkedList();
        Book bookTolstoy = new Book("Война и мир","Толстой",1812,Topic.CLASSICS);
        Book bookDos1 = new Book("Идиот", "Достоевский",1874, Topic.CLASSICS);
        Book bookDos2 =  new Book("Преступление и наказание", "Достоевский",1970, Topic.CLASSICS);       
        books.add(bookTolstoy);
        books.add(bookDos1);
        books.add(bookDos2);        
        HashMap<String, List<Book>> expResult =  new HashMap<>();
        List<Book> added = new LinkedList();
        added.add(bookDos1);
        added.add(bookDos2); 
        expResult.put("Достоевский", added);
        added = new LinkedList();
        added.add(bookTolstoy);
        expResult.put("Толстой", added);
        Map<String, List<Book>> result = WorkWithListOfBooks.groupBooksByAuthors(books);
        assertEquals(expResult, result);
    }
     @Test
    public void testGroupBooksByAuthorsGroups() {
        System.out.println("groupBooksByAuthors");       
        List<Book> books = new LinkedList();
        List< String> au = new LinkedList();
        au.add("Лукьяненко");
        au.add("Перумов");
        Book lukAndPer = new Book("Не время для драконов",au ,1997,Topic.FANTASY);
        Book luk = new Book("Чистовик", "Лукьяненко",2007, Topic.FANTASY);     
        books.add(lukAndPer);
        books.add(luk);        
        HashMap<String, List<Book>> expResult =  new HashMap<>();
        List<Book> added = new LinkedList();
        added.add(lukAndPer); 
        added.add(luk);
        expResult.put("Лукьяненко", added);
        added = new LinkedList();
        added.add(lukAndPer);
        expResult.put("Перумов", added);
        Map<String, List<Book>> result = WorkWithListOfBooks.groupBooksByAuthors(books);
        assertEquals(expResult, result);
    }

    /**
     * Test of findTopAuthorsPerEachYear method, of class WorkWithListOfBooks.
     */
    @Test
    public void testFindTopAuthorsPerEachYear() {
        System.out.println("findTopAuthorsPerEachYear");
        List<Book> books = new LinkedList();
        Book b1 = new Book("A","a", 2000,Topic.COMPUTING);
        Book b2 = new Book("B", "b", 2000, Topic.FANTASY);
        Book b3 = new Book("C", "c", 2001, Topic.CLASSICS);
        books.add(b1);
        books.add(b2);
        books.add(b3);
        Map<Integer, Set<String>> expResult =new HashMap();
        Set<String> added = new HashSet<>();
        added.add("a");
        added.add("b");
        expResult.put(2000, added);
        added = new HashSet<>();
        added.add("c");
        expResult.put(2001, added);
        Map<Integer, Set<String>> result = WorkWithListOfBooks.findTopAuthorsPerEachYear(books);
        assertEquals(expResult, result);
    }

    /**
     * Test of findTopicsWithTheMostNumberOfBooks method, of class WorkWithListOfBooks.
     */
    @Test
    public void testFindTopicsWithTheMostNumberOfBooks() {
        System.out.println("findTopicsWithTheMostNumberOfBooks");
        List<Book> books = new LinkedList();
        Book b1 = new Book("A","a", 2000,Topic.FANTASY);
        Book b2 = new Book("B", "b", 2000, Topic.FANTASY);
        Book b3 = new Book("C", "c", 2001, Topic.CLASSICS);
        books.add(b1);
        books.add(b2);
        books.add(b3);
        List<String> listAB = new LinkedList<>();
        listAB.add("A");
        listAB.add("B");
        Set<Pair<Topic, List<String>>> expResult = new HashSet<>();
        expResult.add(new Pair(Topic.FANTASY, listAB));
        Set<Pair<Topic, List<String>>> result = WorkWithListOfBooks.findTopicsWithTheMostNumberOfBooks(books);
        assertEquals(expResult, result);
    }
    
      @Test
    public void testFindTopicsWithTheMostNumberOfBooksDiffer() {
        System.out.println("findTopicsWithTheMostNumberOfBooks");
        List<Book> books = new LinkedList();
        Book b1 = new Book("A","a", 2000,Topic.FICTION);
        Book b2 = new Book("B", "b", 2000, Topic.FANTASY);
        Book b3 = new Book("C", "c", 2001, Topic.CLASSICS);
        books.add(b1);
        books.add(b2);
        books.add(b3);
        List<String> listA = new LinkedList<>();
        listA.add("A");
        List<String> listB = new LinkedList<>();
        listB.add("B");
        List<String> listC = new LinkedList<>();
        listC.add("C");        
        Set<Pair<Topic, List<String>>> expResult = new HashSet<>();
        expResult.add(new Pair(Topic.FICTION, listA));
        expResult.add(new Pair(Topic.FANTASY, listB));
        expResult.add(new Pair(Topic.CLASSICS, listC));        
        Set<Pair<Topic, List<String>>> result = WorkWithListOfBooks.findTopicsWithTheMostNumberOfBooks(books);
        assertEquals(expResult, result);
    }
}

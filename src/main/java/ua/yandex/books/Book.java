/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.yandex.books;
import java.util.LinkedList;
import java.util.List;
/**
 *
 * @author Ольга
 */

enum Topic {

    COMPUTING, FANTASY, CLASSICS, FICTION
}

public class Book {
    String title;
    List<String> authors;
    int yearOfPublising;
    Topic topic;
    public Book(String name, List<String> a, int year, Topic t){
        title = name;
        authors = a;
        yearOfPublising = year;
        topic = t;
    }
    public Book(String name, String a, int year, Topic t){
        title = name;
        List list = new LinkedList();
        list.add(a);
        authors = list;
        yearOfPublising = year;
        topic = t;
    }
}
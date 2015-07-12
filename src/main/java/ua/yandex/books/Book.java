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
public class Book {

    public enum Topic {
        COMPUTING, FANTASY, CLASSICS, FICTION;
    }
    String title;
    List<String> authors;
    int yearOfPublising;
    Topic topic;

    public Book(String name, List<String> authors, int year, Topic t) {
        title = name;
        this.authors = authors;
        yearOfPublising = year;
        topic = t;
    }

    public Book(String name, String author, int year, Topic t) {
        title = name;
        List list = new LinkedList();
        list.add(author);
        authors = list;
        yearOfPublising = year;
        topic = t;
    }
}

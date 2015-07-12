/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.yandex.books;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import javafx.util.Pair;
import ua.yandex.books.Book.Topic;

/**
 *
 * @author Ольга
 */
public class WorkWithListOfBooks {

    public static Map<String, List<Book>> groupBooksByAuthors(List<Book> books) {
        Map<String, List<Book>> map = new HashMap<>();
        for (Book book : books) {
            for (String author : book.authors) {
                if (!map.containsKey(author)) {
                    List<Book> list = new LinkedList<>();
                    list.add(book);
                    map.put(author, list);
                } else {
                    map.get(author).add(book);
                }
            }
        }
        return map;
    }

    public static Map<Integer, Set<String>> findTopAuthorsPerEachYear(List<Book> books) {
        Map<Integer, Set<String>> result = new HashMap<>();
        Map<String, List<Book>> booksByA = groupBooksByAuthors(books);
        for (Book book : books) {
            int year = book.yearOfPublising;
            if (!result.containsKey(year)) {
                Set<String> more = new HashSet();
                int amount = 0;
                for (String now : booksByA.keySet()) {
                    int temp = 0;
                    List<Book> list = booksByA.get(now);
                    for (Book oneA : list) {
                        if (oneA.yearOfPublising == year) {
                            temp++;
                        }
                    }
                    if (temp > amount) {
                        amount = temp;
                        more.clear();
                        more.add(now);
                    } else if (temp == amount) {
                        more.add(now);
                    }
                }
                result.put(year, more);
            }
        }
        return result;
    }

    public static Set<Pair<Topic, List<String>>> findTopicsWithTheMostNumberOfBooks(List<Book> books) {
        Map<Topic, List<String>> topics = new HashMap<>();
        Set<Pair<Topic, List<String>>> result = new HashSet<>();
        for (Book book : books) {
            if (!topics.containsKey(book.topic)) {
                topics.put(book.topic, new LinkedList<String>());
            }
            topics.get(book.topic).add(book.title);
        }
        int max = 0;
        for (Map.Entry<Topic, List<String>> now : topics.entrySet()) {
            if (now.getValue().size() > max) {
                max = now.getValue().size();
            }
        }
        for (Map.Entry<Topic, List<String>> now : topics.entrySet()) {
            if (now.getValue().size() == max) {
                result.add(new Pair(now.getKey(), now.getValue()));
            }
        }
        return result;
    }
}

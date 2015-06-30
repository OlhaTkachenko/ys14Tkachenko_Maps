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

/**
 *
 * @author Ольга
 */
public class WorkWithListOfBooks {
    public static Map<String, List<Book>> groupBooksByAuthors(List<Book> books) { 
        Map <String, List<Book>> map = new HashMap<>();
        for (Book book : books) {
            for(String author : book.authors){
                if(!map.containsKey(author)){
                   List<Book> list = new LinkedList<>();
                   list.add(book);
                   map.put(author, list);
                }
                else map.get(author).add(book);
            }
        }
      return map;        
    }
    public static Map<Integer, Set<String>> findTopAuthorsPerEachYear(List<Book> books) {
        Map<Integer, Set<String>> result = new HashMap<>();
        Map<String, List<Book>> booksByA = groupBooksByAuthors(books); 
        for(Book book : books){
            int year = book.yearOfPublising;
            if(!result.containsKey(year)){
                Set<String> more = new HashSet();
                int amount = 0;
                for(String now : booksByA.keySet()){
                   int temp = 0;
                   List <Book>list = booksByA.get(now);
                    for (Book oneA : list) {
                        if(oneA.yearOfPublising == year) temp++;
                    }
                    if(temp > amount){
                        amount = temp;
                        more.clear();
                        more.add(now);
                    }
                    else if(temp == amount){
                        more.add(now);
                    }                   
                }
                result.put(year, more);
            }
        }       
        return result;
    }
    public static Set<Pair<Topic,List<String>>> findTopicsWithTheMostNumberOfBooks(List<Book> books) {      
      int   computing = 0, fantasy = 0, classics = 0, fiction = 0;
      Set <Pair<Topic,List<String>>> result = new HashSet<>();
      List<String> computingList = new LinkedList(), fantasyList = new LinkedList(), 
              classicsList = new LinkedList(), fictionList = new LinkedList();
      for(Book book :books ){
          switch(book.topic){
              case COMPUTING:
                  computing++;
                  computingList.add(book.title);
                  break;
              case FANTASY:
                  fantasy++;
                  fantasyList.add(book.title);
                  break;
              case CLASSICS:
                  classics++;
                  classicsList.add(book.title);
                  break;
              case FICTION:
                  fiction++;
                  fictionList.add(book.title);
                  break;
              default:
                  throw new AssertionError(book.topic.name()); 
          }
        }
      int max = Math.max( Math.max(classics, computing),Math.max(fantasy, fiction) );
      if(max == computing){
          result.add(new Pair(Topic.COMPUTING, computingList));
      }
      if(max == fantasy){
          result.add(new Pair(Topic.FANTASY, fantasyList));
      }
      if(max == classics){
          result.add(new Pair(Topic.CLASSICS, classicsList));
      }
      if(max == fiction){
          result.add(new Pair(Topic.FICTION, fictionList));
      }
      return result;
    }

}


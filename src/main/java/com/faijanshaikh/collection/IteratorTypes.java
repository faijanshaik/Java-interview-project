package main.java.com.faijanshaikh;

import java.util.*;

public class IteratorTypes {
    public static void main(String[] args){
        List<String> fruits = new ArrayList<>();
        fruits.add("Banana");
        fruits.add("Mango");
        fruits.add("PineApple");
        fruits.add("Litchi");
        fruits.add("Coconut");
        fruits.add("Orange");
        fruits.add("WaterMelon");
        fruits.add("Grapes");
        System.out.println("--------------Iteartor(forwords)--------------");
        Iterator<String> iterator=fruits.iterator();
        while(iterator.hasNext()){
            String fruit=iterator.next();//iterates in only one direction(forwords)
            System.out.println("fruit:->" +fruit);// it iterate the data over the list in forwords direction
        }

        System.out.println("--------------ListIteartor(forwords)--------------");
        ListIterator<String> listIterator=fruits.listIterator();
        while(listIterator.hasNext()){
            String fruit=listIterator.next();
            System.out.println("fruit:->" +fruit);
        }

        System.out.println("--------------ListIteartor(backwords)--------------");
        ListIterator<String> listIterator2=fruits.listIterator(fruits.size());
        while(listIterator2.hasPrevious()){
            String fruit=listIterator2.previous();//it iterate the data over the list in backword direction
            System.out.println("fruit:->" +fruit);
        }

        System.out.println("--------------SplIteartor(spliting data)--------------");
        Spliterator<String> spliterator=fruits.spliterator();
        Spliterator<String> spliterator2=spliterator.trySplit();


        spliterator.forEachRemaining(fruit -> System.out.println("fruits-->" + fruit));

        if (spliterator2 != null) {
            spliterator2.forEachRemaining(fruit -> System.out.println("fruits-->" + fruit));
        }
    }
    /*
    Difference Between  Iterator and List Iterator and SplIterator

    1.What is the Diff BW a.iterator b.splIterator c.listIterator
     a.Iterator can iterate over collection in single direction
     b.SplIterator has special feature retrive over collection in birection(which means two directions forward and backward)
     c.ListIterator List iterator has facilitating to split the large data into two parts for parallel processing
    */
}

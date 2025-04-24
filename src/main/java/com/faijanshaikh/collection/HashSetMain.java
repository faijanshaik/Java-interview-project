package main.java.com.faijanshaikh;

import java.util.HashSet;

public class HashSetMain {

    public static void main(String[] args){
        /*
          HashSet class is the implementation of Set interface that is avilable from java.util package
          and extend LinkedHashSet.

          It uses HasMap internally to store the elements where the keys are elements and values are constants
          It uses hashCode() method of elements to determine their position in the internal HashMap and
          use equals method to check for duplicate values.

          in the HashSet there is no insertion order which means there is no guarantee to be the same order in which order
          they were added.

          HashSet is facilitating you to store unique elements  this is efficient way to store unique elements.
          the initial capacity of HashSet is 16 and load factor is 0.75 which means it automatically inceases its size by 75%

          HashSet allows  Heterogeneous Objects(only treeSET and TreeMap are not allowed) which means all elements that are going to be stored in HashSet is same data Type
        */
        HashSet hashSet=new HashSet<>();
        System.out.println("Size before adding objects :" +hashSet.size());
        hashSet.add("A");
        hashSet.add("B");
        hashSet.add("C");
        hashSet.add(null);
        hashSet.add(2);
        System.out.println(hashSet.add(null));//false
        System.out.print(hashSet.add("A"));//fasle
        hashSet.add("");//It will accept as empty value
        System.out.print("To check elements contains or not: " + hashSet.contains("A"));//returns true
        System.out.println("HashSet contains following Objects: " +hashSet);// [null, , A, B, 2, C]
        System.out.println("Size after adding objects :" +hashSet.size());
        // It allows only one null element
        // It will not allow duplicate elements(replace with the old vSlue when adding duplicate elements)
        // Insertion order is not preserved
        // HashSet has initial capacity 16 and default load factor is 0.75
        // it implements cloneable,serializable,it extends the abstract class
        // null elements always going to location zero
        // Underlying  Data Structure it internally uses HashMap
        // It implements the serializable and cloneable and extends the abstact class
        // HashSet internally uses HashMap to store the elements
        // HashSet class is not synchronized. If you want synchronized HashSet, use Collections.synchronizedSet() method.

    }
}

package main.java.com.faijanshaikh;

import javax.xml.transform.stream.StreamSource;
import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListMain {
    public static void main(String[] args){
        ArrayList alist=new ArrayList();//1.ArrayList has default initial capacity 10 and load factor (capacity=current capacity*3/2))
        System.out.println("----Array size when its created---:-"+ alist.size());
        alist.add(1);
        alist.add(1);//2.it allows duplicate elements
        alist.add(2);
        alist.add("apple");
        alist.add("A");
        alist.add("");//it Acceots an empty value
        alist.add(null);
        alist.add(null);//3.it allows multiple null elements
        //System.out.println("value at index" + alist.get(7));//IndexOutOfBoundException
        //4.if we accesss index value which is not available in ArrayList then it returns IndexOutOfBoundException
        System.out.println("---Size of Array after adding elemets---:-" +alist.size());
        alist.remove(Integer.valueOf(2));//Remove element by passing element
        alist.remove(3);//Remove Element by passing index value
        System.out.println("---see elements after removing elements from list---:" +alist);
        System.out.println("---see size of ArrayList after removing elemts---:" +alist.size());

        System.out.println("-----normal for loop------");
        for(int i=1;i<alist.size();i++){
            System.out.println(alist.get(i));
        }

        System.out.println("-----advanced for loop-----");
        for(Object temp:alist){
            System.out.println(temp);
        }

        System.out.println("-----While loop-----");
        int i=0;
        while(i<alist.size()){
            System.out.println(alist.get(i));
            i++;
        }

        System.out.println("-----------iterator--------");
        Iterator iterator=alist.iterator();
        while(iterator.hasNext()){
            Object value=iterator.next();
            System.out.println(value);
        }

        System.out.println("-----------forEach--------");
        alist.forEach(value->System.out.println(value));

        System.out.println("-----------toArray()--------");
        Object[] elements=alist.toArray();
        for(Object element:elements){
            System.out.println(element);
        }

        //5.it allows heterogeneous elements(multiple different datatype elements
        //6.ArrayList is better for storing and accessing Data
        //7.Insertion order is preserved
        //8.ArrayList is not Synchronized
        //9.it implements List,Cloneable,serializable and Random access (Marker Inter Interface), It extends AbstractList Class
        //10.ArrayList comes under dynamic memory allocation type or Dynamically growable and shrinkable
        //It also has an initial capacity of 10, and it increases its size by 50% when the number of elements exceeds the capacity.
    /*
Difference between ArrayList, LinkedList, and Vector :-->

All three classes, ArrayList, LinkedList, and Vector, implement the List interface in Java and provide a way to store and manipulate a collection of elements. However, there are some key differences between them:

Data Structure: ArrayList uses an array to store its elements, LinkedList uses a doubly-linked list, and Vector uses an array as well.

Performance: ArrayList provides constant-time performance for basic operations (add, get, set, remove) when performed at the end of the list. LinkedList provides constant-time performance for basic operations (add, get, set, remove) at the beginning and end of the list, but it has linear-time performance when performed in the middle of the list. Vector provides constant-time performance for basic operations, but it is slightly slower than ArrayList in single-threaded scenarios.

Thread Safety: ArrayList is not thread-safe, while Vector is thread-safe. LinkedList is also not thread-safe.

Resizing: ArrayList increases its size by 50% when the number of elements exceeds the capacity, while Vector increases its size by 100%. LinkedList does not have a capacity and it does not need to be resized.

Additional Methods: Vector provides additional methods like capacity() and ensureCapacity(int minCapacity), while ArrayList and LinkedList do not have such methods.*/

    }
}

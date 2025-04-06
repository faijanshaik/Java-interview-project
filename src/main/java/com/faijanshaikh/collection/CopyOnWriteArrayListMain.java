package main.java.com.faijanshaikh;


import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListMain {
    public static void main(String[] args){
        List<Object> list = new CopyOnWriteArrayList<>();
        list.add("A");
        list.add("B");
        list.add('c');
        list.add(true);
        list.add(12);
        list.add("Banana");
        list.add("");
        list.add(null);
        System.out.println("----------list before element removed--------" +list);
        System.out.println("is added =" +list.add(10.5));
        System.out.println("is removed=" +list.remove("c"));
        System.out.println("----------list After element added--------" +list);

        System.out.println("--------failsafeIterator--------");
        Iterator<Object> failsafeIterator=list.iterator();
        try{
            while(failsafeIterator.hasNext()){
                Object elemet=failsafeIterator.next();
                if(elemet.equals("A")){
                    failsafeIterator.remove();// This will throw an Unsupported Operation Exception
                }
            }
        }catch(UnsupportedOperationException uoe){
            System.out.println("remove operation cannot perform while retrieving in Copy on write Array");
            System.out.println("throw an UnsupportedOperationException");
        }
    }

    /*CopyOnWriteArrayList is thread safe implementation of List interface in java,
     it is designed for use in multi-threaded environments, where threads may concurrently read and write
     to the list

     whenever trying performing manipulation operations to the list, copyOnWriteArrayList creates new copy of Array

     whenever an element is added, removed,modified to the list, then write creates copy of array, so  these operations
     performed ont he array not to the existing list, this ensures original array remains unchanged.
     once the operations completed then the new array is replaced with old one, this process is Copy-on-Write

      If read operation is performed while writing is in progress,
      the read operation will see the old version of the Array, this because write array creates new copy of array,
      read operation does not wait for write operation until the write to be completed
    */

    //1. CopyOnWriteArrayList is synchronized(means at a time only one thread can access the object).
    //2. CopyOnWriteArrayList uses fail-safe iterator.
    //3. CopyOnWriteArrayList can not throw ConcurrentModificationException.
    //4. CopyOnWriteArrayList class was added in java version 1.5
    //5. CopyOnWriteArrayList class is present in java.util.concurrent package.
    //6. CopyOnWriteArrayList allows null.
    //7. clone method return the shallow copy of the original object.
    //8. CopyOnWriteArrayList is a thread-safe.(Performance is Slow).
    //9. add, remove operator is not supported by CopyOnWriteArrayList iterator
}

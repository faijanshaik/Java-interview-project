package main.java.com.faijanshaikh;

import java.util.*;

public class DequeMain {
    public static void main(String[] args){
        /*
          Deque is an interface from java.util.Deque and it is extension of Queue interface
          Deque is related to  double ended queue that supports from two ends, it can be used as
          a queue(First-in-First-Out)/FIFO or it can be used as stack( Last-In-First-Out)/LIFO

          Deque(Double ended Queue) is extended by Queue interface and represents data structure
          that allows insertion and removing elements from Both ends  like adding and removing elements
          from front and back as well, By default Deque follows LIFO,when adding and removing from Deque

           some common classes implemented by Deque are ArrayDeque,Linked list and concurrent Linked Deque
        */

        // some of the methods of Deque
        // add() adds the element to the tail
        // addFirst() adds the elements to the head
        // addLast() add the elements to the tail
        // remove() remove the element at Head
        // removeFirst() remove the element at Head
        // removeLast() remove the element at tail
        // poll() remove the element at Head
        // pollFirst() remove the element at Head
        // Poll Last() remove the element at tail
        // when trying to removing or investigating by using these methods like getFirst(),getLast(),removeFirst,removeLast(),Pop()
        // then it throws NoSuchElementEception


        WeakHashMap wh=new WeakHashMap();
        Deque deQue=new LinkedList();
        //Adding elements to the tail
        deQue.add("Apple");
        deQue.add("Banana");
        deQue.add("Cucumber");
        //deQue.add(null);

        System.out.println("fruits: " + deQue);//fruits: [Apple, Banana, Cucumber]

        deQue.addFirst("Avocado");//Adds elements to the tail
        deQue.addLast("Dates");//Adds elements to the tail

        System.out.println("fruits: " + deQue);//fruits: [Avocado, Apple, Banana, Cucumber, Dates]

        deQue.remove();// retrieve and remove the element at Head
        deQue.removeFirst();//retrieve and remove the element at Head
        deQue.removeLast();//retrieve and remove the element at tail

        System.out.println("fruits: " + deQue);//fruits: [Banana, Cucumber]

        deQue.offer("Apple");//adds an element at tail
        deQue.offerFirst("Appricot");//adds an element at Head
        deQue.offerLast("Dragon fruit");//adds an element at tail

        System.out.println("fruits: " + deQue);//[Appricot, Banana, Cucumber, Apple, Dragon fruit]

        deQue.poll();//retrieve and remove the element at Head
        deQue.pollFirst();//retrieve and remove the element at Head
        deQue.pollLast();//retrieve and remove the element at tail
        System.out.println("fruits: " + deQue);//fruits: [Cucumber, Apple]

        deQue.add("Pine Apple");
        deQue.add("Lemon");
        deQue.add("Jack fruit");
        System.out.println("fruits: " + deQue);

        System.out.println("peek: " + deQue.peek());// Retrieve the Head of the element but not remove
        System.out.println("peek First: " + deQue.peekFirst());//Retrieve the Head of the element but not remove
        System.out.println("peek Last: " + deQue.peekLast());//Retrieve the tail of the element but not remove

        System.out.println("Pop: " + deQue.pop());// retrieve and remove the element at Head
        System.out.println("fruits: " + deQue);

        Iterator<String> iterator=deQue.iterator();
        System.out.println("-----iterator-----");
        while(iterator.hasNext()){
            System.out.println("fruits:" + iterator.next());
        }

        System.out.println("-----reverse-----");
        Iterator<String> reverse= deQue.descendingIterator();
        while(reverse.hasNext()){
            System.out.println("fruits:" + reverse.next());
        }

    }
    /*Here are some key points to remember when using the Deque interface in Java:-->

Deque is a double-ended queue, which means elements can be inserted and removed from both ends.

Common implementation classes for Deque include ArrayDeque and LinkedList.

To add elements to the Deque, you can use methods such as addFirst(), addLast(), offerFirst(), and offerLast().

To remove elements from the Deque, you can use methods such as removeFirst(), removeLast(), pollFirst(), and pollLast().

To inspect elements at the front and back of the Deque, you can use methods such as getFirst(), getLast(), peekFirst(), and peekLast().

When removing or inspecting elements from the Deque, it's important to check if the Deque is empty. removeFirst(), removeLast(), getFirst(), getLast() will throw NoSuchElementException if deque is empty, you can use pollFirst(), pollLast(), peekFirst(), peekLast() which will return null if deque is empty.

To control the concurrency of a Deque you can use the synchronizedDeque() method of the Collections class to create a thread-safe version of a Deque.

The Deque interface also provides some additional methods such as push(), pop(), descendingIterator() which are useful in certain use cases.

You should also consider the performance characteristics of different Deque implementations when choosing an implementation class. For example, ArrayDeque is typically faster for certain operations than LinkedList.
*/
}

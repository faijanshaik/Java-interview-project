package main.java.com.faijanshaikh;


import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ArrayBlockingQueueMain {
    /* ArrayBlockingQueue implementation is based on Array Data structures .
    it is usefull for implmenting producer and consumer patterns in multi threaded environment.
     where the producers add the elements to the queue and consumers remove the consumers reove the elements from the queue

     one of the key feature of ArrayBlockingQueue is thread safe,
     means that multiple threads can access the data concurrently with out data corruption
     this makes it a good choice for implementing thread-safe queues in java
     */

    private static ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<>(10);
    public static void main(String[] args){
        int capacity =10;
        BlockingQueue aqueue =new ArrayBlockingQueue<>(10);
        aqueue.add(1);
        aqueue.add(2);
        aqueue.add(3);

        // poll method will retrive and remove the head of the queue
        int head = (int) aqueue.poll();
        System.out.println("Head of queue:"+head);

        //peak method will retrive without removing it
        head=(int)aqueue.peek();
        System.out.println("Head of queue:"+head);

        boolean isEmpty=aqueue.isEmpty();
        System.out.println("queue is empty:"+isEmpty);

        int size=aqueue.size();
        System.out.println("Queue size :"+size);
        System.out.println("------------------------------");
        Thread t1=new Thread(new Producer());
        Thread t2=new Thread(new Consumer());
        t1.start();
        t2.start();

    }

    static class Producer implements Runnable{
        String item=produceItem();
        @Override
        public void run() {
            while(true) {
                try {
                    queue.put(item);
                    System.out.println("produced->" +item);
                } catch (InterruptedException ie) {
                    //Handle exception
                }
            }

        }

        private String produceItem(){
            return "item"+Math.random();
        }
    }

  static class Consumer implements Runnable{
        @Override
        public void run() {
            while(true){
                try{
                    String item=queue.take();
                }catch(InterruptedException ie)
                {
                    //Handle exception
                }

            }
        }
    }
}

/*
put(E e): Inserts the specified element into the queue, blocking if necessary until there is space available.
take(): Retrieves and removes the head of the queue, blocking if necessary until an element becomes available.
offer(E e): Inserts the specified element into the queue if it is possible to do so immediately without blocking.
poll(): Retrieves and removes the head of the queue, or returns null if the queue is empty.
remainingCapacity(): Returns the number of additional elements that can be added to the queue without blocking.
size(): Returns the number of elements in the queue.
isEmpty(): Returns true if the queue is empty, and false otherwise.
*/

/*
1.ArrayBlockingQueue is a thread-safe queue implementation based on an array data structure.
2.It is useful for implementing producer-consumer patterns in a multi-threaded environment.
3.ArrayBlockingQueue has blocking behavior, meaning that producers will block when trying to add elements
	to a full queue, and consumers will block when trying to remove elements from an empty queue.
4.ArrayBlockingQueue provides a number of useful methods for adding, removing, and querying the
	elements in the queue, as well as for adjusting the queue's capacity and blocking behavior.
5.ArrayBlockingQueue is an efficient and thread-safe way to implement producer-consumer patterns in Java.
6.ArrayBlockingQueue has a fixed capacity, which means that you need to specify the maximum number
	of elements that the queue can hold when you create it. Once the queue is full, producers will block until space becomes available.
7.ArrayBlockingQueue provides a number of useful blocking methods, such as put and take,
	which allow producers and consumers to block until they are able to add or remove elements from the queue, respectively.
8.ArrayBlockingQueue also provides non-blocking methods, such as offer and poll,
	which allow producers and consumers to attempt to add or remove elements from the queue without blocking.
9.ArrayBlockingQueue supports optional fairness policies, which can be specified
	when the queue is created. Fairness policies determine the order in which producers and consumers are allowed to access the queue.
10. is part of the java.util.concurrent package, which contains a number of other
	useful concurrent data structures and utilities for implementing concurrent programming in Java.
*/
/*
Difference between ArrayBlockingQueue, PriorityBlockingQueue and LinkedBlockingQueue:-->

ArrayBlockingQueue:
1.It is a thread-safe implementation of the BlockingQueue interface that is based on an array.
2.The size of an ArrayBlockingQueue is fixed and it can't be resized.
3.It's elements are ordered in the order they are added, and elements are retrieved in the order they are added.
4.It is useful when you need a queue with a fixed size and you have to handle multithreading.

PriorityBlockingQueue:
1.It is a thread-safe implementation of the BlockingQueue interface that orders elements according to their natural ordering or a provided comparator.
2.The size of a PriorityBlockingQueue can grow or shrink dynamically.
3.It's elements are ordered by their priority, which can be determined by their natural ordering or by a provided comparator.
4.It is useful when you need to order elements in the queue based on their priority and handle multithreading.

LinkedBlockingQueue:
1.It is a thread-safe implementation of the BlockingQueue interface that is based on linked nodes.
2.The size of a LinkedBlockingQueue can grow or shrink dynamically.
3.It's elements are ordered in the order they are added, and elements are retrieved in the order they are added.
4.It is useful when you need a queue that can grow or shrink dynamically and you have to handle multithreading.
*/




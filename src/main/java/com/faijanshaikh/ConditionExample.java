package main.java.com.faijanshaikh;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionExample {
    /*
       Condition class provides the blocking mechanism for the threads that need to wait for condition to be met.
       it is associated with a lock object and can be obtained by calling newCondition() method of lock interface.

       Condition is used to synchronized  the execution of threads and to controll the access to shared resources
       it is an alternative to using Object.wait() and Object.notify()

       Condition is maintains then multiple waiting queues not like synchronized
       while synchronized uses single wating queue

    */

    public static void main(String[] args){
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();

        Thread1 thread1 = new Thread1(lock, condition);
        Thread2 thread2 = new Thread2(lock, condition,thread1);
        Thread t1 = new Thread(thread1);
        Thread t2 = new Thread(thread2);
        t1.start();
        t2.start();

    }
}

class Thread1 implements Runnable{

    boolean ready = false;
    Lock lock;
    Condition condition;
    Thread1(Lock lock, Condition condition){
        this.lock = lock;
        this.condition = condition;
    }
    @Override
    public void run() {
        lock.lock();
            try {
                System.out.println("Thread name" +Thread.currentThread().getName());
                while(!ready){
                    condition.await();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
}

class Thread2 implements Runnable{

    Lock lock;
    Condition condition;
    Thread1 thread1;

    public Thread2(Lock lock, Condition condition, Thread1 thread1) {
        this.lock = lock;
        this.condition = condition;
        this.thread1 = thread1;
    }

    @Override
    public void run() {
        lock.lock();
        try{
            System.out.println("Thread name" +Thread.currentThread().getName());
            thread1.ready = true;
            condition.signal();
        } finally {
            lock.unlock();
        }
    }
}
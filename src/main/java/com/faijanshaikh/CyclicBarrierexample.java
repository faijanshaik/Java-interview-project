package main.java.com.faijanshaikh;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierexample {

    public static void main(String[] args){

        final CyclicBarrier barrier = new CyclicBarrier(3, new Runnable() {
            @Override
            public void run() {
                // This task will be executed once all thread reaches barrier
                System.out.println("All parties are arrived at barrier, lets play");
            }
        });
        Thread t1 = new Thread(new Worker(barrier),"Thread1");
        Thread t2 = new Thread(new Worker(barrier),"Thread2");
        Thread t3 = new Thread(new Worker(barrier),"Thread3");

        t1.start();
        t2.start();
        t3.start();
    }
}

class Worker implements Runnable{

    CyclicBarrier cyclicBarrier;
    public Worker(CyclicBarrier cyclicBarrier) {
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " is waiting on barrier");
            cyclicBarrier.await();
            System.out.println(Thread.currentThread().getName() + " has crossed the barrier");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (BrokenBarrierException e) {
            throw new RuntimeException(e);
        }
    }
}

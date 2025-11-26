package main.java.com.faijanshaikh;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchExample {
    /*
       CountDownLatch in java is synchronous utility that makes one or more threads wait until certain operations completed

       InCountDownLatch threads are wait at a point until the remaining threads are completed their task one by one and main thread
       executed, here threads are count down one by one, until the threads count reaches to zero then threads are move together

     */
    public static void main(String[] args) throws InterruptedException {

        final CountDownLatch latch = new CountDownLatch(3);
        Thread orderRequest = new Thread(new Service("OrderRequestService",latch));
        Thread orderpayment = new Thread(new Service("OrderPaymentService",latch));
        Thread orderNotofication = new Thread(new Service("OrderNotificationService",latch));

        orderRequest.start();
        orderpayment.start();
        orderNotofication.start();

        latch.await();
        System.out.println("Main Service is-Up");
    }
}

class Service implements Runnable{
    String name;
    CountDownLatch latch;

    public Service(String name, CountDownLatch latch) {
        this.name = name;
        this.latch = latch;
    }

    @Override
    public void run() {
        try{

            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(name +" is-Up");
        latch.countDown();// reduce count down latch one by one
    }
}
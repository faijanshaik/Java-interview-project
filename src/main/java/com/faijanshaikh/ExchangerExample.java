package main.java.com.faijanshaikh;

import java.util.concurrent.Exchanger;

public class ExchangerExample {
    public static void main(String[] args) {
        Exchanger<String> exchanger = new Exchanger<>();
        Thread t1 = new Thread(new Producer(exchanger));
        Thread t2 = new Thread(new Consumer(exchanger));
        t1.start();
        t2.start();
    }
}

class Consumer implements Runnable {

    Exchanger<String> exchanger;
    String message;

    public Consumer(Exchanger exchanger) {
        this.exchanger = exchanger;
        this.message = "World";
    }

    @Override
    public void run() {
        try {
            System.out.println("Consumer before exchange: " + message);
            message = exchanger.exchange(message);
            System.out.println("Consumer before exchange: " + message);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

class Producer implements Runnable {

    Exchanger<String> exchanger;
    String message;

    public Producer(Exchanger exchanger) {
        this.exchanger = exchanger;
        message = "Hello";
    }

    @Override
    public void run() {

        try {
            System.out.println("Producer before exchange: " + message);
            message = exchanger.exchange(message);
            System.out.println("Producer before exchange: " + message);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
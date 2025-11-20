package main.java.com.faijanshaikh.completableFutures;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.concurrent.ExecutionException;

public class CompletableMainExample {
    public static void main(String[]  args) throws ExecutionException, InterruptedException {
        ProductService service = new ProductService(new ProductRepository(new ObjectMapper()));
        File jsonFile = new File("D:/development/WS-4/Java-interview-project/src/Products.json");
      //  service.saveProducts(jsonFile);

       // service.getProducts(jsonFile);
        service.getSortedProducts(jsonFile);
    }

    /*
     CompletableFuture is a class that provides one of the way to write block of asynchronous code as well as synchronous code,
     It overcomes the limitations of Traditional Future API, and it supports thread-safe and conccurency , some of the usefull feature
     like mannually completing the Future, chaining multiple tasks together, exceptional Handling, and timeout controllling

     CompletableFuture class represents the result of asynchronous accmulation,
     * It used the common thread worker from ForkJoin Pool if we do not provided the custom executor

     some of methods of CompletableFuture
     1.thenApply(),  :- this method is exectues the another thread after the current thread executed, and it takes the Function as parameter
                        thenApply() method executed by the same thread that executes the runAsync()

     2.thenAccept(); :- this method consumes the result and doesn' return anaything, it takes the Consumer as parameter
     3.thenApplyAsync(); :- this method is allows to the multiple threds to work asynchronously
     4.thenAcceptAsnc(); :- this is smililar to thenAccept method but works for asynchnous tasks
     5.get();   :-this method returns the result, blocks the main thread for result until the other threads completes their task
     6.runAsync(); :- this method takes the Runnable as parameter and exectues the task and doesn't return nothing(Void)
     7.supplyAsync(); :- this method takes the supplier as parameter and excutes the taks and returns the result of specific return type

     some of methods of Completable Feature that supports exception Handling
     1.exceptionally(); :-Execptionally is one of the method that provides exception handling feature internally and it runs only when the exception
                       is raised and  it returns the fallback result instead of original result, it cannot return changed result
     2.handling(); :- this method is always executed , even execption is not raised, it can returns the changed result , returns the fallback result
                      when exception is raised , if not then return the original result
     3.whenComplete(); ; this method also always executed, even if exception  doesn't occurs ,and it doesn't retutn the result, is better for logging

    */
}

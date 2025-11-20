package main.java.com.faijanshaikh.completableFutures;

import java.io.File;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

public class ProductService {

    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public Void saveProducts(File jsonFile) throws ExecutionException, InterruptedException {
        System.out.println("----Starting save products--------");
        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            //logic Here to call save Products
            List<ProductDTO> products = repository.saveProducts(jsonFile);
            System.out.println(" save product Woker :" + Thread.currentThread().getName());
            products.stream().forEach(product -> System.out.println(product));
        });
        return future.get();// main Thread Wait here untill the worker thread complete their task

    }

    public void getProducts(File jsonFile) throws ExecutionException, InterruptedException {
        System.out.println("----Starting get products--------");
        CompletableFuture<List<ProductDTO>> future = CompletableFuture.supplyAsync(() -> {
            //logic here to getProducts
            List<ProductDTO> products = repository.getProducts(jsonFile);
            System.out.println(" get products Worker :" + Thread.currentThread().getName());
            products.stream().forEach(System.out::println);

            return products;
        });

        future.get();
    }

    //CompletableFuture with CustomExecutor and Asynchronous Task
    public Void getSortedProducts(File jsonFile) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        //this future uses the common thread from Fork join Pool since we did not provided custom executor to the future
        CompletableFuture<Void> future = CompletableFuture.supplyAsync(() -> {
                    List<ProductDTO> productDTOS = repository.getProducts(jsonFile);
                    System.out.println(" getSortedProducts Worker :" + Thread.currentThread().getName());
                    return productDTOS;
                }//,executor
        ).thenApplyAsync((products) -> {
            Map<Integer, List<ProductDTO>> productsMap = products.stream().collect(Collectors.groupingBy(ProductDTO::getRating));
            System.out.println(" products list to map Worker :" + Thread.currentThread().getName());
            productsMap.forEach((rating, productList) -> {
                System.out.println("rating" + rating);
                productList.forEach(product -> {
                    System.out.println(" " + product.getName() + "-" + product.getModel());
                });
            });
            return productsMap;
        }, executor).thenApplyAsync((productsMap) -> {
            System.out.println(" map to List of String Worker:" + Thread.currentThread().getName());
            List<String> productNames = productsMap.entrySet().stream()
                    .flatMap(product -> product.getValue().stream())
                    .filter(product -> product.getRating() > 4)
                    .map(product -> product.getName().toUpperCase())
                    .collect(Collectors.toList());
            return productNames;
        }, executor).thenAcceptAsync((productNames) -> {
            System.out.println("product Names Worker:" + Thread.currentThread().getName());
            productNames.stream().map(String::toUpperCase).forEach(p -> System.out.println(p));
        }, executor);
        return future.get();
    }
}

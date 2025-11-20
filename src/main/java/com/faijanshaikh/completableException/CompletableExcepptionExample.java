package main.java.com.faijanshaikh.completableException;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

public class CompletableExcepptionExample {
    public static void main(String[] args) {
        CompletableExcepptionExample object = new CompletableExcepptionExample();
        try {
            object.getNumbersWithExceptionally();
            object.getNumbersWithHandleMethod();
            object.getNumbersWithWhenCompleteMethod();
        } catch (Exception e) {
            System.out.println("Exception while getting numbers");
        }
    }

    //Note we can also use these three methods in the same CompletableFuture chain
    public Void getNumbersWithExceptionally() throws ExecutionException, InterruptedException {
        CompletableFuture<Void> future = CompletableFuture.supplyAsync(() -> {
            System.out.println("--- ---");
            List<Integer> listNumbers = List.of(1, 2, 3, 4, 5, 0);// Immutable with fixed size of List even cannot modify like replace
            List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 0);//mutable with fixed size it allows to modify value but cant add, or remove
            System.out.println("--- printing numbers---");
            listNumbers.stream().map(n -> n * 2).forEach(n -> System.out.println(n));
            return listNumbers;
        }).thenApply((listNumbers) -> {
            List<Integer> listOfNumbers = listNumbers.stream().filter(n -> n % 2 == 0).collect(Collectors.toList());
            return listNumbers;
        }).thenApply((listNumbers) -> {
            List<Integer> numbers = listNumbers.stream().filter(n -> n % 0 == 0).collect(Collectors.toList());
            return numbers;
        }).exceptionally(exception -> {
            System.out.println("exception Handeled by the exceptionallyMethod");
            return List.of();// returns fall back result
        }).thenAccept(numbers -> {
            System.out.println("--- nothing to print because accpet method returns empty result---");
            numbers.stream().forEach(n -> System.out.println(n));
        });
        return future.get();
    }

    public Void getNumbersWithHandleMethod() throws ExecutionException, InterruptedException {
        CompletableFuture<Void> future = CompletableFuture.supplyAsync(() -> {
            System.out.println("--- ---");
            List<Integer> listNumbers = List.of(1, 2, 3, 4, 5, 0);// Immutable with fixed size of List even cannot modify like replace
            List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 0);//mutable with fixed size it allows to modify value but cant add, or remove
            System.out.println("--- printing numbers---");
            listNumbers.stream().map(n -> n * 2).forEach(n -> System.out.println(n));
            return listNumbers;
        }).thenApply((listNumbers) -> {
            List<Integer> listOfNumbers = listNumbers.stream().filter(n -> n % 2 == 0).collect(Collectors.toList());
            return listNumbers;
        }).thenApply((listNumbers) -> {
            List<Integer> numbers = listNumbers.stream().filter(n -> n % 0 == 0).collect(Collectors.toList());
            return numbers;
        }).handle((numbers, exception) -> {
            System.out.println("exception Handeled by the handle() method");
            if (exception != null) {
                return List.of();
            } else {
                return numbers;
            }

        }).thenAccept(numbers -> {
            System.out.println("--- nothing to print because accpet method returns empty result---");
            numbers.stream().forEach(n -> System.out.println(n));
        });
        return future.get();
    }

    public Void getNumbersWithWhenCompleteMethod() throws ExecutionException, InterruptedException {
        CompletableFuture<Void> future = CompletableFuture.supplyAsync(() -> {
            System.out.println("--- ---");
            List<Integer> listNumbers = List.of(1, 2, 3, 4, 5, 0);// Immutable with fixed size of List even cannot modify like replace
            List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 0);//mutable with fixed size it allows to modify value but cant add, or remove
            System.out.println("--- printing numbers---");
            listNumbers.stream().map(n -> n * 2).forEach(n -> System.out.println(n));
            return listNumbers;
        }).thenApply((listNumbers) -> {
            List<Integer> listOfNumbers = listNumbers.stream().filter(n -> n % 2 == 0).collect(Collectors.toList());
            return listNumbers;
        }).thenApply((listNumbers) -> {
            List<Integer> numbers = listNumbers.stream().filter(n -> n % 0 == 0).collect(Collectors.toList());
            return numbers;
        }).whenComplete((numbers, exception) -> {
            System.out.println("exception Handeled by the handle() method"); // better for logging
            if (exception != null) {
                System.out.println(exception.getMessage());
            } else {
                System.out.println(numbers);
            }

        }).thenAccept(numbers -> {
            System.out.println("--- nothing to print because accpet method returns empty result---");
            numbers.stream().forEach(n -> System.out.println(n));
        });
        return future.get();
    }
}

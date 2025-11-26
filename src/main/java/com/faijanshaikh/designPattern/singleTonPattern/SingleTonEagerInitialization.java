package main.java.com.faijanshaikh.designPattern.singleTonPattern;

public class SingleTonEagerInitialization {
    private static final SingleTonEagerInitialization singleTonEagerInitialization = new SingleTonEagerInitialization();

    private SingleTonEagerInitialization() {

    }

    public static SingleTonEagerInitialization getSingleTonEagerInitialization() {

        return singleTonEagerInitialization;
    }

    public void getMessage() {
        System.out.println(" Singleton Eager Initialization");
    }
}

package main.java.com.faijanshaikh.designPattern.singleTonPattern;

public class SingletonMain {
    public static void main(String[] args) {
        //Eager Initialization
        SingleTonEagerInitialization singleTonEagerInitialization = SingleTonEagerInitialization.getSingleTonEagerInitialization();
        singleTonEagerInitialization.getMessage();

        //Lazy Initialization
        SingleTonLazyInitialization lazyInitialization = SingleTonLazyInitialization.getInstance();
        lazyInitialization.showMessage();

        //Double check initialization
        SingleTonDoubleCheck instance = SingleTonDoubleCheck.getInstance();
        instance.showMessage();

        //SingleTon Billplugh
        SingleTonBillPlugh billPlughInstance = SingleTonBillPlugh.getInstance();
        billPlughInstance.showMessage();
    }
}

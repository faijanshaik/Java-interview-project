package main.java.com.faijanshaikh.designPattern.singleTonPattern;

public class SingleTonLazyInitialization {
    private static SingleTonLazyInitialization lazyInitiance;

    private SingleTonLazyInitialization() {

    }

    public static SingleTonLazyInitialization getInstance() {
        if (lazyInitiance == null) {
            lazyInitiance = new SingleTonLazyInitialization();
        }
        return lazyInitiance;
    }

    public void showMessage() {
        System.out.println("SingleTon lazy initialization");
    }
}

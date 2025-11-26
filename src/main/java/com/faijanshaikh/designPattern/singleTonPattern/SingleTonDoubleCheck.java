package main.java.com.faijanshaikh.designPattern.singleTonPattern;

public class SingleTonDoubleCheck {
    private static SingleTonDoubleCheck instance;

    private SingleTonDoubleCheck() {

    }

    public static SingleTonDoubleCheck getInstance() {
        if (instance == null) {
            synchronized (SingleTonDoubleCheck.class) {
                if (instance == null) {
                    instance = new SingleTonDoubleCheck();
                }
            }
        }
        return instance;
    }

    public void showMessage() {
        System.out.println(" SinleaTon double Check initialization");
    }
}

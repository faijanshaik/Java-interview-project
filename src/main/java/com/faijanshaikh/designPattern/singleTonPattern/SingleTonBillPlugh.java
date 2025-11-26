package main.java.com.faijanshaikh.designPattern.singleTonPattern;

public class SingleTonBillPlugh {

    private SingleTonBillPlugh(){

    }
    private static class BillPlugh{
        private static final SingleTonBillPlugh instance = new SingleTonBillPlugh();
    }

    public static SingleTonBillPlugh getInstance(){
        return BillPlugh.instance;
    }

    public void showMessage(){
        System.out.println(" SingleTon Bill plugh instance");
    }
}

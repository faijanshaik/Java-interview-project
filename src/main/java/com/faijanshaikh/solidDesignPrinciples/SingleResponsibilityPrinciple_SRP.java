package main.java.com.faijanshaikh.solidDesignPrinciples;

public class SingleResponsibilityPrinciple_SRP {
    /*
      SOLID is acronym for 5 object oriented desin principles
      int SRP- Single Responsibility Princile it should have only one reason to change,
      that measn,it should have one responsibility
     */
    public static void main(String[] args) {
        Depositor depositor = new Depositor();
        depositor.depositAmount(305.34);

        Cashier withDraw = new Cashier();
        withDraw.amountWithDraw(200.00);
    }
}

class Depositor {
    public void depositAmount(Double money) {
        System.out.println(money + " Amount deposited");
    }
}

class Cashier {
    public void amountWithDraw(Double money) {
        System.out.println(money + " Amount Withdrawn");
    }
}

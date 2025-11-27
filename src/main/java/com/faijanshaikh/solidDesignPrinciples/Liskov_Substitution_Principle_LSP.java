package main.java.com.faijanshaikh.solidDesignPrinciples;

public class Liskov_Substitution_Principle_LSP {
    /*
      Liskov Substitution Principle states that sub types are substitution of base types
      the child class should be able to replce it parent class with out breaking the rules
     */
    public static void main(String[] args) {
        Eagle eagle = new Eagle();
        eagle.fly();

        Parrot parrot = new Parrot();
        parrot.fly();

        Ostrich ostrich = new Ostrich();
        ostrich.fly();
    }
}

interface Bird {
    void fly();
}

class Eagle implements Bird {
    @Override
    public void fly() {
        System.out.println(" Eagle can fly");
    }
}

class Parrot implements Bird {
    @Override
    public void fly() {
        System.out.println("Parrot can fly");
    }
}

class Ostrich implements Bird {
    @Override
    public void fly() {
        System.out.println(" Ostrich cannot fly");//voilating LSP (it is breaking the LSP rule)
        throw new UnsupportedOperationException("Ostrich cannot fly");
    }
}
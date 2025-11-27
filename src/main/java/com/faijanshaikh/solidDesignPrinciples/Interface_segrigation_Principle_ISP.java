package main.java.com.faijanshaikh.solidDesignPrinciples;

public class Interface_segrigation_Principle_ISP {
    /*
      Integeration segerigation principle states that don't force the class to add or implements unnecessary methdods
      large interfaces breaking into smaller once's
     */
}

/*interface Robot{
    void work();
    void eat(); // unnecessary method added, violates the rule of ISP
    //segregating or breaking the interface into multiple smaller interfaces
}*/

interface Robot {
    void work();
}

interface Human {
    void eat();
}

class WorkingRobot implements Robot {
    @Override
    public void work() {
        System.out.println("Robot working");
    }
}

class HumanEating implements Human {
    @Override
    public void eat() {
        System.out.println("Human eating");
    }
}

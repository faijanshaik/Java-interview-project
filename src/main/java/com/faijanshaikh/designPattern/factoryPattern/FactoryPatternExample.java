package main.java.com.faijanshaikh.designPattern.factoryPattern;

public class FactoryPatternExample {

    /*
    FactoryPattern is a creational design pattern that provides a way to create ojects in a flexible and reusable
    this pattern facilitates to create objects without exposing the creation logic to the client, factory pattern is a
    place where the objects are created and returned

    it provides a common interface for creating Objects and subclasses decides which objects created to it
     */
    public static void main(String[] args){
        Property property = PropertyFactory.getproperty("Residence");
        property.propertyName();
    }

}

class PropertyFactory {
    public static Property getproperty(String propertyName) {
        switch (propertyName) {
            case "Hospital":
                return new Hospital();
            case "Restaurant":
                return new Restaurant();
            case "Residence":
                return new Residence();
            default:
                return null;
        }

    }
}

class Hospital implements Property {
    @Override
    public void propertyName() {
        System.out.println("Its a hospital");
    }
}

class Restaurant implements Property {
    @Override
    public void propertyName() {
        System.out.println("Its a hospital");
    }
}

class Residence implements Property {
    @Override
    public void propertyName() {
        System.out.println("Its a Residence");
    }
}

package main.java.com.faijanshaikh.solidDesignPrinciples;

import java.awt.*;

public class Open_Closed_Priniple_OCP {
    /*
      In Open Closed Principle it always open for implements and closed for modifications
      it allows to implement new feautures without changing the existing code(closed for modification)
     */

    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(5, 10);
        double area = rectangle.calculateArea();

        Triangle trianle = new Triangle(2, 10);
        double area1 = trianle.calculateArea();
    }
}

interface Shape {
    double calculateArea();
}

class Rectangle implements Shape {
    private double length;
    private double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public double calculateArea() {
        return length * width;
    }
}

class Triangle implements Shape {
    private double length;
    private double width;

    public Triangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public double calculateArea() {
        return 0.5 * length * width;
    }
}
package main.java.com.faijanshaikh.designPattern.builderPattern;

public class StudentBuilder {
    /*
      Builder pattern is a creational design pattern that provides a way to create objects with flexible and readable
      it helps to create or build the complex objects in flexible and readable way, it makes the fields as optional
      and object creation compared to constructors , it avoids the telescoping constructors
     */

    private int id;
    private String name;
    private String adress;


    public StudentBuilder(){
        this.id = (int)Math.random();
    }

    public StudentBuilder setName(String name){
        this.name = name;
        return this;
    }

    public StudentBuilder setAdress(String adress){
        this.adress = adress;
        return this;
    }

    public Student build(){
        return  new Student(id, name, adress);
    }
}

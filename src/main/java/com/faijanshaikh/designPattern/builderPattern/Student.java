package main.java.com.faijanshaikh.designPattern.builderPattern;

public class Student {
    private int id;
    private String name;
    private String adress;

    Student(int id, String name, String adress) {
        this.id = id;
        this.name = name;
        this.adress = adress;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", adress='" + adress + '\'' +
                '}';
    }
}

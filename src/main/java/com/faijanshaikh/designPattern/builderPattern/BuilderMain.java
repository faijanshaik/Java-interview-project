package main.java.com.faijanshaikh.designPattern.builderPattern;

public class BuilderMain {
    public static void main(String[] args){
        StudentBuilder builder = new StudentBuilder();
        Student student = builder.setName("Faizan").build();

        System.out.println(student);
    }
}

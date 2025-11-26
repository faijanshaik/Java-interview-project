package main.java.com.faijanshaikh.shallowDeepCopy;

/*
  DeepCopy of an Object will have exact copy of all fields of the original object same like as shallow copy,
  but,if the original Object has any refrences to the other objects as fileds, then copy of those objects are also
  created by the clone method , if any changes made to the copy of an object then it reflected to the original object
*/
class Course implements Cloneable{
    public String subject1;
    public String subject2;
    public String subject3;

    public Course(String subject1, String subject2, String subject3) {
        this.subject1 = subject1;
        this.subject2 = subject2;
        this.subject3 = subject3;
    }

    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

class Student implements Cloneable{
    public int id;
    public String name;
    public Course course;

    public Student(int id, String name, Course course) {
        this.id = id;
        this.name = name;
        this.course = course;
    }

    protected Object clone() throws CloneNotSupportedException {
        Student student =(Student) super.clone();
        student.course =(Course) course.clone();
        return student;
    }
}
public class DeepCloneEx {

    public static void main(String[] args) throws CloneNotSupportedException {
        Course course = new Course("English","Maths","Sceince");
        Student student1 = new Student(1,"Faizan",course);
        Student student2 = (Student) student1.clone();
        System.out.println("name :" + student1.name);//Faizan
        System.out.println("Subject :" +student1.course.subject1);//English

        student2.course.subject1="Chemistry";
        System.out.println("Subject :" +student1.course.subject1);
    }
}

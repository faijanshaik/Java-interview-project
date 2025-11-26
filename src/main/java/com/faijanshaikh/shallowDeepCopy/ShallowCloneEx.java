package main.java.com.faijanshaikh.shallowDeepCopy;

/*
  Shallow copy of an Object will have an exact copy of all fileds of the original Object,
  the default version of clone method creates the shallow copy of an Object,
  if the original object has any references to the other objects as fields,then only the references are copied to the field,
  it will not create another copy of that object, so this, so this means any changes made to the copy of a Object that will be
  reflected to the original object

  shallow copy is not 100% independent of original Object
*/

class Courses implements Cloneable{

    public String subject1;
    public String subject2;
    public String subject3;

    public Courses(String subject1, String subject2, String subject3) {
        this.subject1 = subject1;
        this.subject2 = subject2;
        this.subject3 = subject3;
    }
}

class Student2 implements Cloneable{
    public int id;
    public String name;
    public Courses courses;

    public Student2(int id, String name, Courses courses) {
        this.id = id;
        this.name = name;
        this.courses = courses;
    }

    protected Object clone() throws CloneNotSupportedException {
        Student2 student2 = (Student2) super.clone();
        return student2;
    }
}
public class ShallowCloneEx {

    public static void main(String[] args) throws CloneNotSupportedException {
        Courses courses = new Courses("English","Maths","Sceince");
        Student2 student2 = new Student2(1,"Faizan",courses);

        Student2 student3 = (Student2)student2.clone();
        System.out.println("Name :" +student2.name);//Faizan
        System.out.println("Subject :" +student2.courses.subject1);//English

        student3.courses.subject1="Biology";
        System.out.println("Subject :" +student2.courses.subject1);//Biology
    }
}

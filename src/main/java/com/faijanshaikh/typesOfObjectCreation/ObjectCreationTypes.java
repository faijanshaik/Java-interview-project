package main.java.com.faijanshaikh.typesOfObjectCreation;

import main.java.com.faijanshaikh.serializationDeserialization.ProductDTO;
import org.ietf.jgss.GSSName;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ObjectCreationTypes {
    /*
      Thre are some different ways to create Object in java
      some of it:
      1. by using "new" keyword (standard object creation)
      2. by using clone()
      3. by using class.forName() (reflection based used in frame works)
      4. by using Constructors.newInstance()
      5. by using ObjectInputStreams
    */

    public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, CloneNotSupportedException, NoSuchMethodException, InvocationTargetException, IOException {
        //1.Object Creation by using new Keyword
        General general = new General();
        general.setName("Faizan");
        System.out.println("name :" + general.getName());

        //2. by using class.forname() reflection based used in frameworks
        Class<?> classObject = Class.forName("main.java.com.faijanshaikh.typesOfObjectCreation.General");
        General general2 = (General) classObject.newInstance();
        general2.setName("Faizan2");
        System.out.println("name :" + general2.getName());

        //3.by using Clone
        General general3 = (General) general.clone();
        general3.setName("Faizan3");
        System.out.println("name :" + general3.getName());

        //Object creation By using Constructor.newInstance()
        Class<?> newClass = Class.forName("main.java.com.faijanshaikh.typesOfObjectCreation.General");
        Object object = newClass.getDeclaredConstructor().newInstance();
        General general4 = (General) object;
        general4.setName("Faizan4");
        System.out.println("name :" + general4.getName());

        //Object Creation By using ObjectInputStream

        ProductDTO productDTO = new ProductDTO(1, "Faizan5", "", 1, false, 3);
        FileOutputStream file = new FileOutputStream("newFile.txt");
        ObjectOutputStream oos = new ObjectOutputStream(file);

        //Product Object Serialized
        oos.writeObject(productDTO);
        file.close();
        oos.close();
        FileInputStream fis = new FileInputStream("newFile.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        ProductDTO productDTO1 = (ProductDTO) ois.readObject();
        productDTO1.name = "Faizan5";
        System.out.println("name :" + productDTO1.name);
    }
}

class General implements Cloneable {
    public int id;
    public String name;
    public String adress;

    public General() {
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }
}
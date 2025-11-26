package main.java.com.faijanshaikh.serializationDeserialization;

import java.io.*;

public class SerializationExample {
    public static void main(String[] args){
        ProductDTO product = new ProductDTO(1, "Laptop", "dell", 35000, true, 4);
        String fileName ="newFile.txt";
        try{

            //saving Object into the file
            FileOutputStream file = new FileOutputStream(fileName);
            ObjectOutputStream oos = new ObjectOutputStream(file);

            //Product Object Serialized
            oos.writeObject(product);
            file.close();
            oos.close();
            System.out.println(product.toString() + "product data before deserialization");
            product.model="samsung";
        } catch(IOException ioe){
            System.out.println("IOException is caught");
        }
        product=null;
        try{
            FileInputStream fis = new FileInputStream(fileName);
            ObjectInputStream ois = new ObjectInputStream(fis);
            product =(ProductDTO) ois.readObject();
            fis.close();
            ois.close();
            System.out.println(product.toString() + "product data after deserialization");
        }catch(IOException ie){
            System.out.println("IOException is caught");
        } catch (ClassNotFoundException e) {
            System.out.println("IOException is caught");
        }

    }

    /*
      Serialization is the process of converting the java object into the streams of bytes, it helpful for the data
      exchange between the servers, and data transfer with the databse and save to file

      use cases:-
      -----------
      1.saving to the file
      2.sent over the network
      3.to work with Database

      Deserialization is the reverse process of converting back the streams of bytes into the java object
      in simple words packing the something into the suit case and sent to somewhere and unpakcing it at the location
      ---------------

      1.transient variables are excluded and will not be serializable
      2.static variables are not serializable(even initalized or not initialized at delaration)
      3.final variables are serializable( variables are initialized at declaration or intialization through constructor)
      4.if a variable contains  both static and transient keyword then it will not serialized( even instialized at declaration or through Constructor)
      5. if a variable contains both transient and final then it is only serializable

      Note: If we do not declare serialVersionUID then JVM will generate one automatically based on the class structure, if any of the field removed or added or
      class structure changes after serialized , then serialVersionUID is different from previous one, and deserialization is fails

    */

}

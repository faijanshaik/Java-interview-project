package main.java.com.faijanshaikh.serializationDeserialization;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        //Socket socket = new Socket("localhost",5000);
        try (Socket socket = new Socket("localhost", 5000)) {
            System.out.println("--------client started---------");
            ProductDTO productDTO = new ProductDTO(1, "Laptop", "dell",35000, true, 4);
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(productDTO);//product sent to server
            oos.flush();
            System.out.println("--------product sent to server---------");
            oos.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

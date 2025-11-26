package main.java.com.faijanshaikh.serializationDeserialization;

import main.java.com.faijanshaikh.completableFutures.ProductDTO;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        System.out.println("----server started----");
        ServerSocket serverSocket = new ServerSocket(5000);
        Socket socket = serverSocket.accept();
        System.out.println("----server Connected----");
        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
        ProductDTO product = (ProductDTO) ois.readObject();
        System.out.println("----product recieved-----");
        System.out.println(product);
        serverSocket.close();
        socket.close();
        ois.close();
    }
}

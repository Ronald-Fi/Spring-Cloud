package com.example.demo.serializable_demo;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ServerSocket serverSocket = null;
        serverSocket = new ServerSocket(8080);
        Socket socket = serverSocket.accept();
        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
        User user = (User) ois.readObject();
        System.out.println(user);
        serverSocket.close();
    }
}

package com.example.demo.serializable_demo;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = null;
        socket = new Socket("localhost", 8080);
        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
        User user = new User();
        user.setAge(18);
        user.setName("Ron");
        oos.writeObject(user);
        socket.close();
    }
}

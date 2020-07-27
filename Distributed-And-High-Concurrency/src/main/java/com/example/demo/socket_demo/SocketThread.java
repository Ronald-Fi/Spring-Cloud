package com.example.demo.socket_demo;

import java.io.IOException;
import java.net.Socket;

public class SocketThread implements Runnable {

    Socket socket;

    public SocketThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        //业务处理
        try {
            socket.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package com.example.demo.socket_demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TestA {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;
        try {
            serverSocket = new ServerSocket(8080);
            socket = serverSocket.accept();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String line;
        try {
            BufferedReader is = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter os = new PrintWriter(socket.getOutputStream());
            BufferedReader sin = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Receve Client Msg:" + is.readLine());
            line = sin.readLine();
            while (!line.equals("bye")) {
                os.println(line);
                os.flush();
                System.out.println("Receve Client Msg" + is.readLine());
                line = sin.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

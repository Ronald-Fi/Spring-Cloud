package com.example.demo.socket_demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class App {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 8080);
        BufferedReader sin = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter os = new PrintWriter(socket.getOutputStream());
        BufferedReader is = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String readline = sin.readLine();
        while (!readline.equals("bye")) {
            os.println(readline);
            os.flush();
            System.out.println("Receve Client Msg" + is.readLine());
            readline = sin.readLine();
        }
        os.close();
        is.close();
        socket.close();
    }
}

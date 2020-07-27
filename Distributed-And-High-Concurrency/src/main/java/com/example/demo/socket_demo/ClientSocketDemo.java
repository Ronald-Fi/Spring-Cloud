package com.example.demo.socket_demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientSocketDemo {
    public static void main(String[] args) {
        try {
            //找到目标IP和端口号
            Socket socket = new Socket("localhost", 8080);
            //getOutputStream获取输出流、PrintWriter在当前连接上写入输入
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            //out.println("Hello R");
            //TODO 改造start
            //控制台输入流
            BufferedReader sin = new BufferedReader(new InputStreamReader(System.in));
            //获取输入流
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            //获得控制台输入流
            String readLine = sin.readLine();
            while (!readLine.equals("bye")) {
                out.println(readLine);
                System.out.println("Server:" + in.readLine());
                //重新获取数据
                readLine = sin.readLine();
            }
            //TODO 改造end
            sin.close();
            in.close();
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

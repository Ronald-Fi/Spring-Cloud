package com.example.demo.socket_demo;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServerSocketDemo {
    static ExecutorService executorService = Executors.newCachedThreadPool();

    public static void main(String[] args) {
        //打开连接
        ServerSocket serverSocket = null;
        try {
            //默认本机IP 必须指定监听端口
            serverSocket = new ServerSocket(8080);
            //优化
            while (true) {
                //接收客户端连接（阻塞）
                Socket socket = serverSocket.accept();
                //线程不可控、不建议使用
                //new Thread(new SocketThread(socket)).start();
                //利用线程池进行优化阻塞问题、NIO机制这种方式弃用
                executorService.execute(new SocketThread(socket));
            }
            //getInputStream拿到输入流
//            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//            //获得客户端的输入信息
//            //System.out.println(in.readLine());
//            //改造 start
//            //输出流
//            PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
//            //通过控制台拿到数据
//            BufferedReader sin = new BufferedReader(new InputStreamReader(System.in));
//            //获得控制台输入的数据
//            System.out.println("Client:" + in.readLine());
//            String line = sin.readLine();
//            while (!line.equals("bye")) {
//                //写回客户端
//                printWriter.println(line);
//                printWriter.flush();
//                //读取客户端传过来的数据
//                System.out.println("Client:" + in.readLine());
//                //重新读取控制台的数据
//                line = sin.readLine();
//            }
//            //System.out.println(in.readLine());
//            //改造 end
//            sin.close();
//            in.close();
//            printWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

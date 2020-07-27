package com.example.proxy;

import com.example.domain.ProcessorHandler;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RPCProxyServer {

    private static boolean IS_STATE = true;
    ExecutorService es = Executors.newCachedThreadPool();

    public void publisher(Object service, int port) {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(port);
            //不断接收请求
            while (IS_STATE) {
                //BIO阻塞
                Socket socket = serverSocket.accept();
                es.execute(new ProcessorHandler(socket, service));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != serverSocket) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

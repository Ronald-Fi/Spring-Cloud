package com.example.domain;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class RPCNetTransport {

    private String host;

    private int port;

    public RPCNetTransport(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public Object send(RPCRequest request) {
        Socket socket = null;
        Object result = null;
        ObjectInputStream ois = null;
        ObjectOutputStream oos = null;
        try {
            //创建连接
            socket = new Socket(host, port);
            //网络Socket
            oos = new ObjectOutputStream(socket.getOutputStream());
            //序列化
            oos.writeObject(request);
            oos.flush();
            ois = new ObjectInputStream(socket.getInputStream());
            result = ois.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (null != ois) {
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != oos) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }
}

package com.example.io.bio;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.UUID;

public class BIOClient {

    public static void main(String[] args) throws IOException {
        //要和谁进行通信,服务器IP、服务器的端口
        //一台机器的端口号是有限
        Socket client = new Socket("localhost", 8080);

        //输出 O  write();
        //不管是客户端还是服务端,都有可能write和read
        //如果要进行读写、创建两个线程：一个读一个写
        OutputStream os = client.getOutputStream();

        //生成一个随机的ID
        String name = UUID.randomUUID().toString().replace("-", "");

        System.out.println("客户端发送数据：" + name);
        //传说中的101011010
        os.write(name.getBytes());
        os.close();
        client.close();
    }

}

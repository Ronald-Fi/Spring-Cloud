package com.example.server;

import com.example.annotation.RPCService;
import com.example.domain.ProcessorHandler;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RPCServer implements ApplicationContextAware, InitializingBean {

    private static boolean IS_STATE = true;
    ExecutorService es = Executors.newCachedThreadPool();
    Map<String, Object> handlerMap = new HashMap<>();

    private int port;

    public RPCServer(int port) {
        this.port = port;
    }

    //属性设置完毕调用
    @Override
    public void afterPropertiesSet() throws Exception {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(port);
            //不断接收请求
            while (IS_STATE) {
                //BIO阻塞
                Socket socket = serverSocket.accept();
                es.execute(new ProcessorHandler(socket, handlerMap));
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

    //设置应用上下文
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        Map<String, Object> serviceBeanMap = applicationContext.getBeansWithAnnotation(RPCService.class);
        if (!serviceBeanMap.isEmpty()) {
            for (Object serviceBean : serviceBeanMap.values()) {
                RPCService rpcService = serviceBean.getClass().getAnnotation(RPCService.class);
                String serviceName = rpcService.value().getName();
                handlerMap.put(serviceName, serviceBean);
            }
        }
    }
}

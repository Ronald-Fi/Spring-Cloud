package com.example.domain;

import org.springframework.util.StringUtils;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.Socket;
import java.util.Map;

public class ProcessorHandler implements Runnable {

    private Socket socket;
    private Map<String, Object> handlerMap;

    public ProcessorHandler(Socket socket, Map<String, Object> handlerMap) {
        this.socket = socket;
        this.handlerMap = handlerMap;
    }

    @Override
    public void run() {
        ObjectInputStream ois = null;
        ObjectOutputStream oos = null;
        try {
            //输入
            ois = new ObjectInputStream(socket.getInputStream());
            RPCRequest request = (RPCRequest) ois.readObject();
            //反射调用本地服务
            Object result = invoke(request);
            //输出
            oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(result);
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
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
    }

    private Object invoke(RPCRequest request) throws ClassNotFoundException, NoSuchMethodException,
            InvocationTargetException, IllegalAccessException {
        //反射调用
        String serviceName = request.getClassName();
        String version = request.getVersion();
        //增加版本号判断
        if (!StringUtils.isEmpty(version)) {
            serviceName += "-" + version;
        }
        Object service = handlerMap.get(serviceName);
        if (null == service) {
            throw new RuntimeException("service not found:" + serviceName);
        }

        Object[] args = request.getParameters();//获取客户端请求
        Class<?>[] types = new Class[args.length];//获取每个参数类型
        for (int i = 0; i < args.length; i++) {
            types[i] = args[i].getClass();
        }
        //请求类名
        Class clazz = Class.forName(request.getClassName());//根据请求的类进行加载
        //请求方法名
        Method method = clazz.getMethod(request.getMethodName(), types);//找到请求类中的方法（sayHello，saveUser）
        Object result = method.invoke(service, args);//进行反射调用（HelloServiceImpl）
        return result;
    }
}

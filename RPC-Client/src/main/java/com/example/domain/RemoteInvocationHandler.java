package com.example.domain;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class RemoteInvocationHandler implements InvocationHandler {

    private String host;

    private int port;

    public RemoteInvocationHandler(String host, int port) {
        this.host = host;
        this.port = port;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("come in");
        //请求数据的包装
        RPCRequest request = new RPCRequest();
        request.setClassName(method.getDeclaringClass().getName());
        request.setMethodName(method.getName());
        request.setParameters(args);
        request.setVersion("v2.0");
        //远程通信
        RPCNetTransport netTransport = new RPCNetTransport(host, port);
        Object result = netTransport.send(request);
        return result;
    }
}

package com.example.proxy;

import com.example.domain.RemoteInvocationHandler;

import java.lang.reflect.Proxy;

public class RPCProxyClient {

    public <T> T clientProxy(final Class<T> interfaceCls, final String host, final int port) {
        //Java原生动态代理
        return (T) Proxy.newProxyInstance(interfaceCls.getClassLoader(), new Class<?>[]{interfaceCls},
                new RemoteInvocationHandler(host, port));
    }

}

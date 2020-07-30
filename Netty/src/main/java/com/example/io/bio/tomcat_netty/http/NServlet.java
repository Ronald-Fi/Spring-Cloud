package com.example.io.bio.tomcat_netty.http;

public abstract class NServlet {

    public void service(NRequest request, NResponse response) throws Exception {
        //由service方法来决定,是调用doGet或者调用doPost
        if ("GET".equalsIgnoreCase(request.getMethod())) {
            doGet(request, response);
        } else {
            doPost(request, response);
        }
    }

    public abstract void doGet(NRequest request, NResponse response) throws Exception;

    public abstract void doPost(NRequest request, NResponse response) throws Exception;
}

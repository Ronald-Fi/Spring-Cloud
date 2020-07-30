package com.example.io.bio.tomcat.http;

public abstract class TServlet {
    public void service(TRequest request, TResponse response) throws Exception {
        if ("GET".equalsIgnoreCase(request.getMethod())) {
            doGet(request, response);
        } else {
            doPost(request, response);
        }
    }

    public abstract void doGet(TRequest request, TResponse response) throws Exception;

    public abstract void doPost(TRequest request, TResponse response) throws Exception;
}

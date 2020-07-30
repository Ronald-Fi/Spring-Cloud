package com.example.io.bio.tomcat.servlet;


import com.example.io.bio.tomcat.http.TRequest;
import com.example.io.bio.tomcat.http.TResponse;
import com.example.io.bio.tomcat.http.TServlet;

public class FirstServlet extends TServlet {

    public void doGet(TRequest request, TResponse response) throws Exception {
        this.doPost(request, response);
    }

    public void doPost(TRequest request, TResponse response) throws Exception {
        response.write("This is First Servlet");
    }

}

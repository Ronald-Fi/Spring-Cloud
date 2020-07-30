package com.example.io.bio.tomcat_netty.servlet;


import com.example.io.bio.tomcat_netty.http.NRequest;
import com.example.io.bio.tomcat_netty.http.NResponse;
import com.example.io.bio.tomcat_netty.http.NServlet;

public class SecondServlet extends NServlet {

    public void doGet(NRequest request, NResponse response) throws Exception {
        this.doPost(request, response);
    }

    public void doPost(NRequest request, NResponse response) throws Exception {
        response.write("This is Second Servlet");
    }

}

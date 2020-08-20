package com.example.chat.server.handler;

import io.netty.channel.*;
import io.netty.handler.codec.http.*;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.RandomAccessFile;
import java.net.URL;

@Slf4j
public class HttpServerHandler extends SimpleChannelInboundHandler<FullHttpRequest> {
    //获取class路径
    private URL baseURL = HttpServerHandler.class.getResource("");
    private final String webroot = "webroot";

    private File getResource(String fileName) throws Exception {
        String basePath = baseURL.toURI().toString();
        int start = basePath.indexOf("classes/");
        basePath = (basePath.substring(0, start) + "/" + "classes/").replaceAll("/+", "/");

        //找到WebRoot目录
        String path = basePath + webroot + "/" + fileName;
        //log.info("BaseURL:" + basePath);
        path = !path.contains("file:") ? path : path.substring(5);
        path = path.replaceAll("//", "/");
        return new File(path);
    }

    @Override
    public void channelRead0(ChannelHandlerContext ctx, FullHttpRequest request) throws Exception {
        //业务逻辑 请求一个URL相当于读取一个静态资源文件
        String uri = request.getUri();
        //文件读取器
        RandomAccessFile file = null;

        try {
            String page = uri.equals("/") ? "chat.html" : uri;
            file = new RandomAccessFile(getResource(page), "r");
        } catch (Exception e) {
            ctx.fireChannelRead(request.retain());
            return;
        }

        //构建HttpResponse对象、准备文件内容写出
        HttpResponse response = new DefaultHttpResponse(request.getProtocolVersion(), HttpResponseStatus.OK);
        String contextType = "text/html;";

        if (uri.endsWith(".css")) {
            contextType = "text/css;";
        } else if (uri.endsWith(".js")) {
            contextType = "text/javascript;";
        } else if (uri.toLowerCase().matches(".*\\.(jpg|png|gif)$")) {
            String ext = uri.substring(uri.lastIndexOf("."));
            contextType = "image/" + ext;
        }
        response.headers().set(HttpHeaders.Names.CONTENT_TYPE, contextType + "charset=utf-8;");

        //需要在页面上支持WebSocket,设置长链接
        boolean keepAlive = HttpHeaders.isKeepAlive(request);
        if (keepAlive) {
            response.headers().set(HttpHeaders.Names.CONTENT_LENGTH, file.length());
            response.headers().set(HttpHeaders.Names.CONNECTION, HttpHeaders.Values.KEEP_ALIVE);
        }
        //写出
        ctx.write(response);
        ctx.write(new DefaultFileRegion(file.getChannel(), 0, file.length()));

        //异步监听
        ChannelFuture future = ctx.writeAndFlush(LastHttpContent.EMPTY_LAST_CONTENT);
        if (!keepAlive) {
            future.addListener(ChannelFutureListener.CLOSE);
        }

        file.close();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        Channel client = ctx.channel();
        log.info("Client:" + client.remoteAddress() + "异常");
        //当出现异常就关闭连接
        cause.printStackTrace();
        ctx.close();
    }
}


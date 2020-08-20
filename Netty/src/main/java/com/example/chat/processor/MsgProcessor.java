package com.example.chat.processor;

import com.alibaba.fastjson.JSONObject;
import com.example.chat.protocol.IMDecoder;
import com.example.chat.protocol.IMEncoder;
import com.example.chat.protocol.IMMessage;
import com.example.chat.protocol.IMP;
import io.netty.channel.Channel;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.util.AttributeKey;
import io.netty.util.concurrent.GlobalEventExecutor;

/**
 * 主要用于自定义协议内容的逻辑处理
 */
public class MsgProcessor {

    //容器:记录在线用户
    private static ChannelGroup onlineUsers = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    //定义一些扩展属性
    public static final AttributeKey<String> NICK_NAME = AttributeKey.valueOf("nickName");
    public static final AttributeKey<String> IP_ADDR = AttributeKey.valueOf("ipAddr");
    public static final AttributeKey<JSONObject> ATTRS = AttributeKey.valueOf("attrs");
    public static final AttributeKey<String> FROM = AttributeKey.valueOf("from");

    //自定义解码器
    private IMDecoder decoder = new IMDecoder();
    //自定义编码器
    private IMEncoder encoder = new IMEncoder();

    /**
     * 获取用户昵称
     *
     * @param client
     * @return
     */
    public String getNickName(Channel client) {
        return client.attr(NICK_NAME).get();
    }

    /**
     * 获取用户远程IP地址
     *
     * @param client
     * @return
     */
    public String getAddress(Channel client) {
        return client.remoteAddress().toString().replaceFirst("/", "");
    }

    /**
     * 获取扩展属性
     *
     * @param client
     * @return
     */
    public JSONObject getAttrs(Channel client) {
        try {
            return client.attr(ATTRS).get();
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 获取扩展属性
     *
     * @param client
     * @return
     */
    private void setAttrs(Channel client, String key, Object value) {
        try {
            JSONObject json = client.attr(ATTRS).get();
            json.put(key, value);
            client.attr(ATTRS).set(json);
        } catch (Exception e) {
            JSONObject json = new JSONObject();
            json.put(key, value);
            client.attr(ATTRS).set(json);
        }
    }

    /**
     * 登出通知
     *
     * @param client
     */
    public void logout(Channel client) {
        //如果nickName为null，没有遵从聊天协议的连接，表示未非法登录
        if (getNickName(client) == null) {
            return;
        }
        for (Channel channel : onlineUsers) {
            IMMessage request = new IMMessage(IMP.SYSTEM.getName(), sysTime(), onlineUsers.size(), getNickName(client) + "离开");
            String content = encoder.encode(request);
            channel.writeAndFlush(new TextWebSocketFrame(content));
        }
        onlineUsers.remove(client);
    }

    /**
     * 发送消息
     *
     * @param client
     * @param msg    控制台拿到的数据
     */
    public void sendMsg(Channel client, IMMessage msg) {
        sendMsg(client, encoder.encode(msg));
    }

    /**
     * 发送消息
     *
     * @param client
     * @param msg    socket拿到的数据
     */
    public void sendMsg(Channel client, String msg) {

        IMMessage request = decoder.decode(msg);
        if (null == request) {
            return;
        }

        String addr = getAddress(client);

        if (request.getCmd().equals(IMP.LOGIN.getName())) {
            client.attr(NICK_NAME).getAndSet(request.getSender());
            client.attr(IP_ADDR).getAndSet(addr);
            client.attr(FROM).getAndSet(request.getTerminal());
            //System.out.println(client.attr(FROM).get());
            onlineUsers.add(client);

            //通知在线用户、XX上线了
            for (Channel channel : onlineUsers) {
                boolean isself = (channel == client);
                if (!isself) {
                    //不是自己
                    request = new IMMessage(IMP.SYSTEM.getName(), sysTime(), onlineUsers.size(), getNickName(client) + "加入");
                } else {
                    //自己
                    request = new IMMessage(IMP.SYSTEM.getName(), sysTime(), onlineUsers.size(), "已与服务器建立连接！");
                }

                //消息准备好、开始推送消息
                //如果终端是控制台、推送IMMessage
                if ("Console".equals(channel.attr(FROM).get())) {
                    //开始推送消息包
                    channel.writeAndFlush(request);
                    continue;
                }
                //如果终端是WebSocket、推送支持WebSocket的自定义协议字符串
                String content = encoder.encode(request);
                channel.writeAndFlush(new TextWebSocketFrame(content));
            }
        } else if (request.getCmd().equals(IMP.CHAT.getName())) {
            for (Channel channel : onlineUsers) {
                boolean isself = (channel == client);
                if (isself) {
                    request.setSender("you");
                } else {
                    request.setSender(getNickName(client));
                }
                request.setTime(sysTime());

                if ("Console".equals(channel.attr(FROM).get()) & !isself) {
                    channel.writeAndFlush(request);
                    continue;
                }
                String content = encoder.encode(request);
                channel.writeAndFlush(new TextWebSocketFrame(content));
            }
        } else if (request.getCmd().equals(IMP.FLOWER.getName())) {
            JSONObject attrs = getAttrs(client);
            long currTime = sysTime();
            if (null != attrs) {
                long lastTime = attrs.getLongValue("lastFlowerTime");
                //60秒之内不允许重复刷鲜花
                int secends = 10;
                long sub = currTime - lastTime;
                if (sub < 1000 * secends) {
                    request.setSender("you");
                    request.setCmd(IMP.SYSTEM.getName());
                    request.setContent("您送鲜花太频繁," + (secends - Math.round(sub / 1000)) + "秒后再试");

                    String content = encoder.encode(request);
                    client.writeAndFlush(new TextWebSocketFrame(content));
                    return;
                }
            }
            //正常送花
            for (Channel channel : onlineUsers) {
                if (channel == client) {
                    request.setSender("you");
                    request.setContent("你给大家送了一波鲜花雨");
                    setAttrs(client, "lastFlowerTime", currTime);
                } else {
                    request.setSender(getNickName(client));
                    request.setContent(getNickName(client) + "送来一波鲜花雨");
                }
                request.setTime(sysTime());
                //只有Web页面支持刷花
                String content = encoder.encode(request);
                channel.writeAndFlush(new TextWebSocketFrame(content));
            }
        }
    }

    /**
     * 获取系统时间
     *
     * @return
     */
    private Long sysTime() {
        return System.currentTimeMillis();
    }

}

package com.example.chat.protocol;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import org.msgpack.MessagePack;
import org.msgpack.MessageTypeException;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 自定义IM协议的编码器
 */
public class IMDecoder extends ByteToMessageDecoder {

    //解析IM写一下请求内容的正则
    private Pattern pattern = Pattern.compile("^\\[(.*)\\](\\s\\-\\s(.*))?");

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        try {
            //先获取可读字节数
            final int length = in.readableBytes();
            final byte[] array = new byte[length];
            //将网络传输的二进制内容转换成字符串
            String content = new String(array, in.readerIndex(), length);

            //空消息不解析
            if (!(null == content || "".equals(content.trim()))) {
                if (!IMP.isIMP(content)) {
                    ctx.channel().pipeline().remove(this);
                    return;
                }
            }
            //将字符串变成可识别的IMMessage对象
            in.getBytes(in.readerIndex(), array, 0, length);
            //利用MessagePack序列化框架将网络流信息直接转换成IMMessage对象
            out.add(new MessagePack().read(array, IMMessage.class));
            in.clear();
        } catch (MessageTypeException e) {
            ctx.channel().pipeline().remove(this);
        }
    }

    /**
     * 字符串解析成自定义即时通信协议
     *
     * @param msg
     * @return
     */
    public IMMessage decode(String msg) {
        if (null == msg || "".equals(msg.trim())) {
            return null;
        }
        //解析字符串最好的办法就是正则
        Matcher m = pattern.matcher(msg);
        //消息头
        String header = "";
        //消息体
        String content = "";
        if (m.matches()) {
            header = m.group(1);
            content = m.group(3);
        }

        //分割消息
        String[] headers = header.split("\\]\\[");
        long time = Long.parseLong(headers[1]);
        String nickName = headers[2];
        //昵称最多十个字
        nickName = nickName.length() < 10 ? nickName : nickName.substring(0, 9);

        if (msg.startsWith("[" + IMP.LOGIN.getName() + "]")) {
            return new IMMessage(headers[0], headers[3], time, nickName);
        } else if (msg.startsWith("[" + IMP.CHAT.getName() + "]")) {
            return new IMMessage(headers[0], time, nickName, content);
        } else if (msg.startsWith("[" + IMP.FLOWER.getName() + "]")) {
            return new IMMessage(headers[0], headers[3], time, nickName);
        } else {
            return null;
        }
    }
}

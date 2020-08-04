package com.example.rpc.registry;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;
import io.netty.handler.codec.serialization.ClassResolvers;
import io.netty.handler.codec.serialization.ObjectDecoder;
import io.netty.handler.codec.serialization.ObjectEncoder;

public class RpcRegistry {
    private int port;

    public RpcRegistry(int port) {
        this.port = port;
    }

    public void start() {

        //初始化主线程
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        //初始化子线程池,具体对应客户端的处理逻辑
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        try {
            ServerBootstrap b = new ServerBootstrap();
            //客户端链接出发init方法进行回调
            b.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            //在Netty中,把所有业务逻辑处理全部归总到了一个队列中
                            //这个队列中包含了各样的处理逻辑,这些处理逻辑在Netty中封装好了
                            //封装了一个对象,无锁化串行任务队列 pipeline
                            ChannelPipeline pipeline = ch.pipeline();
                            //pipeline就是对我们处理逻辑的封装
                            //自定义协议解码器
                            /** 入参有5个,分别解释如下
                             maxFrameLength：框架的最大长度。如果帧的长度大于此值,则将抛出TooLongFrameException。
                             lengthFieldOffset：长度字段的偏移量：即对应的长度字段在整个消息数据中得位置
                             lengthFieldLength：长度字段的长度。如：长度字段是int型表示,那么这个值就是4（long型就是8）
                             lengthAdjustment：要添加到长度字段值的补偿值
                             initialBytesToStrip：从解码帧中去除的第一个字节数
                             */
                            pipeline.addLast(new LengthFieldBasedFrameDecoder(Integer.MAX_VALUE, 0, 4, 0, 4));
                            //自定义协议编码器
                            pipeline.addLast(new LengthFieldPrepender(4));
                            //对象参数类型编码器
                            pipeline.addLast("encoder", new ObjectEncoder());
                            //对象参数类型解码器
                            pipeline.addLast("decoder", new ObjectDecoder(Integer.MAX_VALUE,
                                    ClassResolvers.cacheDisabled(null)));
                            //最后一步执行自己的逻辑
                            //1、注册，给每个对象起一个名字,对外提供服务的名字
                            //2、服务的位置进行登记
                            pipeline.addLast(new RegistryHandler());
                        }
                    })
                    .option(ChannelOption.SO_BACKLOG, 128)
                    .childOption(ChannelOption.SO_KEEPALIVE, true);
            //正式启动，相当于用一个死循环进行轮询
            ChannelFuture future = b.bind(port).sync();
            System.out.println("I RPC Registry start listen at " + port);
            future.channel().closeFuture().sync();
        } catch (Exception e) {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }

    public static void main(String[] args) throws Exception {
        new RpcRegistry(8081).start();
    }
}  

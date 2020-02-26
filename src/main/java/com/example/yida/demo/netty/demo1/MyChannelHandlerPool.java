package com.example.yida.demo.netty.demo1;

import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

/**
 * MyChannelHandlerPool
 * 通道组池，管理所有websocket连接
 *
 * @author zhangyifei
 * @date 2020-02-26
 */
public class MyChannelHandlerPool {

    public MyChannelHandlerPool() {
    }

    public static ChannelGroup channelGroup = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

}

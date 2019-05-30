package netty;

import org.jboss.netty.channel.*;

/**
 * @author xuan
 * @date 2018-05-04 00:24.
 */

public class HiHandler extends SimpleChannelHandler {
    /** 接收消息*/
    @Override
    public void messageReceived(ChannelHandlerContext ctx, MessageEvent e) throws Exception {
        String s = (String) e.getMessage();
        System.out.println(s);
        super.messageReceived(ctx, e);
    }
    /** 捕获异常*/
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, ExceptionEvent e) throws Exception {
        System.out.println("exceptionCaught HiHandler");
        super.exceptionCaught(ctx, e);
    }
    /** 新连接*/
    @Override
    public void channelConnected(ChannelHandlerContext ctx, ChannelStateEvent e) throws Exception {
        System.out.println("channelConnected");
        super.channelConnected(ctx, e);
    }
    /** 必须是链接已经建立，关闭通道的时候才会触发*/
    @Override
    public void channelDisconnected(ChannelHandlerContext ctx, ChannelStateEvent e) throws Exception {
        System.out.println("channelDisconnected");
        super.channelDisconnected(ctx, e);
    }
    /** channel关闭的时候触发*/
    @Override
    public void channelClosed(ChannelHandlerContext ctx, ChannelStateEvent e) throws Exception {
        System.out.println("channelClosed");
        super.channelClosed(ctx, e);
    }
}
package netty;

import org.jboss.netty.bootstrap.ServerBootstrap;
import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.ChannelPipelineFactory;
import org.jboss.netty.channel.Channels;
import org.jboss.netty.channel.socket.nio.NioServerSocketChannelFactory;

import java.net.InetSocketAddress;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    public  void start() {
        // 服务类,用于启动netty 在netty5中同样使用这个类来启动
        ServerBootstrap bootstrap = new ServerBootstrap();
        // 新建两个线程池  boss线程监听端口，worker线程负责数据读写
        ExecutorService boss = Executors.newCachedThreadPool();
        ExecutorService worker = Executors.newCachedThreadPool();
        // 设置niosocket工厂  类似NIO程序新建ServerSocketChannel和SocketChannel
        bootstrap.setFactory(new NioServerSocketChannelFactory(boss, worker));
        // 设置管道的工厂
        bootstrap.setPipelineFactory(new ChannelPipelineFactory() {
            @Override
            public ChannelPipeline getPipeline() throws Exception {
                ChannelPipeline pipeline = Channels.pipeline();
                //pipeline.addLast("decoder", new StringDecoder());

                pipeline.addLast("ServerDecoder", new ServerDecoder());  //添加一个Handler来处理客户端的事件，Handler需要继承ChannelHandler
                //pipeline.addLast("encoder", new StringEncoder());
                pipeline.addLast("ServerHandler", new ServerHandler());  //添加一个Handler来处理客户端的事件，Handler需要继承ChannelHandler
                return pipeline;
            }
        });
        bootstrap.bind(new InetSocketAddress(10101));
        System.out.println("start!!!");
    }
}
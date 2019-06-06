package netty;


import org.jboss.netty.bootstrap.ClientBootstrap;
import org.jboss.netty.channel.*;
import org.jboss.netty.channel.socket.nio.NioClientSocketChannelFactory;
import org.jboss.netty.handler.codec.string.StringDecoder;
import org.jboss.netty.handler.codec.string.StringEncoder;

import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client {
    public  void run() throws InterruptedException {
        // 客户端的启动类
        ClientBootstrap bootstrap = new ClientBootstrap();
        //线程池
        ExecutorService boss = Executors.newCachedThreadPool();
        ExecutorService worker = Executors.newCachedThreadPool();
        //socket工厂
        bootstrap.setFactory(new NioClientSocketChannelFactory(boss, worker));
        //管道工厂
        bootstrap.setPipelineFactory(new ChannelPipelineFactory() {
            @Override
            public ChannelPipeline getPipeline() throws Exception {
                ChannelPipeline pipeline = Channels.pipeline();
                pipeline.addLast("decoder", new StringDecoder());
                pipeline.addLast("encoder", new StringEncoder());
                pipeline.addLast("hiHandler", new HiHandler());
                return pipeline;
            }
        });
        //连接服务端
        ChannelFuture connect = bootstrap.connect(new InetSocketAddress("127.0.0.1", 10101));
        Channel channel = connect.getChannel();
        System.out.println("client start");
        //Scanner scanner = new Scanner(System.in);
        int total=100;
        while(total--!=0){

            System.out.println("发送中");
            channel.write(init());

            Thread.currentThread().sleep(2000);
        }
        System.out.println("发送完毕");
    }

    private Pack init(){
        Random r=new Random();
        List<FmsPlan> fmsPlans =new ArrayList<FmsPlan>();
        Integer numLegs;
        List<FmsRoute> fmsRoutes=new ArrayList<FmsRoute>();
        Pack pack=new Pack();
        for (int i=0 ;i<30;i++){
            FmsPlan fmsPlan =new FmsPlan();


            fmsPlan.setLegType(20);
            fmsPlan.setLegLength(r.nextFloat());
            fmsPlan.setOverfly('a');


            fmsPlan.setOriginWptIdent("PK     ");
            fmsPlan.setOriginWptPositionLat(r.nextFloat());
            fmsPlan.setOriginWptPositionLon(r.nextFloat());


            fmsPlan.setTermWptIdent("POMOK  ");
            fmsPlan.setTermWptPositionLat(r.nextFloat());
            fmsPlan.setTermWptPositionLon(r.nextFloat());

            fmsPlan.setRefWaypointPositionLat(r.nextFloat());
            fmsPlan.setRefWaypointPositionLon(r.nextFloat());

            fmsPlan.setRefDistance(r.nextFloat());
            fmsPlan.setTurnDirection(r.nextInt());

            fmsPlan.setLowerAltRestriction(r.nextFloat());
            fmsPlan.setUpperAltRestriction(r.nextFloat());
            fmsPlan.setSpeedRestrictionSpeed(r.nextFloat());
            fmsPlan.setRta(r.nextFloat());

            fmsPlan.setPredictedAltitude(r.nextFloat());
            fmsPlan.setPredictedSpeed(r.nextFloat());
            fmsPlan.setEta(r.nextFloat());
            fmsPlan.setTemperatureInfo(r.nextFloat());
            fmsPlan.setWindMagnitude(r.nextFloat());
            fmsPlan.setWindDirection(r.nextFloat());
            fmsPlan.setFuelRemaining(97f);
            fmsPlans.add(fmsPlan);




            FmsRoute fmsRoute = new FmsRoute();

            fmsRoute.setIndex(80);
            fmsRoute.setDist(r.nextFloat());
            fmsRoute.setAltitude(r.nextFloat());
            fmsRoute.setVpa(r.nextFloat());
            fmsRoute.setInputAltitudeLimit(r.nextFloat());
            fmsRoute.setMode(r.nextInt());
            fmsRoute.setLimitType(r.nextInt());
            fmsRoute.setApproachLegTypes(100);
            fmsRoutes.add(fmsRoute);



        }

        pack.setFmsPlans(fmsPlans);
        pack.setFmsRoutes(fmsRoutes);
        pack.setNumLegs((short)14);
        return pack;
    }
}

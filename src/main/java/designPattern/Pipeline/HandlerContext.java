package designPattern.Pipeline;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author xuan
 * @date 2019-05-16 12:30.
 */

public class HandlerContext {
    private ExecutorService executor= Executors.newCachedThreadPool();
    private Handler handler;
    private HandlerContext next;
    public HandlerContext(Handler handler){
        this.handler=handler;
    }
    public void setNext(HandlerContext ctx){
        this.next=ctx;
    }
    public void doWork(Object msg){
        if(next==null){
            if(this instanceof Pipeline.HeadContext)
                executor.submit(
                        () -> handler.channelRead(next,msg));
            return;
        }else {
            executor.submit(
                    () -> handler.channelRead(next,msg));
        }
    }

    public void  write(Object msg){
        doWork(msg);
    }






}

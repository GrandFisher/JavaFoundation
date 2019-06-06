package designPattern.Pipeline;

import java.util.Date;

/**
 * @author xuan
 * @date 2019-05-16 13:17.
 */

public class TestHandler1 implements Handler {

    @Override
    public void channelRead(HandlerContext ctx, Object msg) {
        try {
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        String result = (String) msg + "|handler1";
        Date date=new Date();
        System.out.println("handler1 do work at:"+ date.toString()+"| msg:" + result);

        ctx.write(result);
    }
}

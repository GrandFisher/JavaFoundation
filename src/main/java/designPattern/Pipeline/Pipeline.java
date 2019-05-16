package designPattern.Pipeline;

/**
 * @author xuan
 * @date 2019-05-16 12:28.
 */

public class Pipeline {
    private HandlerContext head;
    private HandlerContext tail;

    final class HeadContext extends HandlerContext{
        public HeadContext(Handler handler) {
            super(handler);
        }
    }
    final class HeadHandler implements Handler{
        @Override
        public void channelRead(HandlerContext ctx, Object msg) {
            String result= (String) msg+ "end";
            System.out.println(result);
        }
    }

    public Pipeline(){
        head=tail=new HeadContext(new HeadHandler());
    }
    public void addFirst(Handler handler){
        HandlerContext ctx=new HandlerContext(handler);
        HandlerContext temp=head;
        head=ctx;
        head.setNext(temp);
    }

    public void Request(Object msg){//封装了外部调用接口
        head.doWork(msg);
    }
}

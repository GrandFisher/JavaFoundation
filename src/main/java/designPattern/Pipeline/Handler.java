package designPattern.Pipeline;

/**
 * @author xuan
 * @date 2019-05-16 12:29.
 */

public interface Handler {

    void channelRead(HandlerContext ctx, Object msg);

}

package netty;

import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.handler.codec.frame.FixedLengthFrameDecoder;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;

/**
 * @author xuan
 * @date 2018-05-04 00:58.
 */

public class ServerDecoder  extends FixedLengthFrameDecoder {
    private static final int FRAME_LONG_LENGTH = 3932;

    public ServerDecoder() {
        super(FRAME_LONG_LENGTH);
    }

    @Override
    protected Object decode(
            ChannelHandlerContext ctx, Channel channel, ChannelBuffer buffer) throws Exception {

        final Object ret = super.decode(ctx, channel, buffer);
        System.out.println("haha");
        if (ret == null) {
            System.out.println("完全没收到");
            return null;
        }
        final ChannelBuffer frame = (ChannelBuffer) ret;
        //final FmsPacket fmsPacket = new FmsPacket();


        /**/
        System.out.println(frame.capacity());

        String fileName = "D:\\r\\out.txt";
        String fileName1 = "D:\\r\\outContent.txt";


        DataOutputStream out = new DataOutputStream(new BufferedOutputStream(
                new FileOutputStream(fileName, true)));
        DataOutputStream out1 = new DataOutputStream(new BufferedOutputStream(
                new FileOutputStream(fileName1, true)));
        try {
            byte[] b = new byte[frame.capacity()];
            frame.getBytes(0, b);
            out.write(b);
            out1.write(b);
            out.flush();
            out1.flush();
            //Thread.currentThread().sleep(MILLS);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            out.close();
        }
        return frame;
    }
}
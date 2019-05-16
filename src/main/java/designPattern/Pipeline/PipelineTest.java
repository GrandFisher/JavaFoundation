package designPattern.Pipeline;

/**
 * @author xuan
 * @date 2019-05-16 13:20.
 */

public class PipelineTest {
    public static void main(String[] args) {
        Pipeline pipeline=new Pipeline();
        pipeline.addFirst(new TestHandler2());
        pipeline.addFirst(new TestHandler1());
        for (int i = 0; i <  10;  i++) {
            pipeline.Request("test hello:" + i + ";");
        }
    }
}

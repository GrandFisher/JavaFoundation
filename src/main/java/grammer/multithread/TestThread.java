package grammer.multithread;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author xuan
 * @date 2019-03-30 10:34.
 */

public class TestThread {
    public static void main(String[] args) {
        RunnableDemo R1=new RunnableDemo("Thread-1");
        R1.start();
        RunnableDemo R2=new RunnableDemo("Thread-2");
        R2.start();
        ThreadDemo T1 = new ThreadDemo( "Thread-3");
        T1.start();

        ThreadDemo T2 = new ThreadDemo( "Thread-4");
        T2.start();
        ConcurrentHashMap concurrentHashMap=new ConcurrentHashMap();

    }
}

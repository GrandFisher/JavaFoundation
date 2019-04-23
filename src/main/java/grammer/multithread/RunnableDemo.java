package grammer.multithread;

/**
 * @author xuan
 * @date 2019-03-30 10:27.
 */

public class RunnableDemo implements Runnable {
    private Thread t;
    private String threadName;

    RunnableDemo(String threadName) {
        this.threadName = threadName;
    }

    @Override
    public void run() {
        System.out.println("Running " + threadName);
        try {
            for (int i = 0; i < 4; i++) {
                System.out.println("Thread " + threadName + " " + i);
                Thread.sleep(50);
            }
        } catch (InterruptedException e) {
            System.out.println("Thread " + threadName + " interrupted.");
        }
        System.out.println("Thread " + threadName + " exiting.");
    }

    public void start() {
        System.out.println("Starting " + threadName);
        if (t == null) {
            t = new Thread(this, threadName);
            t.start();
        }
    }
}
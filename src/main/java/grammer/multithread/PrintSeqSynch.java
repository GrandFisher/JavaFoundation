package grammer.multithread;

/**
 * @author xuan
 * @date 2019-04-21 15:48.
 */

public class PrintSeqSynch {


    public static void main(String[] args) {
        ThreadSynchTest threadSynchTest=new ThreadSynchTest();
        Thread t = new Thread(threadSynchTest, "A");
        Thread t1 = new Thread(new ThreadSynchTest(), "B");
        Thread t2 = new Thread(new ThreadSynchTest(), "C");
        t.start();
        t1.start();
        t2.start();

    }
}

class ThreadSynchTest implements Runnable {

    private  int i=1;
    static Object object = new Object();

    @Override
    public void run() {
//        testMethod();
//        testThis();
//        testClass();
        testObject();
    }


    public synchronized void testMethod() {
        for (; i < 99; ) {
            System.out.println(Thread.currentThread().getName() + ":" + i++);
            notifyAll();
            try {
                if (i < 99){
                    wait();
                }

            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName());
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + "end");
    }


    public void testThis() {
        synchronized (this) {
            for (; i < 99; ) {
                System.out.println(Thread.currentThread().getName() + ":" + i++);

                this.notifyAll();
                try {
                    if (i < 99)
                        this.wait();
                } catch (InterruptedException e) {
                    System.out.println(Thread.currentThread().getName());
                    e.printStackTrace();
                }
            }

        }

        System.out.println(Thread.currentThread().getName() + "end");
    }

    // 这个不能调用notify和method
    public synchronized static void testStaticMethod() {

//        for (int i = 0; i < 4; ) {
//            System.out.println(Thread.currentThread().getName() + ":" + i++);
////            notifyAll();
//            try {
//                if (i < 4)
////                    wait();
//            } catch (InterruptedException e) {
//                System.out.println(Thread.currentThread().getName());
//                e.printStackTrace();
//            }
//        }
//        System.out.println(Thread.currentThread().getName() + "end");
    }

    public void testClass() {
        synchronized (ThreadSynchTest.class) {
            for (; i < 99; ) {
                System.out.println(Thread.currentThread().getName() + ":" + i++);
                ThreadSynchTest.class.notifyAll();
                try {
                    if (i < 99)
                        ThreadSynchTest.class.wait();
                } catch (InterruptedException e) {
                    System.out.println(Thread.currentThread().getName());
                    e.printStackTrace();
                }
            }

        }

        System.out.println(Thread.currentThread().getName() + "end");


    }

    public void testObject() {
        synchronized (object) {
            for (; i < 10; ) {
                System.out.println(Thread.currentThread().getName() + ":" + i++);
                object.notifyAll();
                try {
                    if (i < 10)
                        object.wait();
                } catch (InterruptedException e) {
                    System.out.println(Thread.currentThread().getName());
                    e.printStackTrace();
                }
            }

        }

        System.out.println(Thread.currentThread().getName() + "end");
    }


}
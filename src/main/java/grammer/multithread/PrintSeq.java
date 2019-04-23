package grammer.multithread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author xuan
 * @date 2019-04-20 16:14.
 */

public class PrintSeq {
    public static void main(String args[]){
        ThreadTest threadTest=new ThreadTest();
        Thread t=new Thread(threadTest,"A");
        Thread t1=new Thread(threadTest,"B");
        Thread t2=new Thread(threadTest,"C");
        t.start();
        t1.start();
        t2.start();
    }
}
class ThreadTest implements Runnable{
    ReentrantLock lock=new ReentrantLock();
    Condition condition=lock.newCondition();
    int i=1;
    @Override
    public void run(){
        lock.lock();
        for(;i<=99;){
            System.out.println(Thread.currentThread().getName()+i++);
            condition.signalAll();
            try {
                //条件会释放锁，
                if(i<=99){
                    condition.await();
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        lock.unlock();
        System.out.println(Thread.currentThread().getName()+"end");
    }
}

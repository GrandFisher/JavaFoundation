package designPattern;

/**
 * @author xuan
 * @date 2019-03-26 16:24.
 */

public class Singleton {

    //懒汉式 线程不安全  lazy loading 很明显
    private static Singleton instance;

    private Singleton() {
    }

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}

class Singleton1 {

    //线程安全但效率贼低
    private static Singleton1 instance;

    private Singleton1() {
    }

    public static synchronized Singleton1 getInstance() {
        if (instance == null) {
            instance = new Singleton1();
        }
        return instance;
    }
}

class Singleton2 {

    //    描述：这种方式比较常用，但容易产生垃圾对象。
    //    优点：没有加锁，执行效率会提高。
    //    缺点：类加载时就初始化，浪费内存。没有lazy-loading
    private static Singleton2 instance = new Singleton2();

    private Singleton2() {
    }

    public static Singleton2 getInstance() {
        return instance;
    }
}

class Singleton3 {
    private volatile static Singleton3 singleton;

    private Singleton3() {
    }

    public static Singleton3 getSingleton() {
        if (singleton == null) {
            synchronized (Singleton3.class) {
                if (singleton == null) {
                    singleton = new Singleton3();
                }
            }
        }
        return singleton;
    }
}

class Singleton4 {
    //这种方式能达到双检锁方式一样的功效，但实现更简单。对静态域使用延迟初始化，应使用这种方式而不是双检锁方式。
    // 这种方式只适用于静态域的情况，双检锁方式可在实例域需要延迟初始化时使用。
    //
    private static class SingletonHolder {
        private static final Singleton4 INSTANCE = new Singleton4();
    }
    private Singleton4 (){}
    public static final Singleton4 getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
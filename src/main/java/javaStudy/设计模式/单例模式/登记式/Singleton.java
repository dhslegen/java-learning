package javaStudy.设计模式.单例模式.登记式;

/**
 * 优点：第一次调用才初始化，避免内存浪费。
 * 缺点：必须加锁 synchronized 才能保证单例，但加锁会影响效率。
 */
public class Singleton {

    //内部静态类，内含一个共享的一个单例
    private static class SingletonHolder {
        static {
            System.out.println("SingletonHolder内部静态类开始加载！");
        }

        private static final Singleton INSTANCE = new Singleton();
    }

    //构造函数私有化，保证不被外界实例化
    private Singleton() {
        System.out.println("我是Singleton的私有构造函数！");
    }

    //获取唯一可用的对象，synchronized保证线程安全。
    public static final Singleton getInstance() {
        System.out.println("我是getInstance（）函数！");
        //借助内部静态类使用才加载的特性，实现延迟加载。
        return SingletonHolder.INSTANCE;
    }

    //该单例的行为
    public void showMessage() {
        System.out.println("登记式！");
    }
}

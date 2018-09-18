package javaStudy.设计模式.创建型模式.单例模式.懒汉式;

/**
 * 优点：第一次调用才初始化，避免内存浪费。
 * 缺点：必须加锁 synchronized 才能保证单例，但加锁会影响效率。。
 */
public class Singleton {

    //简单声明，延迟初始化，static保证类共享。
    private static Singleton instance;

    //构造函数私有化，保证不被外界实例化
    private Singleton() {
    }

    //获取唯一可用的对象，synchronized保证线程安全。
    public static synchronized Singleton getInstance() {
        //用到时才根据条件初始化
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    //该单例的行为
    public void showMessage() {
        System.out.println("懒汉式且线程安全！");
    }
}

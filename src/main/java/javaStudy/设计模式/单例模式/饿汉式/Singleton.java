package javaStudy.设计模式.单例模式.饿汉式;

/**
 * 这种方式比较常用，但容易产生垃圾对象。
 */
public class Singleton {

    //饥饿方式，私有、静态、终态和赋值保证在加载时便有了类控制下的一个共享对象，且不可修改、不可访问。
    private static final Singleton instance = new Singleton();

    //构造函数私有化，保证不被外界实例化
    private Singleton() {
    }

    //获取唯一可用的对象
    public static Singleton getInstance() {
        return instance;
    }

    //该单例的行为
    public void showMessage() {
        System.out.println("饿汉式!");
    }
}

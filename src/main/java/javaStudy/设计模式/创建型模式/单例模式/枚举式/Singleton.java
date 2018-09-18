package javaStudy.设计模式.创建型模式.单例模式.枚举式;

/**
 * 优点：第一次调用才初始化，避免内存浪费。
 * 缺点：必须加锁 synchronized 才能保证单例，但加锁会影响效率。
 */
public enum Singleton {

    INSTANCE;

    //该单例的行为
    public void showMessage() {
        System.out.println("枚举式！");
    }
}

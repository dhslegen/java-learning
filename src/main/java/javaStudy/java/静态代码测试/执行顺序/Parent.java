package javaStudy.java.静态代码测试.执行顺序;

/**
 * @author dhslegen
 */
public class Parent {
    static {
        System.out.println("Parent 静态代码块");
    }

    public Parent() {
        System.out.println("Parent 构造方法");
    }
}

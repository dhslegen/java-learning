package javaStudy.java.静态代码测试.执行顺序;

/**
 * @author dhslegen
 */
public class Son extends Parent {
    static {
        System.out.println("Son 静态代码块");
    }

    Son() {
        System.out.println("Son 构造函数");
    }

    public static void main(String[] args) {
        new Son();
        new Son();
    }
}

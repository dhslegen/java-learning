package javaStudy.java.内部类学习.静态内部类;

/**
 * @author ZhaoWH
 */
public class Main {
    public static void main(String[] args) {
        Outer.Inner inner = new Outer.Inner();
        inner.say();
    }
}

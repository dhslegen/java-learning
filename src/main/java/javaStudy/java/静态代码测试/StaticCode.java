package javaStudy.java.静态代码测试;

public class StaticCode {
    static public int num = 0;
    private int num1 = 0;


    {
        say2();
    }

    {
        say1();
    }

    static {
        System.out.println(num++);
        say();
    }

    private void say1() {
        System.out.println(num++);
        System.out.println(num1++);
        System.out.println("hello word1!");
    }

    private void say2() {
        System.out.println(num++);
        System.out.println(num1++);
        System.out.println("hello word2!");
    }

    private static void say() {
        System.out.println("hello word!");
    }
}

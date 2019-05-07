package javaStudy.java.静态代码测试;

/**
 * 【总结】执行顺序:类初始化->静态属性初始化->静态代码块初始化->实例初始化->实例属性初始化->普通代码块初始化。在实例化时触发，而不是声明时触发。<p>
 * 另外请注意，属性可以不进行初始化，jvm负责初始化，但是局部变量必须初始化。
 *
 * @author ZhaoWH
 */
class StaticCode extends BaseStaticCode {
    private static int num;
    private static String name = "name";
    private int num1;
    private String name1 = "name1";

    {
        String name1 = "name1";
    }


    {
        super.name1 = "name1";
    }


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

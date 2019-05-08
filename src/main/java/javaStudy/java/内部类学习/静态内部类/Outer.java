package javaStudy.java.内部类学习.静态内部类;

/**
 * 静态内部类也是定义在另一个类里面的类，只不过在类的前面多了一个关键字static。静态内部类是不需要依赖于外部类的，这点和类的静态
 * 成员属性有点类似，并且它不能使用外部类的非static成员变量或者方法，这点很好理解，因为在没有外部类的对象的情况下，可以创建静态
 * 内部类的对象，如果允许访问外部类的非static成员就会产生矛盾，因为外部类的非static成员必须依附于具体的对象。
 *
 * <pre>
 * public class Outer$Inner {
 *     int age = 20;
 *
 *     protected Outer$Inner() {
 *     }
 *
 *     public void say() {
 *         System.out.println("I am " + this.age + " years old");
 *         System.out.println("My name is " + Outer.name);
 *     }
 * }
 * </pre>
 *
 * @author ZhaoWH
 */
public class Outer {
    int age = 100;
    static String name = "Outer";

    protected static class Inner {
        int age = 20;

        public void say() {
            System.out.println("I am " + age + " years old");
            // 'javaStudy.java.内部类学习.静态内部类.Outer.this' cannot be referenced from a static context
            // System.out.println("I am " + Outer.this.age + " years old")
            System.out.println("My name is " + Outer.name);
        }
    }
}

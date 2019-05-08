package javaStudy.java.内部类学习.成员内部类;

/**
 * 内部类可以拥有private访问权限、protected访问权限、public访问权限及包访问权限。如果成员内部类Inner用private
 * 修饰，则只能在外部类的内部访问，如果用public修饰，则任何地方都能访问；如果用protected修饰，则只能在同一个包下或者继承外部类
 * 的情况下访问；如果是默认访问权限，则只能在同一个包下访问。这一点和外部类有一点不一样，外部类只能被public和包访问两种权限修饰。
 * 我个人是这么理解的，【由于成员内部类看起来像是外部类的一个成员，所以可以像类的成员一样拥有多种权限修饰，也因为是成员，所以不
 * 能脱离外部类单独实例化,必须由外部类的实例.new Inner()产生，保证了内部类实例包含外部类实例的引用】。
 *
 * <pre>
 * public class BaseOuter$Inner {
 *     int age;
 *     String name;
 *
 *     protected BaseOuter$Inner(BaseOuter this$0) {
 *         this.this$0 = this$0;
 *         this.age = 1;
 *         this.name = "Inner";
 *     }
 *
 *     public void say() {
 *         System.out.println(this.name + ":I am " + this.age + " years old");
 *         System.out.println(this.name + ":I am " + this.age + " years old");
 *         System.out.println(BaseOuter.name + ":I am " + this.this$0.age + " years old");
 *     }
 * }
 * </pre>
 *
 * @author ZhaoWH
 */
public class BaseOuter {
    static String name = "BaseOuter";
    int age = 0;

    protected class Inner {
        int age = 1;
        String name = "Inner";
        // Inner classes cannot have static declarations
        // static String name = "Outer";

        public void say() {
            System.out.println(name + ":I am " + age + " years old");
            System.out.println(this.name + ":I am " + this.age + " years old");
            System.out.println(BaseOuter.name + ":I am " + BaseOuter.this.age + " years old");
        }
    }
}

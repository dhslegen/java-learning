package javaStudy.java.构造器Constructor思考;

import java.util.Date;

/**
 * 如果用户定义的类中没有提供任何构造方法，那么Java编译器将自动提供一个隐含的默认构造方法（编译后加上）。
 * <p>
 * 如果类中显式定义了一个或多个构造方法，并且所有的构造方法都带参数，那么这个类就失去了默认构造方法(编译后没有)。
 * <p>
 * 没有，java代理，有，java就撤了
 * <p>
 * <p>
 * 父类的私有属性和构造方法并不能被继承，所以 Constructor 也就不能被 override（重写）,但是可以 overload（重载）,所以你可以看到一个类中有多
 * 个构造函数的情况。
 * <p>
 * <p>
 * Java 程序在执行子类的构造方法之前，如果没有用 super() 来调用父类特定的构造方法，则会调用父类中“没有参数的构造方法”。因此，如果父类中只定义
 * 了有参数的构造方法，而在子类的构造方法中又没有用 super() 来调用父类中特定的构造方法，则编译时将发生错误，因为 Java 程序在父类中找不到没有参
 * 数的构造方法可供执行。解决办法是在父类里加上一个不做事且没有参数的构造方法。
 *
 * @author dhslegen
 */
public class Super {

    /**
     * 构造方法的作用域
     * <p>
     * 构造方法只能通过以下方式被调用：
     * <p>
     * (1) 当前类的其他构造方法通过this语句调用它。
     * <p>
     * (2) 当前类的子类的构造方法通过super语句调用它。
     * <p>
     * (3)在程序中通过new语句调用它。
     */
    public Super(String name) {
        System.out.println("I am in the super constructor,the parameter value is" + name);
    }

    /**
     * 在以下场合之一，可以把类的所有构造方法都声明为private类型。
     * <p>
     * （1）在这个类中仅仅包含了一些供其他程序调用的静态方法，没有任何实例方法。其他程序无需创建该类的实例，就能访问类的静态方法。例如 java.lang.Math类就符合这种情况，在Math类中提供了一系列用于数学运算的公共静态方法，为了禁止外部程序创建Math类的实例， Math类的惟一的构造方法是private类型的：
     * <p>
     * private Math(){}
     * <p>
     * abstract类型的类也不允许实例化。也许你会问，把Math类定义为如下abstract类型，不是也能禁止Math类被实例化吗？
     * <p>
     * public abstract class Math{…}
     * <p>
     * 如果一个类是抽象类，意味着它是专门用于被继承的类，可以拥有子类，而且可以创建具体子类的实例。而JDK并不希望用户创建Math类的子类，在这种情况下，把类的构造方法定义为private类型更合适。
     * <p>
     * （2）禁止这个类被继承。当一个类的所有构造方法都是private类型，假如定义了它的子类，那么子类的构造方法无法调用父类的任何构造方法，因此会导致编译错误。把一个类声明为final类型，也能禁止这个类被继承。这两者的区别是：
     * <p>
     * 1)如果一个类允许其他程序用new语句构造它的实例，但不允许拥有子类，那就把类声明为final类型。
     * <p>
     * 2)如果一个类既不允许其他程序用new语句构造它的实例，又不允许拥有子类，那就把类的所有构造方法声明为private类型。
     * <p>
     * 由于大多数类都允许其他程序用new语句构造它的实例，因此用final修饰符来禁止类被继承的做法更常见。
     * <p>
     * （3）这个类需要把构造自身实例的细节封装起来，不允许其他程序通过new语句创建这个类的实例，这个类向其他程序提供了获得自身实例的静态方法，这种方法称为静态工厂方法。
     */
    private Super(Date name) {
        this(name.toString());
        System.out.println("I am in the super constructor,the parameter value is" + name);

        // Call to 'this()' must be first statement in constructor body
        // this(name.toString());
    }

    /**
     * 有返回类型的且与类名同名的方法不是构造方法，视为普通方法
     */
    public String Super(String name) {
        String x = "I am in the super constructor,the parameter value is" + name;
        System.out.println(x);
        return x;
    }

    public void say() {
        System.out.println("hello, I am in the super say()");
    }
}

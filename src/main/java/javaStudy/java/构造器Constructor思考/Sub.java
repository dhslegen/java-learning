package javaStudy.java.构造器Constructor思考;

/**
 * @author dhslegen
 */
public class Sub extends Super {
    public void Super() {
        // Call to 'super()' must be first statement in constructor body
        // super();
    }

    /**
     * 子类是必然要调用父类的构造函数的，具体如下：
     * <p>
     * 当子类的构造方法没有用super语句显式调用父类的构造方法，那么通过这个构造方法创建子类对象时，Java虚拟机会自动先调用父类的默认构造方法。<p>
     * <p>
     * 当子类的构造方法没有用super语句显式调用父类的构造方法，而父类又没有提供默认构造方法时，将会出现编译错误。
     */
    public Sub() {
        super("");
        System.out.println("I am in the sub constructor");

        /*public Sub() {
            // There is no default constructor available in 'javaStudy.java.构造器Constructor思考.Super'
            System.out.println("I am in the sub constructor");
        }*/
    }

    @Override
    public void say() {
        super.say();
    }
}

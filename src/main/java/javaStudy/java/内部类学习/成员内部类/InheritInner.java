package javaStudy.java.内部类学习.成员内部类;

/**
 * 1）成员内部类的引用方式必须为 Outter.Inner.
 * <p>
 * 2）构造器中必须有指向外部类对象的引用，并通过这个引用调用super()。
 */
public class InheritInner extends BaseOuter.Inner {
    public InheritInner(BaseOuter outer) {
        outer.super();
    }
}

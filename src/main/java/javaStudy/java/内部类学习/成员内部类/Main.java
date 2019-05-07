package javaStudy.java.内部类学习.成员内部类;

public class Main {
    public static void main(String[] args) {
        Outer outer = new Outer();
        BaseOuter.Inner inner = outer.new Inner();
        inner.say();
        BaseOuter baseOuter = new BaseOuter();
        InheritInner obj = new InheritInner(baseOuter);
    }
}

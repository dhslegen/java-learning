package javaStudy.java.接口和抽象类的思考;

/**
 * 接口的方法默认是 public，所有方法在接口中不能有实现(Java 8 开始接口方法可以有默认实现），而抽象类可以有非抽象的方法。
 * <p>
 * 接口中除了static、final变量，不能有其他变量，而抽象类中则不一定。
 * <p>
 * 一个类可以实现多个接口，但只能实现一个抽象类。接口自己本身可以通过extends关键字扩展多个接口。
 * <p>
 * 接口方法默认修饰符是public，抽象方法可以有public、protected和default这些修饰符（抽象方法就是为了被重写所以不能使用private关键字修饰！）。
 * <p>
 * 从设计层面来说，抽象是对类的抽象，是一种模板设计，而接口是对行为的抽象，是一种行为的规范。
 * <p>
 * 备注：在JDK8中，接口也可以定义静态方法，可以直接用接口名调用。实现类和实现是不可以调用的。如果同时实现两个接口，接口中定义了一样的默认方法，
 * 则必须重写，不然会报错。(详见issue:https://github.com/Snailclimb/JavaGuide/issues/146)
 *
 * @author dhslegen
 */
public class Main {

    public static void main(String[] args) {
        Interface interfaceImplements = new InterfaceImplements();
        interfaceImplements.say();
        interfaceImplements.sing();
        Abstract anAbstract = new AbstractExtends();
        anAbstract.rap();
    }

}

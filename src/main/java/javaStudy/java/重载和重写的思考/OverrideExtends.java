package javaStudy.java.重载和重写的思考;

/**
 * 重写是子类对父类的允许访问的方法的实现过程进行重新编写,发生在子类中，方法名、参数列表必须相同，返回值范围小于等于父类，抛出的异常范围小于等于
 * <p>
 * 父类，访问修饰符范围大于等于父类。另外，如果父类方法访问修饰符为 private 则子类就不能重写该方法。也就是说方法提供的行为改变，而方法的外貌并
 * <p>
 * 没有改变。
 */
public class OverrideExtends extends Override {

    @java.lang.Override
    public Integer sing() throws MyException {
        System.out.println("ji ni tai mei again");
        return 2;
    }

    // 'sing()' in 'javaStudy.java.重载和重写的思考.OverrideExtends' clashes with 'sing()' in 'javaStudy.java.重载和重写的思考.Override'; overridden method does not throw 'java.lang.Exception'
    // @java.lang.Override
    // public Integer sing() throws Exception {
    //     System.out.println("ji ni tai mei again");
    //     return 2;
    // }

    // 'sing()' in 'javaStudy.java.重载和重写的思考.OverrideExtends' clashes with 'sing()' in 'javaStudy.java.重载和重写的思考.Override'; attempting to use incompatible return type
    // @java.lang.Override
    // public Object sing() throws MyException {
    //     System.out.println("ji ni tai mei again");
    //     return 2;
    // }

}

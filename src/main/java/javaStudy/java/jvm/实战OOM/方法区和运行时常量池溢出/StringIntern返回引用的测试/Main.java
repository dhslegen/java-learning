package javaStudy.java.jvm.实战OOM.方法区和运行时常量池溢出.StringIntern返回引用的测试;

/**
 * @author dhslegen
 */
public class Main {

    public static void main(String[] args) {
        String string1 = new StringBuilder("计算机").append("软件").toString();
        System.out.println(string1.intern() == string1);

        String string2 = new StringBuilder("ja").append("va").toString();
        System.out.println(string2.intern() == string2);
    }

}

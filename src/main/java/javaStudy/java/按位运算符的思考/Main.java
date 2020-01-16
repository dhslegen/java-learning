package javaStudy.java.按位运算符的思考;

/**
 * @author dhslegen
 */
public class Main {

    public static void main(String[] args) {
        int i = 0123;
        int j = 0x9a;
        System.out.println(i);
        System.out.println(j);
        int a = -3;
        int b = 9;
        System.out.println("a      :" + getFormat(a));
        System.out.println("b      :" + getFormat(b));
        System.out.println("a & b  :" + getFormat(a & b));
        System.out.println();

        System.out.println("a      :" + getFormat(a));
        System.out.println("b      :" + getFormat(b));
        System.out.println("a | b  :" + getFormat(a | b));
        System.out.println();

        System.out.println("a      :" + getFormat(a));
        System.out.println("b      :" + getFormat(b));
        System.out.println("a ^ b  :" + getFormat(a ^ b));
        System.out.println();

        //
        System.out.println("b      :" + getFormat(b));
        System.out.println("~b     :" + Integer.toBinaryString(~b));
        System.out.println("~b     :" + (~b));
        System.out.println();

        // 有符号右移,负数补1，正数补0
        System.out.println("a      :" + getFormat(a));
        System.out.println("b      :" + getFormat(b));
        System.out.println("a >> b :" + getFormat(a >> b));
        System.out.println();

        // 无符号右移，左补0
        System.out.println("a      :" + getFormat(a));
        System.out.println("b      :" + getFormat(b));
        System.out.println("a >>> b:" + getFormat(a >>> b));
        System.out.println();

        // 无符号左移，右补0
        System.out.println("a      :" + getFormat(a));
        System.out.println("b      :" + getFormat(b));
        System.out.println("a << b :" + Integer.toBinaryString(a << b));
        System.out.println();

        // Expression expected
        // System.out.println(3<<<9);


        // &&当前置参数不符合就停止了
        System.out.println("test1() && test2()");
        if (test1() && test2()) {
            System.out.println("test success");
        }

        // &无论如何都会计算两边
        System.out.println("test1() & test2()");
        if (test1() & test2()) {
            System.out.println("test success");
        }

        // ||当前置参数不符合就停止了
        System.out.println("test2() || test1()");
        if (test2() || test1()) {
            System.out.println("test success");
        }

        // |无论如何都会计算两边
        System.out.println("test1() | test2())");
        if (test2() | test1()) {
            System.out.println("test success");
        }
    }

    private static String getFormat(int b) {
        String s = Integer.toBinaryString(b);
        String o = "00000000000000000000000000000000";
        return o.substring(0, (32 - s.length())) + s;
    }

    private static boolean test1() {
        System.out.println("I am test1");
        return false;
    }

    private static boolean test2() {
        System.out.println("I am test2");
        return true;
    }

}

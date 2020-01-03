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
        System.out.println(String.format("%032d", Integer.valueOf(Integer.toBinaryString(3))));
        System.out.println(String.format("%032d", Integer.valueOf(Integer.toBinaryString(9))));
        System.out.println(3 & 9);
        System.out.println(3 | 9);
        System.out.println(3 ^ 9);
        System.out.println(~9);
        System.out.println(3 >> 9);
        System.out.println(3 >>> 9);
        System.out.println(3 << 9);

        // Expression expected
        // System.out.println(3<<<9);
    }

}

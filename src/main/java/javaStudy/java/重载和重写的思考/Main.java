package javaStudy.java.重载和重写的思考;

/**
 * @author dhslegen
 */
public class Main {

    public static void main(String[] args) {
        Override override = new Override();
        Number number = override.sing();
        override = new OverrideExtends();
        Number sing = override.sing();
        Number dhslegen = 1;
        String a = "a";
        String b = "a";
        String c = new String("a");
        String d = new String("a");
        System.out.println(a == b);
        System.out.println(b == c);
        System.out.println(c == d);
    }

}

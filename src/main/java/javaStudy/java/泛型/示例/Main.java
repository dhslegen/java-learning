package javaStudy.java.泛型.示例;

/**
 * @author dhslegen
 */
public class Main<T> {
    static <String, T, Dhslegen> String get(String string, Dhslegen dhslegen) {
        return string;
    }

    public static void main(String[] args) {
        Integer first = 222;
        Long second = 333L;
        Integer result = get(first, second);
        System.out.println(result);
    }
}

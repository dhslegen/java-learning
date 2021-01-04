package javaStudy.java.传参的思考.示例;

import java.util.Arrays;
import java.util.List;

/**
 * @author dhslegen
 */
public class Main {
    String string = "hello";
    char[] chars = {'a', 'b', 'c'};
    List<String> strings = Arrays.asList("a", "b", "c");

    public void func(String string, char[] ch) {
        this.string = "world";
        ch[0] = 'd';
        strings.set(0, "d");
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.func(main.string, main.chars);
        System.out.print(main.string + " and ");
        System.out.print(main.chars);
        System.out.print(main.strings);
    }
}

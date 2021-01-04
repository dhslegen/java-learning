package javaStudy.java.jvm.实战OOM.方法区和运行时常量池溢出.运行时常量池导致的内存溢出异常;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dhslegen
 */
public class Main {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        int i = 0;
        while (true) {
            list.add(String.valueOf(i++).intern());
        }
    }

}

package javaStudy.java.泛型.泛型方法根据传入的参数自动判断类型;

import org.apache.commons.compress.utils.Lists;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // 指定类型
        ArrayList<String> tList = Lists.newArrayList();
        Main.<String>printString("12", tList);
        ArrayList<Integer> tList1 = Lists.newArrayList();
        Main.<Integer>printString(12, tList1);
        // 不指定,自动推导
        ArrayList<Integer> tList3 = Lists.newArrayList();
        Main.printString(12, tList3);
        ArrayList<String> tList4 = Lists.newArrayList();
        Main.printString("12", tList4);
    }

    static <T> void printString(T t, List<T> tList) {
        System.out.println(t.toString());
    }
}
package javaStudy.java.泛型.PECS;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // 编译报错
        // required ArrayList<Integer>, found ArrayList<Number>
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Number> list2 = list1;

        // 可以正常通过编译,正常使用
        Integer[] arr1 = new Integer[]{1, 2};
        Number[] arr2 = arr1;

        ArrayList<Integer> list11 = new ArrayList<>();
        // 协变, 可以正常转化, 表示list2是继承 Number的类型
        ArrayList<? extends Number> list22 = list11;

        // 无法正常添加
        // ? extends Number 被限制为 是继承 Number的任意类型,
        // 可能是 Integer,也可能是Float,也可能是其他继承自Number的类,
        // 所以无法将一个确定的类型添加进这个列表,除了 null之外
        list22.add(new Integer(1));
        // 可以添加
        list22.add(null);
        for (Number number : list22) {

        }

        // 逆变
        ArrayList<Number> list3 = new ArrayList<>();
        ArrayList<? super Number> list4 = list3;
        list4.add(new Integer(1));
        list4.add(new Long(1));
        for (Object o : list4) {

        }
    }
}

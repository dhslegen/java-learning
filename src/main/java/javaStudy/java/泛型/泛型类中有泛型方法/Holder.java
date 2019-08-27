package javaStudy.java.泛型.泛型类中有泛型方法;

// 泛型类中的类型参数 用 T 表示
public class Holder<T> {
    public Holder(T animal) {

    }

    public Holder() {

    }

    /**
     * 成员泛型方法, 声明的类型参数,也用 T 表示
     */
    public <T> String getString(T t) {
        return t.toString();
    }

}
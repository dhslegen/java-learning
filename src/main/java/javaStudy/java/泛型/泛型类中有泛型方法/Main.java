package javaStudy.java.泛型.泛型类中有泛型方法;

/**
 * 【结论】泛型类的类型参数不会影响类中泛型方法的类型参数，即泛型方法的类型参数只受方法的范围的影响
 *
 * @author dhslegen
 */
public class Main {

    public static void main(String[] args) {
        // 泛型类为 Animal
        Holder<Animal> holder = new Holder<>(new Animal());
        // 泛型方法为 Vegetation
        String s = holder.getString(new Vegetation());
        System.out.println(s);
        // I'm Vegetation
    }
}

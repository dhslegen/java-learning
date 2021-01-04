package javaStudy.设计模式.结构型模式.适配器模式.类适配器模式;

import javaStudy.设计模式.结构型模式.适配器模式.Phone;

/**
 * Adapter类，通过继承src类，实现dst类接口，完成src -> dst的适配。
 *
 * @author dhslegen
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(" === 类适配器模式 ===");
        Phone phone = new Phone();
        phone.charging(new VoltageAdapter());
    }
}

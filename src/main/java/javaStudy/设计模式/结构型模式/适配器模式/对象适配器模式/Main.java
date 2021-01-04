package javaStudy.设计模式.结构型模式.适配器模式.对象适配器模式;

import javaStudy.设计模式.结构型模式.适配器模式.Phone;
import javaStudy.设计模式.结构型模式.适配器模式.Voltage220V;

/**
 * 基本思路和类适配器模式相同，只是将Adapter类作修改，不是继承src类，而是持有src类的。
 *
 * @author dhslegen
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(" === 类适配器模式 ===");
        Phone phone = new Phone();
        phone.charging(new VoltageAdapter(new Voltage220V()));
    }
}

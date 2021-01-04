package javaStudy.设计模式.结构型模式.适配器模式.对象适配器模式;

import javaStudy.设计模式.结构型模式.适配器模式.IVoltage5V;
import javaStudy.设计模式.结构型模式.适配器模式.Voltage220V;

/**
 * @author dhslegen
 */
public class VoltageAdapter implements IVoltage5V {

    /**
     * 关联关系 - 聚合
     */
    private final Voltage220V voltage220V;

    /**
     * 通过构造器，传入一个Voltage220V 实例
     *
     * @param voltage220v voltage220v
     */
    public VoltageAdapter(Voltage220V voltage220v) {
        this.voltage220V = voltage220v;
    }

    @Override
    public int output5V() {
        int dstV = 0;
        if (voltage220V != null) {
            // 获取220V 电压
            int src = voltage220V.output220V();
            System.out.println("使用对象适配器，进行适配～～");
            dstV = src / 44;
            System.out.println("适配完成，输出的电压为 = " + dstV);
        }
        return dstV;
    }

}

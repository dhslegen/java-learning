package javaStudy.设计模式.结构型模式.适配器模式.类适配器模式;

import javaStudy.设计模式.结构型模式.适配器模式.IVoltage5V;
import javaStudy.设计模式.结构型模式.适配器模式.Voltage220V;

/**
 * @author dhslegen
 */
public class VoltageAdapter extends Voltage220V implements IVoltage5V {

    @Override
    public int output5V() {
        // 获取到220V电压
        int srcV = output220V();
        System.out.println("使用类适配器，进行适配～～");
        // 转成5v
        int dstV = srcV / 44;
        System.out.println("适配完成，输出的电压为 = " + dstV);
        return dstV;
    }

}

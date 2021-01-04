package javaStudy.设计模式.结构型模式.适配器模式;

import javaStudy.设计模式.结构型模式.适配器模式.IVoltage5V;

/**
 * @author dhslegen
 */
public class Phone {
    /**
     * 充电
     *
     * @param iVoltage5V iVoltage5V
     */
    public void charging(IVoltage5V iVoltage5V) {
        if (iVoltage5V.output5V() == 5) {
            System.out.println("电压为5V，可以充电～～");
        } else if (iVoltage5V.output5V() > 5) {
            System.out.println("电压大于5V，不能充电～～");
        }
    }
}

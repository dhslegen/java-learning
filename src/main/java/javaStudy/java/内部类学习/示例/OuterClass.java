package javaStudy.java.内部类学习.示例;

/**
 * @author dhslegen
 */
public class OuterClass {
    /**
     * 成员内部类
     */
    private class InstanceInnerClass {
    }

    /**
     * 静态内部类
     */
    static class StaticInnerClass {
    }

    public static void main(String[] args) {
        // 匿名内部类
        (new Thread() {
        }).start();
        (new Thread() {
        }).start();

        // 局部内部类
        class MethodClass1 {
        }
        class MethodClass2 {
        }
    }

    public static void main1() {
        // 局部内部类
        class MethodClass3 {
        }
    }

}

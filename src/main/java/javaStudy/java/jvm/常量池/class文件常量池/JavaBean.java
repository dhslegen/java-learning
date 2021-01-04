package javaStudy.java.jvm.常量池.class文件常量池;

/**
 * @author dhslegen
 */
public class JavaBean {
    private int value = 1;
    public String s = "abc";
    public final static int f = 0x101;

    public void setValue(int v) {
        final int temp = 3;
        this.value = temp + v;
    }

    public int getValue() {
        return value;
    }
}

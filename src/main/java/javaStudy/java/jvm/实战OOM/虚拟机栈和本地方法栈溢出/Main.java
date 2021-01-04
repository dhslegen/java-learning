package javaStudy.java.jvm.实战OOM.虚拟机栈和本地方法栈溢出;

/**
 * @author dhslegen
 */
public class Main {

    private int stackLength = 1;

    public void stackLeak() {
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) {
        Main main = new Main();
        try {
            main.stackLeak();
        } catch (Throwable e) {
            System.out.println("stack length: " + main.stackLength);
            throw e;
        }
    }

}

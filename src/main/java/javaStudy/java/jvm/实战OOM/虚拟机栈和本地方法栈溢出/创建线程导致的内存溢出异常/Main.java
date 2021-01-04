package javaStudy.java.jvm.实战OOM.虚拟机栈和本地方法栈溢出.创建线程导致的内存溢出异常;

/**
 * @author dhslegen
 */
@SuppressWarnings("ALL")
public class Main {

    private void dontStop() {
        while (true) {
        }
    }

    public void stackLeakByThread() {
        while (true) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    dontStop();
                }
            });

            thread.start();
        }
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.stackLeakByThread();
    }

}

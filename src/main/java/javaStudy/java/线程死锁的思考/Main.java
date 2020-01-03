package javaStudy.java.线程死锁的思考;

/**
 * @author dhslegen
 */
public class Main {

    private static Object resource1 = new Object();//资源 1
    private static Object resource2 = new Object();//资源 2

    public static void main(String[] args) {
        new Thread(() -> {
            synchronized (resource1) {
                System.out.println(Thread.currentThread() + "get resource1");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread() + "waiting get resource2");
                synchronized (resource2) {
                    System.out.println(Thread.currentThread() + "get resource2");
                }
            }
        }, "线程 1").start();

        // 循环等待造成死锁
        // new Thread(() -> {
        //     synchronized (resource2) {
        //         System.out.println(Thread.currentThread() + "get resource2");
        //         try {
        //             Thread.sleep(1000);
        //         } catch (InterruptedException e) {
        //             e.printStackTrace();
        //         }
        //         System.out.println(Thread.currentThread() + "waiting get resource1");
        //         synchronized (resource1) {
        //             System.out.println(Thread.currentThread() + "get resource1");
        //         }
        //     }
        // }, "线程 2").start();


        // 按序等待避免死锁
        new Thread(() -> {
            synchronized (resource1) {
                System.out.println(Thread.currentThread() + "get resource1");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread() + "waiting get resource2");
                synchronized (resource2) {
                    System.out.println(Thread.currentThread() + "get resource2");
                }
            }
        }, "线程 2").start();
    }

}

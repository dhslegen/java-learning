package javaStudy.java.sleep和wait区别的思考;

/**
 * 两者最主要的区别在于：sleep 方法没有释放锁，而 wait 方法释放了锁 。
 * 两者都可以暂停线程的执行。
 * Wait 通常被用于线程间交互/通信，sleep 通常被用于暂停执行。
 * wait() 方法被调用后，线程不会自动苏醒，需要别的线程调用同一个对象上的 notify() 或者 notifyAll() 方法。sleep() 方法执行完成后，线程会自
 * 动苏醒。或者可以使用 wait(long timeout)超时后线程会自动苏醒。
 */
public class Main {

    //资源 1
    private static Object resource1 = new Object();
    //资源 2
    private static Object resource2 = new Object();

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            synchronized (resource1) {
                System.out.println(Thread.currentThread() + "get resource1");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread() + "waiting get resource2");
                synchronized (resource2) {
                    System.out.println(Thread.currentThread() + "get resource2 success");
                    resource2.notify();
                }
            }
        }, "线程 1");

        Thread thread2 = new Thread(() -> {
            synchronized (resource2) {
                System.out.println(Thread.currentThread() + "get resource2");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    resource2.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread() + "waiting get resource1");
                synchronized (resource1) {
                    System.out.println(Thread.currentThread() + "get resource1 success");
                }
            }
        }, "线程 2");

        thread1.start();
        thread2.start();
    }

}
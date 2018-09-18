package javaStudy.设计模式.创建型模式.单例模式.双检锁式;

/**
 * 这种方式采用双锁机制，安全且在多线程情况下能保持高性能。(最佳方案)
 */
public class Singleton {

    //简单声明，延迟初始化，static保证类共享。保证
    // 一旦一个共享变量（类的成员变量、类的静态成员变量）被volatile修饰之后，那么就具备了两层语义：
    //　　1）保证了不同线程对这个变量进行操作时的可见性，即一个线程修改了某个变量的值，这新值对其他线程来说是立即可见的。
    //　　2）禁止进行指令重排序。
    //I   volatile关键字来保证可见性
    //　　第一：使用volatile关键字会强制将修改的值立即写入主存；
    //　　第二：使用volatile关键字的话，当线程2进行修改时，会导致线程1的工作内存中缓存变量stop的缓存行无效（反映到硬件层的话，就是CPU的L1或者L2缓存中对应的缓存行无效）；
    //　　第三：由于线程1的工作内存中缓存变量stop的缓存行无效，所以线程1再次读取变量stop的值时会去主存读取。
    //II  volatile也无法保证对变量的任何操作都是原子性的。
    //III volatile能在一定程度上保证有序性。
    //    volatile关键字禁止指令重排序有两层意思：

    //        　　1）当程序执行到volatile变量的读操作或者写操作时，在其前面的操作的更改肯定全部已经进行，且结果已经对后面的操作可见；在其后面的操作肯定还没有进行；

    //        　　2）在进行指令优化时，不能将在对volatile变量访问的语句放在其后面执行，也不能把volatile变量后面的语句放到其前面执行。
    //volatile的原理和实现机制
    //    观察加入volatile关键字和没有加入volatile关键字时所生成的汇编代码发现，加入volatile关键字时，会多出一个lock前缀指令”
    //
    //　　lock前缀指令实际上相当于一个内存屏障（也成内存栅栏），内存屏障会提供3个功能：
    //
    //　　1）它确保指令重排序时不会把其后面的指令排到内存屏障之前的位置，也不会把前面的指令排到内存屏障的后面；即在执行到内存屏障这句指令时，在它前面的操作已经全部完成；
    //
    //　　2）它会强制将对缓存的修改操作立即写入主存；
    //
    //　　3）如果是写操作，它会导致其他CPU中对应的缓存行无效。
    private volatile static Singleton instance;

    //构造函数私有化，保证不被外界实例化
    private Singleton() {
    }

    //获取唯一可用的对象
    public static Singleton getInstance() {
        //用到时才根据条件初始化
        if (instance == null) {
            // synchronized延迟在条件中使用，既保证线程安全，又可使后续的操作没有锁。
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

    //该单例的行为
    public void showMessage() {
        System.out.println("双检锁式！");
    }
}

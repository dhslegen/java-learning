package javaStudy.java.内部类学习.匿名内部类;

/**
 * 我们看到匿名内部类Main$1的构造器含有两个参数，一个是指向外部类对象的引用，一个是int型变量，很显然，这里是将变量test方法中的
 * 形参age以参数的形式传进来对匿名内部类中的拷贝（变量age的拷贝）进行赋值初始化。
 * 也就说如果局部变量的值在编译期间就可以确定，则直接在匿名内部里面创建一个拷贝。如果局部变量的值无法在编译期间确定，则通过构造
 * 器传参的方式来对拷贝进行初始化赋值。
 * 从上面可以看出，在run方法中访问的变量a根本就不是test方法中的局部变量a。这样一来就解决了前面所说的 生命周期不一致的问题。但是
 * 新的问题又来了，既然在run方法中访问的变量a和test方法中的变量a不是同一个变量，当在run方法中改变变量a的值的话，会出现什么情况？
 * 对，会造成数据不一致性，这样就达不到原本的意图和要求。为了解决这个问题，java编译器就限定必须将变量a限制为final变量，不允许对
 * 变量a进行更改（对于引用类型的变量，是不允许指向新的对象），这样数据不一致性的问题就得以解决了。
 * 到这里，想必大家应该清楚为何 方法中的局部变量和形参都必须用final进行限定了。
 *
 * <pre>
 * class Main$1 extends Anonymous {
 *     Main$1(Main this$0, int var2) {
 *         this.this$0 = this$0;
 *         this.val$age = var2;
 *     }
 *
 *     public void say() {
 *         System.out.println("我是匿名类" + this.val$age + "->" + 10);
 *     }
 * }
 * </pre>
 *
 * @author ZhaoWH
 */
public class Main {

    public static void main(String[] args) {

    }

    private void test(final int age) {
        final int age1 = 10;
        new Anonymous() {
            public void say() {
                System.out.println("我是匿名类" + age + "->" + age1);
            }
        }.say();
    }
}

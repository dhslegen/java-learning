package javaStudy.java.接口和抽象类的思考;

/**
 * 抽象类可以写抽象方法（不写也行），抽象方法不允许有方法体，除此之外和普通类无区别
 *
 * @author dhslegen
 */
public abstract class Abstract {
    /**
     * 抽象类中的变量和普通类一致
     */
    public String it;
    protected String that;
    private String them;
    String she;
    public static final String he = "";

    /**
     * say
     */
    protected abstract void say();

    /**
     * sing
     */
    public abstract void sing();

    /**
     * rap
     */
    public void rap() {
        rap1();
    }

    /**
     * rap
     */
    private void rap1() {
        System.out.println("rap1 in abstract");
    }

    // Illegal combination of modifiers: 'abstract' and 'private'
    // private abstract void dance();

    // rap,Illegal combination of modifiers: 'abstract' and 'default'
    // default abstract void rap() {
    // }

    // Abstract methods cannot have a body
    // abstract void rap() {
    // }
}

package javaStudy.java.接口和抽象类的思考;

/**
 * @author dhslegen
 */
public interface Interface {


    /**
     * 接口中的变量必须是public static final,即使省略其中的任何一个关键词
     */
    public static final String it = "";
    public static String them = "";
    public final String these = "";
    static final String she = "";
    public String he = "";
    static String him = "";
    final String her = "";
    String item = "";

    /**
     * say，这里不是默认包访问级别而是public
     */
    void say();

    // Modifier 'public' is redundant for interface methods
    // public void say();

    /**
     * sing
     */
    default void sing() {
        System.out.println("you are not lone" + it);
    }

    // Modifier 'protected' not allowed here
    // protected void sing();

    // Modifier 'private' not allowed here
    // private default void sing();

}

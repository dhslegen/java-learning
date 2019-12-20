package javaStudy.java.接口和抽象类的思考;

/**
 * @author dhslegen
 */
public interface Interface {

    /**
     * say
     */
    void say();

    // Modifier 'public' is redundant for interface methods
    // public void say();

    /**
     * sing
     */
    default void sing() {
        System.out.println("you are not lone");
    }

    // Modifier 'protected' not allowed here
    // protected void sing();

}

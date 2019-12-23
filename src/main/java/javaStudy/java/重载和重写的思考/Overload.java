package javaStudy.java.重载和重写的思考;

/**
 * 重载构成的条件只涉及方法签名部分，方法名一样，参数不一样即可
 *
 * @author dhslegen
 */
public class Overload {

    public void sing() {
        System.out.println("ji ni tai mei");
    }

    public void sing(String song) {
        System.out.println("I am singing");
    }

    public void sing(Integer times) {
        System.out.println("I am singing");
    }

    public void sing(String song, Integer time) {
        System.out.println("I am singing");
    }

    // 'sing(String)' is already defined in 'javaStudy.java.重载和重写的思考.Overload'
    // public String sing(String song) {
    //     return song;
    // }

}

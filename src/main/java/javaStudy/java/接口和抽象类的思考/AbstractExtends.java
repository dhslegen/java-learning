package javaStudy.java.接口和抽象类的思考;

/**
 * @author dhslegen
 */
public class AbstractExtends extends Abstract {

    // Class 'AbstractExtends' must either be declared abstract or implement abstract method 'say()' in 'Abstract'
    /*public class AbstractExtends extends Abstract {
    }*/

    @Override
    public void say() {
        System.out.println("hello word");

        // 'say()' in 'javaStudy.java.接口和抽象类的思考.AbstractExtends' clashes with 'say()' in 'javaStudy.java.接口和抽象类的思考.Abstract'; attempting to assign weaker access privileges ('private'); was 'protected'
        // @Override
        // private void say() {
        //     System.out.println("hello word");
        // }
    }

    @Override
    public void sing() {

    }

    @Override
    void rap() {

    }

}

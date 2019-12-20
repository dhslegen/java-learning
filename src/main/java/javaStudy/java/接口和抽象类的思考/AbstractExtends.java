package javaStudy.java.接口和抽象类的思考;

/**
 * @author zhaowenhao
 */
public class AbstractExtends extends Abstract {

    // Class 'AbstractExtends' must either be declared abstract or implement abstract method 'say()' in 'Abstract'
    /*public class AbstractExtends extends Abstract {
    }*/

    @Override
    public void say() {
        System.out.println("hello word");
    }

}

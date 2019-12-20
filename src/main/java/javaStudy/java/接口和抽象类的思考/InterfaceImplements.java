package javaStudy.java.接口和抽象类的思考;

public class InterfaceImplements implements Interface {

    // Class 'InterfaceImplements' must either be declared abstract or implement abstract method 'say()' in 'Interface'
    /*public class InterfaceImplements implements Interface {
    }*/

    @Override
    public void say() {
        sing();
    }

}

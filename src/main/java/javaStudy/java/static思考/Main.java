package javaStudy.java.static思考;

public class Main {
    public static void main(String[] args) {
        Static aStatic = new Static();
        aStatic.setName("hello");
        System.out.println(Static.getStaticName());
        System.out.println(aStatic.getName());
        Static.say();
    }
}

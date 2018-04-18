package java实例与思考.设计模式.抽象工厂模式;

public class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("Inside Square::draw() method.");
    }
}

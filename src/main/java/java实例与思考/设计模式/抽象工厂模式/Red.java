package java实例与思考.设计模式.抽象工厂模式;

public class Red implements Color {
    @Override
    public void fill() {
        System.out.println("Inside Red::fill() method.");
    }
}

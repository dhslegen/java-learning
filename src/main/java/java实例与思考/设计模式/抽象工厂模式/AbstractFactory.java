package java实例与思考.设计模式.抽象工厂模式;

public abstract class AbstractFactory {
    abstract Color getColor(String color);

    abstract Shape getShape(String shape);
}

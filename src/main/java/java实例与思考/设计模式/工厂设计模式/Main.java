package java实例与思考.设计模式.工厂设计模式;

import org.springframework.web.servlet.mvc.method.annotation.PathVariableMapMethodArgumentResolver;

public class Main {
    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();
        Shape shape1 = shapeFactory.getShape("CIRCLE");
        shape1.draw();
        Shape shape2 = shapeFactory.getShape("RECTANGLE");
        shape2.draw();
        Shape shape3 = shapeFactory.getShape("SQUARE");
        shape3.draw();
    }
}

package java实例与思考.设计模式.抽象工厂模式;

public class ColorFactory extends AbstractFactory {
    @Override
    Shape getShape(String shapeType) {
        return null;
    }

    @Override
    public Color getColor(String color) {
        if (color == null) {
            return null;
        } else if (color.equals("RED")) {
            return new Red();
        } else if (color.equals("GREEN")) {
            return new Green();
        } else if (color.equals("BLUE")) {
            return new Blue();
        }
        return null;
    }
}

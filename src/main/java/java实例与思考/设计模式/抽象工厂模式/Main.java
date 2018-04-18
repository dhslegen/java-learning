package java实例与思考.设计模式.抽象工厂模式;

/**
 * 【理解】
 * <p>&nbsp;&nbsp;待完成
 */
public class Main {
    public static void main(String[] args) {
        //获取形状工厂
        AbstractFactory shapeFactory = FactoryProducer.getFactory("SHAPE");
        //获取circle对象
        Shape shape1 = shapeFactory.getShape("CIRCLE");
        shape1.draw();
        //获取Rectangle对象
        Shape shape2 = shapeFactory.getShape("RECTANGLE");
        shape2.draw();
        //获取Square对象
        Shape shape3 = shapeFactory.getShape("SQUARE");
        shape3.draw();
        //获取颜色工厂
        AbstractFactory colorFactory = FactoryProducer.getFactory("COLOR");
        //获取Red对象
        Color color1 = colorFactory.getColor("RED");
        color1.fill();
        //获取Green对象
        Color color2 = colorFactory.getColor("GREEN");
        color2.fill();
        //获取Blue对象
        Color color3 = colorFactory.getColor("BLUE");
        color3.fill();
    }
}

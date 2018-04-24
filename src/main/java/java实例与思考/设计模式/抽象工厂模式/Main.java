package java实例与思考.设计模式.抽象工厂模式;

/**
 * 【概述】
 * <p>&nbsp;&nbsp;抽象工厂模式（Abstract Factory Pattern）是围绕一个超级工厂(FactoryProducer)创建其他工厂
 * (AbstractFactory)。该超级工厂又称为其他工厂的工厂。这种类型的设计模式属于创建型模式，它提供了一种创建对象的
 * 最佳方式。
 * <p>【理解】
 * <p>&nbsp;&nbsp;简单地说，工厂用来生产具有某种行为的对象，将这种行为抽象为抽象类或接口，工厂根据需要实例化不
 * 同的实现这种行为的对象；同样的，工厂本身也具有特定的行为（生产某类对象），将这种行为抽象为抽象类或接口，工厂根
 * 据需要实例化实现这种行为（生产某类对象）的不同对象；以此类推无穷尽矣。
 * <p>&nbsp;&nbsp;在本例中，超级工厂生产的工厂对象依靠两种行为（getShape和getColor）组合来差异化，而工厂生产
 * 的普通对象依靠一种行为（draw或fill）的不同实现来差异化。但同样的是都可以根据需要示例不同的对象。
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

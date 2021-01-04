package javaStudy.设计模式.创建型模式.建造者模式;

/**
 * 建造者模式（Builder Pattern）使用多个简单的对象一步一步构建成一个复杂的对象。一个 Builder 类会一步一步构造最终的对象。该 Builder 类是独立于其他对象的。
 * <p>
 * 将一个复杂的构建与其表示相分离，使得同样的构建过程可以创建不同的表示，分离就是没有强依赖。
 * <p>
 * 典型应用
 * <pre>
 * // MyBatis配置文件路径
 * String resources = "mybatis_config.xml";
 * // 获取一个输入流
 * Reader reader = Resources.getResourceAsReader(resources);
 * // 获取SqlSessionFactory
 * SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
 * // 打开一个会话
 * SqlSession sqlSession = sqlSessionFactory.openSession();
 * </pre>
 *
 * @author dhslegen
 */
public class Main {

    public static void main(String[] args) {
        Computer computer = new Computer.Builder("因特尔", "三星")
                .setDisplay("三星24寸")
                .setKeyboard("罗技")
                .setUsbCount(2)
                .build();
        System.out.println(computer);
    }

}

package java实例与思考;


import java.lang.annotation.*;
import java.lang.reflect.Field;

public class 注解 {
    /*     Annotation（注解）就是Java提供了一种元程序中的元素关联任何信息和着任何元数据（metadata）的途径和方法，
     * 以对像的形式给java的数据加属性标记（？=？）。
     *     Annotion(注解)是一个接口，程序可以通过反射来获取指定程序元素的Annotion对象，然后通过Annotion对象来获
     * 取注解里面的元数据。它可以用于创建文档，跟踪代码中的依赖性，甚至执行基本编译时检查。
     *     从某些方面看，annotation 就像修饰符一样被使用，并应用于包、类 型、构造方法、方法、成员变量、参数、本地
     * 变量的声明中。这些信息被存储在Annotation的“name=value”结构对中。
     *     @interface声明的注解（特殊的类）是实现了Annotation接口的特殊对象，Annotation的成员在Annotation类型中
     * 以无参数的方法的形式被声明。其方法名和返回值定义了该成员的名字和类型。在此有一个特定的默认语法：允许声明任何
     * Annotation成员的默认值：一个Annotation可以将name=value对作为没有定义默认值的Annotation成员的值，当然也可
     * 以使用name=value对来覆盖其它成员默认值。这一点有些近似类的继承特性，父类的构造函数可以作为子类的默认构造函数，
     * 但是也可以被子类覆盖。
     *     当我们通过java反射api访问Annotation时，返回值将是一个实现了该 annotation类型接口的对象，通过访问这个
     * 对象我们能方便的访问到其Annotation成员。
     *
     * 注解的分类：

     * 根据注解参数的个数，我们可以将注解分为三类：
     *　1.标记注解:一个没有成员定义的Annotation类型被称为标记注解。这种Annotation类型仅使用自身的存在与否来为我们提供信息。比如后面的系统注解@Override;
     *　2.单值注解
     *　3.完整注解

     * 根据注解使用方法和用途，我们可以将Annotation分为三类：
     *　1.JDK内置系统注解
     *　2.元注解
     *　3.自定义注解

     * 系统内置标准注解:
     *1.@Override：用于修饰此方法覆盖了父类的方法;
　　  *2.@Deprecated：用于修饰已经过时的方法;
　　  *3.@SuppressWarnnings:用于通知java编译器禁止特定的编译警告。
     * /

    /***********输出结果***************/

    /**
     * @param args
     */
    public static void main(String[] args) {

        FruitInfoUtil.getFruitInfo(Apple.class);

    }
}
/***********注解声明***************/

/**
 * 水果名称注解
 *
 * @author peida
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@interface FruitName {
    String value() default "";
}


/**
 * 水果供应者注解
 *
 * @author peida
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@interface FruitProvider {
    /**
     * 供应商编号
     *
     * @return
     */
    public int id() default -1;

    /**
     * 供应商名称
     *
     * @return
     */
    public String name() default "";

    /**
     * 供应商地址
     *
     * @return
     */
    public String address() default "";
}

/**
 * 水果颜色注解
 *
 * @author peida
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@interface FruitColor {
    /**
     * 颜色枚举
     *
     * @author peida
     */
    public enum Color {
        BULE, RED, GREEN
    }

    ;

    /**
     * 颜色属性
     *
     * @return
     */
    Color fruitColor() default Color.GREEN;

}

/***********注解使用***************/
class Apple {

    @FruitName("Apple")
    private String appleName;

    private String appleColor;

    @FruitProvider(id = 1, name = "陕西红富士集团", address = "陕西省西安市延安路89号红富士大厦")
    private String appleProvider;

    public void setAppleColor(String appleColor) {
        this.appleColor = appleColor;
    }

    public String getAppleColor() {
        return appleColor;
    }

    public void setAppleName(String appleName) {
        this.appleName = appleName;
    }

    public String getAppleName() {
        return appleName;
    }

    public void setAppleProvider(String appleProvider) {
        this.appleProvider = appleProvider;
    }

    public String getAppleProvider() {
        return appleProvider;
    }

    public void displayName() {
        System.out.println("水果的名字是：苹果");
    }
}

/***********注解处理器***************/

class FruitInfoUtil {
    public static void getFruitInfo(Class<?> clazz) {

        String strFruitName = " 水果名称：";
        String strFruitColor = " 水果颜色：";
        String strFruitProvicer = "供应商信息：";

        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields) {
            if (field.isAnnotationPresent(FruitName.class)) {
                FruitName fruitName = (FruitName) field.getAnnotation(FruitName.class);
                strFruitName = strFruitName + fruitName.value();
                System.out.println(strFruitName);
            } else if (field.isAnnotationPresent(FruitColor.class)) {
                FruitColor fruitColor = (FruitColor) field.getAnnotation(FruitColor.class);
                strFruitColor = strFruitColor + fruitColor.fruitColor().toString();
                System.out.println(strFruitColor);
            } else if (field.isAnnotationPresent(FruitProvider.class)) {
                FruitProvider fruitProvider = (FruitProvider) field.getAnnotation(FruitProvider.class);
                strFruitProvicer = " 供应商编号：" + fruitProvider.id() + " 供应商名称：" + fruitProvider.name() + " 供应商地址：" + fruitProvider.address();
                System.out.println(strFruitProvicer);
            }
        }
    }
}
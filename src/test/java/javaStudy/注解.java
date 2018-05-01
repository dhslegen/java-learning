package javaStudy;


import java.lang.annotation.*;
import java.lang.reflect.Field;

/**
 * 【概述】
 * <p>&nbsp;&nbsp;注解就是Java提供了一种元程序中的元素关联任何信息和着任何元数据（metadata）的途径和方法，
 * 以对象的形式给java的数据加属性标记（？=？）。
 * <p>&nbsp;&nbsp;Annotion(注解)是一个接口，程序可以通过反射来获取指定程序元素的Annotion对象，然后通过Annotion对象来获
 * 取注解里面的元数据。它可以用于创建文档，跟踪代码中的依赖性，甚至执行基本编译时检查。
 * <p>&nbsp;&nbsp;从某些方面看，annotation 就像修饰符一样被使用，并应用于包、类 型、构造方法、方法、成员变量、参数、本地
 * 变量的声明中。这些信息被存储在Annotation的“name=value”结构对中。
 * <p>&nbsp;&nbsp;声明的注解（特殊的类）是实现了Annotation接口的特殊对象，Annotation的成员在Annotation类型中
 * 以无参数的方法的形式被声明。其方法名和返回值定义了该成员的名字和类型。在此有一个特定的默认语法：允许声明任何
 * Annotation成员的默认值：一个Annotation可以将name=value对作为没有定义默认值的Annotation成员的值，当然也可
 * 以使用name=value对来覆盖其它成员默认值。这一点有些近似类的继承特性，父类的构造函数可以作为子类的默认构造函数，
 * 但是也可以被子类覆盖。
 * <p>&nbsp;&nbsp;当我们通过java反射api访问Annotation时，返回值将是一个实现了该 annotation类型接口的对象，通过访问这个
 * 对象我们能方便的访问到其Annotation成员。
 * <p>【注解的分类】
 * <p>&nbsp;&nbsp;根据注解参数的个数，我们可以将注解分为三类：
 * <p>&nbsp;&nbsp;&nbsp;1.标记注解:一个没有成员定义的Annotation类型被称为标记注解。这种Annotation类型仅使用自身的存在
 * 与否来为我们提供信息。比如后面的系统注解@Override;
 * <p>&nbsp;&nbsp;&nbsp;2.单值注解
 * <p>&nbsp;&nbsp;&nbsp;3.完整注解
 * <p>&nbsp;&nbsp;根据注解使用方法和用途，我们可以将Annotation分为三类：
 * <p>&nbsp;&nbsp;&nbsp;1.JDK内置系统注解
 * <p>&nbsp;&nbsp;&nbsp;2.元注解
 * <p>&nbsp;&nbsp;&nbsp;3.自定义注解
 * <p>&nbsp;&nbsp;系统内置标准注解:
 * <p>&nbsp;&nbsp;&nbsp;1.@Override：用于修饰此方法覆盖了父类的方法;
 * <p>&nbsp;&nbsp;&nbsp;2.@Deprecated：用于修饰已经过时的方法;
 * <p>&nbsp;&nbsp;&nbsp;3.@SuppressWarnnings:用于通知java编译器禁止特定的编译警告。
 * <p>【语法】
 * <p>&nbsp;&nbsp;使用@interface自定义注解时，自动继承了java.lang.annotation.Annotation接口，由编译程序自动完成其他细
 * 节。在定义注解时，不能继承其他的注解或接口。@interface用来声明一个注解，其中的每一个方法实际上是声明了一个配置参数。方法
 * 的名称就是参数的名称，返回值类型就是参数的类型（返回值类型只能是基本类型、Class、String、enum）。可以通过default来声明
 * 参数的默认值。
 * <p>&nbsp;&nbsp;定义注解格式：
 * <p>&nbsp;&nbsp;public @interface 注解名 {定义体}
 * <p>&nbsp;&nbsp;注解参数的可支持数据类型：
 * <p>&nbsp;&nbsp;&nbsp;1.所有基本数据类型（int,float,boolean,byte,double,char,long,short)
 * <p>&nbsp;&nbsp;&nbsp;2.String类型
 * <p>&nbsp;&nbsp;&nbsp;3.Class类型
 * <p>&nbsp;&nbsp;&nbsp;4.enum类型
 * <p>&nbsp;&nbsp;&nbsp;5.Annotation类型
 * <p>&nbsp;&nbsp;&nbsp;6.以上所有类型的数组
 * <p>&nbsp;&nbsp;Annotation类型里面的参数该怎么设定:
 * <p>&nbsp;&nbsp;&nbsp;第一,只能用public或默认(default)这两个访问权修饰.例如,String value();这里把方法设为defaul默hdqd
 * 认类型；
 * <p>&nbsp;&nbsp;&nbsp;第二,参数成员只能用基本类型byte,short,char,int,long,float,double,boolean八种基本数据类型和
 * String,Enum,Class,annotations等数据类型,以及这一些类型的数组.例如,String value();这里的参数成员就为String;
 * <p>&nbsp;&nbsp;&nbsp;第三,如果只有一个参数成员,最好把参数名称设为"value",后加小括号.例:下面的例子FruitName注解就只
 * 有一个参数成员。
 * <p>【注解的处理】
 * <p>&nbsp;&nbsp;注解处理器类库(java.lang.reflect.AnnotatedElement)：
 * <p>&nbsp;&nbsp;Java使用Annotation接口来代表程序元素前面的注解，该接口是所有Annotation类型的父接口。除此之外，Java在
 * java.lang.reflect 包下新增了AnnotatedElement接口，该接口代表程序中可以接受注解的程序元素，该接口主要有如下几个实现类：
 * <p>&nbsp;&nbsp;&nbsp;Class：类定义
 * <p>&nbsp;&nbsp;&nbsp;Constructor：构造器定义
 * <p>&nbsp;&nbsp;&nbsp;Field：累的成员变量定义
 * <p>&nbsp;&nbsp;&nbsp;Method：类的方法定义
 * <p>&nbsp;&nbsp;&nbsp;Package：类的包定义
 * <p>&nbsp;&nbsp;java.lang.reflect 包下主要包含一些实现反射功能的工具类，实际上，java.lang.reflect 包所有提供的反射
 * API扩充了读取运行时Annotation信息的能力。当一个Annotation类型被定义为运行时的Annotation后，该注解才能是运行时可见，
 * 当class文件被装载时被保存在class文件中的Annotation才会被虚拟机读取。
 * <p>&nbsp;&nbsp;AnnotatedElement 接口是所有程序元素（Class、Method和Constructor）的父接口，所以程序通过反射获取了
 * 某个类的AnnotatedElement对象之后，程序就可以调用该对象的如下四个个方法来访问Annotation信息：
 * <p>&nbsp;&nbsp;&nbsp;方法1：<T extends Annotation> T getAnnotation(Class<T> annotationClass): 返回改程序元素
 * 上存在的、指定类型的注解，如果该类型注解不存在，则返回null。
 * <p>&nbsp;&nbsp;&nbsp;方法2：Annotation[] getAnnotations():返回该程序元素上存在的所有注解。
 * <p>&nbsp;&nbsp;&nbsp;方法3：boolean is AnnotationPresent(Class<?extends Annotation> annotationClass):判断该
 * 程序元素上是否包含指定类型的注解，存在则返回true，否则返回false.
 * <p>&nbsp;&nbsp;&nbsp;方法4：Annotation[] getDeclaredAnnotations()：返回直接存在于此元素上的所有注释。与此接口中
 * 的其他方法不同，该方法将忽略继承的注释。（如果没有注释直接存在于此元素上，则返回长度为零的一个数组。）该方法的调用者可以
 * 随意修改返回的数组；这不会对其他调用者返回的数组产生任何影响。
 */
public class 注解 {

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
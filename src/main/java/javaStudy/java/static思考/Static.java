package javaStudy.java.static思考;

/**
 * 普通方法能操作静态变量和方法，反之却不行
 */
public class Static {
    private static String name;
    private Integer age;

    public String getName() {
        return name;
    }

    public static String getStaticName() {
        return name;
    }

    public void setName(String name) {
        Static.name = name;
        age = 10;
        System.out.println(getStaticName());
    }

    public static void say() {
        // 'javaStudy.java.static思考.Static.this' cannot be referenced from a static context
        // this.age = name;

        // Non-static method 'setName(java.lang.String)' cannot be referenced from a static context
        // setName("");
        System.out.println(name);
    }
}

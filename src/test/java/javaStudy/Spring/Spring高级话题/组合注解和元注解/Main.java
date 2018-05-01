package javaStudy.Spring.Spring高级话题.组合注解和元注解;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 【理解】
 * <p>&nbsp;&nbsp;Spring提供了一种组合注解的方式，大大减少了重复代码的使用。将需要组合的注解注解到新定义的注解，并重写
 * 注解中同一个函数如value（），则使用新注解时，相当于使用了所有组合注解，赋值会传递给组合注解。很显然，例子失败了。
 */
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
        DemoService demoService = context.getBean(DemoService.class);
        demoService.outputResult();
        context.close();
    }
}

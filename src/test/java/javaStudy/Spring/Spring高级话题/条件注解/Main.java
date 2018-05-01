package javaStudy.Spring.Spring高级话题.条件注解;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 【理解】
 * <p>&nbsp;&nbsp;除了用profile的方式，Spring还提供了用@Conditional(WindowsCondition.class)为bean组件设置成条件创建，
 * 其参数接受一个实现了org.springframework.context.annotation.Condition接口的类字节对象，当getBean时，自动回调matches
 * 方法，如果成立则创建。
 */
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConditionConfig.class);
        ListService listService = context.getBean(ListService.class);
        System.out.println(context.getEnvironment().getProperty("os.name") + "系统下的列表命令行为:" + listService.showListCmd());
    }
}

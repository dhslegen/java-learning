package java实例与思考.Spring.Spring常用配置.Scope;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 【理解】
 * <p>&nbsp;&nbsp;@Scope描述的是Spring是如何创建bean实例的，有如下几种:
 * <p>&nbsp;&nbsp;&nbsp;(1)Singleton:一个容器中只有一个Bean的实例，全容器共享
 * <p>&nbsp;&nbsp;&nbsp;(2)Prototype:每次调用新建一个bean的实例
 * <p>&nbsp;&nbsp;&nbsp;(3)Request:Web项目中，给每一个http request 新建一个Bean实例。
 * <p>&nbsp;&nbsp;&nbsp;(4)Session:Web项目中，给每一个http session新建一个Bean实例。
 * <p>&nbsp;&nbsp;&nbsp;(5)GlobalSession:这个只在portal应用中有用，给每一个global http session新建一个Bean实例。
 * <p>&nbsp;&nbsp;&nbsp;(6)StepScope:Spring Batch批处理中的Scope。
 */
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ScopeConfig.class);
        DemoService d1 = context.getBean(DemoService.class);
        DemoService d2 = context.getBean(DemoService.class);
        DemoSingletonService s1 = context.getBean(DemoSingletonService.class);
        DemoSingletonService s2 = context.getBean(DemoSingletonService.class);
        DemoPrototypeService p1 = context.getBean(DemoPrototypeService.class);
        DemoPrototypeService p2 = context.getBean(DemoPrototypeService.class);
        System.out.println("d1与d2是否相等:" + d1.equals(d2));
        System.out.println("s1与s2是否相等:" + s1.equals(s2));
        System.out.println("p1与p2是否相等:" + p1.equals(p2));

    }
}

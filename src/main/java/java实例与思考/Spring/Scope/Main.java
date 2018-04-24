package java实例与思考.Spring.Scope;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

/**
 * 【理解】
 * <p>nbsp;nbsp;@Scope描述的是Spring是如何创建bean实例的，有如下几种:
 * <p>nbsp;nbsp;nbsp;(1)
 * <p>nbsp;nbsp;nbsp;(2)
 * <p>nbsp;nbsp;nbsp;(3)
 * <p>nbsp;nbsp;nbsp;(4)
 * <p>nbsp;nbsp;nbsp;(5)
 * <p>nbsp;nbsp;nbsp;(6)
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

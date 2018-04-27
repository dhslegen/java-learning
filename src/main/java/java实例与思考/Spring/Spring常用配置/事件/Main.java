package java实例与思考.Spring.Spring常用配置.事件;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 【理解】
 * <P>&nbsp;&nbsp;Spring事件是Spring框架支持的自动监听功能，首先实现ApplicationListener<DemoEvent>接口的监听对象注
 * 入容器后，容器自动监听DemoEvent事件的发布;然后发布对象调用容器实例ApplicationContext的publishEvent方法发布
 * DemoEvent事件，自动触发正在监听DemoEvent事件监听对象的onApplicationEvent方法。
 */
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(EventConfig.class);
        DemoPublisher demoPublisher = context.getBean(DemoPublisher.class);
        demoPublisher.publish("hello application event");
        context.close();
    }
}

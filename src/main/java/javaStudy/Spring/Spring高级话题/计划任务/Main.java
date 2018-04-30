package javaStudy.Spring.Spring高级话题.计划任务;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 【理解】
 * <p>&nbsp;&nbsp;Spring对计划任务的支持非常简单，在配置类中利用@EnableScheduling注解开启计划任务的支持，如此只要容器
 * 中的bean中含有@Scheduled注解的方法，容器读取后定时执行。
 */
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TaskSchedulerConfig.class);
    }
}

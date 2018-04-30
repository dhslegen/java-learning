package javaStudy.Spring.Spring高级话题.多线程;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 【理解】
 * <p>&nbsp;&nbsp;Spring会把@Async注解的方法重构，重构为用配置类里得到的任务执行器执行。
 */
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TaskExecutorConfig.class);
        AsyncTaskService asyncTaskService = context.getBean(AsyncTaskService.class);
        for (int i = 0; i < 10; i++) {
            asyncTaskService.executeAsyncTask(i);
            asyncTaskService.executeAsyncTaskPlus(i);
            context.close();
        }
    }
}

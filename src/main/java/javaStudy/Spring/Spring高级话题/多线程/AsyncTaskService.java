package javaStudy.Spring.Spring高级话题.多线程;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsyncTaskService {
    @Async //表明方法是个异步方法，如果注解在类上，表明该类所有的方法都是异步方法，这些方法会自动被ThreadPoolTaskExecutor
    // 注入作为任务执行器
    public void executeAsyncTask(Integer i) {
        System.out.println("执行异步任务:" + (i));
    }

    @Async
    public void executeAsyncTaskPlus(Integer i) {
        System.out.println("执行异步任务+1:" + (i + 1));
    }
}

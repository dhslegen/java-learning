package javaStudy.Spring.Spring高级话题.计划任务;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@ComponentScan("javaStudy.Spring.Spring高级话题.计划任务")
@EnableScheduling //开启容器对计划任务的支持
public class TaskSchedulerConfig {
}

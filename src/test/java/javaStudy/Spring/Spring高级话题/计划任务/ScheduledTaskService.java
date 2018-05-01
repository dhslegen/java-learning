package javaStudy.Spring.Spring高级话题.计划任务;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class ScheduledTaskService {
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime() {
        System.out.println("每隔5秒执行一次 " + DATE_FORMAT.format(new Date()));
    }

    @Scheduled(cron = "0 7 15 ? * *")
    public void fixTimeExecution() {
        System.out.println("在指定时间" + DATE_FORMAT.format(new Date()) + "执行");
    }
}

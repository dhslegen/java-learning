package javaStudy.SpringMVC.自定义HttpMessageConverter;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Random;

@Controller
public class SseController {
    //text/event-stream,这是服务器端SSE的支持，本例演示每隔5秒推送随机消息。
    @RequestMapping(value = "/push", produces = "text/event-stream;charset=UTF-8")
    @ResponseBody
    public String push() {
        Random random = new Random();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "data:Testing 1,2,3" + random.nextInt() + "\n\n";
    }
}

package javaStudy.SpringMVC.服务器端推送技术.SSE;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Random;

@Controller
public class SseController {
    //text/event-stream,这是服务器端SSE的支持，本例演示每隔5秒推送随机消息。sse是饥饿模式下
    //的服务器端推送模式，客户端个收到返回会立刻进行下一次请求，而服务器端可以根据条件选择性返回，
    //从而不会浪费每次请求。
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

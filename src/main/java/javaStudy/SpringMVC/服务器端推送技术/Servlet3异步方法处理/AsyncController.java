package javaStudy.SpringMVC.服务器端推送技术.Servlet3异步方法处理;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.DeferredResult;

@Controller
public class AsyncController {
    @Autowired
    PushService pushService;

    /**
     * 【理解】
     * <p>&nbsp;&nbsp;这里用到的是servlet3.0以上的异步特性，来实现服务器端不断推送消息。也就是请求不会阻塞，而是代理给
     * AsyncContext了，同时用到了DeferredResult，顾名思义就是滞后的返回结果，特性就是mvc处理它时，必须等到有值才返回，
     * 这是和callable做返回值唯一不同的地方。过程如下：
     * <p>1.客户端请求服务
     * <p>2.SpringMVC调用Controller，Controller返回一个DeferredResult对象
     * <p>3.SpringMVC调用ruquest.startAsync,这里是servlet的范围，mvc将请求的处理代理给AsyncContext对象
     * <p>4.DispatcherServlet以及Filters等从应用服务器线程中结束，但Response仍旧是打开状态，也就是说暂时还不返回给客户端
     * <p>5.某些其它线程将结果设置到DeferredResult中，SpringMVC检测到DeferredResult有值后，调用AsyncContext的getResponse
     * 将请求发送给应用服务器继续处理
     * <p>6.DispatcherServlet再次被调用并且继续处理DeferredResult中的结果，最终将其返回给客户端
     *
     * @return
     */
    @RequestMapping("/defer")
    @ResponseBody
    public DeferredResult<String> deferredCall() {
        return pushService.getAsyncUpdate();
    }
}

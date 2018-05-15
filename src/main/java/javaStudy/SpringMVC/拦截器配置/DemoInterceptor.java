package javaStudy.SpringMVC.拦截器配置;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.logging.Handler;

public class DemoInterceptor extends HandlerInterceptorAdapter {//继承HandlerInterceptorAdapter来实现自定义拦截器

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {//在请求发生之前执行
        long startTime = System.currentTimeMillis();
        request.setAttribute("startTime", startTime);
        System.out.println("我在请求前执行！");
        return true;//决定是否将请求继续向后处理TRUE是继续向后
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {//在请求发生之前执行
        long startTime = (Long) request.getAttribute("startTime");
        request.removeAttribute("startTime");
        long endTime = System.currentTimeMillis();

        System.out.println("我在请求完成后执行！本次请求的处理的时间为:" + new Long(endTime - startTime) + "ms");
        request.setAttribute("handlingTime", endTime - startTime);
    }
}

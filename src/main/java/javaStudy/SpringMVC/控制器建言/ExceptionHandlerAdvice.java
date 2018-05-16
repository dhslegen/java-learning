package javaStudy.SpringMVC.控制器建言;

import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

/**
 * 【理解】
 * <p>&nbsp;&nbsp;@ControllerAdvice顾名思义，就是对于控制器的全局配置，而MyMvcConfig实现了WebMvcConfigurerAdapter，更像是
 * Spring对于WebMvc框架的全局配置（XML，或者容器）,后者发生在控制器之前或之后，更多的是配置及添加各种解释器、添加各种配置器、拦
 * 截器等。@ControllerAdvice只关注控制器范围内，并对所有控制器做参数转化、键值对的处理、控制器异常处理等的统一的附加处理。实现原理
 * 特定的注解的方法中必须含有约定好的对应的类型的参数，框架用实际参数回调，达到配置的效果
 */
@ControllerAdvice
public class ExceptionHandlerAdvice {
    // @ExceptionHandler用于全局处理控制器了的异常,当所有@Controller响应过程中抛出异常时，自动执行
    @ExceptionHandler(value = Exception.class)
    public ModelAndView exception(Exception exception, WebRequest request) {
        ModelAndView modelAndView = new ModelAndView("error");//error页面
        modelAndView.addObject("errorMessage", exception.getMessage());
        return modelAndView;
    }

    // @ModelAttribute绑定键值对到Model里,当所有@Controller开始响应的初期，自动执行但晚于HandlerInterceptorAdapter实现类的的preHandle方法
    @ModelAttribute
    public void addAttributes(Model model, Model model1, String name, String aaa) {
        model.addAttribute("msg", "额外信息");
        model1.addAttribute("msg1", "额外信息1");
        model1.addAttribute("msg2", model.equals(model));
        model1.addAttribute("msg3", name);
        model1.addAttribute("msg4", aaa);
        model1.addAttribute("id", "womeiyuou");
    }

    // @InitBinder处理前台的请求参数(?后面的)，可以设置忽略某参数，或绑定到Model，晚于@ModelAttribute执行
    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        webDataBinder.setDisallowedFields("id");
    }
}

package javaStudy.SpringMVC.控制器建言;

import javaStudy.SpringMVC.SpringMVC的常用注解.DemoObj;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdviceController {
    @RequestMapping("/advice")
    public ModelAndView getSomething(@ModelAttribute("msg") String msg, DemoObj obj) {
        throw new IllegalArgumentException("非常抱歉，参数有误/" + "来自@ModelAttribute:" + msg);
    }
}

package javaStudy.SpringMVC.控制器建言;

import javaStudy.SpringMVC.SpringMVC的常用注解.DemoObj;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdviceController {
    @RequestMapping("/advice")
    public ModelAndView getSomething(@ModelAttribute("msg") String msg, @ModelAttribute("msg1") String msg1, @ModelAttribute("msg2") String msg2, @ModelAttribute("msg3") String msg3, @ModelAttribute("msg4") String msg4, @ModelAttribute("id") String ids, DemoObj obj, String name, String id) {
        throw new IllegalArgumentException("非常抱歉，参数有误/" + "来自@ModelAttribute:" + msg + msg1 + msg2 + msg3 + msg4);
    }
}

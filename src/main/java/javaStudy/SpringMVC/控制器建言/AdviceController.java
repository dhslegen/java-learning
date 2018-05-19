package javaStudy.SpringMVC.控制器建言;

import javaStudy.SpringMVC.SpringMVC的常用注解.DemoObj;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

@Controller
public class AdviceController {
    @RequestMapping("/advice")
    public ModelAndView getSomething(@ModelAttribute("msg") String msg, @ModelAttribute("date") Date date, DemoObj obj, String name, String id, Model model) {
        throw new IllegalArgumentException("非常抱歉，参数有误/" + "来自@ModelAttribute:" + msg + date);
    }
}

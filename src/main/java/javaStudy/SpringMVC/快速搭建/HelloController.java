package javaStudy.SpringMVC.快速搭建;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller //声明控制器
public class HelloController {
    @RequestMapping("/index")//配置URL和方法的映射
    public String hello(Model model) {
        return "index";//通过ViewResolver再次映射，找到实际页面
    }
}

package javaStudy.SpringMVC.控制器建言;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ModelAttributeTestController {
    @ModelAttribute("name")
    public String test(@RequestParam(required = false) String name) {
        return name;
    }

    @RequestMapping(value = "/test1")
    //@ModelAttribute("name")如果同时使用，则@ModelAttribute优先级高，导致@RequestMapping返回null，这时路径直传没有映射为/test1
    public String test1(@RequestParam(required = false) String name, Model model) {
        return name;
    }

}

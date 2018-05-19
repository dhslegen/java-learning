package javaStudy.SpringMVC.控制器建言;


import javaStudy.SpringMVC.SpringMVC的常用注解.DemoObj;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.Arrays;
import java.util.Map;

@SessionAttributes(value = {"names", "msg", "date", "obj", "org.springframework.validation.BindingResult.demoObj", "demoObj"}, types = {Integer.class})
@Controller
public class AdviceControllerWithSessionAttributes {

    @RequestMapping("/test")
    //这里演示了一种Model直接在@RequestMapping方法中，Model代表了request域的键值对，也可以用Map<String,Object> map代替
    public String test(String id, DemoObj obj, Map<String, Object> map) {
        map.put("names", Arrays.asList("caoyc", "zhh", "cjx"));
        map.put("age", 18);
        map.put("id", 20);
        map.put("obj", obj);
        return "test";
    }
}
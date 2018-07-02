package javaStudy.SpringMVC.自定义HttpMessageConverter;

import javaStudy.SpringMVC.SpringMVC的常用注解.DemoObj;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ConverterController {
    //@RequestBody表明要从request体中，提取数据，并通过HttpMessageConverter转换为目标对象，这里自动调用
    //HttpMessageConverter的readInternal方法。
    //@ResponseBody表明要将结果按application/x-wisely的自定义类型，写到response体中，这里自动调用
    //HttpMessageConverter的writeInternal方法。
    @RequestMapping(value = "/convert", produces = "application/x-wisely")
    @ResponseBody
    public DemoObj convert(@RequestBody DemoObj demoObj) {
        return demoObj;
    }

}

package javaStudy.SpringMVC.SpringMVC的常用注解;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
//@ResponseBody放在类上时,Spring会将该类带有@RequestMapping注解的,全部附加@ResponseBody的同名注解
@RequestMapping("/anno")
public class DemoAnnoController {
    @RequestMapping(produces = "text/plain;charset=UTF-8")//produces定制返回的response的媒体类型和字符集
    @ResponseBody
    public String index(HttpServletRequest request) {//可接收HttpRequest作为参数，当然也可接受HttpResponse作为参数
        return "url:" + request.getRequestURL() + " can access.";
    }

    @RequestMapping(value = "/pathVar/{str}", produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String demoPathVar(@PathVariable String str, HttpServletRequest request) {//路径中{str}表示该方
        // 法的@PathVariable修饰的同名参数要被真实的参数传入
        return "url:" + request.getRequestURL() + " can access,str:" + str;
    }

    @RequestMapping(value = "/requestParam", produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String passRequestParam(Long id, HttpServletRequest request) {//常规的request参数获取,
        // 参数的传值遵循同名传值,方法如果没有实际同名参数则默认为null，按需选值，有啥算啥
        return "url" + request.getRequestURL() + " can access,id:" + id;
    }

    @RequestMapping(value = "/obj", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String passObj(DemoObj obj, HttpServletRequest request) {//与上面的类似，只不过实际同名
        // 参数没有直接传给形式参数，而是先创建一个形式参数一致的对象，同名参数付给对象对应的的setter方法，
        // 最后对象传递至形式参数。（注意实参只会和对应的setter方法名对应，而不是setter中的形参，实参驼峰
        // 的第一个字母无所谓大小写）
        return "url:" + request.getRequestURL() + " can access,obj id:" + obj.getId() + " obj name:" + obj.getName();
    }

    @RequestMapping(value = {"/name1", "/name2"}, produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String remove(HttpServletRequest request) {//多个路径到同一个方法，当value是个数组即可
        return "url:" + request.getRequestURL() + " can access";
    }
}

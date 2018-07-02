package javaStudy.SpringMVC.控制器建言;

import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

/**
 * 【理解】
 * <p>&nbsp;&nbsp;@ControllerAdvice顾名思义，就是对于控制器的全局配置，@ControllerAdvice其实是抽取所有的@Controller
 * 内部的方法，这些方法也可直接放在特定的某个@Controller中。而MyMvcConfig实现了WebMvcConfigurerAdapter，更像是
 * Spring对于WebMvc框架的全局配置（XML，或者容器）,发生在控制器之前或之后，更多的是配置及添加各种解释器、添加各种配置器、拦
 * 截器等。实现原理：特定的注解的方法中必须含有约定好的对应的类型的参数，框架用实际参数回调，达到配置的效果
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

    // @ModelAttribute绑定键值对到Model里,也可接受页面的参数,如果过程中涉及绑定，Model空间自动自家两个键值对，分别是一对绑定
    // 的类名首字母小写-对象，一对绑定的结果描述。最后这个对象传给形参，完成自动绑定
    @ModelAttribute
    public Model addAttributes(Model model, Date date/*, DemoObj obj*/) {
        model.addAttribute("msg", "额外信息");
        // model.addAttribute("date", date);
        return model;
    }

    /*  @ModelAttribute
    public int myModel(@RequestParam(required = false) Integer number) {
        return number;
    }

    @ModelAttribute(value = "num")
    public int myModel2(@RequestParam(required = false) Integer number2) {
        return number2;
    }*/

    //     @InitBinder处理前台的请求参数(?后面的)，这里的绑定特指页面的参数与对象的绑定，也就是不会影响同名参数的点对点传值，
    // 执行时机是形式请求参数检索实参（页面的参数）之前，包括 @ModelAttribute的方法除了Model类型参数之外还有其他参数以及
    // 不用多说的@RequestMapping("/*")的方法之前，也发生在@SessionAttributes存在的控制器类的映射方法响应之后的
    // session备份的键值绑定。
    //     当不是点对点同名传值时，间接通过Model空间的键值绑定，有两种情况：
    //     1.手动添加的键值，直接绑定，如@ModelAttribute("msg") String msg
    //     2.自动添加的键值（类型猜测？）一对绑定的类名首字母小写-对象，一对绑定的结果描述，但对象是只初始化的对象（new...）。
    //     如：DemoObj obj，最后通过点对点setter完成最终传参
    //【理解】对于@InitBinder来说 @ModelAttribute和@RequestMapping的地位是相同的，都要根据参数寻求绑定，同名绑定null，不会存
    // 到model空间，对象绑定引用,只不过引用有是否已经有值之分。引用存在Model空间，有的是手动加的，有的则是类型猜测自动加的。最终
    // 形式请求参数检索实参全部取自model空间。
    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        //webDataBinder.setDisallowedFields("id");
        //这里是解决点对点传值的类型转化问题，包括参数到对象的setter类型转化的问题
        webDataBinder.registerCustomEditor(Date.class, new MyDateEditor());
    }


}

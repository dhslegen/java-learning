package javaStudy.SpringMVC.SpringMVC的常用注解;

/**
 * 【Spring MVC常见注解】
 * <p>&nbsp;&nbsp;(1)@Controller:声明为Spring Bean,Dispatcher servlet会自动扫描注解了该注解的类，并将
 * Web请求映射到注解了@RequestMapping的方法上。（组合了component，但springMVC中是有特殊作用的）
 * <p>&nbsp;&nbsp;(2)@RequestMapping:用来映射Web请求（访问路径和参数）、处理类和处理方法的。注解在方法上
 * 的@RequestMapping路径会继承注解在类上的，支持Servlet的request和response作为参数，也支持对request和response
 * 的媒体类型进行配置
 * <p>&nbsp;&nbsp;(3)@ResponseBody:支持返回值放在response体内，而不是返回一个页面。我们在很多基于Ajax的
 * 程序可以以此注解返回数据而不是页面。此注解可放置在返回值和方法上*(其实就是方法上?)
 * <p>&nbsp;&nbsp;(4)@RequestBody:允许request的参数放在request体内，而不是连接在地址后面。此注解放置在参数前
 * <p>&nbsp;&nbsp;(5)@PathVariable:接受路径参数，如/news/001,可接受001作为参数。此注解放在参数前
 * <p>&nbsp;&nbsp;(6)@RestController:组合注解，组合了@Controller和@ResponseBody两个注解。
 */
public class Main {
}

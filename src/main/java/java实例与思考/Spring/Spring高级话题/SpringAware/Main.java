package java实例与思考.Spring.Spring高级话题.SpringAware;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.context.ServletConfigAware;

/**
 * 【理解】
 * <p>&nbsp;&nbsp;Aware的意思是“意识到的”，容器通过判断是否是实现了某某Aware的实例，然后调用接口方法，将容器的属性反馈给Bean
 */
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AwareConfig.class);
        AwareService awareService = context.getBean(AwareService.class);
        awareService.outputResult();
    }
}

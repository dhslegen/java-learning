package javaStudy.Spring.Spring高级话题.组合注解和元注解;

import org.springframework.stereotype.Service;

@Service
public class DemoService {

    public void outputResult() {
        System.out.println("从组合注解配置照样获得的bean");
    }
}

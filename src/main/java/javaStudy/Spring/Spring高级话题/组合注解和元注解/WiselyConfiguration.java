package javaStudy.Spring.Spring高级话题.组合注解和元注解;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Configuration//组合@Configuration
@ComponentScan//组合@@ComponentScan
public @interface WiselyConfiguration {
    String[] value() default {};
}

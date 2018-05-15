package javaStudy.SpringMVC.快速搭建;

import javaStudy.SpringMVC.拦截器配置.DemoInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc //开启SpringMVC支持，若无此句，重写WebMvcConfigurerAdapter无效,开启默认配置
@ComponentScan("javaStudy.SpringMVC")
public class MyMvcConfig extends WebMvcConfigurerAdapter {//继承WebMvcConfigurerAdapter类，对SpringMVC进行配置

    //配置一个JSP的ViewResolver，用来映射路径和实际页面的位置
    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
        internalResourceViewResolver.setPrefix("/WEB-INF/classes/views/");
        internalResourceViewResolver.setSuffix(".jsp");
        internalResourceViewResolver.setViewClass(JstlView.class);
        return internalResourceViewResolver;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //addResourceHandler指的是对外暴露的访问路径
        registry.addResourceHandler("/assets/**").addResourceLocations("classpath:/assets/");
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //和@RequestMapping("")直接返回string的@Controller效果一致
        registry.addViewController("/toUpload").setViewName("upload");
    }

    @Bean
    public DemoInterceptor demoInterceptor() {
        return new DemoInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //注册拦截器
        registry.addInterceptor(demoInterceptor());
    }

    @Bean
    public MultipartResolver multipartResolver() {
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
        multipartResolver.setMaxUploadSize(1000000);
        return multipartResolver;
    }
}

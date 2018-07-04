package javaStudy.SpringMVC.快速搭建;

import javaStudy.SpringMVC.拦截器配置.DemoInterceptor;
import javaStudy.SpringMVC.自定义HttpMessageConverter.MyMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import java.util.List;

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
    //若没有业务处理，只是页面转向，可通过重写addViewControllers简化配置
    public void addViewControllers(ViewControllerRegistry registry) {
        //和@RequestMapping("")直接返回string的@Controller效果一致，都存在是优先@Controller
        registry.addViewController("/toUpload").setViewName("upload");
        registry.addViewController("/converter").setViewName("converter");
        registry.addViewController("/sse").setViewName("/sse");
    }

    @Override
    //配置路径参数不忽略“.”符号
    public void configurePathMatch(PathMatchConfigurer configurer) {
        configurer.setUseSuffixPatternMatch(false);
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
    //上传文件用到的解析器，会自动调用common.file的支持，没有该依赖会报错。只有配置这个转化器，页面的multipart file才会解析为
    //Spring的MultipartFile
    public MultipartResolver multipartResolver() {
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
        multipartResolver.setMaxUploadSize(1000000);
        return multipartResolver;
    }

    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(converter());
    }

    @Bean
    public MyMessageConverter converter() {
        return new MyMessageConverter();
    }
}

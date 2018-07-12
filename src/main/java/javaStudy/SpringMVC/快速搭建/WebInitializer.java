package javaStudy.SpringMVC.快速搭建;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.Registration;
import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

public class WebInitializer implements WebApplicationInitializer {
    //实现该接口会自动被SpringServletContainerInitializer获取到，并启动servlet容器，实现替代web.xml的位置

    @Override
    public void onStartup(ServletContext servletContext) {
        //新建WebApplicationContext，注册配置类，并将其和当前servletContext关联
        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
        ctx.register(MyMvcConfig.class);
        ctx.setServletContext(servletContext);
        //注册SpringMVC的DispatcherServlet
        ServletRegistration.Dynamic servlet = servletContext.addServlet("dispatcher", new DispatcherServlet(ctx));
        servlet.addMapping("/");
        servlet.setLoadOnStartup(1);
        //开启异步方法的支持
        servlet.setAsyncSupported(true);
    }
}

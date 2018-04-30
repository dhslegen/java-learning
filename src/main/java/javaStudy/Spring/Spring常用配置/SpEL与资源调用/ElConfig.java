package javaStudy.Spring.Spring常用配置.SpEL与资源调用;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;

/**
 * <p>【理解】
 * <p>&nbsp;&nbsp;@Configuration也相当于一个bean，只不过这个bean可以通过AnnotationConfigApplicationContext(ElConfig.class)
 * 获取到容器，可以自己获取自己
 */
@Configuration
@ComponentScan("javaStudy.Spring.Spring常用配置.SpEL与资源调用")
@PropertySource("classpath:javaStudy/Spring/Spring常用配置/SpEL与资源调用/test.properties")
public class ElConfig {
    //注入普通字符
    @Value("I Love You!")
    private String normal;
    //注入操作系统属性
    @Value("#{systemProperties['os.name']}")
    private String osName;
    //注入表达式的结果
    @Value("#{ T (java.lang.Math).random() * 100.0}")
    private double randomNumber;
    //注入其他bean的属性
    @Value("#{demoService.another}")
    private String fromAnother;
    //注入文件资源
    @Value("classpath:javaStudy/Spring/Spring常用配置/SpEL与资源调用/test.properties")
    private Resource testFile;
    //注入网址资源
    @Value("http://www.baidu.com")
    private Resource testUrl;
    //注入配置文件
    @Value("${book.name}")
    private String bookName;
    @Autowired
    private Environment environment;

    //@PropertySource指定配置文件地址，但如果想使用 @Value注入配置文件内容，则需要PropertySourcesPlaceholderConfigurer对象
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertConfigure() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    public void outputResource() {
        try {
            System.out.println(normal);
            System.out.println(osName);
            System.out.println(randomNumber);
            System.out.println(fromAnother);
            System.out.println(IOUtils.toString(testFile.getInputStream()));
            System.out.println(IOUtils.toString(testUrl.getInputStream()));
            System.out.println(bookName);
            //从Environment中获取Properties
            System.out.println(environment.getProperty("book.author"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

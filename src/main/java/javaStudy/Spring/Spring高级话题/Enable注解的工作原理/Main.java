package javaStudy.Spring.Spring高级话题.Enable注解的工作原理;

import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * 【简介】
 * <p>&nbsp;&nbsp;几种常用的@Enable*注解的介绍
 * <p>&nbsp;&nbsp;&nbsp;@EnableAspectJAutoProxy:开启AspectJ自动代理的支持。
 * <p>&nbsp;&nbsp;&nbsp;@EnableAsync:开启异步方法的支持。
 * <p>&nbsp;&nbsp;&nbsp;@EnableScheduling:开启计划任务的支持。
 * <p>&nbsp;&nbsp;&nbsp;@EnableWebMVC:开启WebMVC的配置支持。
 * <p>&nbsp;&nbsp;&nbsp;@EnableConfigurationProperties:开启对@ConfigurationProperties注解配置bean的支持。
 * <p>&nbsp;&nbsp;&nbsp;@EnableJpaRepositories:开启对Spring Data Repositories的支持。
 * <p>&nbsp;&nbsp;&nbsp;@EnableTransactionManagement:开启注解式事务的支持。
 * <p>&nbsp;&nbsp;&nbsp;@EnableCaching:开启注解式的缓存支持。
 * <p>【原理】
 * <p>&nbsp;&nbsp;所有的注解都有一个@Import注解，@Import注解是用来导入配置类的，自动开启支持的实现其实就是导入
 * 了一些自动配置的Bean。导入配置得方式分为以下三种类型:
 * <p>&nbsp;&nbsp;&nbsp;1.直接导入配置类:@EnableScheduling,@Import(SchedulingConfiguration.class)
 * <p>&nbsp;&nbsp;&nbsp;2.依据条件选择配置类:@EnableAsync,@Import(AsyncConfigurationSelector.class),导入
 * 选择器，根据情况选择
 * <p>&nbsp;&nbsp;&nbsp;3.动态注册Bean:@EnableAspectAutoProxy,更像是打开了容器注册器的某个感知开关，
 * definition.getPropertyValues().add("proxyTargetClass", Boolean.TRUE);
 */
@EnableScheduling
@EnableAsync
@EnableAspectJAutoProxy
public class Main {
}

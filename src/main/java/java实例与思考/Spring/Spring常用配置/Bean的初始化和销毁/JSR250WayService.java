package java实例与思考.Spring.Spring常用配置.Bean的初始化和销毁;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * 【理解】
 * <p>&nbsp;&nbsp;@PostConstruct在初始化后，@PreDestroy在销毁前
 */
public class JSR250WayService {
    @PostConstruct
    public void init() {
        System.out.println("jsr250-init-method");
    }

    public JSR250WayService() {
        super();
        System.out.println("初始化构造函数-JSR250WayService");

    }

    @PreDestroy
    public void destroy() {
        System.out.println("jsr250-destroy-method");
    }
}

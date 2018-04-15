package java实例与思考.Spring.Beande的初始化和销毁;

public class BeanWayService {
    public void init() {
        System.out.println("@Bean-init-method");
    }

    public BeanWayService() {
        super();
        System.out.println("初始化构造函数-BeanWayService");

    }

    public void destroy() {
        System.out.println("@Bean-destroy-method");
    }
}

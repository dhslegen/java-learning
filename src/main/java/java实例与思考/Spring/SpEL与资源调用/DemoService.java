package java实例与思考.Spring.SpEL与资源调用;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class DemoService {
    @Value("其他类的属性")
    private String another;

    public void setAnother(String another) {
        this.another = another;
    }

    public String getAnother() {

        return another;
    }
}

package javaStudy.Spring.Spring常用配置.Scope;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("singleton")
public class DemoSingletonService {
}

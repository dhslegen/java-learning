package java实例与思考.Spring.Profile;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * 【理解】
 * <p>&nbsp;&nbsp;通过为@Bean的组件，添加@profile的元数据，将bean分为生产环境和开发环境的两种，后期通过
 * context.getEnvironment().setActiveProfiles("dev");context.register(ProfileConfig.class);选择
 * 使用哪种bean
 */
@Configuration
public class ProfileConfig {
    @Bean
    @Profile("dev")
    public DemoBean devDemoBean() {
        return new DemoBean("from development profile");
    }

    @Bean
    @Profile("prod")
    public DemoBean proDemoBean() {
        return new DemoBean("from production profile");
    }
}

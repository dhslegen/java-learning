package javaStudy.Spring.Spring高级话题.测试;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 【理解】
 * <p>&nbsp;&nbsp;Spring为junit测试框架提供了SpringJUnit4ClassRunner.class，这样的话测试的程序将在Spring框架下运行，
 * 于是Spring的框架就被引入了，支持Spring注解。另外junit的原理是这样的:不管是在本目录下还是test目录下，用到的是同一个类
 * 加载器，因此只要基于自己的包路径能够访问到要测试的类路径，有可能是同一个项目路径，不是同一个物理路径，优先使用test包报下
 * 的测试类。（用最基本的.class思考这个问题）
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestConfig.class})
@ActiveProfiles("prod")
public class DemoBeanIntegrationTests {
    @Autowired
    private TestBean testBean;

    @Test
    public void proBeanShouldInject() {
        String expected = "from production profile";
        String actual = testBean.getContent();
        Assert.assertEquals(expected, actual);
        System.out.println("我有机会输出");
    }
}

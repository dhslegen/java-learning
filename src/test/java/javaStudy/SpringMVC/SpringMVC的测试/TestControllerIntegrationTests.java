package javaStudy.SpringMVC.SpringMVC的测试;

import javaStudy.SpringMVC.快速搭建.MyMvcConfig;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {MyMvcConfig.class})// spring的上下文
@WebAppConfiguration("src/main/resources")// web的上下文
public class TestControllerIntegrationTests {
    // MockMvc模拟MVC对象,用它进行测试。
    private MockMvc mockMvc;

    // 可以在测试用例中注入Spring的Bean
    @Autowired
    private DemoService demoService;

    // 可以注入WebApplicationContext
    @Autowired
    WebApplicationContext context;

    // 可以注入模拟的http session
    @Autowired
    MockHttpSession session;

    // 可以注入模拟的http request
    @Autowired
    MockHttpServletRequest request;

    @Before
    public void setUp() throws Exception {
        // 通过MockMvcBuilders.webAppContextSteup()初始化
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context).build();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testNormalController() throws Exception {
        mockMvc.perform(get("/normal")).andExpect(status().isOk()).andExpect(view().name("page")).andExpect(forwardedUrl("/WEB-INF/classes/views/page.jsp")).andExpect(model().attribute("message", demoService.saySomething()));
    }

    @Test
    public void testRestController() throws Exception {
        mockMvc.perform(get("/testRest")).andExpect(status().isOk()).andExpect(content().contentType("text/plain;charset=UTF-8")).andExpect(content().string(demoService.saySomething()));
    }
}
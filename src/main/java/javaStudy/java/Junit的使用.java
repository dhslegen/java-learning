package javaStudy.java;

import junit.framework.TestCase;
import org.junit.Assert;

/**
 * 【概述】
 * <p>&nbsp;&nbsp;JUnit是一个Java语言的单元测试框架，它由 Kent Beck 和 Erich Gamma 建立，逐渐成为 xUnit 家族中最为
 * 成功的一个。 JUnit有它自己的JUnit扩展生态圈，多数Java的开发环境都已经集成了JUnit作为单元测试的工具。在这里，一个单
 * 元可以是一个方法、类、包或者子系统。因此，单元测试是指对代码中的最小可测试单元进行检查和验证，以便确保它们正常工作。
 * 例如，我们可以给予一定的输入测试输出是否是所希望得到的结果。
 * <p>【特点】
 * <p>&nbsp;&nbsp;&nbsp;JUnit提供了注释以及确定的测试方法；
 * <p>&nbsp;&nbsp;&nbsp;JUnit提供了断言用于测试预期的结果；
 * <p>&nbsp;&nbsp;&nbsp;JUnit测试优雅简洁不需要花费太多的时间；l
 * <p>&nbsp;&nbsp;&nbsp;JUnit测试让大家可以更快地编写代码并且提高质量；
 * <p>&nbsp;&nbsp;&nbsp;JUnit测试可以组织成测试套件包含测试案例，甚至其他测试套件；
 * <p>&nbsp;&nbsp;&nbsp;Junit显示测试进度，如果测试是没有问题条形是绿色的，测试失败则会变成红色；
 * <p>&nbsp;&nbsp;&nbsp;JUnit测试可以自动运行，检查自己的结果，并提供即时反馈，没有必要通过测试结果报告来手动梳理。
 * <p>【注解】
 * <p>&nbsp;&nbsp;&nbsp;@Test ：该注释表示，用其附着的公共无效方法（即用public修饰的void类型的方法 ）可以作为一
 * 个测试用例；
 * <p>&nbsp;&nbsp;&nbsp;@Before ：该注释表示，用其附着的方法必须在类中的每个测试之前执行，以便执行测试某些必要的
 * 先决条件；
 * <p>&nbsp;&nbsp;&nbsp;@BeforeClass ：该注释表示，用其附着的静态方法必须执行一次并在类的所有测试之前，发生这种
 * 情况时一般是测试计算共享配置方法，如连接到数据库；
 * <p>&nbsp;&nbsp;&nbsp;@After ：该注释表示，用其附着的方法在执行每项测试后执行，如执行每一个测试后重置某些变量
 * ，删除临时变量等；
 * <p>&nbsp;&nbsp;&nbsp;@AfterClass ：该注释表示，当需要执行所有的测试在JUnit测试用例类后执行，AfterClass注解
 * 可以使用以清理建立方法，如断开数据库连接，注意：附有此批注（类似于BeforeClass）的方法必须定义为静态；
 * <p>&nbsp;&nbsp;&nbsp;@Ignore ：该注释表示，当想暂时禁用特定的测试执行可以使用忽略注释，每个被注解为@Ignore
 * 的方法将不被执行
 * <p>【断言】
 * <p>&nbsp;&nbsp;在这里，作者将介绍一些断言方法，所有这些方法都来自 org.junit.Assert 类，其扩展了
 * java.lang.Object 类并为它们提供编写测试，以便检测故障。简而言之，我们就是通过断言方法来判断实际结果与我们预期
 * 的结果是否相同，如果相同，则测试成功，反之，则测试失败。
 * <p>&nbsp;&nbsp;&nbsp;void assertEquals([String message], expected value, actual value) ：断言两个值相等，
 * 值的类型可以为int、short、long、byte、char 或者java.lang.Object，其中第一个参数是一个可选的字符串消息；
 * <p>&nbsp;&nbsp;&nbsp;void assertTrue([String message], boolean condition) ：断言一个条件为真；
 * <p>&nbsp;&nbsp;&nbsp;void assertFalse([String message],boolean condition) ：断言一个条件为假；
 * <p>&nbsp;&nbsp;&nbsp;void assertNotNull([String message], java.lang.Object object) ：断言一个对象不为空(null)；
 * <p>&nbsp;&nbsp;&nbsp;void assertNull([String message], java.lang.Object object) ：断言一个对象为空(null)；
 * <p>&nbsp;&nbsp;&nbsp;void assertSame([String message], java.lang.Object expected, java.lang.Object actual) ：
 * 断言两个对象引用相同的对象；
 * <p>&nbsp;&nbsp;&nbsp;void assertNotSame([String message], java.lang.Object unexpected, java.lang.Object actual)：
 * 断言两个对象不是引用同一个对象；
 * <p>&nbsp;&nbsp;&nbsp;void assertArrayEquals([String message], expectedArray, resultArray) ：
 * 断言预期数组和结果数组相等，数组的类型可以为int、long、short、char、byte 或者 java.lang.Object
 */
public class Junit的使用 {
}

class TestOperation extends TestCase {


    public TestOperation(String name) {  // 构造函数
        super(name);
    }

    @Override
    public void setUp() throws Exception {  // 在每个测试方法执行 [之前] 都会被调用，多用于初始化
        System.out.println("欢迎使用Junit进行单元测试...");
    }

    @Override
    public void tearDown() throws Exception {  // 在每个测试方法执行 [之后] 都会被调用，多用于释放资源
        System.out.println("Junit单元测试结束...");
    }

    public void testDivideByZero() {
        Throwable te = null;
        try {
            Assert.fail("测试失败");  //断言失败
        } catch (Exception e) {
            e.printStackTrace();
            te = e;
        }

        Assert.assertEquals(Exception.class, te.getClass());
        Assert.assertEquals("除数不能为 0 ", te.getMessage());

    }
}
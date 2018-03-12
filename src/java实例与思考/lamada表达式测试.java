package java实例与思考;

import java.util.function.Consumer;
import java.util.stream.Stream;

import org.junit.Test;

public class lamada表达式测试 {
	@Test
	public void test1() {
		Stream<String> stream = Stream.of("1", "2", "3");
		stream.forEach((Consumer<String>) e -> System.err.println(e));
		stream.forEach((Consumer<String>) e -> {
			System.err.println(e);
		});
		stream.forEach((Consumer<String>) System.err::println);
		/*
		 * 【结论】lamada表达式是一个去掉函数类型、函数名及小括号（仅当形参只有一个时）、甚至函数体花括号（限于只有一句调用或者一句返回的函数体）
		 * 的函数，它的使用取决于匹配的目标类型（函数式接口：只有一个函数的定义），相当于按照接口的函数定义将lamada表达式重新组装实现函数，
		 * 并返回实现了该接口的实例 ，因此它是被动的。
		 */
		// 当形参恰好是要传给调用的函数时，可以更加精简：对象或静态类（可以this）::对象的实例方法（如：System.err::println或Integer::valueOf）。
		// 【另外】ClassName::methodName除了代表e->ClassName.methodName(e)，如Integer::valueOf代表e->Integer.valueOf(e)、
		// 也可以代表e->e.methodName(e)(e是ClassName的实例)，如Integer::doubleValue代表 e ->
		// e.doubleValue()
	}
}

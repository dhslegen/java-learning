package java实例与思考;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

public class Stream学习 {
	@Test
	public void testLimitAndSkip() {

		class Person {
			public int no;
			private String name;

			public Person(int no, String name) {
				this.no = no;
				this.name = name;
			}

			public String getName() {
				System.out.println(name);
				return name;
			}

			@Override
			public String toString() {
				// TODO Auto-generated method stub
				return this.name;
			}
		}
		/*
		 * limit 和 skip 对运行次数的影响
		 */
		List<Person> persons = new ArrayList<Person>();
		for (int i = 1; i <= 10000; i++) {
			Person person = new Person(i, "name" + i);
			persons.add(person);
		}
		List<String> personList2 = persons.stream().map(Person::getName).limit(10).skip(3).collect(Collectors.toList());
		System.out.println("有影响测试" + personList2);

		/*
		 * limit 和 skip 对 sorted 后的运行次数无影响
		 */
		persons = new ArrayList();
		for (int i = 1; i <= 5; i++) {
			Person person = new Person(i, "name" + i);
			persons.add(person);
		}
		List<Person> personList = persons.stream().sorted((p1, p2) -> p1.getName().compareTo(p2.getName())).limit(2)
				.collect(Collectors.toList());
		System.out.println("对 sorted 后的运行次数无影响测试" + personList);
		/*
		 * 【结论】limit在sorted排序后，不影响排序运行次数，其他的都受limit影响，因此sort很特殊，它坚持全局扫描。
		 * limit会提高没有排序操作的效率，但有排序时，还是会全部扫描。
		 */
	}
}

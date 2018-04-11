package java实例与思考;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;

import org.junit.Test;

public class 泛型实现的数据结构 {
	@Test
	public void test链表linkedlist() {
		/* 【一】【链表：linkedlist<E>】 */
		/*
		 * 值得注意的是链表对象并没有存储所有的数据对象，相反只存储了首节点、尾节点node<E>和长度int size，
		 * 而链表的形成在外部完成，利用最基本的linkfirst（node），linklast（node），linkbefore（E，node），
		 * node（int）等函数实现链表增加，删除，更改，查询，可见其核心就是 节点对象 private static class Node<E>
		 * { E item; Node<E> next; Node<E> prev;
		 * 
		 * Node(Node<E> prev, E element, Node<E> next) { this.item = element;
		 * this.next = next; this.prev = prev; } } 【进一步】linkedlist实现了List<E>,
		 * Deque<E>, Cloneable, java.io.Serializable，其中list<E>
		 * 继承自collection<E>接口，因此大部分函数是重写接口中的，可以利用接口回调技术
		 */
		/* 【增】 */
		LinkedList<String> lb = new LinkedList<String>();
		lb.add("我是谁");// 向末尾添加节点，成功与否并返回真值
		System.out.println("向末尾添加节点，成功与否并返回真值" + lb.add("我为何存在"));
		lb.add("一个人死去");
		lb.add("另一个诞生");
		lb.addFirst("我有一个问题");// 向开头添加节点
		lb.addLast("谁能回答呢");// 向末尾添加节点
		lb.add(0, "我应该如何思考");// 向指定位置添加节点，不返回真值
		/* 【查】 */
		/*
		 * 根据索引查找节点对象get（）
		 */
		System.out.println("get的两个基本变法返回首尾的字节" + lb.getLast() + lb.getFirst());
		for (int i = 0; i < lb.size(); i++) {
			String string = lb.get(i);// 获取指定位置的对象
			System.out.printf(string + "  ");
		}
		/* 增强for循环 */
		HashMap<String, String> m = new HashMap<String, String>();
		m.put("1", "a");
		m.put("2", "b");
		m.put("3", "c");
		for (String obj : m.keySet()) {
			System.out.println(obj);
		}
		for (String string : lb) {
			System.out.println("增强for循环" + string);// 增强for循环，用于数组或者事项interable接口的集合类
		}
		/*
		 * 根据节点对象查找索引indexof（）
		 */
		System.out.println();
		System.out.println("获取首次出现指定对象的索引" + lb.indexOf("我为何存在"));
		System.out.println("获取最后出现指定对象的索引" + lb.lastIndexOf("谁能回答呢"));
		/* 包含 */
		System.out.println("判断是否包含指定对象并返回真值：" + lb.contains("我为何存在"));
		/* 链表长度 */
		System.out.println("长度" + lb.size());

		/* 【删】 */
		System.out.println("删除指定节点并返回其对象：" + lb.remove(1));
		System.out.println("删除最后节点并返回其对象：" + lb.removeLast());
		System.out.println("删除第一节点并返回其对象：" + lb.removeFirst());
		System.out.println("删除第一次出现目标对象的节点并返回其真值：" + lb.remove("一个人死去"));
		for (int i = 0; i < lb.size(); i++) {
			String string = lb.get(i);// 获取指定位置的对象
			System.out.printf(string + "  ");
		}
		System.out.println();
		/* 【改】 */
		/* 指定索引修改为目标对象 */
		lb.set(0, "你就是你");
		lb.set(1, "为了精彩");
		lb.set(2, "重获新生");
		for (int i = 0; i < lb.size(); i++) {
			String string = lb.get(i);// 获取指定位置的对象
			System.out.printf(string + "  ");
		}
		System.out.println();
		/* 克隆,注意返回的事object对象，需强制转换 */
		LinkedList<String> lb2 = (LinkedList<String>) lb.clone();
		for (int i = 0; i < lb.size(); i++) {
			String string = lb.get(i);// 获取指定位置的对象
			System.out.printf(string + "  ");
		}
		System.out.println();
		/* 遍历 */
		Iterator<String> it = lb2.iterator();// iterator（）返回含有指定类型对象的迭代器对象，
		// 刚好传给封装同类型的迭代器对象中
		while (it.hasNext()) {
			String st = it.next();
			System.out.printf(st);
		}
	}

	@Test
	public void test集合hashset() {
		/* 【二】【集合：hashset<E>】特点是不允许重复，实现的接口为set，set是collection的子接口 */
		HashSet<String> h = new HashSet<String>();
		HashSet<String> h2 = new HashSet<String>();
		/* 【增】 */
		h.add("赵");
		h.add("钱");
		h.add("孙");
		h.add("李");
		h.add("周");
		h.add("吴");
		h2.add("郑");
		h2.add("王");
		h2.add("马");
		h2.add("赵");
		h2.add("吴");
		h.addAll(h2);
		Object[] str = h.toArray();
		/* 【查】 */
		System.out.println("判断是否属于集合" + h.contains("赵"));
		System.out.println("判断是否为空" + h.isEmpty());
		System.out.println("判断是否包含另一个集合" + h.containsAll(h2));
		for (int i = 0; i < str.length; i++) {
			System.out.println("toarray返回到数组" + str[i]);
		}
		System.out.println("返回元素个数" + h.size());
		Iterator it = h.iterator();
		while (it.hasNext()) {
			String strr = (String) it.next();
			System.out.println(strr);
		} // 用迭代器的方法
		/* 【删】 */
		// System.out.println("删除指定集合"+h.removeAll(h2));
		System.out.println("删除指定元素" + h.remove("赵"));
		Object[] str2 = h.toArray();
		for (int i = 0; i < str2.length; i++) {
			System.out.println("toarray返回到数组" + str2[i]);
		}
		/* 【改】 */
		Set<String> s = (Set<String>) h.clone();
		Iterator<String> it2 = s.iterator();
		while (it2.hasNext()) {
			String string = (String) it2.next();
			System.out.println("克隆" + string);
		}
		/* 【集合操作】操作后集合存在调用方即h */
		System.out.println("交集" + h.retainAll(h2));
		System.out.println("差集" + h.removeAll(h2));
		System.out.println("并集" + h.addAll(h2));
	}

	@Test
	public void test散列映射hashmap() {
		/* 【三】【散列表：hashmap<k,v>】特点:键-值映射减少检索开销，特殊的集合，但是键不可以重复。实现了map<e>接口 */
		/* 【增】 */
		HashMap<String, String> hm = new HashMap<>();
		hm.put("1", "小明");
		hm.put("2", "小红");
		hm.put("3", "小白");
		hm.put("4", "小黑");
		/* 【查】 */
		System.out.println("是否包含指定键" + hm.containsKey("1"));
		System.out.println("是否包含指定值" + hm.containsValue("小白"));
		System.out.println("是否为空" + hm.isEmpty());
		System.out.println("只能以键找值，这就是检索的意义" + hm.get("2"));
		System.out.println("输出类名" + hm.getClass());
		System.out.println("散列表的大小" + hm.size());
		Collection c = hm.values();
		Iterator it2 = c.iterator();
		while (it2.hasNext()) {
			Object object = (Object) it2.next();
			System.out.println("通过values()返回实现collection接口的values类对象，"
					+ "回调iterator（），返回实现了iterator接口的valueitera1tor对象，回调next（）" + "这就是通过值迭代器遍历" + object);
		}
		/* 【删】 */
		System.out.println("以键删，并返回对应的值" + hm.remove("3"));
		System.out.println("以值-值删，并返回真值" + hm.remove("4", "小黑"));
		// hm.clear();
		Collection c2 = hm.values();
		Iterator it3 = c2.iterator();
		while (it3.hasNext()) {
			Object object = (Object) it3.next();
			System.out.println("通过values()返回实现collection接口的values类对象，"
					+ "回调iterator（），返回实现了iterator接口的valueiterator对象，回调next（）" + "这就是通过值迭代器遍历" + object);
		}
		/* 【克隆】 */
		Object b = hm.clone();
		Collection c3 = hm.values();
		Iterator it4 = c3.iterator();
		while (it4.hasNext()) {
			Object object = (Object) it4.next();
			System.out.println("通过values()返回实现collection接口的values类对象，"
					+ "回调iterator（），返回实现了iterator接口的valueiterator对象，回调next（）" + "这就是通过值迭代器遍历" + object);
		}
	}

	@Test
	public void test树集treeset() {
		/* 【四】【树集：treeset<E>】特点:采用树形结构存储数据，和对象实现的comparable接口有关
		 * 上比下小，右比左小 。从内部可以看出， 将对树集的操作转化为对treemap的操作*/
		TreeSet<String> ts = new TreeSet<String>();
		/*
		 * 从创建开始，实现navigablemap接口的treemap对象已经传值给接口变量 m
	     * private transient NavigableMap<E,Object> m;
		 * public TreeSet() { this(new TreeMap<E,Object>()); }
         * TreeSet(NavigableMap<E,Object> m) {this.m = m; }
  	*/		
		/* 【增】 添加的顺序和对象实现的comparable接口有关，上比下小，右比左小。如string类
		 * public int compareTo(String anotherString)*/
		System.out.println("向树集添加对象，返回真值" + ts.add("赵") + ts.add("钱") + ts.add("孙") + ts.add("李"));
		/* 【查】 */
		System.out.println("是否包含对象，返回真值"+ts.contains("赵"));
		System.out.println("查询第一个对象，返回对象"+ts.first());
		System.out.println("查询最后一个对象，返回对象"+ts.last());
		System.out.println("判断是否为空，返回真值"+ts.isEmpty());
		System.out.println("查询树集大小，返回数值"+ts.size());
		/*利用迭代器遍历*/
		Iterator<String> itr01=ts.iterator();
		/*
		然后 public Iterator<E> iterator() {
        return m.navigableKeySet().iterator(); }
                第一步回调treemap中的navigableKeySet()
        public NavigableSet<K> navigableKeySet() {
        KeySet<K> nks = navigableKeySet;
        return (nks != null) ? nks : (navigableKeySet = new KeySet<>(this));}
                构造函数中的new KeySet<>(this))执行如下
        KeySet(NavigableMap<E,?> map) { m = map; }其中NavigableMap<E, ?> m
                最终结果是实现了navigableset接口并初始化好的keyset对象付给接口。
                第二步，回调keyset对象的iterator（）方法，最终将keyiterator迭代 对象赋给迭代接口
                【思考】将treeset的遍历转化为treemap《E,object》，在转化为map中set，interator
                的操作的遍历。
		*/
		while (itr01.hasNext()) {
			String str= (String) itr01.next();
			char s=str.charAt(0);
			System.out.println("shuzi"+(int)s);
		}
		// 【！】可以看出汉字的排序并不是拼音先后，而是Unicode码的先后
		/* 【删】 */
		System.out.println("删除树集中指定的对象,返回真值" + ts.remove("钱"));
		Iterator<String> itr02=ts.iterator();
		while (itr02.hasNext()) {
			String str= (String) itr02.next();
			char s=str.charAt(0);
			System.out.println("删除元素后遍历"+(int)s+str);
		}
		System.out.println("删除树集所有元素,无返回值" );
	ts.clear();
		Iterator<String> itr03=ts.iterator();
		while (itr03.hasNext()) {
			String str= (String) itr03.next();
			char s=str.charAt(0);
			System.out.println("删除元素后遍历"+(int)s+str);
		}
	}
	@Test
	public void test树映射treemap() {
		/*
		 * 【五】【树映射：treemap<k，v>】特点:采用树形结构存储数据，键的比较决定在树形的位置 。
		 * 上比下小，右比左小。
		 */
		TreeMap<String , String > tm=new TreeMap<String ,String >();
		/*【增】*/
		tm.put("1", "赵");
		tm.put("2", "钱");
		tm.put("3", "孙");
		tm.put("4", "李");
		/* 【查】 */
		System.out.println("是否包含指定键" + tm.containsKey("1"));
		System.out.println("是否包含指定值" + tm.containsValue("小白"));
		System.out.println("是否为空" + tm.isEmpty());
		System.out.println("只能以键找值，这就是检索的意义" + tm.get("2"));
		System.out.println("输出类名" + tm.getClass());
		System.out.println("散列表的大小" + tm.size());
		Collection c = tm.values();
		Iterator it2 = c.iterator();
		while (it2.hasNext()) {
			Object object = (Object) it2.next();
			System.out.println("通过values()返回实现collection接口的values类对象，"
					+ "回调iterator（），返回实现了iterator接口的valueitera1tor对象，回调next（）" + "这就是通过值迭代器遍历" + object);
		}
		/* 【删】 */
		System.out.println("以键删，并返回对应的值" + tm.remove("3"));
		System.out.println("以值-值删，并返回真值" + tm.remove("4", "李"));
		// hm.clear();
		Collection c2 = tm.values();
		Iterator it3 = c2.iterator();
		while (it3.hasNext()) {
			Object object = (Object) it3.next();
			System.out.println("通过values()返回实现collection接口的values类对象，"
					+ "回调iterator（），返回实现了iterator接口的valueiterator对象，回调next（）" + "这就是通过值迭代器遍历" + object);
		}
		/* 【克隆】 */
		Object b = tm.clone();
		Collection c3 = tm.keySet();
		Iterator it4 = c3.iterator();
		while (it4.hasNext()) {
			Object object = (Object) it4.next();
			System.out.println("通过values()返回实现collection接口的values类对象，"
					+ "回调iterator（），返回实现了iterator接口的valueiterator对象，回调next（）" + "这就是通过值迭代器遍历" + object);
		}
	}

	@Test
	public void test堆栈stack() {
		/*
		 * 【六】【堆栈：stack<E>】特点:只有一端输入输出，先进先出，后进后出,类似vector，
		 * 其内部围绕对象数组 。
		 */
		Stack<String> sk = new Stack<String>();
		/* 【进栈】 */
		System.out.println(sk.push("赵"));
		System.out.println(sk.push("钱"));
		System.out.println(sk.push("孙"));
		System.out.println(sk.push("李"));
		System.out.println(sk.push("周"));
		System.out.println(sk.push("吴"));
		/* 【出栈】 */
		System.out.println("出栈无参数，动态输出栈顶" + sk.peek() + sk.pop());
		System.out.println(sk.pop());
		System.out.println(sk.pop());
		System.out.println("此刻栈顶" + sk.peek() + "此刻容量" + sk.size());
		System.out.println("查询指定对象，返回int数值，顶是1：" + sk.search("赵"));
		/* 【用栈实现递归】 */
		Stack<Integer> sk01 = new Stack<Integer>();
		sk01.push(new Integer(1));
		sk01.push(new Integer(1));
		int k = 1;
		while (k <= 10) {
			for (int i = 0; i <= 2; i++) {
				Integer f1 = sk01.pop();
				Integer f2 = sk01.pop();
				Integer temp = new Integer(f1.intValue() + f2.intValue());
				System.out.println("" + temp.toString());
				sk01.push(f1);
				sk01.push(temp);
			}
			k++;
		}
	}
	@Test
	public void test猴子分椰子一() {
		int x=1;
		double num=0;
		while(true){
			num=(x-1)/5*4;
			for(int i=1;i<=5;i++){
				num=(num-1)/5*4;
			}
			if(num%1==0){
				System.out.println(x);
				break;}
			else 
			x++;
		}
	}
	@Test
	public void test猴子分椰子二() {
		double a = 1.0;
		int flag = 0;
		while (flag == 0) {
			double c=a;
			for (int i = 1; i <= 5; i++) {
			double b = (5 * c + 1) / 4;
				if ((double)Math.floor(b) != b) {
					break;
				}
				c = b;
				if (i == 5) {
					c=5*c+1;
					System.out.println("最少" + c + "个椰子");
					flag = 1;
				}
			}
			a++;
		}
	}
	public void sum(int a, int... nums) {// 可变参数可看做数组，因此直接传数组也可以但要注意顺序放在最后
		int sum = 0;
		for (int i : nums) {
			sum += i;
		}
		System.out.println(sum + "" + a);
	}// 【!】函数里面不能定义函数，包括main及test函数，只能定义在类里

	@Test
	public void test可变参数() {
		int[] a = { 1, 2, 3, 4, 5, 6 };
		sum(1, 2, 3, 4, 5, 6, 7, 8, 9);
		sum(0, a);
		List l = Arrays.asList("sf", "de", "vv", "mk", "m");
		System.out.println(l);
		int n[] = { 1, 2, 3, 4, 5, 6 };
		l = Arrays.asList(n);
		System.out.println("基本类型数组相当于一个对象" + l);
		Integer n2[] = { 1, 2, 3, 4, 5, 6 };
		l = Arrays.asList(n2);
		System.out.println("而参数只接受可变数量对象" + l);
	}
}
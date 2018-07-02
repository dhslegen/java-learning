package javaStudy.java;

import java.io.IOException;

import org.junit.Test;

public class 继承的思考 {
	@Test
	public void test() {
		/* 【运行可执行文件】 */
		Runtime rt = Runtime.getRuntime();// 新建运行器
		try {
			rt.exec("C:\\Program Files (x86)\\Tencent\\QQBrowserQQ\\QQBrowser.exe");// 可执行文件的路径或命令
			// 普通文件不行如视频音频等
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/* 继承更像是合作而不是接纳,因为继承的还可以访问父类资源,但继承的肯定是不能访问新增 */
	@Test
	public void test重写变量和重写方法的覆盖问题() {
		child c = new child();
		// System.out.println(c.aString);// 访问父类继承的变量
		// System.out.println(c.bString);// 访问父类重写的变量
		// System.out.println(c.bbtrString);// 访问父类被重写变量
		// System.out.println(c.cString);// 访问子类新增变量
		// c.afunc();// 访问继承方法
		// c.bfunc();// 访问重写的方法
		// c.cfunc();// 访问新增的方法
		// c.ffunc();
		c.bfunc();
		/* 继承更像是合作而不是接纳,因为继承的还可以访问父类资源,但继承的肯定是不能访问新增 */

		/*
		 * [结论]：对于重写方法和重写变量(其实是错误的说法)，继承的方法可以访问父类被覆盖（隐藏）的变量，但访问方法时只能访问子类重写方法，
		 * 新增和重写的方法只能访问继承的重写的以及新增的方法和变量;
		 * 可以这么想：子类对象创建时，在内存里同时也为父类开辟了空间，也就是父类一组变量和方法和子类的一组方法和变量。
		 * 1.对于子类中跟父类一样名称的变量：如果父类的变量是私有的，自然是两个空间；如果父类的变量是可继承的，也是两个空间，
		 * 只不过父类的变量只能由继承方法调用，新增和重写只能访问子类的变量，这就是变量的隐藏。
		 * 2.对于子类中跟父类一样名称的方法：如果父类的方法时私有的，自然是两个空间；如果父类的方法是可继承的，是一个空间（注意差异）
		 * 也就是只存子类的重写方法，各个方法之间调用关系保持不变。典型的例子，子类调用父类继承，继承调用父类的私有，私有调用子类的重写。
		 */
	}
}

class base {
	String aString = "aaa";// 用于继承
	String bString = "bbb";// 用于重写

	void afunc() {
		System.out.println("用于继承的afunc,操作了" + aString + "和" + bString);
		dfunc();
	}

	void bfunc() {
		System.out.println("用于重写的bfunc,操作了" + aString + "和" + bString);
		dfunc();
	}

	private void dfunc() {
		System.out.println("用于调用的私有dfunc");
		gfunc();
	}

	protected void ffunc() {
		System.out.println("用于继承的ffunc");
		dfunc();
	}

	protected void gfunc() {
		System.out.println("用于重写的gfunc");
	}
}

class child extends base {
	String bString = "重写的bbb";
	String cString = "新增的ccc";
	String bbtrString = super.bString;

	void bfunc() {
		System.out.println("重写的bfunc,操作了" + aString + bString + cString);
		// afunc();
	}

	void cfunc() {
		afunc();
		bfunc();
		System.out.println("新增的func,操作了" + aString + bString + cString);
	}

	protected void gfunc() {
		System.out.println("重写的gfunc");
	}
}
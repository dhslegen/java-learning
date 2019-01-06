package javaStudy.java.泛型;

interface fxj<e, r, v> {
	
	void make(e ee, r rr, v vv);
}

class fxl<e, r, v> implements fxj<e, r, v> {
	public fxl() {
		// TODO 自动生成的构造函数存根
	}
	public void make(e ee, r rr, v vv) {
		System.out.println(ee.toString() + rr.toString() + vv.toString());
	}
}

class a_1 {
	@Override
	public String toString() {
		System.out.println("woshia");// TODO 自动生成的方法存根
		return super.toString();
	}

	void shuchu() {
		System.out.println("hahha");
	}
}

class b_1 {
	@Override
	public String toString() {
		System.out.println("woshib");// TODO 自动生成的方法存根
		return super.toString();
	}
}

class c_1 {
	@Override
	public String toString() {
		System.out.println("woshic");// TODO 自动生成的方法存根
		return super.toString();
	}
}

public class 泛型 {
/*
																 * 泛型类class
																 * fxl<e, r, v>
																 * 就是组合多个不指定类的超级类，
																 * 用法与普通类一样，
																 * 只不过在初始化对象时要讲泛型列表一次用正常类替换
																 * ，相当于已经套用了模板，
																 * 此时的泛型就有了实际的意义但只能
																 * 调用object的类方法，
																 * 如tostring.
																 * 另外泛型类也可实现泛型接口interface
																 * fxj<e, r, v>
																 * { void make(e
																 * ee, r rr, v
																 * vv); }
								...........								 */

	public static void main(String args[]) {
		fxl fxl1 = new fxl();
		a_1 ee = new a_1();
		c_1 vv = new c_1();
		b_1 rr = new b_1();
		fxl1.make(ee, rr, vv);
		fxj jj=new fxl();
		jj.make(ee, rr, vv);
	}
}

package java实例与思考;

import java.io.FileFilter;
/*匿名类就是new接类名或是接口名（）再接匿名类体{}，从而表示一个继承自类的子类对象或是
实现了接口的类对象,用于向抽象类对象或接口变量传递引用，从而实现多态，是对接口回调，上
转型的精彩运用，现写现用*/
abstract class g {
	abstract void cs();
	abstract void sc() ;

}

interface b {

	void scc();
}

class c extends g implements b {
	public void scc() {
		System.out.println("nihao");
	}

	@Override
	void cs() {
		// TODO 自动生成的方法存根
		
	}

	@Override
	void sc() {
		// TODO 自动生成的方法存根
		
	}
}

public class 匿名类 {
	static void ff(b b) {
		b.scc();
	}

	static void gg(g vG) {
		vG.sc();
	}

	public static void main(String[] args) {
		ff(new b() {
			public void scc() {
				System.out.println("用匿名重写的方法");
			}//new b(){}就是匿名类，表示实现了接口b的类的对象，并不是接口变量的传递。

		});
		gg(new g() {

			void sc() {
				System.out.println("匿名方法重写的方法二");
			}//new b(){}就是匿名类，表示继承自g类的子类的对象，并不是对象的传递。

			@Override
			void cs() {
				// TODO 自动生成的方法存根
				
			}
		});
	}
}

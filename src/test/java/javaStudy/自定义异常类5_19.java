package javaStudy;

public class 自定义异常类5_19 {
	public static void main(String sd[]) {
		a v = new a();
		try {

			v.f(16);
			v.f(-15);
		} catch (myc e) {
			System.out.println(e.getm());
		}
	}
}

class myc extends Exception {
	String m;

	myc(int n) {
		m = n + "不是正数";
	}

	public String getm() {
		return m;
	}
}

class a {
	public void f(int n) throws myc {
		if (n < 0) {
			myc ex = new myc(n);
			throw (ex);
		}
		double number = Math.sqrt(n);
		System.out.println(n + "的平方根是：" + number);
	}
}
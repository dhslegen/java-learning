package javaStudy;

import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class CopyOftest {
	class aa {
		static final String s = "";
	}

	public static String myjzzh(int a, int b, String c) {
		String str03 = null;
		BigInteger bi = new BigInteger(c, a);
		str03 = bi.toString(b).toUpperCase();
		return str03;
	}

	static String autoMatch(int a, int b) {
		String str = myjzzh(10, 16, String.valueOf(b));
		int l = str.length();
		for (int i = 0; i < (2 * a) - l; i++) {
			str = "0" + str;
		}
		return str;
	}

	static int[] autoAdd(int a, int b) {
		int[] n = new int[a];
		for (int i = 0; i < n.length; i++) {
			n[i] = 0;
		}
		String str = myjzzh(10, 16, String.valueOf(b));
		if ((str.length()) % 2 != 0) {
			str = "0" + str;
		}
		char[] c = str.toCharArray();
		for (int i = str.length() - 1; i >= 0; i = i - 2) {

			n[a - 1] = Integer.valueOf(myjzzh(16, 10, new String(c, i - 1, 2)));
			a--;
		}
		return n;
	}

	static String WorddAutoMatchHexstring(String str) {
		String str1 = "";
		char[] cs = str.toCharArray();
		for (int i = 0; i < cs.length; i++) {
			str1 = str1 + myjzzh(10, 16, String.valueOf((int) cs[i]));
		}
		return str1;
	}

	/**
	 * @param args
	 * @throws ParseException
	 */
	public static void main(String[] args) throws ParseException {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(df.parse("2017-11-30 13:10:29").getTime()/1000);
		long current = System.currentTimeMillis();// 当前时间毫秒数
		long current1 = new Date().getTime();// 当前时间毫秒数
		System.out.println("现在的毫秒数"+current);
		System.out.println("现在的毫秒数"+TimeZone.getDefault().getRawOffset());

	}
}

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

class people {
	static String name = "中国人";
}

class MyClass {
	public final double i = Math.random();
	public static double j = Math.random();

	MyClass() {
		j = Math.random();
	}
}

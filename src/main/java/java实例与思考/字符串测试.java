package java实例与思考;

import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.print.DocFlavor.STRING;

import org.junit.Test;

public class 字符串测试 {
	public static void main(String sd[]) {
		String s1;
		String s2;
		String s3, s4, s5;
		char a[] = new char[4];
		s5 = new String(a, 2, 2);
		s1 = new String("我爱你，你呢");
		s2 = new String("我爱你");
		s3 = new String("我爱你");
		s4 = new String("你");
		s1.getChars(1, 4, a, 1);// 字符串与字符转换1到4-1的字符串读给a字符数组，并从1处存
		// a = s1.toCharArray();
		for (int i = 0; i < a.length; i++) {
			char c = a[i];
			System.out.println(a[i] + new String(a));
		}
		byte[] b = "我是最帅的".getBytes();// 字节与字符串的转换
		System.out.println(b.length);
		String string = new String(b);
		String string1 = new String(b, 0, 4);// 起始位置0，注意4是长度，不是位置，因为这是写字符串的操作
		System.out.println(string + string1);
		StringBuffer str = new StringBuffer("i am your friend");// 可变的字符串容器，容量是参数的大小加16字符
		str.setCharAt(9, 'g');
		System.out.println(str);
		str.insert(10, "ood");
		System.out.println(str);
		str.reverse();
		System.out.println(str);
		str.delete(0, 5);
		System.out.println(str);
		str.replace(0, 2, "sbbb");
		System.out.println(str);
		StringTokenizer fenxi = new StringTokenizer("nihisgsd",
				"is");/*
						 * 字符串的分析与提取，分隔标记是第二个字符串的 任意组合或单一标记
						 */
		for (int i = 0; fenxi.hasMoreTokens(); i++) {
			String str1 = fenxi.nextToken();
			System.out.println("提取后的字符串" + str1);
		} // 这是常用的提取方法
			// 正则表达式是带有元字符的字符串，可以正常输出的元字符如\d，作为需要比对的表达式。
		String str3 = "\\dcat";
		System.out.println(str3 + "8cat"
				.matches(str3));/*
								 * 常用元字符：\d数字，\s空各类,\w标识符,大写的好表示非
								 * \p{lower、upper。。。。}字母等， 但要注意前加\元字符就是单个字符的模板
								 */
		String str4 = "\\Scat";
		System.out.println(str4 + "dcat".matches(str4));
		String str5 = "[adg]sfsdf";// 自定义元字符还包括[a-z][^abc][abc&&[^bc]]等交并操作
		String str6 = "hello[2665]?";/*
										 * 增加限定符的正则表达式指定单一元字符的可以多次出现如：x?x出现0次或1次
										 * 、x*x出现0次或多次、x+
										 * x出现1次或多次、x{n}x恰好出现n次、x{n,}出现n以上、x{n，m
										 * }出现n-m次 xyx后跟y、x|yx或y
										 */
		String regex = "[a-z[A-Z]]+";/* 字符串的匹配matches */
		Scanner scanner = new Scanner(System.in);
		System.out.println("输入一行文本（#退出）");
		String str7 = scanner.nextLine();
		while (str7 != null) {
			if (str7.startsWith("#"))
				break;
			else {

				if (str7.matches(regex))
					System.out.println(str7 + "中的字符全是英文");
				else
					System.out.println(str7 + "中含有非英字符");
				str7 = scanner.nextLine();
			}

		}
		/* 字符串的替换，替换的是所有与正则表达式matches的子字符串 */
		String str8 = "123halesol789".replaceAll(regex, "456");
		System.out.println(str8);
		String str9 = "请登录：http://www.cctv.com看电视";
		String regex2 = "http://[.]?\\w+[.]{1}\\w+[.]{1}\\p{Alpha}+";/*
																		 * (http
																		 * ://
																		 * |www)
																		 * 相当于http
																		 * ://
																		 */
		String str10 = str9.replaceAll(regex2, "");
		System.out.println(str9 + "\n" + str10 + "http://www.cctv.com".matches(regex2));
		/* 字符串分解，以匹配正则表达式的字符串为分隔符，将分解后的字符串添加到字符串数组 */
		String str11 = "\\D+";
		String regex3 = "[\\s\\d\\p{Punct}]+";
		String str12[] = "we love this game(nba):jordan,height=1.88".split(regex3);
		for (int i = 0; i < str12.length; i++) {
			System.out.println("单词" + (i + 1) + str12[i]);

		}
		/*
		 * scanner相当于一个字符串阅读器，当定义了分隔符（默认是空格）就可以用hasnext判断next读取，特殊的参数是system.
		 * in则是读取输入的字符串
		 */
		Scanner scanner2 = new Scanner("tv cost 77 ,computer cost 99");// 默认分隔符是空格
		double sum = 0;
		while (scanner2.hasNext()) {
			try {
				double price = scanner2.nextDouble();
				sum = sum + price;
				System.out.println(price);
			} catch (InputMismatchException e) {
				String tString = scanner2.next();// TODO: handle exception
			}
		}
		System.out.println("总消费" + sum + "元");
		Scanner scanner3 = new Scanner("长途：45元，漫游：23元，打车56元");
		scanner3.useDelimiter("[^0123456789]+");// 使用正则表达式作为分隔符
		while (scanner3.hasNext()) {
			try {
				double price = scanner3.nextDouble();
				sum = sum + price;
				System.out.println(price);
			} catch (InputMismatchException e) {
				String tString = scanner3.next();// TODO: handle exception
			}
		}
		System.out.println("总消费" + sum + "元");
		/*
		 * 模式匹配，模式对象就是正则表达式的封装对象pattern
		 * p=pattern.compile（regex，（第二个参数可无，对模式匹配的进一步约束如忽略大小写）），
		 * 匹配对象就是利用模式对象进一步封装要匹配的字符串matcher m=p.matcher（str），从而得到正则与字符串的比较器。
		 * 匹配对象的常用方法：Boolean find（）查找下一个匹配的子字符串成功返回true失败返回false首次调用查找第一个符
		 * 合的、Boolean matches（）判断是否封装的两个匹配、Boolean lookingat()只是判断第一个子字符串是否匹配、
		 * Boolean find（int a） 从参数为之查找、string
		 * replaceall（a）返回字符串匹配的全部被a替换后的字符串，但本身不变、replacefirst（）
		 * 是替换的一个匹配子字符串并返回，本身不变更，值得注意的是find是记忆性操作，调用一次保留一个指针，再次调用指针
		 * 是接着进行查找,只有查找得到表明存在，紧接着才能。start，end，。group！
		 */
		Pattern p = Pattern.compile("monkeys");
		Matcher m = p.matcher("have 7 monkeys on the tree,walk 8 monkeys ,still leave how many monkeys?");
		while (m.find()) {
			String str01 = m.group();
			System.out.println("从" + m.start() + "到" + m.end() + "是" + str01);
		}
		p = Pattern.compile("(http://|www)[.]?\\w+[.]{1}\\w+\56{1}\\p{Alpha}+");
		m = p.matcher("新浪：www.sina.com,央视：http://www.cctv.com,新华：www.cctv.com.cn.bc");
		System.out.println(m.replaceAll(""));
		/* 模式的或链接 */
		p = Pattern.compile("love\\w{3}|hate\\w{2}");
		m = p.matcher("loveyouhatemelove122hate56");
		while (m.find()) {
			System.out.println(m.group());
		}
		int nu = 1024;
		double l = 11.223;
		String num = "132345";
		int vvv = Integer.parseInt(num);// haikeyi:parsebyte,parseshort''''''
		String vvvv = Long.toString(nu, 10);
		String vvvvv = String.valueOf(num);
		Date sss = new Date();
		SimpleDateFormat mater = new SimpleDateFormat("y-MMM-dd");
		String ssss = mater.format(sss);
		System.out.println("数字字符串转化为基本数据：" + Integer.parseInt(num) + "\n" + "基本数据转化为数字字符串：" + String.valueOf(nu)
				+ "long整型转为字符串：" + Long.toBinaryString(nu) + "二进制\n" + Long.toHexString(nu) + "十六进制\n"
				+ Long.toOctalString(nu) + "八进制\n" + sss + sss.getTime() + ssss);
		System.out.println(s1.contains(s1) + "" + s3.equals(s2) + (s1 == s2) + s1.length() + s1.startsWith(s4)
				+ s1.endsWith(s4) + "\n" + s1.compareToIgnoreCase(s2) + "\n" + s4.compareTo(s3) + "\n"
				+ s1.substring(0, 4) + "\n" + s1.substring(1) + "\n" + s1.indexOf(s4) + "\n" + "出现该字符的最后位置"
				+ s1.lastIndexOf(s4) + "\n" + s5);
	}

	public String myjzzh(int a, int b, String c) {
		String str03 = null;
		BigInteger bi = new BigInteger(c, a);
		str03 = bi.toString(b);
		System.out.println(a + "进制数字" + c + "转化为" + b + "进制,结果为" + str03);

		int d = Integer.parseInt(c.substring(0, 1));
		int e = Integer.parseInt(c.substring(1, 2));
		int f=(int) (d*Math.pow(2, 4))+e;
		System.out.println(d+""+e+""+f);
		return str03;
	}

	@Test
	public void test各进制转换() {
		String str01 = "101";
		int s = 16;
		/*
		 * Integer.toString(i,radix)和Long.toString(i, radix)可用作十进制基本类型向指定进制字符串转化
		 */
		/* 【十进制->二进制】 */
		System.out.println(Integer.toBinaryString(s));
		/* 【十进制->八进制】 */
		System.out.println(Integer.toOctalString(s));
		/* 【十进制->十六进制】 */
		System.out.println(Integer.toOctalString(s));
		/*
		 * Integer.parseInt(s, radix)和Long.parseLong(s,
		 * radix)可用作指定进制字符串转化为十进制基本类型
		 */
		/* 【二进制->十进制】 */
		System.out.println(Integer.parseInt(str01, 2));
		/* 【八进制->十进制】 */
		System.out.println(Integer.parseInt(str01, 8));
		/* 【十六进制->十进制】 */
		System.out.println(Integer.parseInt(str01, 16));
		/* 【通用方法】 */
		String str02 = "16";
		BigInteger bi = new BigInteger(str02, 8);
		System.out.println(bi.toString(10));
		myjzzh(16,10, "104A");
		System.out.println((char) 35);
	}
}

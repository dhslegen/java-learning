package javaStudy.java;

import java.util.Scanner;

public class 数字格式化 {
	public static void main(String args[]) {
		int[] a = { 1, 2, 3 };
		int c = 10;
		int d = 11;
		int[] b = { 10, 11 };
		int[] l = new int[5];
		l[0] = 10;
		l[1] = 5;
		l[2] = 11;
		l[3] = 21;
		l[4] = 13;
		String e = "hello0";
		String f = "hello1";
		String g = "10";
		sort(a);
		String j = String.format("%+,011f%d", 5882.99, 1);
		String j1 = String.format("%04d", 10000);
		String h = String.format("%+,6d个人吃了%1.3f斤大%%米%+,d", 12, 462.236588, 123456895213l);
		/*
		 * Scanner r=new Scanner(System.in); double sum=0; int m=0; while
		 * (r.hasNextDouble()){ double x=r.nextDouble(); m=m+1; sum=sum+x;
		 * m+"个数的和为"+sum+"\n"+m+"个数的平均值是："+(sum/m)+ }
		 */
		int q = ++d;
		int w = c++;
		int t = c;
		byte p = -8;
		byte i = (byte) (p >> 2);
		int v = c ^ d;
		int s = v ^ d;
		int cv = c > d ? 100 : 200;
		Scanner reader = new Scanner(System.in);
		int ii = reader.nextInt();
		switch (ii) {
		case 1:
			System.out.println("我是春天");
			break;
		case 2:
			System.out.println("我是下啊天");
		case 3:
			System.out.println("我是秋天");
		default:
			System.out.println("woshenmeyebushi6");
			
		}

		System.out.println(
				e + f + "\n" + h + j+"dddd"+j1 + "\n" + a.length + l[1] + q + w + t + i + "\n" + v + "\n" + s + "\n" + cv);
	}

	private static void sort(int[] a) {
		// TODO Auto-generated method stub

	}

}

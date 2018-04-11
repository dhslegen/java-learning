package java实例与思考;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.CharArrayReader;
import java.io.CharArrayWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.nio.Buffer;
import java.util.Date;

import org.junit.Test;

public class 输入输出流 {
	/* 【I/O流】提供文件数据读写的方法与规范，4个重要抽象类： */
	/* 字节输入流inputstream，字符输入流reader,其对应的是read（）操作； */
	/* 字节输出流outputstream，字符输入流writer,其对应的是write（）操作； */
	/* 注意输入或输出不是以文件（源或目标）而言，而是相对流（想象为一个管道） */
	/* 即源-read到-输入流；输出流-write到-目标 */
	@Test
	public void test文件() {
		/* 【！文件对象封装路径，而路径对应的可能是文件，也可能是目录（文件夹），可能存在，也可能不存在】 */
		/* 【程序眼中只有路径，路径可以被创建成文件，也可以被创建成目录，因此特别注意的是相同路径只能被】 */
		/* 【创建一次，创建成目录无法在创建成文件或目录】 */
		File f00 = new File("D:/my目录/");// 封装目录，但可以创被建为文件createNewFile()
		File f01 = new File("D:/", "myfile1.txt");// 封装文件，但可以被创建为目录mkdir()
		System.out.println("封装文件的创建目录，真值:" + f01.mkdir());
		try {
			System.out.println("创建文件,返回真值，已存在则为假" + f01.createNewFile());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 注意文件对象并没有创建文件，只是创建封装了路径并集合了文件操作的对象。
		// 只是封装的文件不存在，可以调用createnewfile（）新建文件
		// 【注意】目录名用“/”号不是\
		/* 【文件相关】 */
		System.out.println("是否存在,真值:" + f01.exists());
		System.out.println("获取文件名字,string:" + f01.getName());
		System.out.println("获取文件绝对路径,string:" + f01.getAbsolutePath());
		System.out.println("获取文件长度（单位是字节）,long:" + f01.length());
		System.out.println("获取文件的父目录,string:" + f01.getParent());
		System.out.println("获取文件的最后修改时间,long1970到现在的毫秒:" + new Date(f01.lastModified()));
		System.out.println("文件是否可读，真值:" + f01.canRead());
		System.out.println("文件是否可写，真值:" + f01.canWrite());
		System.out.println("文件是否隐藏，真值:" + f01.isHidden());
		System.out.println("文件是否文件(前提存在)，真值:" + f01.isFile());
		System.out.println("文件是否目录(前提存在)，真值:" + f01.isDirectory());
		/* 【目录相关】 */
		System.out.println("目录是否存在，真值：" + f00.exists());
		System.out.println("目录是否目录(前提存在)，真值：" + f00.isDirectory());
		try {
			System.out.println("封装目录的创建文件，真值:" + f00.createNewFile());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("创建目录,已存在的话FALSE，真值：" + f00.mkdir());
		System.out.println("目录是否存在，真值：" + f00.exists());
		System.out.println("目录是否目录(前提存在)，真值：" + f00.isDirectory());
		System.out.println("文件是否文件(前提存在)，真值:" + f00.isFile());
		/* 【列出目录下的文件】 */
		/* 普通扫描 */
		File f02 = new File("D:/网络视频");
		String[] strs = f02.list();
		for (int i = 0; i < strs.length; i++) {
			System.out.println(strs[i]);
		}
		/* 过滤扫描 */
		/*
		 * 【原理】list方法内容：String names[] = list();
		 * 
		 * for (int i = 0 ; i < names.length ; i++)
		 * 
		 * { if (filter.accept(this,names[i]))这里回调对象中的accept（file f，string s），参数
		 * 
		 * 是实例化的this和list产生的文件名数字，判断是否添加到结果集，传的是调用list的file类的变量
		 * 
		 * 而对象已经定义了判断规则，即重写函数。如{return s.endswith（.mp4）}
		 * 
		 * { v.add(names[i]); } }
		 */
		/* 这里是与接口有关的匿名类，现写现用； */
		strs = f02.list(new FilenameFilter() {
			public boolean accept(File dir, String name) {
				return name.contains("库里");
			}
		});
		for (int i = 0; i < strs.length; i++) {
			System.out.println(strs[i]);
		}
		/* 还可以自己定义 */
		class myfilter implements FilenameFilter {
			String s;

			public myfilter(String s1) {
				s = "." + s1;
			}

			public boolean accept(File f, String s3) {
				return s3.endsWith(s);
			}
		}
		strs = f02.list(new myfilter("docx"));
		for (int i = 0; i < strs.length; i++) {
			System.out.println(strs[i]);
		}
		/* 【运行可执行文件】 */
		Runtime rt = Runtime.getRuntime();// 新建运行器
		try {
			rt.exec("C:/Program Files (x86)/Tencent/QQBrowser/QQBrowser");// 可执行文件的路径或命令
			// 普通文件不行如视频音频等
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void test文件字节流() {
		/* 【字节流就是读出或写入文件的字节的管道，一端是文件一端是字节数组】 */
		/* 【输出流-write-字节数组，输入流-read-字节数组】 */
		byte[] b = new byte[5];
		try {
			FileInputStream fis = new FileInputStream("D:/yuan.txt");
			/* 构造方法的参数可以是封装了文件的文件对象也可以直接写文件路径，但不可以为目录路径 */
			try {
				for (int i = 1; i <= 18; i++) {
					// System.out.println(fis.read());
				}
				/* read()方法读出输入流的一个字节，返回字节中存的数，再次调用则读下个字节 ， */
				/* 若读到空字节，返回-1。从结果可以看出，记事本文件存储汉字时用的是gb2312编码 */
				/* ，即每字节存161-254的值，两者合一为汉字 */
				System.out.println("返回实际存放了几个字节，" + "如果过程中读到了空字节返回-1："

						+ "依据是b的长度和开始位置：" + fis.read(b, 0, 4));
				for (int i = 0; i < b.length; i++) {
					System.out.println(b[i]);
					/*
					 * 【且注意】 byte数组每个元素存放着八位2进制数，单打印出来并不是int，
					 * 
					 * 可能会溢出128就打印为-128
					 */
				}
				/*
				 * 从结果可以看出read方法的执行是相关的，即只能接着上次的位置，
				 * 
				 * 无法重新开始（即使是不同的参数）,记忆性顺序读取
				 */
				FileOutputStream fis01 = new FileOutputStream("D:/yuan.txt", true);
				/* 输出流的特点是文件不存在，可以创建文件，输入流则不行（产生文件不存在的错误 */
				/* 如果文件已存在 ，默认会冲掉原文件，但是构造函数中加一个参数append（增补）为真 */
				/* 则表示增加，而非重写 */
				fis01.write(b);
				fis01.write(97);
				fis01.close();
				while (fis.read(b, 0, 2) != -1) {
					String str = new String(b, 0, 2);// 将字节数组转化为字符串，两两结合，错位会乱码
					System.out.println(str);
				}

			} catch (IOException e) {
				e.printStackTrace();
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void test文件字符流() {
		char[] ch = new char[5];
		try {
			FileReader fr = new FileReader("D:/yuan.txt");
			try {
				// System.out.println(fr.read());
				fr.read(ch);
				for (int i = 0; i < ch.length; i++) {
					System.out.println(ch[i]);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			FileWriter fw = new FileWriter("D:/yuan.txt", false);
			fw.write(new String("我爱你中国"));
			fw.write("我爱你北京");
			fw.flush();
			fw.close();
			/* 【注意】流要记得调用flush和close因为有可能要写入的数据一直存在流中而没有写进文件 */
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void test数组字节流和字符流() {
		/* 【数组字节流】 */
		byte[] b1 = { 43, 44, 45, 46, 47, 48, 49, 50, 51, 52 };
		byte[] b2 = { 33, 34, 35, 36, 37, 38, 39, 40, 41, 42 };
		ByteArrayInputStream bi0 = new ByteArrayInputStream(b1, 0, 4);
		ByteArrayInputStream bi = new ByteArrayInputStream(b2);
		/* 注意参数必须是字节数组或接位置及长度（相当于一块指定内存） */
		// System.out.println(bi.read());
		// bi.read(b2, 4, 4);
		// for (int i = 0; i < b2.length; i++) {
		// System.out.println(b2[i]);
		// }
		ByteArrayOutputStream bo = new ByteArrayOutputStream();
		ByteArrayOutputStream bo1 = new ByteArrayOutputStream(10);
		/* 注意这里参数不可以是字节数组，因为源是内存，不是字节数组,也没有了append参数，不会冲刷 */
		bo.write(b2, 0, 10);
		bo.write(b1, 0, 10);
		byte[] b02 = bo.toByteArray();
		for (int i = 0; i < b02.length; i++) {
			System.out.println(b02[i]);
		}
		/* 【数组字符流】 */
		char[] c = { '我', '爱', '你', '中', '国' };
		char[] c01 = new char[5];
		CharArrayReader cr = new CharArrayReader(c);
		CharArrayReader cr01 = new CharArrayReader(c, 0, 5);
		/* 注意参数必须是字符数组或接位置及长度（相当于一块指定内存） */
		try {
			System.out.println(cr.read());
			cr.read(c01);
			for (int i = 0; i < c01.length; i++) {
				System.out.println(c01[i]);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CharArrayWriter cw = new CharArrayWriter();
		CharArrayWriter cw01 = new CharArrayWriter(5);
		/* 注意这里参数不可以是字符数组，因为源是内存，不是字符数组,也没有了append参数，不会冲刷 */

		try {
			cw.write(97);
			cw.write(new String("sfsd"));
			cw.write('s');
			char[] ca = cw.toCharArray();
			for (int j = 0; j < ca.length; j++) {
				System.out.println(ca[j]);
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void test字符串字符流() {
		StringReader sr = new StringReader("我爱你中国");
		char[] a={'C','D'};
		/*注意这里只能是字符串*/
		try {
			System.out.println(sr.read());
			sr.read(a, 0, 2);
			/* 用法和数组字符流一致 */
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
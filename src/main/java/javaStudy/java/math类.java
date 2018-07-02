package javaStudy.java;

import java.math.BigInteger;
import java.text.NumberFormat;

public class math类 {
	public static void main(String[] args) {
		/*
		 * 【*】math类主要提供数学运算的犯法和常用静态常量E，PI，绝对值abs（a），二数比较max（a，b）min（a，b），不包括，1的随机数
		 * random（），a的b次幂pow（a，b），a的平方根 sqrt（a），对数log（a），三角函数sin（a）
		 */
		System.out.println(Math.E);
		System.out.println(Math.PI);
		/*
		 * 数字的格式化是指按照指定格式返回字符串，常用numberformat类，其对象调用setmax（min）
		 * imumfractiondigits（位数）限定
		 * 小数本分，调用~integerdigits（位数），最后调用format（目标）返回字符串
		 */
		NumberFormat format = NumberFormat.getInstance();
		format.setMinimumIntegerDigits(6);
		format.setMinimumFractionDigits(6);
		System.out.println(format.format(Math.sqrt(10)));
		format.setMaximumIntegerDigits(5);
		format.setMaximumFractionDigits(2);
		System.out.println(format.format(Math.sqrt(10)));
		/* 自定义保留几位小数部分 */
		class mynumberformat {
			public String format(double a, int n) {
				String string = String.valueOf(a);// 将得到的数字转字符串
				int index = string.indexOf(".");// 获取小数点位置
				String temp = string.substring(index + 1);// 截取小数点后面的字符串
				int v = Math.min(n, temp.length());// 计算小数点后面的位数,取参数n和位数之间较小的
				string = string.substring(0,
						index + n + 1);/*
										 * 确定截取位置并最终输出字符串，值得注意substring（a，b）
										 * 截取的字符串不最后的包含b参数对应位置的字符，因此要加一
										 */
				return string;
			}

		}
		mynumberformat mynumberformat = new mynumberformat();
		System.out.println(mynumberformat.format(Math.sqrt(10), 3));// 调用自定义函数
		/*【*】biginteger类定义大整数对象，初始化biginteger（“数字”），是一种对大整数的封装，但应注意的是这并不是数字因此
		 * 无法用操作符，只能调用函数完成等同的操作*/
		
		BigInteger n1=new BigInteger("12345678944454641518");
		BigInteger n2=new BigInteger("12345678944454641518");
		//不可以BigIntegern3=n1+n2;只能调用add（）
		System.out.println("和是："+n1.add(n2)+"差是："+n1.subtract(n2)+"积是："+n1.multiply(n2)+"商是："
		+n1.divide(n2)+"余是："+n1.remainder(n2)+"比较结果："+n1.compareTo(n2)+"二进制字符串："+n1.toString(2));
		BigInteger n3=new BigInteger("1");
		BigInteger n4=new BigInteger("2");
		BigInteger n5=new BigInteger("0");
		BigInteger n6=new BigInteger("16");
		for(BigInteger i=n4;i.compareTo(n6)<0;i=i.add(n3)){
			if(n6.remainder(i).compareTo(BigInteger.ZERO)==0){
				n5=n5.add(n3);
				System.out.println("因子是"+i);
			}
			
		}
		System.out.println("共有"+n5+"个因子");
		/*【*】数字格式化是比java.text.NumberFormat更专业的类formatter类中的format（）方法，现已作为string类的静态方法，由类
		 * 直接调用，用法format（模式，值列表）“格式符和普通字符”构成模式，用逗号隔开常亮变量表达式是值列表。
		 * 【常用格式符】
		 *   整数方面 %d格式为十进制 、%o八进制、 %x小写十六进制、 %X大写十六进制ABC23、%u/i无符号和有符号十进制整数；
		 *   浮点数方面 %f格式化十进制浮点数保留6位小数、%E格式化十进制的科学计数法大写指数符E，%e就是小写指数符的意思、%g（G）
		 *   不显示无意的的0、%A（a） 十六进制浮点
		 * 【修饰符】+号强制加+号，，号按千分组，空格表示空格补齐默认右对齐，而0表示0补齐且默认右对齐，两种情况加-号都是左对齐
		 * 【数据长度】m.n特别注意m是字符串总长度不是整数部分，包括，.0等符号，n是小数部分即精度*/
		String str1=String.format("%0,+20.4f",121565669.232646622965);//修饰符+，0长度20.5类型f
		System.out.println(str1);
		String str7=String.format("%6f",121565669.232646622965);
		System.out.println(str7);
		String str2=String.format("%20.5f",121565669.232646622965);
		System.out.println(str2);
		String str5=String.format("%f",121565669.232646622965);
		System.out.println(str5);
		String str4=String.format("%10.12G",121565669.232646622965);
		System.out.println(str4);																				
		String str6=String.format("%23.12E",121565669.232646622965);
		System.out.println(str6);
		String str3=String.format("%-20d",121565669);
		System.out.println(str3);
		String str8=String.format("%02d",1);
		System.out.println(str8);
		/*以上测试说明，优先级：整数部分>小数部分精度>字符串总长度，只有满足了前两者才考虑是否用空格和0补全，超出的话依据实际，
		 * 总长度只是说明最小长度,【注意】修饰符顺序可变，但是0-不可组合，因此是不可以在末尾补全0的*/
	}
}

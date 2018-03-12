package java实例与思考;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class date类 {
	public static void main(String[] args) {
		/* date(long time)中的time是指相对于1970年1月1日0点的毫秒数，无参表示本地时间， */
		/* 可以调用currenttimemillis（） */
		/* 得到本地毫秒在填入time参数创建一个本地日期的date对象。通常需要将时间格式化， */
		/* 用到simpledateformat（“正则表达式”），封装一个模式，元字符： */
		/* y年 M月（MMM汉字月）d天 a上下午 H0-24 h0-12 m分钟 s秒 E星期 */
		Date date = new Date();
		SimpleDateFormat s = new SimpleDateFormat("今天是yy年M月d日Eh时m分s秒");
		System.out.println(s.format(date));
		/*
		 * 日历类calendar，初始化日历对象调用类方法getinstance，翻到某一时期的日历对象调用
		 * set（年月日（时分（秒）））或者settime(new date（）本地时间)， 此时的日历封装好包含指定时间的那页日历的信息，对象调用
		 * get（静态常亮如Calendar。month）获取相应信息，gettimeinmillis（）将时间表示为毫秒
		 */
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		System.out.println(calendar.get(Calendar.YEAR) + "" + calendar.get(Calendar.MONTH)
				+ calendar.get(Calendar.DAY_OF_MONTH) + calendar.get(Calendar.DAY_OF_WEEK)
				+ calendar.get(Calendar.HOUR_OF_DAY) + calendar.get(Calendar.MINUTE) + calendar.get(Calendar.SECOND));
		Calendar calendar2 = Calendar.getInstance();
		calendar2.set(1995, 12, 17);
		int l = (int) ((calendar2.getTimeInMillis() - calendar.getTimeInMillis()) / (1000 * 60 * 60 * 24));
		System.out.println(l);
		/* 建立一个日历并输出：用数组存放日期包括空格，用星期几决定多少个不填号码，最后1行7个打印出来 */
		Calendar calendar3 = Calendar.getInstance();
		calendar3.setTime(new Date());
		int mark = calendar3.get(Calendar.DAY_OF_WEEK) - 1;
		String aString[] = new String[mark + 30];
		for (int i = 0; i < mark; i++) {
			aString[i] = "";
		}
		for (int i = mark, n = 1; i < aString.length; i++) {
			aString[i] = String.valueOf(n);
			n++;
		}
		System.out.printf("%12s%12s%12s%12s%12s%12s%12s\n", "日", "一", "二", "三", "四", "五", "六");
		for (int i = 0; i < aString.length; i++) {
			if (i % 7 == 0 && i != 0) {
				System.out.println("\n");

			}
			System.out.printf("%5s", aString[i]);
		}
	}
}

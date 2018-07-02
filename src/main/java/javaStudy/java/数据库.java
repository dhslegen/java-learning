package javaStudy.java;

import java.sql.*;

import org.junit.Test;

public class 数据库 {
	Connection con = null;
	PreparedStatement pre;
	Statement sql = null;
	ResultSet rs;
	String dbClassName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	String dbUrl = "jdbc:sqlserver://localhost:1433;DatabaseName=GMCC_ACQUIRE_SYSTEM;SelectMethod=Cursor";
	String dbUser = "sa";
	String dbPwd = "123456";

	@Test
	public void test查询() {
		try {
			Class.forName(dbClassName);
			con = DriverManager.getConnection(dbUrl, dbUser, dbPwd);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			pre = con.prepareStatement("SELECT * FROM RECLAIM_TRANSACT_DUMP ");
			rs = pre.executeQuery();// 预处理
			while (rs.next()) {
				System.out.println(rs.getString(1) + rs.getString(2) + rs.getString(3));
			}
			sql = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);// 支持滚动，结果集不改变数据库
			rs = sql.executeQuery("SELECT * FROM student");// 正常
			while (rs.next()) {
				System.out.println(rs.getString(1) + rs.getString(2) + rs.getString(3) + rs.getString(4));
			}
			rs = sql.executeQuery("SELECT * FROM course where cname like'数%'");// 模糊查询
			while (rs.next()) {
				System.out.println(rs.getString(1) + rs.getString(2) + rs.getString(3) + rs.getString(4));
			}
			rs = sql.executeQuery("SELECT * FROM course where cname like'数%' order by cno");// 排序查询
			while (rs.next()) {
				System.out.println(rs.getString(1) + rs.getString(2) + rs.getString(3) + rs.getString(4));
			}
			rs = sql.executeQuery("SELECT * FROM course where cno>4");// 条件查询
			while (rs.next()) {
				System.out.println(rs.getString(1) + rs.getString(2) + rs.getString(3) + rs.getString(4));
			}
			rs.last();
			rs.previous();
			System.out.println(rs.getRow());
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Test
	public void test更新() {
		try {
			Class.forName(dbClassName);
			con = DriverManager.getConnection(dbUrl, dbUser, dbPwd);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

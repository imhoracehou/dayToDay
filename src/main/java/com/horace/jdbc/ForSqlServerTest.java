package com.horace.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ForSqlServerTest {
	private static String url = "jdbc:sqlserver://10.10.4.177:1433;DatabaseName=testforhorace";
	private static String username = "sa";
	private static String password = "leandev123";
	
	private static String url2 = "jdbc:sqlserver://10.14.0.145:1433;DatabaseName=konteklon";
	private static String username2 = "sa";
	private static String password2 = "leandev";

	public static void main(String[] args) throws Exception {
		test1();
	}

	public static void test1() {
		try {
			Connection conn = getSqlServerConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("if exists (select * from sysobjects where id = object_id(N'employee') and OBJECTPROPERTY(id, N'IsUserTable') = 1) if not exists(select * from syscolumns where id=object_id('employee') and name='s') select count(*) from employee");
			while (rs.next()) {
				Long count = rs.getLong(1);
				System.out.println(count);
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public static void testBatch() {
		try {
			Connection conn = getSqlServerConnection();
			Statement stmt = conn.createStatement();
			stmt.addBatch("insert into Persons values(4,'hou','horace','some address1','JiNan');");
			stmt.addBatch("insert into Persons values(5,'wang','lily','some address2','BeiJing');");
			stmt.addBatch("insert into Persons values(6,'hou','xiao','some address3','ShangHai');");
			// stmt.addBatch("GO;");//JDBC don`t support GO language.
			stmt.executeBatch();
			stmt.close();
			conn.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public static Connection getSqlServerConnection() {
		Connection conn = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url2, username2, password2);
			return conn;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}

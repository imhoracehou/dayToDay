package base;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Date;

/**
 * stmt.executeBatch() 比 stmt.executeUpdate(sql)速度大概提升四倍。
 */
public class JDBCTest {
	private static String DRIVER_NAME = "org.postgresql.Driver";
	private static String URL = "jdbc:postgresql://localhost:15432/horace";
	private static String USER_NAME = "kontek";
	private static String USER_PWD = "kontek";

	public static void main(String[] args) throws Exception {
		test2();
	}

	public static void test1() throws Exception {
		String sql = "update tb_user set name = 'testJDBC' where id = 'id001'";

		Class.forName(DRIVER_NAME);
		Connection conn = DriverManager.getConnection(URL, USER_NAME, USER_PWD);
		Statement stmt = conn.createStatement();
		//
		long start = (new Date()).getTime();
		for (int i = 0; i < 2200; i++) {
			stmt.executeUpdate(sql);
		}
		long end = (new Date()).getTime();
		System.out.println(end - start);
		//
		start = (new Date()).getTime();
		for (int i = 0; i < 2200; i++) {
			stmt.addBatch(sql);
		}
		stmt.executeBatch();
		end = (new Date()).getTime();
		System.out.println(end - start);

		stmt.close();
		conn.close();
	}

	public static void test2() throws Exception {

		Class.forName(DRIVER_NAME);
		Connection conn = DriverManager.getConnection(URL, USER_NAME, USER_PWD);
		Statement stmt = conn.createStatement();
		//
		stmt.addBatch("delete from tb_user");
		stmt.addBatch("insert into tb_user values('id9001','9001','9001')");
		stmt.executeBatch();
		stmt.addBatch("insert into tb_user values('id9002','9002','9002')");
		stmt.executeBatch();
		//
		stmt.close();
		conn.close();
	}
}

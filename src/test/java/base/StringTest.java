package base;

import java.util.ArrayList;
import java.util.List;

public class StringTest {

	public static void main(String[] args) {
		String sql = "delete from finalizedsalaryitem_custstat where salaryitem_id in (select id from finalizationsalaryitem where restoreid=22101001094892750) or customerstatistic_id in (select id from finalizationsalaryitemcustomerstatistic where restoreid=22101001094892750) or customerstatistic_id in (select id from finalizationsalaryitemcustomerstatistic where restoreid=22101001094892750);";
		List<String> list = formatDeleteOrSql(sql);
		for (String s : list) {
			System.out.println(s);
		}
	}

	public static List<String> formatDeleteOrSql(String sql) {
		String preDeleteSql = "delete from ";
		List<String> list = new ArrayList<String>();
		if (sql.contains("or")) {
			sql = sql.trim().replace(preDeleteSql, "");
			String tableName = sql.substring(0, sql.indexOf(" "));

			String[] deleteSql = sql.split(" or ");
			for (int i = 0; i < deleteSql.length; i++) {
				if (i == 0) {
					list.add(preDeleteSql + deleteSql[0]);
				} else {
					list.add(preDeleteSql + tableName + " where " + deleteSql[i]);
				}
			}

		}
		return list;
	}
}

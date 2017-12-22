package copy;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;

import org.postgresql.copy.CopyManager;
import org.postgresql.core.BaseConnection;

public class CopyTest {
	private static String DRIVER_NAME = "org.postgresql.Driver";
	private static String URL = "jdbc:postgresql://localhost:15432/horace";
	private static String USER_NAME = "kontek";
	private static String USER_PWD = "kontek";

	public static void main(String[] args) throws Exception {
		test1();
	}

	public static void test1() throws Exception {
		String lineSeparator = System.getProperty("line.separator", "\n");// 获取当前系统换行符

		StringBuffer sb = new StringBuffer();
		sb.append("id001,hou,jinan").append(lineSeparator).append("id002,wou,ouzhou").append(lineSeparator).append("id003,houwang,beijing").append(lineSeparator).append("id004,houwang,null").append(lineSeparator);
		ByteArrayInputStream inputStringStream = new ByteArrayInputStream(sb.toString().getBytes());

		Class.forName(DRIVER_NAME);
		Connection conn = DriverManager.getConnection(URL, USER_NAME, USER_PWD);
		CopyManager copyManager = new CopyManager((BaseConnection) conn);
		copyManager.copyIn("COPY tb_user(id,name,address) FROM STDIN(DELIMITER ',' , NULL 'null')", inputStringStream);

		conn.close();
		inputStringStream.close();
	}

	public static void test2() throws Exception {
		FileInputStream fis = new FileInputStream("e:\\test2.txt");
		Class.forName(DRIVER_NAME);
		Connection conn = DriverManager.getConnection(URL, USER_NAME, USER_PWD);
		CopyManager copyManager = new CopyManager((BaseConnection) conn);
		copyManager.copyIn("COPY employeeholidaybasicbalance(restoreId,id,employeeholidaybasictype,days,degree,disabledays,disabledegreeofemployment,disablehours,holidaybalancetype,holiday_id) FROM STDIN(DELIMITER ',' , NULL 'null')", fis);

		conn.close();
		fis.close();
	}
	public static void test3() throws Exception {
		FileInputStream fis = new FileInputStream("e:\\test3.txt");
		Class.forName(DRIVER_NAME);
		Connection conn = DriverManager.getConnection(URL, USER_NAME, USER_PWD);
		CopyManager copyManager = new CopyManager((BaseConnection) conn);
		copyManager.copyIn("COPY regularsalaryitem(restoreId,id,account,accumulatedsurplus,accumulatedsurplusextra,averagehourwage,calculatetaxdisable,companyid,connectorno,costcenter,datetype,definitionnumber,definitiontitle,filtercode,hourofworksaccount,identifier,itp1foundation,itp2foundation,itp2oncall,level4,movablesalary,needcalculateflag,note,obstate,ordersequence,overtimeamount,overtimehours,roundingtype,salaryabsencenumbers,taxtype,templatename,timeamount,timehours,tradelevy,utbstate,vacationsalary,absencetype1,absencetype2,absencetype3,standardaccount,useemployeecostcenter,useemployeelevel4,attributiontaxtype_id,formulafornumberof,formulaforprice,formulafortotalamount,maxamount,minimumamount,costcenterchecked,costcenteremployeeidchecked,datechecked,displaynamechecked,generalledgeraccountchecked,hourschecked,itemnumberofchecked,itempricechecked,itemtotalamountchecked,level4checked,level4employeeidchecked,objectchecked,objectemployeeidchecked,printaccountchecked,printdatechecked,printwagespecchecked,definitionlevel1,definitionlevel2,definitionlevel3,salaryitemgroup_id,status,salaryvariablesupplementsetting_id,timevariablesupplementsetting_id) FROM STDIN(DELIMITER ',' , NULL 'null')", fis);
		
		conn.close();
		fis.close();
	}
}

package admin;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.util.Scanner;

import jdbc.DBUtil;
import oracle.jdbc.OracleTypes;

public class AdminLogIn {
	
	public int logIn() {
		
		// 관리자로그인
		Connection conn = null;
		CallableStatement stat = null;
		DBUtil util = new DBUtil();
		Scanner scan = new Scanner(System.in);

		try {
			
			System.out.println("관리자 로그인");
			System.out.print("관리자 ID: ");
			String id = scan.nextLine();

			System.out.print("관리자 PW: ");
			String pw = scan.nextLine();
			
			String sql = "{ call proc_loginadmin(?,?,?) }";
			
			conn = util.open();
			stat = conn.prepareCall(sql);
			
			stat.setString(1, id);
			stat.setString(2, pw);
			stat.registerOutParameter(3, OracleTypes.NUMBER);
			
			stat.executeUpdate();
			
			//1이면 로그인성공, 0이면 로그인실패
			int num = stat.getInt(3);
			stat.close();
			conn.close();
			return num;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}//loginAdmin

}

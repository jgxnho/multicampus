package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTemplate {
	//1. 연결
	public static Connection getConnection() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("1. [Error] 드라이버 등록 실패");
		}
		
		String url = "jdbc:mysql://localhost:3306/multi";
		String id = "root";
		String pw = "rjsgh1078";
		
		Connection con = null;
		try {
			con = DriverManager.getConnection(url,id,pw);
			con.setAutoCommit(false);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("[Error] 연결 실패");
		}
		return con;
	}
	
	//2. 해제
	public static void Close(ResultSet rs) {
		try {
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("[Error] ResultSet close 에러");
		}
	}
	public static void Close(Statement stmt) {
		try {
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("[Error] Statement close 에러");
		}
	}
	public static void Close(Connection con) {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("[Error] Connection close 에러");
		}
	}
	
	
	//3. 저장
	public static void Commit(Connection con) {
		try {
			con.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//4. 취소
	public static void Rollback(Connection con) {
		try {
			con.rollback();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

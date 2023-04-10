package com.test01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTest01 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//1. driver 등록
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//2. connection 객체 생성
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/multi",
													"root",
													"rjsgh1078");
		
		//3. 쿼리 실행
		Statement stmt = con.createStatement();
		
		ResultSet rs = stmt.executeQuery(" SELECT * FROM EMPLOYEE ");
		
		//4. 결과 처리
		while(rs.next()) {
			System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt("SALARY"));		
		}
		
		//5. DB 종료
		rs.close();
		stmt.close();
		con.close();
		
		
		
		
		
		
		
	}

}

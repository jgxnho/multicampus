package com.test01;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import common.JDBCTemplate;

public class JDBCTest03 extends JDBCTemplate {

	public static void main(String[] args) throws SQLException {
		//MYTEST 테이블에 insert
		
		//0. 준비
		Connection con = null;
		Statement stmt = null;
		int res = 0; // insert 실행 후 결과값 저장할 변수
		
		//키보드로 값 입력 받아 보자
		Scanner sc = new Scanner(System.in);
		System.out.print("NO : ");
		int no = sc.nextInt();
		System.out.print("NAME : ");
		String name = sc.next();
		System.out.print("NICKNAME : ");
		String nickName = sc.next();
		
		//insert into mytest values( MNO, 'MNAME', 'NICKNAME' )
		String sql = " INSERT INTO MYTEST VALUES( "+no+", '"+name+"', '"+nickName+"') ";
		
		//1.
		con = getConnection();
		
		//2.
		stmt = con.createStatement();
		res = stmt.executeUpdate(sql); // query 실행 후 적용된 row의 숫자를 리턴
		
		//3.
		if(res>0) {
			System.out.println("insert 성공");
		}else {
			System.out.println("insert 실패");
		}
		
		//4.
		Close(stmt);
		Close(con);
		sc.close();
		
		
		select();
		
	}

	public static void select() {
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

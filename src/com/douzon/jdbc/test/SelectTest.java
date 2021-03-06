package com.douzon.jdbc.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectTest {

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			// 1. JDBC Driver (MySQL) 로딩
			Class.forName("com.mysql.jdbc.Driver"); // 패키지 이름

			// 2. 연결하기 ( Connection 객체 얻어오기 )
			String url = "jdbc:mysql://localhost:3306/webdb"; // DB 종류마다 url이 다르다
			conn = DriverManager.getConnection(url, "webdb", "webdb"); // interface

			// 3. Staement 객체를 생성
			stmt = conn.createStatement();

			// 4. SQL문 실행
			String sql = "select name, owner, birth from pet";
			rs = stmt.executeQuery(sql);

			// 5. 결과 가져오기
			while (rs.next()) {
				String name = rs.getString(1);
				String owner = rs.getString(2);
				String birth = rs.getString(3); // DB의 Date 타입을 java에서 Stirng으로 받는다.
				
				System.out.println(name + " : " + owner + " : " + birth);
			}

		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패" + e);
		} catch (SQLException e) {
			System.out.println("error: " + e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}

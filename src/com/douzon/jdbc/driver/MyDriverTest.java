package com.douzon.jdbc.driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyDriverTest {

	public static void main(String[] args) {
		Connection conn = null;
		try {
			// 1. JDBC Driver 로딩
			Class.forName("com.douzon.jdbc.driver.MyDriver"); // 패키지 이름

			// 2. 연결하기
			String url = "jdbc:mysql://localhost:3306/webdb"; // DB 종류마다 url이 다르다
			conn = DriverManager.getConnection(url, "webdb", "webdb"); // interface
			System.out.println("연결성공");

		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패" + e);
		} catch (SQLException e) {
			System.out.println("error: " + e);
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}
}

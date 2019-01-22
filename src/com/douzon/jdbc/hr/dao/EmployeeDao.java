package com.douzon.jdbc.hr.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.douzon.jdbc.hr.vo.EmployeeVo;

public class EmployeeDao {
	public List<EmployeeVo> getList(String keyword){
		List<EmployeeVo> list = new ArrayList<EmployeeVo>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();

			String sql = 
					"select emp_no, first_name, last_name, hire_date" +
					"  from employees" +
					" where first_name like ?" +
					"    or last_name like ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + keyword + "%");
			pstmt.setString(2, "%" + keyword + "%");
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Long empNo = rs.getLong(1);
				String firstName = rs.getString(2);
				String lastName = rs.getString(3);
				String hireDate = rs.getString(4);
				
				EmployeeVo vo = new EmployeeVo();
				vo.setEmp_no(empNo);
				vo.setFirst_name(firstName);
				vo.setFirst_name(lastName);
				vo.setHire_date(hireDate);
				
				list.add(vo);
			}
			
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(pstmt != null) {
					pstmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return list;
	}
	
	public List<EmployeeVo> getList() {
		List<EmployeeVo> list = new ArrayList<EmployeeVo>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			conn = getConnection();

			// 3. Staement 객체를 생성
			stmt = conn.createStatement();

			// 4. SQL문 실행
			String sql = "select emp_no, first_name, last_name , hire_date from employees";
			rs = stmt.executeQuery(sql);

			// 5. 결과 가져오기
			while (rs.next()) {
				Long emp_no = rs.getLong(1);
				String first_name = rs.getString(2);
				String last_name = rs.getString(3); // DB의 Date 타입을 java에서 Stirng으로 받는다.
				String hire_date = rs.getString(4);

				EmployeeVo vo = new EmployeeVo();
				vo.setEmp_no(emp_no);
				vo.setFirst_name(first_name);
				vo.setLast_name(last_name);
				vo.setHire_date(hire_date);
				
				list.add(vo);
			}

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
		return list;
	}
	
	private Connection getConnection() throws SQLException {
		Connection conn = null;

		try {
			Class.forName("com.mysql.jdbc.Driver"); // 패키지 이름

			String url = "jdbc:mysql://localhost:3306/employees"; // DB 종류마다 url이 다르다
			conn = DriverManager.getConnection(url, "hr", "hr"); // interface
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패" + e);
		}
		return conn;
	}
}

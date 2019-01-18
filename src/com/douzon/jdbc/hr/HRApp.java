package com.douzon.jdbc.hr;

import java.util.List;
import java.util.Scanner;

import com.douzon.jdbc.hr.dao.EmployeeDao;
import com.douzon.jdbc.hr.vo.EmployeeVo;

public class HRApp {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("사원 이름을 입력하시오 :");
		String no = scanner.next();
		scanner.close();
		search(no);
	}

	private static void search(String no) {
		List<EmployeeVo> list = new EmployeeDao().getList();
		for (EmployeeVo vo : list) {
			System.out.println(vo);
		}
	}
}

package com.douzon.jdbc.hr;

import java.util.List;
import java.util.Scanner;

import com.douzon.jdbc.hr.dao.EmployeeDao;
import com.douzon.jdbc.hr.vo.EmployeeVo;

public class HRApp {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("검색어>>");
		String keyword = scanner.nextLine();

		List<EmployeeVo> list = new EmployeeDao().getList(keyword);
		for (EmployeeVo vo : list) {
			System.out.println(
					"[" + vo.getEmp_no() + "]" + vo.getFirst_name() + " " + vo.getFirst_name() + " " + vo.getHire_date());
		}

		scanner.close();
	}
}

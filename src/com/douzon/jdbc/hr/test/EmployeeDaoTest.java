package com.douzon.jdbc.hr.test;

import java.util.List;

import com.douzon.jdbc.hr.dao.EmployeeDao;
import com.douzon.jdbc.hr.vo.EmployeeVo;

public class EmployeeDaoTest {
	public static void main(String[] args) {
		getListTest();
	}

	public static void getListTest() {
		List<EmployeeVo> list = new EmployeeDao().getList();
		for (EmployeeVo vo : list) {
			System.out.println(vo);
		}
	}
}

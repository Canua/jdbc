package com.douzon.jdbc.bookshop.test;

import java.util.List;

import com.douzon.jdbc.bookshop.dao.BookDao;
import com.douzon.jdbc.bookshop.vo.BookVo;

public class BookDaoTest {

	public static void main(String[] args) {
//		insertTest("이클립스", 2);
//		insertTest("브레이킹던", 2);
		insertTest("아리랑", 6);
		insertTest("젋은그들", 7);
		insertTest("아프니까 청춘이다", 8);
		insertTest("귀천", 9);
		
		
		getListTest();
	}
	public static void insertTest(String title, long authorNo) {
		BookVo vo = new BookVo();
		vo.setTitle(title);
		vo.setAuthorNo(authorNo);
		
		new BookDao().insert(vo);
	}
	public static void getListTest() {
		List<BookVo> list = new BookDao().getList();
		for (BookVo vo : list) {
			System.out.println(vo);
		}
	}

}

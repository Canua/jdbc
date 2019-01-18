package com.douzon.jdbc.bookshop;

import java.util.List;
import java.util.Scanner;

import com.douzon.jdbc.bookshop.dao.BookDao;
import com.douzon.jdbc.bookshop.test.BookDaoTest;
import com.douzon.jdbc.bookshop.vo.BookVo;

public class MainApp {

	public static void main(String[] args) {
		BookDaoTest bookDaoTest = new BookDaoTest();
		BookDaoTest.getListTest();
		Scanner scanner = new Scanner(System.in);
		System.out.print("대여 하고 싶은 책의 번호를 입력하세요:");
		long no = scanner.nextInt();
		scanner.close();
		rent(no);
		displayBookInfo();
	}

	private static void rent(long no) {
		String rent = "대여중";
		BookVo vo = new BookVo();
		vo.setNo(no);
		vo.setStatus(rent);
		
//		new BookDao().update(no, "대여중");
		
		new BookDao().update(vo);
		List<BookVo> list = new BookDao().getList();
		for (int i = 0; i < list.size(); i++) {
			if (no == list.get(i).getNo()) {
				System.out.println(list.get(i).getTitle() + "이(가) 대여 됐습니다.");
			}
		}
		System.out.println("＊＊＊＊＊＊도서 정보 출력하기＊＊＊＊＊＊");
	}

	private static void displayBookInfo() { // DAO
		List<BookVo> list = new BookDao().getList();
		for(int i = 0; i < list.size(); i ++) {
		System.out.println("책 제목 : " + list.get(i).getTitle() + 
				           ", 저자 : " + list.get(i).getAuthorName() +
				           ", 대여 유무 " + list.get(i).getStatus());
		}
	}
}

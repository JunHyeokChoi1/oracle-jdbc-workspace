package com.kh.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import com.kh.model.dao.BookDAO;
import com.kh.model.vo.Book;
import com.kh.model.vo.Member;
import com.kh.model.vo.Rent;

public class BookController {

	private BookDAO dao = new BookDAO();
	private Member member = new Member();
	
	public ArrayList<Book> printBookAll() {
		// sql문 : select, 테이블 : tb_book 
		// ArrayList 추가할때 add 메서드
		// rs.getString("bk_title");
		return null;
	}
	
	public boolean registerBook(Book book) {
		if(book.getBkAuthor()==null) {
			try {
				dao.registerBook(book);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return true;
		}
		return false;
	}
	
	public boolean sellBook(int no) {
		return false;
	}
	
	public boolean registerBook(Member member) {
		return false;
	}
	
	public boolean deleteMember() {	//update
		return false;
	}
	
	public boolean rentBook(int no) {
		return false;
	}
	
	public boolean deleteRent(int no) {
		// 위에 member 변수있잖아요
		// 로그인때 담아놓아서 매개변수 따로 안받음
		
		
		return false;
	}
	
	public ArrayList<Rent> printRentBook() {
		// SQL문 - join 필요 테이블 다 엮어야 됨
		// 이유 --> rent_no, rent_date, bk_title, bk_author
		// 조건은 member_id 가지고 가져오니까
		// while문 안에서! Rent rent = new Rent();
		// setter 사용!!
		// rent.setBook(new Book(rs.getString("bk_title"), rs.getString("bk_author")));
		
		return null;
	}
	
}



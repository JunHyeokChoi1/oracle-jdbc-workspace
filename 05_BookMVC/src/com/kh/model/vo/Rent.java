package com.kh.model.vo;

import java.util.Date;

public class Rent {
	
	// 모델링의 중요성 foreign 키는 객체로 가져올 수 있음
	private int rentNo;
	private Member member;
	private Book book;
	private Date rentDate;
	public Rent() {
	}
	public Rent(int rentNo, Member member, Book book, Date rentDate) {
		super();
		this.rentNo = rentNo;
		this.member = member;
		this.book = book;
		this.rentDate = rentDate;
	}
	public int getRentNo() {
		return rentNo;
	}
	public void setRentNo(int rentNo) {
		this.rentNo = rentNo;
	}
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public Date getRentDate() {
		return rentDate;
	}
	public void setRentDate(Date rentDate) {
		this.rentDate = rentDate;
	}
	@Override
	public String toString() {
		return "Rent [rentNo=" + rentNo + ", member=" + member + ", book=" + book + ", rentDate=" + rentDate + "]";
	}
	
	
}

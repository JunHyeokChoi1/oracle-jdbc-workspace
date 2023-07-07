package com.kh.model.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.model.vo.Book;
import com.kh.model.vo.Member;
import com.kh.model.vo.Rent;

import config.ServerInfo;

public class BookDAO implements BookDAOTemplate{
	
	private Properties p = new Properties();
	
	public BookDAO() {
		try {
			p.load(new FileInputStream("src/config/jdbc.properties"));
			Class.forName(ServerInfo.DRIVER_NAME);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public Connection getConnect() throws SQLException {
		Connection conn = DriverManager.getConnection(ServerInfo.url, ServerInfo.USER, ServerInfo.PASSWORD);
		return conn;
	}

	public void closeAll(PreparedStatement st, Connection conn) throws SQLException {
		st.close();
		conn.close();
	}

	public void closeAll(ResultSet rs, PreparedStatement st, Connection conn) throws SQLException {
		rs.close();
		closeAll(st, conn);
	}

	@Override
	public ArrayList<Book> printBookAll() throws SQLException {
		return null;
	}

	@Override
	public int registerBook(Book book) throws SQLException {
		// 반환값 타입이 int인 경우 다 st.executeUpdate()!
		
		Connection conn = getConnect();
		PreparedStatement st = conn.prepareStatement(p.getProperty("registerBook"));
		
		st.setString(1, book.getBkAuthor());
		st.setString(2, book.getBkTitle());
		
		st.executeUpdate();
		
		closeAll(st, conn);
		
		return book.getBkNo();
	}

	@Override
	public int sellBook(int no) throws SQLException {
		// 책 삭제 delete 문으로
		Connection conn = getConnect();
		PreparedStatement st = conn.prepareStatement(p.getProperty("registerBook"));
		
		
		st.executeUpdate();
		
		closeAll(st, conn);
		
		return 0;
	}

	@Override
	public int registerMember(Member member) throws SQLException {
		return 0;
	}

	@Override
	public Member login(String id, String password) throws SQLException {
		
		// char rs.getString("status").charAt(0)
		return null;
	}

	@Override
	public int deleteMember(String id, String password) throws SQLException {
		
		// UPDATE - STATUS를 Y로
		// status가 n이면 회원 유지, y면 회원 탈퇴
		// n이 기본값! <--- 회원 유지!
		return 0;
	}

	@Override
	public int rentBook(Rent rent) throws SQLException {
		return 0;
	}

	@Override
	public int deleteRent(int no) throws SQLException {
		return 0;
	}

	@Override
	public ArrayList<Rent> printRentBook(String id) throws SQLException {
		return null;
	}

}

package com.youtube.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.youtube.model.vo.Channel;

import config.ServerInfo;

public class ChannelDAO implements ChannelDAOTemplate {
	
	private Properties p = new Properties();
	
	public ChannelDAO() {
		try {
			p.load(new FileInputStream("src/config/jdbc.properties"));
			Class.forName(ServerInfo.DRIVER_NAME);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	@Override
	public Connection getConnect() throws SQLException {
		Connection conn = DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASSWORD);
		return conn;
	}

	@Override
	public void closeAll(PreparedStatement st, Connection conn) throws SQLException {
		st.close();
		conn.close();
	}

	@Override
	public void closeAll(ResultSet rs, PreparedStatement st, Connection conn) throws SQLException {
		rs.close();
		closeAll(st, conn);
	}

	
	@Override
	public int addChannel(Channel channel) throws SQLException {
		return 0;
	}

	@Override
	public int updateChannel(Channel channel) throws SQLException {
		return 0;
	}

	@Override
	public int deleteChannel(int channelCode) throws SQLException {
		return 0;
	}

	@Override
	public Channel myChannel(String memberId) throws SQLException {
		return null;
	}

}

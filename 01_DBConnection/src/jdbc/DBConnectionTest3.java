package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import config.ServerInfo;

public class DBConnectionTest3 {
	
	/*
	 * 디비 서버에 대한 정보가 프로그램상에 하드코딩 되어져 있음!
	 * --> 해결책 : 별도의 모듈에 디비서버에 대한 정보를 뽑아내서 별도 처리
	 * 
	 */
	
	public static void main(String[] args) {
		
		try {
			// 1. 드라이버 로딩
			Class.forName(ServerInfo.DRIVER_NAME);
			System.out.println("Driver Loading .... !!");
			// 2. 디비 연결
			Connection conn = DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASSWARD);
			System.out.println("DB Connection ...!!");
			
			// 3. Statement 객체 생성 - UPDATE
			String query = "UPDATE emp SET dept_title = ? WHERE emp_id = ?";
			PreparedStatement st = conn.prepareStatement(query);
			
			st.setString(1, "디자인");
			st.setInt(2, 1);
			
			int result = st.executeUpdate();
			System.out.println(result + "명 수정!");
			
			// 결과가 잘 나오는지 확인 - select			
			String query1 = "SELECT * FROM EMP";
			PreparedStatement st1 = conn.prepareStatement(query1);
			
			ResultSet rs = st1.executeQuery();
			while(rs.next()) {
				
				String empId = rs.getString("emp_id");
				String deptTitle = rs.getString("dept_title");
				
				System.out.println(deptTitle + "/" + empId);
				
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}

}
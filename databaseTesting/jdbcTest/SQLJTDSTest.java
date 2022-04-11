package jdbcTest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import jdbcConnection.SQLJTDSConnection;

public class SQLJTDSTest {

	
	public static void main(String[] args) throws SQLException {
		System.out.println("Get connection.....");
		
		//Lấy ra đối tượng Connection kết nối vào database
		Connection conn = SQLJTDSConnection.getMySQLConnection();
		
		System.out.println("Opened connection : " + conn);
		Statement statement = conn.createStatement();
		
		String sqlParam = "Select emp.Emp_Id, emp.First_Name, emp.Title, emp.Dept_Id from [automationfc].[dbo].[EMPLOYEE] emp where emp.Title like ? and emp.Dept_Id =?";
		
		PreparedStatement pstm = conn.prepareStatement(sqlParam, ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
		pstm.setString(1, "%ent");
		pstm.setInt(2, 3);
		
		ResultSet rs = pstm.executeQuery();
		
		while(rs.next()) {
			//Di chuyển con trỏ xuống bản ghi kế tiếp
			int branchId = rs.getInt(1);
			String address = rs.getString(2);
			String city = rs.getString(3);
			String name = rs.getString(4);
			
			System.out.println("------------------");
			System.out.println(branchId);
			System.out.println(address);
			System.out.println(city);
			System.out.println(name);
		}
		System.out.println("***********************");
		
		pstm.setString(1, "%er");
		pstm.setInt(2, 1);
		rs = pstm.executeQuery();
		
		while(rs.next()) {
			//Di chuyển con trỏ xuống bản ghi kế tiếp
			int branchId = rs.getInt(1);
			String address = rs.getString(2);
			String city = rs.getString(3);
			String name = rs.getString(4);
			
			System.out.println("------------------");
			System.out.println(branchId);
			System.out.println(address);
			System.out.println(city);
			System.out.println(name);
		}
		
		//Đóng kết nối
		conn.close();
		System.out.println("----------Closed Connection------------");
	}
}

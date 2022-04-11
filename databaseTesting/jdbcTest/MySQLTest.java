package jdbcTest;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import jdbcConnection.MySQLConnection;

public class MySQLTest {

	static Connection conn;
	public static void main(String[] args) throws SQLException {
		
		
		conn = MySQLConnection.getMySQLConnection();
		
		System.out.println("Opened connection : " + conn);
		
		Statement statement = conn.createStatement();
		String sql = "Select Emp.Emp_Id, Emp.First_Name, Emp.Last_Name, Emp.Dept_Id From Employee Emp;";
		
		//Thực thi câu lệnh SQL trả về đối tượng ResultSet.
		ResultSet rs = statement.executeQuery(sql);
		//Duyệt trên kết quả trả về
		while (rs.next()) {
			int empId = rs.getInt(1);
			String empFirstName = rs.getString(2);
			String empLastName = rs.getString("Last_Name");
			int deptID = rs.getInt(4);
			
			System.out.println("--------------------");
			System.out.println("Emp Id:" + empId);
			System.out.println("Emp Firstname : " + empFirstName);
			System.out.println("Emp Lastname : " + empLastName);
			System.out.println("Dept Id:" + deptID);
		}
		conn.close();
		System.out.println("--------------Close Connection-----------------");
	}

}

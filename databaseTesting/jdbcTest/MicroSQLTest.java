package jdbcTest;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import jdbcConnection.MicroSQLConnection;

public class MicroSQLTest {

	public static void main(String[] args) throws SQLException {
		System.out.println("Get connection.........");

		// Lấy ra đối tượng Connection kết nối vào database
		Connection conn = MicroSQLConnection.getSQLConnection();

		System.out.println("Opened connection : " + conn);
		Statement statement = conn.createStatement();

		String sql = "SELECT EMP_ID, FIRST_NAME, LAST_NAME, DEPT_ID FROM [automationfc].[dbo].[EMPLOYEE];";
		// Thực thi câu lệnh SQL trả về đối tượng ResultSet
		ResultSet rs = statement.executeQuery(sql);

		while (rs.next()) {
			// Di chuyển con trỏ xuống bản ghi kế tiếp
			int empId = rs.getInt(1);
			String empFirstName = rs.getString(2);
			String empLastName = rs.getString("Last_Name");
			int deptID = rs.getInt("Dept_Id");

			System.out.println("------------------");
			System.out.println("Emp Id : " + empId);
			System.out.println("Emp Firstname : " + empFirstName);
			System.out.println("Emp Lastname : " + empLastName);
			System.out.println("Department Id : " + deptID);
		}
		// Đóng kết nối
		conn.close();
		System.out.println("----------Closed Connection------------");
	}

}

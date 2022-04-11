package jdbcConnection;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySQLConnection {

	public static Connection getMySQLConnection() {
		//hostname : IP public
		String hostName = "localhost";
		String dbName = "automationfcvn";
		String userName = "root";
		String password = "Luong1995@";
		return getMySQLConnection(hostName, dbName, userName, password);
	}
	
	private static Connection getMySQLConnection (String hostName, String dbName, String userName, String password) {
		Connection conn = null;
		try {
			//Cấu trúc URL Connection dành cho MySQL
			//Ví dụ : jdbc:mysql://localhost:3306/automationfcvn
			String connectionUrl = "jdbc:mysql://"+ hostName + ":3306/" + dbName;
			conn = DriverManager.getConnection(connectionUrl, userName, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
}

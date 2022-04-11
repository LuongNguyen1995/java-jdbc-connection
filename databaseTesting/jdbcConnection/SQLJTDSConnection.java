package jdbcConnection;

import java.sql.Connection;
import java.sql.DriverManager;

public class SQLJTDSConnection {
	public static Connection getMySQLConnection() {
		//hostname : IP public
		String hostName = "localhost";
		String sqlInstanceName = "SQLEXPRESS";
		String database = "automationfc";
		String userName = "sa";
		String password = "Luong1995@";
		return getMySQLConnection(hostName, sqlInstanceName,database, userName, password);
	}
	
	private static Connection getMySQLConnection (String hostName, String sqlInstanceName ,String database, String userName, String password) {
		Connection conn = null;
		try {
			//Cấu trúc URL Connection dành cho SQL Server
			//Ví dụ : jdbc:sqlserver://localhost:1433/automationfc;instance=SQLEXPRESS
			String connectionUrl = "jdbc:jtds:sqlserver://"+ hostName + ":1433/" + database +";instance=" + sqlInstanceName;
			conn = DriverManager.getConnection(connectionUrl, userName, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
}

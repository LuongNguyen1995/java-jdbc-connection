package jdbcConnection;

import java.sql.Connection;
import java.sql.DriverManager;

public class MicroSQLConnection {

	public static Connection getSQLConnection() {
		// hostname : IP public
		String hostName = "localhost";
		String sqlInstanceName = "SQLEXPRESS";
		String database = "automationfc";
		String userName = "sa";
		String password = "Luong1995@";
		return getSQLConnection(hostName, sqlInstanceName, database, userName, password);
	}
	
	private static Connection getSQLConnection (String hostName, String sqlInstanceName ,String database, String userName, String password) {
		Connection conn = null;
		try {
			//Cấu trúc URL Connection dành cho SQL Server
			//Ví dụ : jdbc:sqlserver://localhost:1433;instance=SQLEXPRESS;databaseName==automationfc
			String connectionUrl = "jdbc:sqlserver://"+ hostName + ":1433" +";instance=" + sqlInstanceName + ";databaseName="+ database;
			conn = DriverManager.getConnection(connectionUrl, userName, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
}

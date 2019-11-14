package doubandao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAOBASE implements DAO{

		public Connection getConnection() {
			// TODO Auto-generated method stub
			Connection conn = null;
			try {
			   Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			   String url = "jdbc:sqlserver://127.0.0.1:1433;databaseName=DouBan;user=exp;password=123456";
			   conn = DriverManager.getConnection(url);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
		    } catch (SQLException e) {
		    	e.printStackTrace();
		    }return conn;
		}
	
}

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcUtil {

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver is registered");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static Connection getDBConnection() throws SQLException {

		String url = "jdbc:mysql://localhost:3306/register";
		String username = "root";
		String password = "021105";

		return DriverManager.getConnection(url, username, password);
	}

	public static void closeResources(Connection connect, Statement stmt) throws SQLException {
		if (connect != null)
			connect.close();

		if (stmt != null)
			stmt.close();
	}

}

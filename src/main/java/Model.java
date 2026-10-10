import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Model {
	private String uname;
	private String password;
	private String email;
	private String ucity;
	private Connection connect = null;
	private PreparedStatement pstmnt = null;
	private int row;

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getpassword() {
		return password;
	}

	public void setpassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUcity() {
		return ucity;
	}

	public void setUcity(String ucity) {
		this.ucity = ucity;
	}

	public int register() {
		try {
			connect = JdbcUtil.getDBConnection();
			String sql = "INSERT INTO users ( uname, email, password, ucity) VALUES(?,?,?,?)";
			pstmnt = connect.prepareStatement(sql);
			pstmnt.setString(1, uname);
			pstmnt.setString(2, email);
			pstmnt.setString(3, password);
			pstmnt.setString(4, ucity);

			row = pstmnt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		finally {
			try {
				JdbcUtil.closeResources(connect, pstmnt);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return row;
	}

}

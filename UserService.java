package TheFinder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Vector;

public class UserService {
	 public Vector <User> users;
	User user = new User();
	
	UserService() {
		users.addElement(user);
	}
	
    public boolean register(String ID, String Name, String Phone, String Address, String Email, String Password) {
    	
    	boolean flag = false;
        String sql = "INSERT INTO User(ID,Name,Phone,Address,Email,Password) VALUES(?,?,?,?,?,?)";
 
        try (Connection conn = welcomeForm.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, ID);
            pstmt.setString(2, Name);
            pstmt.setString(3, Phone);
            pstmt.setString(4, Address);
            pstmt.setString(5, Email);
            pstmt.setString(6, Password);
            pstmt.executeUpdate();
            flag = true;
        } catch (SQLException e) {
			flag = false;
        }
        return flag;
    }

	public boolean login(String ID, String Password) {

		boolean flag = false;
		String sqli = "INSERT INTO User(ID,Name,Phone,Address,Email,Password) VALUES(?,?,?,?,?,?)";
		String sqld = "DELETE FROM User WHERE ID = ?";

		try (Connection coni = welcomeForm.connect();
				PreparedStatement pstmti = coni.prepareStatement(sqli)) {

			pstmti.setString(1, ID);
			pstmti.setString(2, "-");
			pstmti.setString(3, "-");
			pstmti.setString(4, "-");
			pstmti.setString(5, "-");
			pstmti.setString(6, Password);
			pstmti.executeUpdate();
			flag = false;

			try (Connection cond = welcomeForm.connect();
					PreparedStatement pstmtd = cond.prepareStatement(sqld)) {   

				pstmtd.setString(1, ID);
				pstmtd.executeUpdate();

			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}

		} catch (SQLException e) {
			flag = true;
		}
		return flag;
	}

	
}

package TheFinder;
import java.util.Vector;
public class User {
	
	private String userID;
	private String name;
	private String phone;
	private String address;
	private String email;
	private String password;
	 public Vector <UserService> myuserserviceclass;
	public UserService p=new UserService(); 
	
	User() {
		myuserserviceclass.add(p);
	}
	
	public void setUserID(String UID)
	{
		this.userID = UID;
	}
	public void setName(String n)
	{
		this.name = n;
	}
	public void setPhone(String p)
	{
		this.phone = p;
	}
	public void setAddress(String a)
	{
		this.address = a;
	}
	public void setEmail(String e)
	{
		this.email = e;
	}
	public void setPassword(String pass)
	{
		this.password = pass;
	}

	public String getUserID()
	{
		return this.userID;
	}
	public String getName()
	{
		return this.name;
	}
	public String getPhone()
	{
		return this.phone;
	}
	public String getAddress()
	{
		return this.address;
	}
	public String getEmail()
	{
		return this.email;
	}
	public String getPassword()
	{
		return this.password;
	}
	
}

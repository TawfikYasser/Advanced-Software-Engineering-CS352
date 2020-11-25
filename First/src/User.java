import java.util.ArrayList;

public class User {

	
	String username,email,password,phone,role;
	boolean status;
	ArrayList<User> users = new ArrayList<User>();

	public User(String username, String email, String password, String phone, String role, boolean status) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.role = role;
		this.status = status;
	}
	
	public User() {
		
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	
	

	
}

package entities;

public class Users {
	private String userName;
	private String passWord;
	private String email;
	private String firstName;
	private String lastName;
	
	public Users (String userName, String passWord, String email, String firstName, String lastName) {
		this.userName = userName;
		this.passWord = passWord;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public Users (String userName, String firstName, String lastName, String email) {
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public String getUserName() {
		return userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public String getEmail() {
		return email;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}
}

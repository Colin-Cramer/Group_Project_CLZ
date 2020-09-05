package entities;

public class Users {
	private String userName;
	private String passWord;
	private String email;
	private String firstName;
	private String lastName;
	
	public Users (String userName, String passWord, String email, String firstName, String lastName) {
		this.setUserName(userName);
		this.setPassWord(passWord);
		this.setEmail(email);
		this.setFirstName(firstName);
		this.setLastName(lastName);
	}
	
	public Users (String firstName, String lastName, String email) {
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setEmail(email);
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}

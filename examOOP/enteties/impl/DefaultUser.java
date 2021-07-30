package examOOP.enteties.impl;

import examOOP.enteties.User;

public class DefaultUser implements User {

	static private int id = 0;

	private String firstName;
	private String lastName;
	private String password;
	private String email;
	private int idUser = 0;

	public DefaultUser() {
		idUser = id++;
	}

	public DefaultUser(String firstName, String lastName, String password, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.email = email;
		idUser = id++;
	}

	@Override
	public String getFirstName() {
		return firstName;
	}

	@Override
	public String getLastName() {
		return lastName;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getEmail() {
		return email;
	}

	@Override
	public String toString() {
		return "User [name=" + firstName + lastName + ", email=" + email + ", password=" + password + "]";
	}

	@Override
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public void setEmail(String newEmail) {
		email = newEmail;
	}

	@Override
	public int getId() {
		return idUser;
	}

	void clearState() {
		this.firstName = "";
		this.lastName = "";
		this.password = "";
		this.email = "";
	}
}

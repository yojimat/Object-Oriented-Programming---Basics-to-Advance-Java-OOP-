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
		return "First Name: " + getFirstName() + "\t\t" +
				"Last Name: " + getLastName() + "\t\t" +
				"Email: " + getEmail();
	}

	@Override
	public void setPassword(String password) {
		if(password == null) return;
		this.password = password;
	}

	@Override
	public void setEmail(String newEmail) {
		if(newEmail == null) return;
		email = newEmail;
	}

	@Override
	public int getId() {
		return idUser;
	}

	void clearState() {
		// Só precisava setar o id para zero T-T
		firstName = "";
		lastName = "";
		password = "";
		email = "";
		id = 0;
	}
}

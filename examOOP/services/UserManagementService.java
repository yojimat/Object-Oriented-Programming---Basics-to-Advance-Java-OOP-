package examOOP.services;

import examOOP.enteties.User;

public interface UserManagementService {

	String registerUser(User user);
	
	User[] getUsers();

	User getUserByEmail(String userEmail);

}

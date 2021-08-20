package examOOP.services.impl;

import java.util.Arrays;

import examOOP.enteties.User;
import examOOP.services.UserManagementService;

public class DefaultUserManagementService implements UserManagementService {

	private static final String NOT_UNIQUE_EMAIL_ERROR_MESSAGE = "This email is already used by another user. Please, use another email";
	private static final String EMPTY_EMAIL_ERROR_MESSAGE = "You have to input email to register. Please, try one more time";
	private static final String NO_ERROR_MESSAGE = "";

	private static final int DEFAULT_USERS_CAPACITY = 10;

	private static DefaultUserManagementService instance;
	private int lastIndexAdded;

	private User[] users;

	{
		users = new User[DEFAULT_USERS_CAPACITY];
	}

	private DefaultUserManagementService() {
	}

	@Override
	public String registerUser(User user) {
		String userEmail = user.getEmail();

		if (userEmail.isEmpty()) {
			return EMPTY_EMAIL_ERROR_MESSAGE;
		}

		if (getUserByEmail(userEmail) != null) {
			return NOT_UNIQUE_EMAIL_ERROR_MESSAGE;
		}
		addUser(user);
		return NO_ERROR_MESSAGE;
	}

	public static UserManagementService getInstance() {
		if (instance == null) {
			instance = new DefaultUserManagementService();
		}
		return instance;
	}

	@Override
	public User[] getUsers() {
		int nonNullUsers = 0;
		for (User user : users) {
			if (user != null) {
				nonNullUsers++;
			}
		}

		User[] filteredUsers = new User[nonNullUsers];
		int index = 0;
		for (User user : users) {
			if (user != null) {
				filteredUsers[index++] = user;
			}
		}
		return filteredUsers;
	}

	@Override
	public User getUserByEmail(String userEmail) {
		User[] receivedUsers = getUsers();
		for (User user : receivedUsers) {
			if (user.getEmail().equals(userEmail)) {
				return user;
			}
		}
		return null;
	}

	void clearServiceState() {
		users = new User[DEFAULT_USERS_CAPACITY];
		lastIndexAdded = 0;
		instance = null;
	}

	private void addUser(User user) {
		if (user == null)
			return;
		if (users.length <= lastIndexAdded) {
			users = Arrays.copyOf(users, users.length * 2);
		}
		users[lastIndexAdded++] = user;
	}
}

package examOOP.menu.impl;

import java.util.Scanner;

import examOOP.configs.ApplicationContext;
import examOOP.enteties.User;
import examOOP.menu.Menu;
import examOOP.services.UserManagementService;
import examOOP.services.impl.DefaultUserManagementService;

public class SignInMenu implements Menu {

	private ApplicationContext context;
	private UserManagementService userManagementService;

	{
		context = ApplicationContext.getInstance();
		userManagementService = DefaultUserManagementService.getInstance();
	}

	@Override
	public void start() {
		printMenuHeader();
		String[] credentialsPair = getUserInfo();
		User savedUser = userManagementService.getUserByEmail(credentialsPair[0]);

		if (savedUser != null && userCredentialsAreCorrect(credentialsPair[1], savedUser)) {
			context.setLoggedInUser(savedUser);
			System.out.println("Glad to see you back" + savedUser.getFirstName() + savedUser.getLastName());
		} else
			System.out.println("Unfortunately, such login and password doesn't exist.");

		context.getMainMenu().start();
	}

	@Override
	public void printMenuHeader() {
		System.out.println("Welcome to the Sign In Menu");
	}

	private String getInput() {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		return input;
	}

	private String[] getUserInfo() {
		String[] questionsArray = { "Enter your email:", "Enter your password:" };
		String email = "", password = "";
		int phase = 0;
		while (phase < questionsArray.length) {
			switch (phase) {
				case 0:
					System.out.println(questionsArray[phase]);
					email = getInput();
					phase += 1;
					break;
				case 1:
					System.out.println(questionsArray[phase]);
					password = getInput();
					phase += 1;
					break;
				default:
					break;
			}
		}

		return new String[] { email, password };
	}

	private boolean userCredentialsAreCorrect(String password, User savedUser) {
		if (savedUser.getPassword().equals(password))
			return true;
		return false;
	}

}

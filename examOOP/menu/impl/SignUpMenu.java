package examOOP.menu.impl;

import java.util.Scanner;

import examOOP.configs.ApplicationContext;
import examOOP.enteties.User;
import examOOP.enteties.impl.DefaultUser;
import examOOP.menu.Menu;
import examOOP.services.UserManagementService;
import examOOP.services.impl.DefaultUserManagementService;

public class SignUpMenu implements Menu {

	private UserManagementService userManagementService;
	private ApplicationContext context;

	{
		userManagementService = DefaultUserManagementService.getInstance();
		context = ApplicationContext.getInstance();
	}

	@Override
	public void start() {
		printMenuHeader();
		User newUser = getUserInfo();
		String errorMessage = userManagementService.registerUser(newUser);

		if (errorMessage.isEmpty()) {
			System.out.println("New user is created");
			context.setLoggedInUser(newUser);
		} else
			System.out.println(errorMessage);

		context.getMainMenu().start();
	}

	@Override
	public void printMenuHeader() {
		System.out.println("Welcome to the Sign Up Menu");
	}

	private String getInput() {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		return input;
	}

	private User getUserInfo() {
		String[] questionsArray = { "Enter your first name:", "Enter your last name:", "Enter your password:",
				"Enter your email:" };
		String name = "", lastName = "", password = "", email = "";
		int phase = 0;
		while (phase < questionsArray.length) {
			switch (phase) {
				case 0:
					System.out.println(questionsArray[phase]);
					name = getInput();
					phase += 1;
					break;
				case 1:
					System.out.println(questionsArray[phase]);
					lastName = getInput();
					phase += 1;
					break;
				case 2:
					System.out.println(questionsArray[phase]);
					password = getInput();
					phase += 1;
					break;
				case 3:
					System.out.println(questionsArray[phase]);
					email = getInput();
					phase += 1;
					break;
				default:
					break;
			}
		}

		User newUser = new DefaultUser(name, lastName, password, email);
		return newUser;
	}
}

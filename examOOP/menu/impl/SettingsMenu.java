package examOOP.menu.impl;

import java.util.Scanner;

import examOOP.configs.ApplicationContext;
import examOOP.menu.Menu;

public class SettingsMenu implements Menu {

	private static final String SETTINGS = "1. Change Password" + System.lineSeparator()
			+ "2. Change Email";

	private ApplicationContext context;

	{
		context = ApplicationContext.getInstance();
	}

	@Override
	public void start() {
		if (context.getLoggedInUser() == null) {
			System.out.println("Please, log in or create new account to change your account settings.");
			context.getMainMenu().start();
			return;
		}
		printMenuHeader();
		selectMenuItem();
	}

	@Override
	public void printMenuHeader() {
		System.out.println("Settings Menu");
		System.out.println(SETTINGS);
	}

	private void changePassword() {
		System.out.println("Enter new password:");
		Scanner scanner = new Scanner(System.in);
		String password = scanner.nextLine();
		context.getLoggedInUser().setPassword(password);
		System.out.println("Your password has been successfully changed.");
		context.getMainMenu().start();
	}

	private void changeEmail() {
		System.out.println("Enter new email:");
		Scanner scanner = new Scanner(System.in);
		String email = scanner.nextLine();
		context.getLoggedInUser().setEmail(email);
		System.out.println("Your email has been successfully changed.");
		context.getMainMenu().start();
	}

	private void selectMenuItem() {
		Scanner scanner = new Scanner(System.in);
		String choosenOption = scanner.nextLine();
		switch (choosenOption) {
			case "1":
				changePassword();
				break;
			case "2":
				changeEmail();
				break;
			case "menu":
				context.getMainMenu().start();
				break;
			default:
				System.out.println("Only 1, 2 is allowed. Try one more time");
				start();
				break;
		}
		scanner.close();
	}
}

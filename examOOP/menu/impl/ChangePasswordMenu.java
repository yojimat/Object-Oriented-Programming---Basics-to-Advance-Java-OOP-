package examOOP.menu.impl;

import java.util.Scanner;

import examOOP.configs.ApplicationContext;
import examOOP.menu.Menu;

public class ChangePasswordMenu implements Menu {
	
	private ApplicationContext context;
	
	{
		context = ApplicationContext.getInstance();
	}

	@Override
	public void start() {
		printMenuHeader();
		changePassword();
		System.out.println("Your password has been successfully changed.");
		context.getMainMenu().start();
	}

	@Override
	public void printMenuHeader() {
		System.out.println("Enter new password:");
	}

	private void changePassword() {
		Scanner scanner = new Scanner(System.in);
		String password = scanner.next();
		context.getLoggedInUser().setPassword(password);
	}
}

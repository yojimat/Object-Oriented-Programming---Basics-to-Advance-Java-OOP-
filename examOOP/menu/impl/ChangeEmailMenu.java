package examOOP.menu.impl;

import java.util.Scanner;

import examOOP.configs.ApplicationContext;
import examOOP.menu.Menu;


// Esqueci totalmente deste menu, mas de acordo com a solução ele faz todo sentido semântico
public class ChangeEmailMenu implements Menu {

	private ApplicationContext context;

	{
		context = ApplicationContext.getInstance();
	}

	@Override
	public void start() {
		printMenuHeader();
		changeEmail();	
		System.out.println("Your email has been successfully changed.");
		context.getMainMenu().start();
	}

	@Override
	public void printMenuHeader() {
		System.out.println("Enter new email:");
	}

	private void changeEmail() {
		Scanner scanner = new Scanner(System.in);
		String email = scanner.nextLine();
		context.getLoggedInUser().setEmail(email);
	}
}

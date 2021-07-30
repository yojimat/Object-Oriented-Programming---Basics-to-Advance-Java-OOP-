package examOOP.menu.impl;

import java.util.Scanner;

import examOOP.Main;
import examOOP.configs.ApplicationContext;
import examOOP.menu.Menu;

public class MainMenu implements Menu {

	public static final String MENU_COMMAND = "menu";

	private static final String MAIN_MENU_TEXT_FOR_LOGGED_OUT_USER = "Please, enter number in console to proceed."
			+ System.lineSeparator() + "1. Sign Up" + System.lineSeparator() + "2. Sign In" + System.lineSeparator()
			+ "3. Product Catalog" + System.lineSeparator() + "4. My Orders" + System.lineSeparator() + "5. Settings"
			+ System.lineSeparator() + "6. Customer List";

	private static final String MAIN_MENU_TEXT_FOR_LOGGED_IN_USER = "Please, enter number in console to proceed."
			+ System.lineSeparator() + "1. Sign Up" + System.lineSeparator() + "2. Sign Out" + System.lineSeparator()
			+ "3. Product Catalog" + System.lineSeparator() + "4. My Orders" + System.lineSeparator() + "5. Settings"
			+ System.lineSeparator() + "6. Customer List";

	private ApplicationContext context;

	{
		context = ApplicationContext.getInstance();
	}

	@Override
	public void start() {
		context.setMainMenu(this);
		printMenuHeader();
		Scanner sc = new Scanner(System.in);
		String command = sc.nextLine();

		if (command.equals(Main.EXIT_COMMAND)) {
			System.exit(0);
		}

		selectMenuItem(command);
		sc.close();
	}

	@Override
	public void printMenuHeader() {
		if (context.getLoggedInUser() == null)
			System.out.println(MAIN_MENU_TEXT_FOR_LOGGED_OUT_USER);
		else
			System.out.println(MAIN_MENU_TEXT_FOR_LOGGED_IN_USER);

	}

	private void selectMenuItem(String command) {
		switch (command) {
			case "1":
				new SignUpMenu().start();
				break;
			case "2":
				if (context.getLoggedInUser() == null)
					new SignInMenu().start();
				else
					new SignOutMenu().start();
				break;
			default:
				System.out.println("Only 1, 2, 3, 4, 5 is allowed. Try one more time.");
				start();
				break;
		}
	}

}

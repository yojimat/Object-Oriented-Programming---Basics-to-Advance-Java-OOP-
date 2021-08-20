package examOOP.menu.impl;

import examOOP.configs.ApplicationContext;
import examOOP.enteties.User;
import examOOP.menu.Menu;
import examOOP.services.UserManagementService;
import examOOP.services.impl.DefaultUserManagementService;

public class CustomerListMenu implements Menu {

	private ApplicationContext context;
	private UserManagementService userManagementService;

	{
		userManagementService = DefaultUserManagementService.getInstance();
		context = ApplicationContext.getInstance();
	}

	@Override
	public void start() {
		printMenuHeader();
		printCustomerList();
		context.getMainMenu().start();
	}

	@Override
	public void printMenuHeader() {
		System.out.println("Customer List Menu");

	}

	private void printCustomerList() {
		User[] users = userManagementService.getUsers();

		if (users.length == 0) {
			System.out.println("No customers");
			return;
		}

		for (User user : users) {
			System.out.println(user);
		}
	}
}

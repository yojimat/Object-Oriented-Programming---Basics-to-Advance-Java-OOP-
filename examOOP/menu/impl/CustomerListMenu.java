package examOOP.menu.impl;

import examOOP.configs.ApplicationContext;
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
		// <write your code here>
	}

	@Override
	public void printMenuHeader() {
		// <write your code here>	
	}

}

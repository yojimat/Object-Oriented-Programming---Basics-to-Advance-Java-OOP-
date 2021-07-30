package examOOP.menu.impl;

import examOOP.configs.ApplicationContext;
import examOOP.menu.Menu;
import examOOP.services.ProductManagementService;
import examOOP.services.impl.DefaultProductManagementService;

public class ProductCatalogMenu implements Menu {

	private static final String CHECKOUT_COMMAND = "checkout";
	private ApplicationContext context;
	private ProductManagementService productManagementService;

	{
		context = ApplicationContext.getInstance();
		productManagementService = DefaultProductManagementService.getInstance();
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

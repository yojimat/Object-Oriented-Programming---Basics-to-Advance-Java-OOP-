package examOOP.menu.impl;

import examOOP.configs.ApplicationContext;
import examOOP.enteties.Order;
import examOOP.enteties.User;
import examOOP.menu.Menu;
import examOOP.services.OrderManagementService;
import examOOP.services.impl.DefaultOrderManagementService;

public class MyOrdersMenu implements Menu {

	private ApplicationContext context;
	private OrderManagementService orderManagementService;

	{
		context = ApplicationContext.getInstance();
		orderManagementService = DefaultOrderManagementService.getInstance();
	}

	@Override
	public void start() {
		printMenuHeader();
		User loggedInUser = context.getLoggedInUser();
		if (loggedInUser != null) {
			getAllPurchaseOrders(loggedInUser.getId());
		} else {
			System.out.println("Please, log in or create a new account to see the list of your orders.");
		}

		context.getMainMenu().start();
	}

	@Override
	public void printMenuHeader() {
		System.out.println("My orders");
	}

	private void getAllPurchaseOrders(int userId) {
		Order[] orders = orderManagementService.getOrdersByUserId(userId);

		if (orders.length <= 0) {
			System.out.println("Unfortunately, you dont'have any orders yet. Navigate back to main menu to place a new order.");
		}

		for(Order order : orders) {
			System.out.println(order);
		}
	}
}

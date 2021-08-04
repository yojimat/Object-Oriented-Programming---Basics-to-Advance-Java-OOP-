package examOOP.menu.impl;

import java.util.InputMismatchException;
import java.util.Scanner;

import examOOP.configs.ApplicationContext;
import examOOP.enteties.Order;
import examOOP.enteties.impl.DefaultOrder;
import examOOP.menu.Menu;
import examOOP.services.OrderManagementService;
import examOOP.services.impl.DefaultOrderManagementService;

public class CheckoutMenu implements Menu {

	private ApplicationContext context;
	private OrderManagementService orderManagementService;

	{
		context = ApplicationContext.getInstance();
		orderManagementService = DefaultOrderManagementService.getInstance();
	}

	@Override
	public void start() {
		printMenuHeader();

		if (createOrder()) {
			context.getSessionCart().clear();
			System.out.println("Thanks a lot for your purchase. Details about order delivery are sent to your email.");
		} else {
			System.out.println(
					"You entered a invalid credit card number. A valid credit card should contain 16 digits. Please, try one more time");
			start();
			return;
		}

		context.getMainMenu().start();
	}

	@Override
	public void printMenuHeader() {
		System.out
				.println("Enter your credit card number without spaces and press enter if you confirm your purchase.");
	}

	private boolean createOrder() {
		Scanner sc = new Scanner(System.in);
		String creditCardNumber = sc.nextLine();
		Order newOrder = new DefaultOrder();
		boolean orderCreated = false;

		if (newOrder.isCreditCardNumberValid(creditCardNumber)) {
			newOrder.setCreditCardNumber(creditCardNumber);
			newOrder.setCustomerId(context.getLoggedInUser().getId());
			newOrder.setProducts(context.getSessionCart().getProducts());

			orderManagementService.addOrder(newOrder);
			orderCreated = true;
		}

		return orderCreated;
	}
}

package examOOP.menu.impl;

import java.util.Scanner;

import examOOP.configs.ApplicationContext;
import examOOP.enteties.Cart;
import examOOP.enteties.Product;
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
		printMenuHeader();
		printProducts();
		Scanner sc = new Scanner(System.in);

		System.out
				.println("Enter product id to add it to the cart or 'menu' if you want to navigate back to main menu.");

		String command = sc.nextLine();

		if (command.equals(MainMenu.MENU_COMMAND)) {
			context.getMainMenu().start();
		}

		addProductToCart(command);

		if (command.equals(CHECKOUT_COMMAND)) {
			// TODO
		}

		sc.close();
	}

	@Override
	public void printMenuHeader() {
		System.out.println("Welcome to Product Catalog Menu");
	}

	private void printProducts() {
		Product[] products = productManagementService.getProducts();
		for (Product product : products) {
			System.out.println(product.toString());
		}
	}

	private void addProductToCart(String command) {
		try {
			int productId = Integer.parseInt(command);
			Product productToAdd = productManagementService.getProductById(productId);

			if (productToAdd == null) {
				System.out.println(
						"Please, enter product ID if you want to add product to cart. Or enter 'checkout' if you want to proceed with checkout. Or enter 'menu' if you want to navigate back to the main menu.");
			} else {
				Cart cart = context.getSessionCart();
				cart.addProduct(productToAdd);

				System.out.println("Product " + productToAdd.getProductName()
						+ " has been added to your cart. If you want to add a new product - enter the product id. If you want to proceed with checkout - enter word 'checkout' to console.");
			}
		} catch (NumberFormatException e) {
			System.out.println("Please enter a correct id.");
		}
		start();
	}
}

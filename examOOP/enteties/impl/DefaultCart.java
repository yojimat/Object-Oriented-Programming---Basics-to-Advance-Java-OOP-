package examOOP.enteties.impl;

import java.util.Arrays;

import examOOP.enteties.Cart;
import examOOP.enteties.Product;

public class DefaultCart implements Cart {

	private static final int DEFAULT_PRODUCTS_CAPACITY = 10;

	private Product[] products;
	private int lastIndexAdded;

	{
		products = new Product[DEFAULT_PRODUCTS_CAPACITY];
	}

	@Override
	public boolean isEmpty() {
		// <write your code here>

		return true;
	}

	@Override
	public void addProduct(Product product) {
		if (product == null)
			return;
		if (products.length <= lastIndexAdded) {
			products = Arrays.copyOf(products, products.length * 2);
		}
		products[lastIndexAdded++] = product;
	}

	@Override
	public Product[] getProducts() {
		int nonNullProducts = 0;
		for (Product product : products) {
			if (product != null)
				nonNullProducts++;
		}

		Product[] filteredProducts = new Product[nonNullProducts];
		int index = 0;
		for (Product product : products) {
			if (product != null)
				filteredProducts[index++] = product;
		}

		return filteredProducts;
	}

	@Override
	public void clear() {
		// <write your code here>
	}

}

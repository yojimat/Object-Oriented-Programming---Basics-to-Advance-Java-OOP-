package examOOP.enteties.impl;

import examOOP.enteties.Order;
import examOOP.enteties.Product;

public class DefaultOrder implements Order {

	private static final int AMOUNT_OF_DIGITS_IN_CREDIT_CARD_NUMBER = 16;

	private String creditCardNumber;
	private Product[] products;
	private int customerId;

	@Override
	public boolean isCreditCardNumberValid(String creditCardNumber) {
		if (creditCardNumber.length() != AMOUNT_OF_DIGITS_IN_CREDIT_CARD_NUMBER) {
			return false;
		}
		for (char charDigit : creditCardNumber.toCharArray()) {
			int digit = Character.getNumericValue(charDigit);
			if(digit < 0 )
				return false;
		}
		return true;
	}

	@Override
	public void setCreditCardNumber(String creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}

	@Override
	public void setProducts(Product[] products) {
		this.products = products;
	}

	@Override
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	@Override
	public int getCustomerId() {
		return this.customerId;
	}

	@Override
	public String toString() {
		return "Order [customerId=" + customerId + ", creditCardNumber=" + creditCardNumber + ", products=" + getStringProducts()
				+ "]";
	}

	private String getStringProducts() {
		StringBuilder output = new StringBuilder();
		for (Product product : products) {
			output.append(String.valueOf(product));
		}

		return output.toString();
	}

}

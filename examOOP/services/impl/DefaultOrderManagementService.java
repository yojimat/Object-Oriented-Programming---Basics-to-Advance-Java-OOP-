package examOOP.services.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import examOOP.enteties.Order;
import examOOP.services.OrderManagementService;

public class DefaultOrderManagementService implements OrderManagementService {

	private static final int DEFAULT_ORDER_CAPACITY = 10;

	private static DefaultOrderManagementService instance;

	private Order[] orders;
	private int lastIndexAdded;

	{
		orders = new Order[DEFAULT_ORDER_CAPACITY];
	}

	public static OrderManagementService getInstance() {
		if (instance == null) {
			instance = new DefaultOrderManagementService();
		}
		return instance;
	}

	@Override
	public void addOrder(Order order) {
		if (order == null)
			return;
		if (orders.length <= lastIndexAdded) {
			orders = Arrays.copyOf(orders, orders.length * 2);
		}
		orders[lastIndexAdded++] = order;
	}

	@Override
	public Order[] getOrdersByUserId(int userId) {
		Order[] ordersToSearch = getOrders();
		List<Order> ordersFound = new ArrayList<Order>();

		for (Order order : ordersToSearch) {
			if (order.getCustomerId() == userId)
				ordersFound.add(order);
		}

		return ordersFound.toArray(new Order[ordersFound.size()]);
	}

	@Override
	public Order[] getOrders() {
		int nonNullOrders = 0;
		for (Order order : orders) {
			if (order != null)
				nonNullOrders++;
		}

		Order[] filteredOrdes = new Order[nonNullOrders];
		int index = 0;
		for (Order order : orders) {
			if (order != null)
				filteredOrdes[index++] = order;
		}

		return filteredOrdes;
	}

	void clearServiceState() {
		// <write your code here>
	}

}

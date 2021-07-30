package examOOP.services;

import examOOP.enteties.Order;

public interface OrderManagementService {

	void addOrder(Order order);

	Order[] getOrdersByUserId(int userId);

	Order[] getOrders();

}

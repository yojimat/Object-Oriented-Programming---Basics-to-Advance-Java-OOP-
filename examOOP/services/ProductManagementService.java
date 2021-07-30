package examOOP.services;

import examOOP.enteties.Product;

public interface ProductManagementService {

	Product[] getProducts();

	Product getProductById(int productIdToAddToCart);

}

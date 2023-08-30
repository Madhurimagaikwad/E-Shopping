package com.velocity.eShopCart.service;

import java.util.List;

import com.velocity.eShopCart.model.Product;

public interface ProductService {

	public Product addProduct(Product product);

	public Product updateProduct(int id);

	public Product getProductById(int id);

	public List<Product> getAllProducts();

	public void deleteProduct(int id);
}

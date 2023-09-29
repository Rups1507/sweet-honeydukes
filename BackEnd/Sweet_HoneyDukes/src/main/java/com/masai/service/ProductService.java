package com.masai.service;

import java.util.List;

import com.masai.model.Product;

public interface ProductService {
	public Product addProduct(Product product);
	public Product updateProduct(Product product);
	public Product cancelProduct(Integer productId);
	public List<Product> showAllProduct();
	public List<Product> showAllProduct(Integer productId);
}

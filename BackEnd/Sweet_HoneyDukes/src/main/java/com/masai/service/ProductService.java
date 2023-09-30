package com.masai.service;

import java.util.List;

import com.masai.exception.NoRecordsFoundException;
import com.masai.model.Product;

public interface ProductService {
	public Product addProduct(Product product)throws NoRecordsFoundException;
	public Product updateProduct(Product product)throws NoRecordsFoundException;
	public Product cancelProduct(Integer productId)throws NoRecordsFoundException;
	public List<Product> showAllProduct()throws NoRecordsFoundException;
	public List<Product> showAllProduct(Integer productId)throws NoRecordsFoundException;
}

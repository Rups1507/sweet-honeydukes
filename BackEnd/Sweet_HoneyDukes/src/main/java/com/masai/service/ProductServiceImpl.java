package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.NoRecordsFoundException;

import com.masai.model.Product;
import com.masai.repository.CategoryRepo;
import com.masai.repository.ProductRepo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepo productRepo;
	
	
@Override
public Product addProduct(Product product) throws NoRecordsFoundException {
	productRepo.save(product);
	return product;
  
}


@Override
public Product updateProduct(Product product) throws NoRecordsFoundException {
	Optional<Product> op = productRepo.findById(product.getProductid());
	if(op.isPresent()) {
		productRepo.save(product);
		return product;
	}
	else {
		throw new NoRecordsFoundException("No Product available with productId: "+product.getProductid());
	}
	
}




@Override
public Product cancelProduct(Integer productId) throws NoRecordsFoundException {
	Optional<Product> op = productRepo.findById(productId);
	if(op.isPresent()) {
		productRepo.deleteById(productId);
		return op.get();
	}
	else {
		throw new NoRecordsFoundException("No Product available with productId: "+ productId);
	}
}


@Override
public List<Product> showAllProduct() throws NoRecordsFoundException {
    List<Product> products = productRepo.findAll();
    
    if (products.isEmpty()) {
        throw new NoRecordsFoundException("No products found!");
    }
    
    return products;
}




public Product showAllProduct(Integer productId) throws NoRecordsFoundException  {

	Optional<Product> opt = productRepo.findById(productId);
	if(opt.isPresent()) {
		return opt.get();
	} else {
		throw new NoRecordsFoundException("Product not found!");
	}
	

}




	
	

}

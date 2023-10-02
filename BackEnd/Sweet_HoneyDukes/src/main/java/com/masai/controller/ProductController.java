package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.NoRecordsFoundException;
import com.masai.model.Product;
import com.masai.service.ProductService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	
	@PostMapping("/add")
	public ResponseEntity<Product> addProductHandler(@Valid @RequestBody Product product) throws NoRecordsFoundException {
		
		Product savedProduct = productService.addProduct(product);
		
		return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
	}
	
	
	@PutMapping("/update")
	public ResponseEntity<Product> updateProductHandler(@RequestBody Product product) throws NoRecordsFoundException {
		
		Product updatedProduct = productService.updateProduct(product);
		
		return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
	}
	
	
	@DeleteMapping("/delete/{productId}")
	public ResponseEntity<Product> deleteProductHandler(@PathVariable("productId") Integer productId) throws NoRecordsFoundException {
		
		Product p = productService.cancelProduct(productId);
		
		return new ResponseEntity<>(p, HttpStatus.OK);
	}
	
	
	@GetMapping("/{productId}")
	public ResponseEntity<Product> showProductById(@PathVariable("productId") Integer productId) throws NoRecordsFoundException {
		
		Product p = productService.showAllProduct(productId);
		
		return new ResponseEntity<>(p, HttpStatus.OK);
	}


	
}
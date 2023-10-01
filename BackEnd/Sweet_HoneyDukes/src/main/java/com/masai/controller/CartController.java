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
import com.masai.model.Cart;
import com.masai.model.Product;
import com.masai.service.CartService;

@RestController
@RequestMapping("cart")
public class CartController {

	
	@Autowired
	private CartService cartService;
	
	@PostMapping("/add")
	public ResponseEntity<Cart> addCard(@RequestBody Cart cart)
	{
		Cart c=cartService.addCart(cart);
		
		return new ResponseEntity<>(c,HttpStatus.ACCEPTED);
		
	}
	
	@PutMapping("/update")
	public ResponseEntity<Cart> updateCard(@RequestBody Cart cart) throws NoRecordsFoundException
	{
		Cart c=cartService.updateCart(cart);
		
		return new ResponseEntity<>(c,HttpStatus.ACCEPTED);
		
	}
	
	@DeleteMapping("/delete/{cartId}")
	public ResponseEntity<String> deleteCart(@PathVariable("cartId") Integer cartId) throws NoRecordsFoundException {
	    return new ResponseEntity<>("Cart with ID " + cartId + " has been deleted", HttpStatus.ACCEPTED);
        
	}
	
	@GetMapping("/carts/allcarts")
	public ResponseEntity<List<Cart>> allListOfCart() throws NoRecordsFoundException{
		
	       List<Cart> carts =cartService.showAllCart();
		
		if(!carts.isEmpty())
		{
			return new ResponseEntity<>(carts,HttpStatus.OK);
		}
		else
		{
			throw new NoRecordsFoundException("Carts List is Empty");
		}
	}
	

}

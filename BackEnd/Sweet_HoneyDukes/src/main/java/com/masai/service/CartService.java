package com.masai.service;

import java.util.List;

import com.masai.model.Cart;

public interface CartService {
	public Cart addCart(Cart cart);
	public Cart updateCart(Cart cart); 
	public Cart cancelCart(Integer cartId);
	public List<Cart> showAllCart();
	public List<Cart> showAllCart(Integer cartId);
}

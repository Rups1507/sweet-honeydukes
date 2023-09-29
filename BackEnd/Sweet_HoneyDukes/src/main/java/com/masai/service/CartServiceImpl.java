package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.masai.exception.NoRecordsFoundException;
import com.masai.model.Cart;
import com.masai.repository.CartRepo;

public class CartServiceImpl implements CartService {
	
	@Autowired
	private CartRepo cartRepo;
	
	@Override
	public Cart addCart(Cart cart) {
		cartRepo.save(cart);
		return cart;
	}

	@Override
	public Cart updateCart(Cart cart) throws NoRecordsFoundException {
		Optional<Cart> op = cartRepo.findById(cart.getCartId());
		if(op.isPresent()) {
			cartRepo.save(op.get());
			return cart;
		}
		else {
			throw new NoRecordsFoundException("No Cart available with cartId: "+cart.getCartId());
		}
		
	}

	@Override
	public Cart cancelCart(Integer cartId) throws NoRecordsFoundException {
		Optional<Cart> op = cartRepo.findById(cartId);
		if(op.isPresent()) {
			cartRepo.deleteById(cartId);
			return op.get();
		}
		else {
			throw new NoRecordsFoundException("No Cart available with cartId: "+ cartId);
		}
	}

	@Override
	public List<Cart> showAllCart() throws NoRecordsFoundException {
		List<Cart> cart = cartRepo.findAll();
		if(!cart.isEmpty())
			return cart;
		throw new NoRecordsFoundException("No Cart available");
	}

	@Override
	public List<Cart> showAllCart(Integer cartId) throws NoRecordsFoundException {
		Optional<Cart> op = cartRepo.findById(cartId);
		if(op.isPresent()) {
			List<Cart> list = null;
			 list.add(op.get());
			 return list;
		}
		else {
			throw new NoRecordsFoundException("No Cart availabe with cartId: "+ cartId);
		}
		
	
	}

}

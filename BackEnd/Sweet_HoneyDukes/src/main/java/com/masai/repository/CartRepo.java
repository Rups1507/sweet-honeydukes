package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.model.Cart;

public interface CartRepo extends JpaRepository<Cart, Integer> {

}

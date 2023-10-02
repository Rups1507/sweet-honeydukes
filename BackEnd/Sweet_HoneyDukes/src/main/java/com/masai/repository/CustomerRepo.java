package com.masai.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.model.Customer;
import com.masai.model.Product;

public interface CustomerRepo extends JpaRepository<Customer, Integer> {

	


}

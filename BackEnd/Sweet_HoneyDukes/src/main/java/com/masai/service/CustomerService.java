package com.masai.service;

import java.util.List;

import com.masai.model.Customer;

public interface CustomerService {
	public Customer addCustomer(Customer customer);
	public Customer updateCustomer(Customer customer);
	public Customer cancelCustomer(Integer customerId);
	public List<Customer> showAllCustomer();
	
	//check with IA 
	public List<Customer> showAllCustomer(Integer customerId);
}

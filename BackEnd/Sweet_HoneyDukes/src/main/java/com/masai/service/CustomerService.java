package com.masai.service;

import java.util.List;

import com.masai.exception.NoRecordsFoundException;
import com.masai.model.Customer;

public interface CustomerService {
	public Customer addCustomer(Customer customer)throws NoRecordsFoundException;
	public Customer updateCustomer(Customer customer)throws NoRecordsFoundException;
	public Customer cancelCustomer(Integer customerId)throws NoRecordsFoundException;
	public List<Customer> showAllCustomer()throws NoRecordsFoundException;
	
	//check with IA 
	public List<Customer> showAllCustomer(Integer customerId)throws NoRecordsFoundException;
}

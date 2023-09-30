package com.masai.service;

//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.NoRecordsFoundException;
import com.masai.model.Cart;
import com.masai.model.Customer;
import com.masai.model.Product;
import com.masai.repository.CartRepo;
import com.masai.repository.CustomerRepo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerRepo customerRepo;

	@Override
	public Customer addCustomer(Customer customer) throws NoRecordsFoundException {
		customerRepo.save(customer);
		return customer;
	}

	@Override
	public Customer updateCustomer(Customer customer) throws NoRecordsFoundException {
		Optional<Customer> op = customerRepo.findById(customer.getCustomerid());
		if(op.isPresent()) {
			customerRepo.save(op.get());
			return customer;
		}
		else {
			throw new NoRecordsFoundException("No Customer available with customerId: "+customer.getCustomerid());
		}
	}

	@Override
	public Customer cancelCustomer(Integer customerId) throws NoRecordsFoundException {
		Optional<Customer> op = customerRepo.findById(customerId);
		if(op.isPresent()) {
			customerRepo.deleteById(customerId);
			return op.get();
		}
		else {
			throw new NoRecordsFoundException("No Customer available with customerId: "+ customerId);
		}
	}

	@Override
	public List<Customer> showAllCustomer() throws NoRecordsFoundException {
		 List<Customer> customers = customerRepo.findAll();
		    
		    if (customers.isEmpty()) {
		        throw new NoRecordsFoundException("No customers found!");
		    }
		    
		    return customers;
	}

	@Override
	public List<Customer> showAllCustomer(Integer customerId) throws NoRecordsFoundException {
		Optional<Customer> op = customerRepo.findById(customerId);
		if(op.isPresent()) {
			List<Customer> list = null;
			 list.add(op.get());
			 return list;
		}
		else {
			throw new NoRecordsFoundException("No Customer availabe with customerId: "+ customerId);
		}
	}
	


	
	

}
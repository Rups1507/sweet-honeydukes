package com.masai.service;

//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.CustomerException;
import com.masai.model.Customer;
import com.masai.repository.CustomerRepo;

import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerRepo customerRepo;

	@Override
	public Customer addCustomer(Customer customer) throws CustomerException {
		customerRepo.save(customer);
		return customer;
	}

	@Override
	public Customer updateCustomer(Customer customer) throws CustomerException {
		Optional<Customer> op = customerRepo.findById(customer.getCustomerid());
		if(op.isPresent()) {
			customerRepo.save(op.get());
			return customer;
		}
		else {
			throw new CustomerException("No Customer available with customerId: "+customer.getCustomerid());
		}
	}

	@Override
	public Customer cancelCustomer(Integer customerId) throws CustomerException {
		Optional<Customer> op = customerRepo.findById(customerId);
		if(op.isPresent()) {
			customerRepo.deleteById(customerId);
			return op.get();
		}
		else {
			throw new CustomerException("No Customer available with customerId: "+ customerId);
		}
	}

	@Override
	public List<Customer> showAllCustomer() throws CustomerException {
		 List<Customer> customers = customerRepo.findAll();
		    
		    if (customers.isEmpty()) {
		        throw new CustomerException("No customers found!");
		    }
		    
		    return customers;
	}

	@Override
	public Customer showAllCustomer(Integer customerId)throws CustomerException{
		Optional<Customer> opt = customerRepo.findById(customerId);
		if(opt.isPresent()) {
			return opt.get();
		} else {
			throw new CustomerException("Customer not found!");
		}
	}
	


	
	

}

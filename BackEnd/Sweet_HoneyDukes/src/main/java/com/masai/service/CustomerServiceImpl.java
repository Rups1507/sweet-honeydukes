package com.masai.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.model.Customer;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepo customerRepo;
	
	@Autowired
	private CartRepo cartrepo;
	

@Override
public Customer addCustomer(Customer customer) throws CustomerException {
    if (customerRepo.existsByCustomerEmail(customer.getCustomerEmail())) {
        throw new CustomerException("Email id already used");
    }
    log.debug("Calling save method from CustomerJpa Repository");

    customer.setRole("USER");

    Cart cart = new Cart();
    cart.setGrandTotal(0.0);
    cart.setProductCount(0);
    cart.setTotal(0.0);

    cartrepo.save(cart);

    customer.setCart(cart);
    Customer savedCustomer = customerRepo.save(customer);

    log.info("Customer saved successfully");

    return savedCustomer;
}

@Override
public Customer updateCustomer(Customer customer, Integer customerId) throws CustomerException {
    log.debug("Calling findById method from CustomerJpa Repository");
    Optional<Customer> opt = customerRepo.findById(customerId);

    if (opt.isPresent()) {
        Customer existingCustomer = opt.get();
        existingCustomer.setCustomerName(customer.getCustomerName());
        existingCustomer.setSweetOrders(customer.getSweetOrders());
        existingCustomer.setCart(customer.getCart());

        log.info("Customer name, its orders, and its cart updated successfully");
        return existingCustomer;
    } else {
        throw new CustomerException("User with this customerId is not present");
    }
}


@Override
public Customer cancelCustomer(Integer customerId) throws CustomerException {
    log.debug("Calling findById method from CustomerJpa Repository");

    Customer customer = customerRepo.findById(customerId)
            .orElseThrow(() -> new CustomerException("No customer found with this ID"));

    customerRepo.delete(customer);

    log.info("Customer deleted successfully");

    return customer;
}


@Override
public List<Customer> showAllCustomers() throws CustomerException {
    log.debug("Calling findAll method from CustomerJpa Repository");
    List<Customer> customers = customerRepo.findAll();

    if (customers.isEmpty()) {
        log.warn("No customers found in the database.");
        throw new CustomerException("No customer present in the database");
    } else {
        log.info("All customers retrieved successfully.");
        return customers;
    }
}


@Override
public Customer showCustomerById(Integer userId) throws CustomerException {
    log.debug("Calling findById method from CustomerJpa Repository");
    
    Customer customer = customerRepo.findById(userId)
            .orElseThrow(() -> new CustomerException("Customer does not exist"));
    
    log.info("Customer retrieved successfully");
    
    return customer;
}



}

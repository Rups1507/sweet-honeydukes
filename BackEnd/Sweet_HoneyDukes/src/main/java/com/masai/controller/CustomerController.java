package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.CustomerException;
import com.masai.model.Customer;
import com.masai.service.CustomerService;


@RestController
@RequestMapping("/customer")
public class CustomerController {

	
    @Autowired
    private CustomerService customerService;



    @PostMapping("/add")
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) throws CustomerException {
    	Customer c = customerService.addCustomer(customer); 
            return new ResponseEntity<Customer>(c, HttpStatus.ACCEPTED);
    }

	
	   @GetMapping("/update")
	    public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer) throws CustomerException{
	        return new ResponseEntity<>(customerService.updateCustomer(customer),HttpStatus.OK);

	    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Customer> cancelCustomer(@PathVariable("id") Integer id) throws CustomerException{
        return new ResponseEntity<>(customerService.cancelCustomer(id),HttpStatus.OK);

    }


    @GetMapping("/customer/allcustomers")
    public ResponseEntity<List<Customer>> showAllCustomer() throws CustomerException{
        return new ResponseEntity<>(customerService.showAllCustomer(),HttpStatus.OK);

    }

    @GetMapping("/customer/{customerid}")
    public ResponseEntity<Customer> showAllCustomer(@PathVariable("billid") Integer customerId) throws CustomerException {
    	Customer p = customerService.showAllCustomer(customerId);
		
		return new ResponseEntity<>(p, HttpStatus.OK);
	}
 	
	
}

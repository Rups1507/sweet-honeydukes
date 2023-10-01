package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.NoRecordsFoundException;
import com.masai.model.SweetOrder;
import com.masai.service.SweetOrderService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/sweet_order")
public class SweetOrderController {
	
	@Autowired
	private SweetOrderService sweetOrder;
	
	@PostMapping("/add")
	public ResponseEntity<SweetOrder> addSweetOrder(@Valid @RequestBody SweetOrder sweet){
		return new ResponseEntity<SweetOrder>(sweetOrder.addSweetOrder(sweet), HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	public ResponseEntity<SweetOrder> updateSweetOrder(@Valid @RequestBody SweetOrder sweet) throws NoRecordsFoundException{
		return new ResponseEntity<SweetOrder>(sweetOrder.updateSweetOrder(sweet), HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<SweetOrder> deleteCategory(@PathVariable Integer id) throws NoRecordsFoundException{
		return new ResponseEntity<SweetOrder>(sweetOrder.cancelSweetOrder(id), HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<SweetOrder>> getAllCategory() throws NoRecordsFoundException{
		return new ResponseEntity<List<SweetOrder>>(sweetOrder.showAllSweetOrder(), HttpStatus.FOUND);
	}
}

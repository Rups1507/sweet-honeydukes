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
import com.masai.model.SweetItem;
import com.masai.service.SweetItemService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/sweet_items")
public class SweetItemsController {
	@Autowired
	private SweetItemService sweetItem;
	
	@PostMapping("/add")
	public ResponseEntity<SweetItem> addSweetOrder(@Valid @RequestBody SweetItem sweet){
		return new ResponseEntity<SweetItem>(sweetItem.addSweetItem(sweet), HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	public ResponseEntity<SweetItem> updateSweetOrder(@Valid @RequestBody SweetItem sweet) throws NoRecordsFoundException{
		return new ResponseEntity<SweetItem>(sweetItem.updateSweetItem(sweet), HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<SweetItem> deleteCategory(@PathVariable Integer id) throws NoRecordsFoundException{
		return new ResponseEntity<SweetItem>(sweetItem.cancelSweetItem(id), HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<SweetItem>> getAllCategory() throws NoRecordsFoundException{
		return new ResponseEntity<List<SweetItem>>(sweetItem.showAllSweetItem(), HttpStatus.FOUND);
	}
}

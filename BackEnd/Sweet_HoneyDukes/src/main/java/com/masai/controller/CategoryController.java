package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.NoRecordsFoundException;
import com.masai.model.Category;
import com.masai.service.CategoryService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/category")
@CrossOrigin("*")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@PostMapping("/add")
	public ResponseEntity<Category> addCategory(@Valid @RequestBody Category category){
		return new ResponseEntity<Category>(categoryService.addCategory(category), HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Category> updateCategory(@Valid @RequestBody Category category) throws NoRecordsFoundException{
		return new ResponseEntity<Category>(categoryService.updateCategory(category), HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Category> deleteCategory(@PathVariable Integer id) throws NoRecordsFoundException{
		return new ResponseEntity<Category>(categoryService.cancelCategory(id), HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<Category>> getAllCategory() throws NoRecordsFoundException{
		return new ResponseEntity<List<Category>>(categoryService.showAllCategory(), HttpStatus.FOUND);
	}
}

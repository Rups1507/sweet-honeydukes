package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.NoRecordsFoundException;
import com.masai.model.Category;
import com.masai.repository.CategoryRepo;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryRepo categoryRepo;
	
	
	@Override
	public Category addCategory(Category category) {
		categoryRepo.save(category);
		return category;
	}

	@Override
	public Category updateCategory(Category category) throws NoRecordsFoundException {
		Optional<Category> op = categoryRepo.findById(category.getCategoryid());
		
		if(op.isPresent()) {
			categoryRepo.save(category);
			return category;
		}
		else {
			throw new NoRecordsFoundException("No Category with id: " +category.getCategoryid() );
		}
		
	}

	@Override
	public Category cancelCategory(Integer categoryId) throws NoRecordsFoundException {
		Optional<Category> op = categoryRepo.findById(categoryId);
		
		if(op.isPresent()) {
			categoryRepo.deleteById(categoryId);;
			return op.get();
		}
		else {
			throw new NoRecordsFoundException("No Category with id: " +categoryId );
		}
	}

	@Override
	public List<Category> showAllCategory() throws NoRecordsFoundException {
		List<Category> category = categoryRepo.findAll();
		if(!category.isEmpty()) {
			return category;
		}
		else {
			throw new NoRecordsFoundException("No Category found" );
		}
	}

	@Override
	public Double calculateTotalCost(Integer categoryId) {
		// TODO Auto-generated method stub
		return null;
	}

}

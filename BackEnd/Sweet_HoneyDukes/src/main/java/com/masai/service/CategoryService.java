package com.masai.service;

import java.util.List;

import com.masai.exception.NoRecordsFoundException;
import com.masai.model.Category;

public interface CategoryService {
	public Category addCategory(Category category);
	public Category updateCategory(Category category) throws NoRecordsFoundException;
	public Category cancelCategory(Integer categoryId) throws NoRecordsFoundException;
	public List<Category> showAllCategory() throws NoRecordsFoundException;
	public Double calculateTotalCost(Integer categoryId);
}

package com.masai.service;

import java.util.List;

import com.masai.model.Category;

public interface CategoryService {
	public Category addCategory(Category category);
	public Category updateCategory(Category category);
	public Category cancelCategory(Integer categoryId);
	public List<Category> showAllCategory();
	public Double calculateTotalCost(Integer categoryId);
}

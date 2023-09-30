package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.model.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer> {

}

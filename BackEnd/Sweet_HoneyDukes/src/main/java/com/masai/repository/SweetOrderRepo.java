package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.model.SweetOrder;

public interface SweetOrderRepo extends JpaRepository<SweetOrder, Integer> {

}

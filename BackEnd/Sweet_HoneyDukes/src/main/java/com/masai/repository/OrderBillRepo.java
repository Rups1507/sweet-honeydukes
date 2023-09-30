package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.model.OrderBill;

public interface OrderBillRepo extends JpaRepository<OrderBill, Integer> {

}

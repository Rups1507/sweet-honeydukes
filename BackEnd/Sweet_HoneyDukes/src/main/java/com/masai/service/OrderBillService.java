package com.masai.service;

import java.util.List;

import com.masai.model.OrderBill;

public interface OrderBillService {
	public OrderBill addOrderBill(OrderBill orderBill);
	public OrderBill updateOrderBill(OrderBill orderBill);
	public OrderBill cancelOrderBill(Integer orderBillId);
	public List<OrderBill> showAllOrderBill();
	public List<OrderBill> showAllOrderBill(Integer orderBillId);
	
}

package com.masai.service;

import java.util.List;

import com.masai.exception.NoRecordsFoundException;
import com.masai.model.OrderBill;

public interface OrderBillService {
	public OrderBill addOrderBill(OrderBill orderBill);
	public OrderBill updateOrderBill(OrderBill orderBill) throws NoRecordsFoundException;
	public OrderBill cancelOrderBill(Integer orderBillId) throws NoRecordsFoundException;
	public List<OrderBill> showAllOrderBill() throws NoRecordsFoundException;
	public OrderBill showAllOrderBill(Integer orderBillId) throws NoRecordsFoundException;
	
}

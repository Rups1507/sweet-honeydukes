package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.masai.exception.NoRecordsFoundException;
import com.masai.model.OrderBill;
import com.masai.repository.OrderBillRepo;

public class OrderBillServiceImpl implements OrderBillService {
	
	@Autowired
	private OrderBillRepo orderBillRepo;	
	
	@Override
	public OrderBill addOrderBill(OrderBill orderBill) {
		orderBillRepo.save(orderBill);
		return orderBill;
	}

	@Override
	public OrderBill updateOrderBill(OrderBill orderBill) throws NoRecordsFoundException {
		Optional<OrderBill> op = orderBillRepo.findById(orderBill.getOrderBillId());
		if(op.isPresent()) {
			orderBillRepo.save(op.get());
			return op.get();
		}
		throw new NoRecordsFoundException("No Order Bill found with orderBillId: " + orderBill.getOrderBillId());
	}

	@Override
	public OrderBill cancelOrderBill(Integer orderBillId) throws NoRecordsFoundException {
		Optional<OrderBill> op = orderBillRepo.findById(orderBillId);
		if(op.isPresent()) {
			orderBillRepo.deleteById(orderBillId);
			return op.get();
		}
		throw new NoRecordsFoundException("No Order Bill found with orderBillId: " + orderBillId);
	}

	@Override
	public List<OrderBill> showAllOrderBill() throws NoRecordsFoundException {
		List<OrderBill> orderBill = orderBillRepo.findAll();
		if(!orderBill.isEmpty()) {
			return orderBill;
		}
		throw new NoRecordsFoundException("No Order Bill found ");
	}

	@Override
	public List<OrderBill> showAllOrderBill(Integer orderBillId) throws NoRecordsFoundException {
		Optional<OrderBill> op = orderBillRepo.findById(orderBillId);
		if(op.isPresent()) {
			List<OrderBill> list = null;
			list.add(op.get());
			return list;
		}
		throw new NoRecordsFoundException("No Order Bill found with orderBillId: " + orderBillId);
	}

}

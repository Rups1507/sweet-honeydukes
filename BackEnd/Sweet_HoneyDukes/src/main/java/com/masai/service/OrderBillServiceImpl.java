package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.NoRecordsFoundException;
import com.masai.model.OrderBill;
import com.masai.model.Product;
import com.masai.repository.OrderBillRepo;

@Service
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
			orderBillRepo.save(orderBill);
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
	public OrderBill showAllOrderBill(Integer orderBillId) throws NoRecordsFoundException {
		Optional<OrderBill> opt = orderBillRepo.findById(orderBillId);
		if(opt.isPresent()) {
			return opt.get();
		} else {
			throw new NoRecordsFoundException("OrderBill not found!");
		}

}
	
}

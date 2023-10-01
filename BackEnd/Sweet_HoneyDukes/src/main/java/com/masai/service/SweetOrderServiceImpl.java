package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.NoRecordsFoundException;
import com.masai.model.SweetOrder;
import com.masai.repository.SweetOrderRepo;

@Service
public class SweetOrderServiceImpl implements SweetOrderService {
	
	@Autowired
	private SweetOrderRepo sweetOrderRepo;
	
	@Override
	public SweetOrder addSweetOrder(SweetOrder sweetOrder) {
		sweetOrderRepo.save(sweetOrder);
		return sweetOrder;
	}

	@Override
	public SweetOrder updateSweetOrder(SweetOrder sweetOrder) throws NoRecordsFoundException {
	Optional<SweetOrder> op = sweetOrderRepo.findById(sweetOrder.getSweetOrderId());
	if(op.isPresent()) {
		sweetOrderRepo.save(sweetOrder);
		return sweetOrder;
	}
	throw new NoRecordsFoundException("No sweet Order found with sweetOrderId: "+ sweetOrder.getSweetOrderId());
	}

	@Override
	public SweetOrder cancelSweetOrder(Integer sweetOrderId) throws NoRecordsFoundException {
		Optional<SweetOrder> op = sweetOrderRepo.findById(sweetOrderId);
		if(op.isPresent()) {
			sweetOrderRepo.delete(op.get());
			return op.get();
		}
		throw new NoRecordsFoundException("No sweet Order found with sweetOrderId: "+ sweetOrderId);
	}

	@Override
	public List<SweetOrder> showAllSweetOrder() throws NoRecordsFoundException {
		List<SweetOrder> lis = sweetOrderRepo.findAll();
		if(!lis.isEmpty()) {
			return lis;
		}
		throw new NoRecordsFoundException("No sweet Order found ");
	}

	@Override
	public Double calculateTotalCost(Integer sweetOrderId) {
		
		return null;
	}

}

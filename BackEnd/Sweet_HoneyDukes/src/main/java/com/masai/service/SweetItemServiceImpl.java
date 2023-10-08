package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.NoRecordsFoundException;
import com.masai.model.SweetItem;
import com.masai.repository.SweetItemRepo;

@Service
public class SweetItemServiceImpl implements SweetItemService {
	
	@Autowired
	private SweetItemRepo sweetItemRepo;
	
	@Override
	public SweetItem addSweetItem(SweetItem sweetItem) {
		sweetItemRepo.save(sweetItem);
		return sweetItem;
	}

	@Override
	public SweetItem updateSweetItem(SweetItem sweetItem) throws NoRecordsFoundException {
		Optional<SweetItem> op = sweetItemRepo.findById(sweetItem.getOrderItemId());
		if(op.isPresent()) {
			sweetItemRepo.save(sweetItem);
			return op.get();
		}
		throw new NoRecordsFoundException("No sweet Item found for id: "+sweetItem.getOrderItemId());
	}

	@Override
	public SweetItem cancelSweetItem(Integer sweetItemId) throws NoRecordsFoundException {
		Optional<SweetItem> op = sweetItemRepo.findById(sweetItemId);
		if(op.isPresent()) {
			sweetItemRepo.deleteById(sweetItemId);
			return op.get();
		}
		throw new NoRecordsFoundException("No sweet Item found for id: "+sweetItemId);
	}

	@Override
	public List<SweetItem> showAllSweetItem() throws NoRecordsFoundException {
		List<SweetItem> list = sweetItemRepo.findAll();
		if(!list.isEmpty()) {
			return list;
		}
		throw new NoRecordsFoundException("No sweet Item found");
	}

}

package com.masai.service;

import java.util.List;

import com.masai.exception.NoRecordsFoundException;
import com.masai.model.SweetItem;

public interface SweetItemService {
	public SweetItem addSweetItem(SweetItem sweetItem);
	public SweetItem updateSweetItem(SweetItem sweetItem) throws NoRecordsFoundException;
	public SweetItem cancelSweetItem(Integer sweetItemId) throws NoRecordsFoundException;
	public List<SweetItem> showAllSweetItem() throws NoRecordsFoundException;
}

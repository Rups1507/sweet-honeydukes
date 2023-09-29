package com.masai.service;

import java.util.List;

import com.masai.model.SweetItem;

public interface SweetItemService {
	public SweetItem addSweetItem(SweetItem sweetItem);
	public SweetItem updateSweetItem(SweetItem sweetItem);
	public SweetItem cancelSweetItem(Integer sweetItemId);
	public List<SweetItem> showAllSweetItem();
}

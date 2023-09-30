package com.masai.service;

import java.util.List;

import com.masai.model.SweetOrder;


public interface SweetOrderService {
	public SweetOrder addSweetOrder(SweetOrder sweetOrder);
	public SweetOrder updateSweetOrder(SweetOrder sweetOrder);
	public SweetOrder cancelSweetOrder(Integer sweetOrderId);
	public List<SweetOrder> showAllSweetOrder();
	public Double calculateTotalCost(Integer sweetOrderId);
}

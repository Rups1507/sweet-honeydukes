package com.masai.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderBill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderBillId;

    @NotNull(message = "Date should be there")
    private LocalDate orderBill;
    
    @NotNull(message = "Total should not be null")
    private Double totalCost;

    @JsonIgnore
    @OneToOne(mappedBy = "orderBill", cascade = CascadeType.ALL)
    private SweetOrder sweetOrderList;
    
    @JsonIgnore
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Customer customer;

	public OrderBill(Integer orderBillId, LocalDate orderBill, Double totalCost, SweetOrder sweetOrderList,
			Customer customer) {
		super();
		this.orderBillId = orderBillId;
		this.orderBill = orderBill;
		this.totalCost = totalCost;
		this.sweetOrderList = sweetOrderList;
		this.customer = customer;
	}

	public Integer getOrderBillId() {
		return orderBillId;
	}

	public void setOrderBillId(Integer orderBillId) {
		this.orderBillId = orderBillId;
	}

	public LocalDate getOrderBill() {
		return orderBill;
	}

	public void setOrderBill(LocalDate orderBill) {
		this.orderBill = orderBill;
	}

	public Double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(Double totalCost) {
		this.totalCost = totalCost;
	}

	public SweetOrder getSweetOrderList() {
		return sweetOrderList;
	}

	public void setSweetOrderList(SweetOrder sweetOrderList) {
		this.sweetOrderList = sweetOrderList;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "OrderBill [orderBillId=" + orderBillId + ", totalCost=" + totalCost + ", sweetOrderList="
				+ sweetOrderList + ", customer=" + customer + "]";
	}


}


package com.masai.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class SweetOrder {
	public enum OrderStatus {
	    PENDING,
	    PROCESSING,
	    DELIVERED,
	    CANCELLED,
	    RETURNED,
	    REFUNDED,
	    COMPLETED
	}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer sweetOrderId;



    @ManyToOne
    @NotNull
    @JoinColumn(name = "customer_id")
    private Customer customer;


    @JsonIgnore
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "sweetOrder")
    private List<Product> products = new ArrayList<>();
    
    @OneToOne
    private OrderBill orderBill;
    
    @NotNull
    private LocalDateTime date;
    
    @NotNull
    private OrderStatus status = OrderStatus.PENDING;

	public SweetOrder(Integer sweetOrderId, @NotNull Customer customer, List<Product> products, OrderBill orderBill,
			@NotNull LocalDateTime date, @NotNull OrderStatus status) {
		super();
		this.sweetOrderId = sweetOrderId;
		this.customer = customer;
		this.products = products;
		this.orderBill = orderBill;
		this.date = date;
		this.status = status;
	}

	public Integer getSweetOrderId() {
		return sweetOrderId;
	}

	public void setSweetOrderId(Integer sweetOrderId) {
		this.sweetOrderId = sweetOrderId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public OrderBill getOrderBill() {
		return orderBill;
	}

	public void setOrderBill(OrderBill orderBill) {
		this.orderBill = orderBill;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "SweetOrder [sweetOrderId=" + sweetOrderId + ", customer=" + customer + ", products=" + products
				+ ", orderBill=" + orderBill + ", date=" + date + ", status=" + status + "]";
	}


}
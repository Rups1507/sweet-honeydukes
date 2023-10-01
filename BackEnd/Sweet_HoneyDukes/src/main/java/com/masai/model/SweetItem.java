package com.masai.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity


public class SweetItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderItemId;
    private String name;
    private String photoPath;
    private Double price;
    private String description;
    private Boolean available = true;

    @ManyToOne
    private Category category;

    @ManyToOne
    private Cart cart;

    @OneToOne
    private Product product;

	public Integer getOrderItemId() {
		// TODO Auto-generated method stub
		return null;
	}



   
}
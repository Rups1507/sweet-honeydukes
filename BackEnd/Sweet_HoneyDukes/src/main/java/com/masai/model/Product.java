package com.masai.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer productid;
	
	@NotNull(message = "Product name should not be null")
	@Size(min=3, max=40)
	private String name;
	
	@NotNull(message = "Photo is mandatory")
	private String photopath;
	
	@NotNull(message = "Price should be there")
	private Double price;
	
	@NotNull(message = "Please mention desription")
	private String description;
	
	@NotNull(message = "Confirm availability")
	private Boolean available;
	
	private int quantity;

	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL)
	private SweetOrder sweetOrder;
	
	 @JsonIgnore
	  @ManyToMany(mappedBy = "products", cascade = CascadeType.ALL)
	  private List<Cart> carts = new ArrayList<>();
	
    
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private Category category;


	public Integer getProductid() {
		return productid;
	}


//	@Override
//	public String toString() {
//		return "Product [productid=" + productid + ", name=" + name + ", photopath=" + photopath + ", price=" + price
//				+ ", description=" + description + ", available=" + available + ", quantity=" + quantity + "]";
//	}






	


	
	
	

	

	
	
	
	
}
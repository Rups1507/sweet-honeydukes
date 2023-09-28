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
import lombok.NoArgsConstructor;

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


	public Product(Integer productid, String name, String photopath, Double price, String description,
			Boolean available, int quantity, SweetOrder sweetOrder, List<Cart> carts, Category category) {
		super();
		this.productid = productid;
		this.name = name;
		this.photopath = photopath;
		this.price = price;
		this.description = description;
		this.available = available;
		this.quantity = quantity;
		this.sweetOrder = sweetOrder;
		this.carts = carts;
		this.category = category;
	}


	public Integer getProductid() {
		return productid;
	}


	public void setProductid(Integer productid) {
		this.productid = productid;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPhotopath() {
		return photopath;
	}


	public void setPhotopath(String photopath) {
		this.photopath = photopath;
	}


	public Double getPrice() {
		return price;
	}


	public void setPrice(Double price) {
		this.price = price;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public Boolean getAvailable() {
		return available;
	}


	public void setAvailable(Boolean available) {
		this.available = available;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public SweetOrder getSweetOrder() {
		return sweetOrder;
	}


	public void setSweetOrder(SweetOrder sweetOrder) {
		this.sweetOrder = sweetOrder;
	}


	public List<Cart> getCarts() {
		return carts;
	}


	public void setCarts(List<Cart> carts) {
		this.carts = carts;
	}


	public Category getCategory() {
		return category;
	}


	public void setCategory(Category category) {
		this.category = category;
	}


	@Override
	public String toString() {
		return "Product [productid=" + productid + ", name=" + name + ", photopath=" + photopath + ", price=" + price
				+ ", description=" + description + ", available=" + available + ", quantity=" + quantity
				+ ", sweetOrder=" + sweetOrder + ", category=" + category + "]";
	}




	
	
	

	

	
	
	
	
}
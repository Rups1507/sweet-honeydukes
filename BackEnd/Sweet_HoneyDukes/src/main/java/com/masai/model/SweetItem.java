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

	public SweetItem(Integer orderItemId, String name, String photoPath, Double price, String description,
			Boolean available, Category category, Cart cart, Product product) {
		super();
		this.orderItemId = orderItemId;
		this.name = name;
		this.photoPath = photoPath;
		this.price = price;
		this.description = description;
		this.available = available;
		this.category = category;
		this.cart = cart;
		this.product = product;
	}

	public Integer getOrderItemId() {
		return orderItemId;
	}

	public void setOrderItemId(Integer orderItemId) {
		this.orderItemId = orderItemId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhotoPath() {
		return photoPath;
	}

	public void setPhotoPath(String photoPath) {
		this.photoPath = photoPath;
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

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "SweetItem [orderItemId=" + orderItemId + ", name=" + name + ", photoPath=" + photoPath + ", price="
				+ price + ", description=" + description + ", available=" + available + ", category=" + category
				+ ", cart=" + cart + ", product=" + product + "]";
	}

   
}
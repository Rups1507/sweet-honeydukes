package com.masai.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Category {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer categoryid;
	
	@NotNull
	@Size(min=3, max=20, message = "Category name should be there")
	private String name;

	public Category(Integer categoryid,
			@NotNull @Size(min = 3, max = 20, message = "Category name should be there") String name) {
		super();
		this.categoryid = categoryid;
		this.name = name;
	}

	public Integer getCategoryid() {
		return categoryid;
	}

	public void setCategoryid(Integer categoryid) {
		this.categoryid = categoryid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Category [categoryid=" + categoryid + ", name=" + name + "]";
	}
	
	
}


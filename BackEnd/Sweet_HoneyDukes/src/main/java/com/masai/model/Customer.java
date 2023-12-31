package com.masai.model;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EqualsAndHashCode(callSuper = false)
@DiscriminatorValue("Customer")
public class Customer extends User{


	
	@NotBlank(message = "address neded")
	private String Address;
    

    @JsonIgnore
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private Set<SweetOrder> sweetOrders = new HashSet<>();

    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    private Cart cart;
    

    @JsonIgnore
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private Set<OrderBill> bills = new HashSet<>();



	@Override
	public String toString() {
		return "Customer [Address=" + Address + ", sweetOrders=" + sweetOrders + ", cart=" + cart + ", bills=" + bills
				+ "]";
	}

//	public Object getCustomerEmail() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	public void setCustomerId(Integer userId) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	public void setRole(String string) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	public void setCart(Cart cart2) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	public Integer getCustomerid() {
//		// TODO Auto-generated method stub
//		return null;
//	}



}

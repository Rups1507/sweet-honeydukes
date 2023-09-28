package com.masai.model;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Customer {

	
	  private Integer customerId;

	    @NotNull
	    @Size(min = 4, max = 30, message = "min length should be 4 and max should be 30")
	    private String customerName;
		
	    @Column(unique = true)
		@Email(message = "Invalid email format")
		@NotBlank(message = "Email not be blank")
		private String customerEmail;
		
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


	    

		public Customer(Integer customerId,
				@NotNull @Size(min = 4, max = 30, message = "min length should be 4 and max should be 30") String customerName,
				@Email(message = "Invalid email format") @NotBlank(message = "Email not be blank") String customerEmail,
				@NotBlank(message = "address neded") String address, Set<SweetOrder> sweetOrders, Cart cart,
				Set<OrderBill> bills) {
			super();
			this.customerId = customerId;
			this.customerName = customerName;
			this.customerEmail = customerEmail;
			Address = address;
			this.sweetOrders = sweetOrders;
			this.cart = cart;
			this.bills = bills;
		}

		@Override
		public String toString() {
			return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", customerEmail="
					+ customerEmail + ", Address=" + Address + ", sweetOrders=" + sweetOrders + ", cart=" + cart
					+ ", bills=" + bills + "]";
		}

		public Integer getCustomerId() {
			return customerId;
		}

		public void setCustomerId(Integer customerId) {
			this.customerId = customerId;
		}

		public String getCustomerName() {
			return customerName;
		}

		public void setCustomerName(String customerName) {
			this.customerName = customerName;
		}

		public String getCustomerEmail() {
			return customerEmail;
		}

		public void setCustomerEmail(String customerEmail) {
			this.customerEmail = customerEmail;
		}

		public String getAddress() {
			return Address;
		}

		public void setAddress(String address) {
			Address = address;
		}

		public Set<SweetOrder> getSweetOrders() {
			return sweetOrders;
		}

		public void setSweetOrders(Set<SweetOrder> sweetOrders) {
			this.sweetOrders = sweetOrders;
		}

		public Cart getCart() {
			return cart;
		}

		public void setCart(Cart cart) {
			this.cart = cart;
		}

		public Set<OrderBill> getBills() {
			return bills;
		}

		public void setBills(Set<OrderBill> bills) {
			this.bills = bills;
		}
	    
	    
}

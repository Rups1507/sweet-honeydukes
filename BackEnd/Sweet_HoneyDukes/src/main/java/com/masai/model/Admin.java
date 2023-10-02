package com.masai.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@DiscriminatorValue("Admin")
public class Admin extends User {
  
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	private boolean active=true;
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	private final String role = "ROLE_ADMIN";

	public boolean getActive() {
		return this.active;
	}

	
	

   
}
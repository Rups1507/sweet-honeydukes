package com.masai.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity

public class Admin {
  @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int adminId;
	@NotNull(message = "Name of admin can't be Null")
	private String name;
	@NotNull(message = "Email of admin can't be Null")
	@Email(message = "Email should be in proper Format")
	@Column(unique = true)
	private String email;
	@NotNull(message = "Password of admin can't be Null")
	private String password;
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	private boolean active=true;
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	private final String role = "ROLE_ADMIN";

	public boolean getActive() {
		return this.active;
	}

	
	

   
}
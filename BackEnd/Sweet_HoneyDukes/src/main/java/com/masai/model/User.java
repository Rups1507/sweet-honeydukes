package com.masai.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type", discriminatorType = DiscriminatorType.STRING)
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;
	
	@Column(unique = true)
	private String username;
	
	@JsonProperty(access = Access.WRITE_ONLY)
	@NotNull(message = "password should not be null")
	private String password;
	
//	@NotEmpty(message = "Role should not be null & may be User / Admin")
//	private String role;

//	public Integer getUserId() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	public Object getFirstName() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	public void setFirstName(Object firstName) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	public Object getEmail() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	
//
//	public void setEmail(Object email) {
//		// TODO Auto-generated method stub
//		
//	}


}

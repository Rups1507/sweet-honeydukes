package com.masai.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
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

	
	public Admin(int adminId, @NotNull(message = "Name of admin can't be Null") String name,
			@NotNull(message = "Email of admin can't be Null") @Email(message = "Email should be in proper Format") String email,
			@NotNull(message = "Password of admin can't be Null") String password, boolean active) {
		super();
		this.adminId = adminId;
		this.name = name;
		this.email = email;
		this.password = password;
		this.active = active;
	}

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", name=" + name + ", email=" + email + ", password=" + password
				+ ", active=" + active + ", role=" + role + "]";
	}
	

   
}
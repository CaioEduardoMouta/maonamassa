package br.com.devdojo.examgenerator.persistence.model;

import javax.persistence.Column;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class Professor extends AbstractEntity {
	@NotEmpty(message = "The field name cannot be empty")
	private String name;
	@Email(message = "this email is not valid")
	@NotEmpty(message = "The field email cannot be empty")
	@Column(unique = true)
	private String email;
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	

}

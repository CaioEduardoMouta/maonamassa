package br.com.devdojo.examgenerator.persistence.model;

import org.hibernate.validator.constraints.NotEmpty;

public class Professor {
	@NotEmpty
	private String name;

}

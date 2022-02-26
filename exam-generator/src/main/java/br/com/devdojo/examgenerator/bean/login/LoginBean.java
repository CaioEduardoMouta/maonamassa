package br.com.devdojo.examgenerator.bean.login;

import java.io.Serializable;

import javax.faces.context.ExternalContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.com.devdojo.examgenerator.persistence.dao.LoginDAO;

@Named
@ViewScoped
public class LoginBean implements Serializable {
	private String username;
	private String password;
	private final LoginDAO loginDAO;
	private final ExternalContext externalContext;
	public LoginBean(String username, String password, LoginDAO loginDAO, ExternalContext externalContext) {
		super();
		this.username = username;
		this.password = password;
		this.loginDAO = loginDAO;
		this.externalContext = externalContext;
	}
	
	
}

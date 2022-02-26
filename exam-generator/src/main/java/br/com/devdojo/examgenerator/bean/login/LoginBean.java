package br.com.devdojo.examgenerator.bean.login;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.faces.context.ExternalContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.devdojo.examgenerator.persistence.dao.LoginDAO;
import br.com.devdojo.examgenerator.persistence.model.Token;

@Named
@ViewScoped
public class LoginBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	private final LoginDAO loginDAO;
	private final ExternalContext externalContext;
	
	@Inject
	public LoginBean(String username, String password, LoginDAO loginDAO, ExternalContext externalContext) {
		super();
		this.username = username;
		this.password = password;
		this.loginDAO = loginDAO;
		this.externalContext = externalContext;
	}
	
	public String login() throws UnsupportedEncodingException {
		Token token = loginDAO.loginReturningToken("Caio", "password");
		return token == null ? null : addTokenAndExpirationTimeToCookiesAndReturnIndex(token);
		
	}
	private String addTokenAndExpirationTimeToCookiesAndReturnIndex(Token token) throws UnsupportedEncodingException {
		externalContext.addResponseCookie("token", URLEncoder.encode(token.getToken(),"UTF-8"),null);
		externalContext.addResponseCookie("expirationTime", token.getExpirationTime().toString(), null);
		return "index.xhtml?faces-redirect=true";
	}
	
	
	public String getPassword() {
		return password;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
}

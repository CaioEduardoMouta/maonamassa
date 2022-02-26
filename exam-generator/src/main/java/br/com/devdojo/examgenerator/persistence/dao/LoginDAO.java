package br.com.devdojo.examgenerator.persistence.dao;

import java.io.Serializable;

import javax.inject.Inject;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import static org.springframework.http.HttpMethod.POST;

import br.com.devdojo.examgenerator.persistence.model.Token;

public class LoginDAO implements Serializable {
	
	private final String BASE_URL = "http://localhost:8005/login";
	private final RestTemplate restTemplate;
	
	@Inject
	public LoginDAO(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
	
	public Token loginReturningToken(String username, String password) {
		String loginJson = "{\"username\":" +addQuotes(username) + ",\"password\":" + addQuotes(password) + "}";
		ResponseEntity<Token> tokenExchange = restTemplate
				.exchange(BASE_URL,POST, new HttpEntity<>(loginJson, createJsonHeader()), Token.class);
		
		return tokenExchange.getBody();
	}
	@SuppressWarnings("StringBufferReplaceableByString")
	private String addQuotes(String value) {
		return new StringBuilder(300).append("\"").append(value).append("\"").toString();
	}
	
	private HttpHeaders createJsonHeader() {
		HttpHeaders header = new HttpHeaders();
		header.setContentType(MediaType.APPLICATION_JSON_UTF8);
		return header;
	}

}

package br.com.devdojo.examgenerator.endpoint.v1;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class ProfessorEndpoint {
	
	@GetMapping
	public ResponseEntity<?> h1() {
		return new ResponseEntity<>(body:"Hi", HttpStatus.OK);
	}

}

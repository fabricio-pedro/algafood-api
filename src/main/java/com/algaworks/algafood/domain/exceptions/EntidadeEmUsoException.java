package com.algaworks.algafood.domain.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


public class EntidadeEmUsoException extends RuntimeException {

	private static final long serialVersionUID = -1398522394700800474L;
	
	public EntidadeEmUsoException(String msg) {
		super(msg);
	}

}

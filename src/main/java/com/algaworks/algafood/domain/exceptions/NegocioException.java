package com.algaworks.algafood.domain.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


public class NegocioException extends RuntimeException {

	private static final long serialVersionUID = -1445041726905659390L;
    
	public NegocioException(String msg) {
		super(msg);
	}
	public NegocioException(String msg, Throwable cause) {
		super(msg, cause);
	}
}

package com.algaworks.algafood.infrastructure.email;

public class EmailException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public EmailException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public EmailException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
    
}

package com.algaworks.algafood.api.handleExceptions;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Builder;
import lombok.Getter;
@JsonInclude(Include.NON_NULL)
@Getter
@Builder
public class ProblemDetails {
	
	private String type;
	private int status;
	private String title;
	private String details;
	

}

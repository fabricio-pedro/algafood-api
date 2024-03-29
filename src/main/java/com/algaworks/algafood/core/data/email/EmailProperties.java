package com.algaworks.algafood.core.data.email;

import javax.validation.constraints.NotNull;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import lombok.Getter;
import lombok.Setter;

@Validated
@Setter
@Getter
@Component
@ConfigurationProperties("algafood.email")
public class EmailProperties {
    
	@NotNull
	private String remetente;
	
	@NotNull
	private String impl;
	private Sandbox sandbox = new Sandbox();
	
	@Getter
	@Setter
	public class Sandbox {
	    
	    private String destinatario;
	    
	}
	
}

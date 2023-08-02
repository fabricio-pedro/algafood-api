package com.algaworks.algafood.configurations;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.algaworks.algafood.core.data.email.EmailProperties;
import com.algaworks.algafood.domain.services.EnvioEmailService;
import com.algaworks.algafood.infrastructure.email.EmailEnumStrategies;
import com.algaworks.algafood.infrastructure.email.FakeEnvioEmailService;
import com.algaworks.algafood.infrastructure.email.SmtpEnvioEmailService;

@Configuration
public class EmailConfig {

 @Autowired	
  private EmailProperties emailProperties;	
  
  @Bean
  public EnvioEmailService buildEmailservice() {
  
	String implementacao=emailProperties.getImpl().toUpperCase();
	return EmailEnumStrategies
		    .valueOf(implementacao)
		    .getEmailEnvioService();
	  

	   
	 	 
	  
  }
	
}	
	



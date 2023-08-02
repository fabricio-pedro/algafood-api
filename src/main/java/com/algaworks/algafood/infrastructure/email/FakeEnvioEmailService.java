package com.algaworks.algafood.infrastructure.email;

import org.springframework.stereotype.Service;

import com.algaworks.algafood.domain.services.EnvioEmailService;

import lombok.extern.slf4j.Slf4j;


@Slf4j
public class FakeEnvioEmailService extends SmtpEnvioEmailService {


	
	@Override
	public void enviar(Mensagem msg) {
		String corpo=processarTemplate(msg);
		log.info(corpo);
		
	}

}

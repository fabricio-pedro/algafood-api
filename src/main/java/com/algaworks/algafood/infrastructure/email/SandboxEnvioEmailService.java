package com.algaworks.algafood.infrastructure.email;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.MimeMessageHelper;

import com.algaworks.algafood.core.data.email.EmailProperties;

import lombok.extern.slf4j.Slf4j;
@Slf4j
public class SandboxEnvioEmailService extends SmtpEnvioEmailService {
    @Autowired
	private EmailProperties emailProperties;
    
    protected MimeMessage criarMimeMessage(Mensagem mensagem) throws MessagingException {
       
    	MimeMessage mimeMessage = super.criarMimeMessage(mensagem);
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "UTF-8");
        helper.setTo(emailProperties.getSandbox().getDestinatario());
        
        return mimeMessage;
    }
    
}

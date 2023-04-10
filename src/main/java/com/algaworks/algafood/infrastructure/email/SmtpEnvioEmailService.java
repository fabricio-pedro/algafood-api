package com.algaworks.algafood.infrastructure.email;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.algaworks.algafood.core.data.email.EmailProperties;
import com.algaworks.algafood.domain.services.EnvioEmailService;

@Service
public class SmtpEnvioEmailService implements EnvioEmailService {

   @Autowired	
   private JavaMailSender mailSender;
	
   @Autowired
   private EmailProperties emailProperties;
	
   @Override
  public void enviar(Messagem msg) {
		
	  try {
	   MimeMessage mimeMessage=this.mailSender.createMimeMessage();
	   MimeMessageHelper helper=new MimeMessageHelper(mimeMessage, "UTF-8");
	   helper.setSubject(msg.getAssunto());
	   helper.setFrom(emailProperties.getRemetente());
	   helper.setText(msg.getCorpo(), true);
	   helper.setTo(msg.getDestinarios().toArray(new String[0]));
	  
	   mailSender.send(mimeMessage);
	  }catch(Exception ex) {
		  throw new EmailException("Não foi possível enviar email", ex);
	  }	
	}
 
}

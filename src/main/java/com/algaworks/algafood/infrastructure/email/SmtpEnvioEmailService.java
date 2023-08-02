package com.algaworks.algafood.infrastructure.email;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import com.algaworks.algafood.core.data.email.EmailProperties;
import com.algaworks.algafood.domain.services.EnvioEmailService;

import freemarker.core.ParseException;
import freemarker.template.Configuration;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.Template;
import freemarker.template.TemplateNotFoundException;

public class SmtpEnvioEmailService implements EnvioEmailService {

   @Autowired	
   private JavaMailSender mailSender;
	
   @Autowired
   private EmailProperties emailProperties;
   
   @Autowired
   private Configuration freemarkerConfig;
	
   @Override
  public void enviar(Mensagem msg) {
	 
	  try {
	   
	   mailSender.send(criarMimeMessage(msg));
	  }catch(Exception ex) {
		  throw new EmailException("Não foi possível enviar email", ex);
	  }	
	}
  
  protected MimeMessage criarMimeMessage(Mensagem msg) throws MessagingException {
	  String corpo =processarTemplate(msg);	
	  MimeMessage mimeMessage=this.mailSender.createMimeMessage();
	   MimeMessageHelper helper=new MimeMessageHelper(mimeMessage, "UTF-8");
	   helper.setSubject(msg.getAssunto());
	   helper.setFrom(emailProperties.getRemetente());
	   helper.setText(corpo, true);
	   helper.setTo(msg.getDestinarios().toArray(new String[0]));
	return mimeMessage;
	  
  }
   
  protected String processarTemplate(Mensagem msg ) {
	 try {
		Template template= this.freemarkerConfig.getTemplate(msg.getCorpo());
	   return	FreeMarkerTemplateUtils.processTemplateIntoString(template,msg.getVariaveis());
	} catch (Exception ex) {
		// TODO Auto-generated catch block
		throw new EmailException("Não foi possível processar o template", ex);
	} 
	   
   }
  
  
 
}

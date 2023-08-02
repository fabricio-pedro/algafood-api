package com.algaworks.algafood.infrastructure.email;

import com.algaworks.algafood.domain.services.EnvioEmailService;

public enum EmailEnumStrategies {
   FAKE("fake",new FakeEnvioEmailService()),
   SMTP("smtp", new SmtpEnvioEmailService()),
   SANDBOX("sandbox", new SandboxEnvioEmailService());
	private EnvioEmailService envioEmailService;
    EmailEnumStrategies(String mode,EnvioEmailService envioEmail) {
	envioEmailService=envioEmail;
 }
    public EnvioEmailService getEmailEnvioService() {
    	return this.envioEmailService;
    }
    
    
}

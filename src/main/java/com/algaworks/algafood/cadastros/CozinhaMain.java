package com.algaworks.algafood.cadastros;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.algaworks.algafood.AlgafoodExample2Application;
import com.algaworks.algafood.domain.model.Cozinha;

public class CozinhaMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context=(ApplicationContext) new SpringApplicationBuilder(AlgafoodExample2Application.class)
				.web(WebApplicationType.NONE)
				.run(args);
		CozinhaCrud crud=context.getBean(CozinhaCrud.class);
		
		crud.listAll().stream().forEach(x->System.out.println(x.getNome()));
		Cozinha cozinha=new Cozinha();
		cozinha.setNome("brasileira");
		crud.incluir(cozinha);
		System.out.println("Cozinha descriçao:"+crud.buscar(2l).getNome());
				
	}

}

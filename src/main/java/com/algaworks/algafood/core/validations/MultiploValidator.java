package com.algaworks.algafood.core.validations;

import java.math.BigDecimal;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.algaworks.algafood.domain.repositories.RestauranteRepository;

public class MultiploValidator implements ConstraintValidator<Multiplo, Number> {
  
	 @Autowired
	private RestauranteRepository repo;
	
	
	int numeroMultiplo;
	
	@Override
	public void initialize(Multiplo constraintAnnotation) {
		// TODO Auto-generated method stub
		this.numeroMultiplo=constraintAnnotation.numero();
		
	
	}
	
	@Override
	public boolean isValid(Number value, ConstraintValidatorContext context) {
		boolean valid=true;
		
		 if(value!=null) {
			
			var valorDecimal=BigDecimal.valueOf(value.doubleValue());
			var numeroMultiploDecimal=BigDecimal.valueOf(numeroMultiplo);
			var remainder=valorDecimal.remainder(numeroMultiploDecimal);
			
		    valid=BigDecimal.ZERO.compareTo(remainder)==0;
			 
		 }
		
		
		return valid;
	}

}

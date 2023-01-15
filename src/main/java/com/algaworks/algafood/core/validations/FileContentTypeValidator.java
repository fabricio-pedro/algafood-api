package com.algaworks.algafood.core.validations;

import java.util.Arrays;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.web.multipart.MultipartFile;

public class FileContentTypeValidator implements ConstraintValidator<FileContentType, MultipartFile> {
  
	
	private List<String> contentTypes;;
	
	
	
	
	@Override
	public void initialize(FileContentType constraintAnnotation) {
		// TODO Auto-generated method stub
		this.contentTypes=Arrays.asList(constraintAnnotation.allowed());
		
	
	}
	
	@Override
	public boolean isValid(MultipartFile file, ConstraintValidatorContext context) {
	      return file==null || this.contentTypes.contains(file.getContentType()); 
	      
		
	        	
	
		
	
	}

}

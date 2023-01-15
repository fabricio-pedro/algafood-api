package com.algaworks.algafood.core.validations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.util.unit.DataSize;
import org.springframework.web.multipart.MultipartFile;

public class FileSizeValidator implements ConstraintValidator<FileSize, MultipartFile> {
  
	
	private DataSize dataSize;
	
	
	
	
	@Override
	public void initialize(FileSize constraintAnnotation) {
		// TODO Auto-generated method stub
		this.dataSize=DataSize.parse(constraintAnnotation.max());
		
	
	}
	
	@Override
	public boolean isValid(MultipartFile file, ConstraintValidatorContext context) {
	   return file==null || file.getSize() <=dataSize.toBytes();	 
	        	
	
		
	
	}

}

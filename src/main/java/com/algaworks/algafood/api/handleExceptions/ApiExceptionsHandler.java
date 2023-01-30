package com.algaworks.algafood.api.handleExceptions;

import java.net.URI;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.TypeMismatchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.algaworks.algafood.api.handleExceptions.ProblemDetails.ProblemDetailsBuilder;
import com.algaworks.algafood.domain.exceptions.EntidadeEmUsoException;
import com.algaworks.algafood.domain.exceptions.EntidadeNaoEncontradaException;
import com.algaworks.algafood.domain.exceptions.NegocioException;
import com.fasterxml.jackson.databind.JsonMappingException.Reference;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.fasterxml.jackson.databind.exc.PropertyBindingException;


@RestControllerAdvice
public class ApiExceptionsHandler extends ResponseEntityExceptionHandler {
	
	private static final String MSG_ERROR_GENERICA_USUARIO_FINAL="Ocorreu um error interno inesperado no sistema."+
	                                                "Tente novamente e caso problema persistir entre em contato com o "+
			                                        "administrador do sistema";
	@Autowired
	private MessageSource messageSource;
	
	@ExceptionHandler(EntidadeNaoEncontradaException.class)
	public ResponseEntity<?> handleRestauranteNaoEncontradoException(EntidadeNaoEncontradaException ex,WebRequest request){
	     
		int status=HttpStatus.NOT_FOUND.value();
		
		ProblemDetails problemDetails=createProblemDetailsBuilder(status, ex.getMessage(),ProblemType.RECURSO_NAO_ENCONTRADO)
				                     .userMessage(ex.getLocalizedMessage())
				                     .timestamp(OffsetDateTime.now())
				                     .build();
		
		return handleExceptionInternal(ex, problemDetails, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
		
	}
	@ExceptionHandler(NegocioException.class)
	public ResponseEntity<?> handleNegocioException(NegocioException ex,WebRequest request){
     
        int status=HttpStatus.BAD_REQUEST.value();
		ProblemDetails problemDetails=createProblemDetailsBuilder(status, ex.getMessage(),ProblemType.ERRO_DE_NEGOCIO)
				                      .timestamp(OffsetDateTime.now())
				                      .build();
		return handleExceptionInternal(ex, problemDetails, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
		
	}
	@ExceptionHandler(EntidadeEmUsoException.class)
	public ResponseEntity<?> handleEntidadeEmUsoException(EntidadeEmUsoException ex,WebRequest request){
		  
			
			ProblemDetails problemDetails=createProblemDetailsBuilder(HttpStatus.CONFLICT.value(), ex.getMessage(),ProblemType.ENTIDADE_EM_USO)
					                      .userMessage(ex.getMessage())
					                      .timestamp(OffsetDateTime.now()).build();
			   
			return handleExceptionInternal(ex, problemDetails, new HttpHeaders(), HttpStatus.CONFLICT, request);
	}
 @Override
 protected ResponseEntity<Object> handleHttpMediaTypeNotAcceptable(
			HttpMediaTypeNotAcceptableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

		return ResponseEntity.status(status).headers(headers).build();
 }	

 @Override
protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers,
		HttpStatus status, WebRequest request) {
	
	  if(body==null) {
		body=ProblemDetails.builder()
			  .details(status.getReasonPhrase())
			  .status(status.value())
			  .timestamp(OffsetDateTime.now())
			  .build();  
		  
	  }
	  
	 return super.handleExceptionInternal(ex,body,headers, status, request);
}
 

@Override 
 protected ResponseEntity<Object> handleTypeMismatch(
			TypeMismatchException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

	     if(ex instanceof MethodArgumentTypeMismatchException) {
	    	return handleMethMethodArgumentTypeMismatch((MethodArgumentTypeMismatchException)ex, headers, status, request); 
	     }

		return handleExceptionInternal(ex, null, headers, status, request);
	}

private ResponseEntity<Object> handleMethMethodArgumentTypeMismatch(MethodArgumentTypeMismatchException ex, HttpHeaders headers, HttpStatus status, WebRequest request){
	ProblemType typeOfProblem=ProblemType.PARAMETRO_INVALIDO;
	URI uri= ServletUriComponentsBuilder.fromCurrentRequest().build().toUri();
	String parameter=ex.getParameter().getParameterName();
	String value=ex.getValue().toString();
	String typeExpected=ex.getRequiredType().getSimpleName();
	String details=String.format("A URL  com parametro '%s' recebeu o valor '%s', que é invalido, informe umm valor do tipo '%s'",parameter,value,typeExpected);
	ProblemDetails problems=createProblemDetailsBuilder(status.value(), details, typeOfProblem)
			                .timestamp(OffsetDateTime.now()).build();
	return handleExceptionInternal(ex, problems, headers, status, request); 
}
 
 
 @Override
protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
		 HttpHeaders headers, HttpStatus status, WebRequest request) {
	     Throwable rootCause=ExceptionUtils.getRootCause(ex);
         
	     if(rootCause instanceof InvalidFormatException) {
    	 return handleInvalidFormat((InvalidFormatException)rootCause,headers,status,request);
         }else if(rootCause instanceof PropertyBindingException) {
           return handlePropertyBinding((PropertyBindingException)rootCause, headers, status, request);
         }
	  
	     String details="Erro de sintaxe no corpo  da mensagem, verifique o formato";
		ProblemDetails problemDetails=createProblemDetailsBuilder(HttpStatus.BAD_REQUEST.value(),details,ProblemType.ERRO_FORMATO_INCOMPREENSIVEL)
				                      .timestamp(OffsetDateTime.now())
				                      .userMessage(MSG_ERROR_GENERICA_USUARIO_FINAL).build();
		return handleExceptionInternal(ex, problemDetails, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
	 
	
}
 
 protected ResponseEntity<Object> handleNoHandlerFoundException(
			NoHandlerFoundException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

	      String resource = ex.getRequestURL();
	      String details=String.format("O recurso '%s' que você tentou acessar é inexistente, tente outro",resource);
	      ProblemDetails problems=createProblemDetailsBuilder(status.value(),details, ProblemType.RECURSO_NAO_ENCONTRADO)
	    		                  .timestamp(OffsetDateTime.now())
	    		                  .build();
	 
		return handleExceptionInternal(ex, problems,headers, status, request);
	}
 @Override
 protected ResponseEntity<Object> handleBindException(BindException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
	return handleValidationInternal(ex, headers, status, request, ex.getBindingResult());
	 
 }
 
 protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
            return handleValidationInternal(ex, headers, status, request,ex.getBindingResult());
	}
 
 @ExceptionHandler(MaxUploadSizeExceededException.class)
 @ResponseStatus
 public String handleFileSizeLimitExceeded(MaxUploadSizeExceededException exc) {
      var size= exc.getMaxUploadSize();                                                                              
	 return "{\"error\":\"file too big\"}";
 }
 
 
private ResponseEntity<Object> handleValidationInternal(Exception ex, HttpHeaders headers,
	HttpStatus status, WebRequest request, BindingResult bindingResult) {
	ProblemType typeOfProblem=ProblemType.DADOS_INVALIDOS;
	String details="Um ou mais campos estão invalidos.Faça o preenchimento e tente novamente";
	
	bindingResult.getFieldErrors().stream().forEach(x->System.out.println(x.getField()));
	
	List<ProblemDetails.Field> problemFields = bindingResult.getFieldErrors().stream()
			.map(fieldError -> {
				String message = messageSource.getMessage(fieldError, LocaleContextHolder.getLocale());
				System.out.println("messagem:"+message);
				return ProblemDetails.Field.builder()
					.name(fieldError.getField())
					.errorInField(message)
					.build();
			})
			.collect(Collectors.toList());
	
         problemFields.stream().forEach(x->System.out.println(x.getName()));
	
	ProblemDetails problems=createProblemDetailsBuilder(status.value(), details, typeOfProblem)
			                .timestamp(OffsetDateTime.now())
	                        .userMessage(details)
	                        .fields(problemFields)
			                .build();
			
return handleExceptionInternal(ex, problems, headers, status, request);
} 
 
	
private ResponseEntity<Object> handleInvalidFormat(InvalidFormatException ex,
		HttpHeaders headers, HttpStatus status, WebRequest request) {
	    String field= joinPath(ex.getPath());     
	    ProblemType typeOfProblem=ProblemType.ERRO_FORMATO_INCOMPREENSIVEL;
	    String details=String.format("A propriedade '%s' recebeu valor '%s', que é um tipo inválido, "
	    		+ "informe um valor do tipo 'Long' ", field,ex.getValue(), ex.getTargetType().getSimpleName());
	    ProblemDetails problems=createProblemDetailsBuilder(status.value(), details, typeOfProblem)
	    		                .timestamp(OffsetDateTime.now()) 
	    		                .userMessage(MSG_ERROR_GENERICA_USUARIO_FINAL).build();
	
	   return handleExceptionInternal(ex, problems, new HttpHeaders(), HttpStatus.BAD_REQUEST, request) ;
}

private ResponseEntity<Object> handlePropertyBinding(PropertyBindingException ex,
		HttpHeaders headers, HttpStatus status, WebRequest request){
	    String field= joinPath(ex.getPath()); 
	    String details=String.format("A propriedade '%s' não existe, corrija ou remova e tente novamente", field);  
	    ProblemType typeOfProblem=ProblemType.ERRO_FORMATO_INCOMPREENSIVEL;
	    ProblemDetails problems=createProblemDetailsBuilder(status.value(), details, typeOfProblem)
	    		.timestamp(OffsetDateTime.now())
	    		.userMessage(MSG_ERROR_GENERICA_USUARIO_FINAL).build();
	
	return  handleExceptionInternal(ex, problems, headers, status, request);
} 


private String joinPath(List<Reference> references) {
    return references.stream()
        .map(ref -> ref.getFieldName())
        .collect(Collectors.joining("."));
}

private  ProblemDetailsBuilder createProblemDetailsBuilder(int status,String details,ProblemType type) {
	 return ProblemDetails.builder()
	        .status(status)
	        .details(details)
	        .title(type.getTitle())
	        .type(type.getType());
}


 
}

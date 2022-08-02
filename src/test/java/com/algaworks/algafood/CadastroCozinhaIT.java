package com.algaworks.algafood;

import static org.assertj.core.api.Assertions.assertThat;

import javax.validation.ConstraintViolationException;

import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;

import com.algaworks.algafood.domain.exceptions.EntidadeEmUsoException;
import com.algaworks.algafood.domain.exceptions.EntidadeNaoEncontradaException;
import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.services.CadastroCozinhaService;

import ch.qos.logback.core.status.Status;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matcher.*;




@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class CadastroCozinhaIT {

  @Autowired	
  private CadastroCozinhaService cozinhaService;
  @Autowired
  private Flyway flyway;
  @LocalServerPort
  private int port;
  
  @BeforeEach
  public void initialize() {
	enableLoggingOfRequestAndResponseIfValidationFails(); 
	RestAssured.port=port;
	RestAssured.basePath="/cozinhas";
	flyway.migrate();
  }
  
  @Test
  public void deveRetornarStatus200AoConsultarCozinha() {
	 
	 given()
	   .accept(ContentType.JSON).
	 when()
	   .get().
	then()
	   .statusCode(HttpStatus.OK.value());   
	 
	  
  }
  @Test
  public void deveRetornarStatus201AoInserirUmaConzinha() {
     given()
       .contentType(ContentType.JSON)
       .body("{\"nome\":\"Japonesa\"}").
       accept(ContentType.JSON).
    when()
       .post().
   then()
        .statusCode(HttpStatus.CREATED.value());
       
       
  }
}

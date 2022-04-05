package com.algaworks.algafood.api.io.creators;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.algaworks.algafood.api.io.model.RestauranteModelRes;
import com.algaworks.algafood.domain.model.Restaurante;

@Component
public class RestauranteResCreator {

 @Autowired	
 private ModelMapper mapper;
	
  public RestauranteModelRes toModelRes(Restaurante restaurante) {
	  return mapper.map(restaurante, RestauranteModelRes.class);	  
  }	
  
  public List<RestauranteModelRes> toListModelRes(List<Restaurante> restaurantes){
	  
	  return restaurantes.stream()
			              .map(restaurante->toModelRes(restaurante))
			              .collect(Collectors.toList());
	  
  }
	
}

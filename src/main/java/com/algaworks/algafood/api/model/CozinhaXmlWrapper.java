package com.algaworks.algafood.api.model;

import java.util.List;

import com.algaworks.algafood.domain.model.Cozinha;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import lombok.Data;
import lombok.NonNull;

@Data
@JacksonXmlRootElement(localName = "cozinhas")
public class CozinhaXmlWrapper {

@NonNull
@JsonProperty("cozinha")
@JacksonXmlElementWrapper(useWrapping = false)
private List<Cozinha> cozinhas;	
	
}

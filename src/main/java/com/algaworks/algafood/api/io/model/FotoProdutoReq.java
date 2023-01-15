package com.algaworks.algafood.api.io.model;

import org.springframework.http.MediaType;
import org.springframework.web.multipart.MultipartFile;

import com.algaworks.algafood.core.validations.FileContentType;
import com.algaworks.algafood.core.validations.FileSize;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FotoProdutoReq {
 
 private String descricao;
 @FileSize(max = "32KB")
 @FileContentType(allowed = {MediaType.IMAGE_JPEG_VALUE,MediaType.IMAGE_PNG_VALUE,MediaType.IMAGE_JPEG_VALUE})
 private MultipartFile arquivo;
	
}

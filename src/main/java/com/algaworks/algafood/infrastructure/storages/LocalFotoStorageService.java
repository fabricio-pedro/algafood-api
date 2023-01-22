package com.algaworks.algafood.infrastructure.storages;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

import org.springframework.aop.ThrowsAdvice;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;

import com.algaworks.algafood.domain.services.FotoStorageService;

@Service 
public class LocalFotoStorageService implements FotoStorageService {
    @Value("${algafood.storage.fileSystem.directory}")
	private Path diretoryOfPhotos;

	@Override
	public void armazenar(NovaFoto novaFoto) {
		try {
			Path pathOfPhoto=getPathOfPhoto(novaFoto.getNome());
			FileCopyUtils.copy(novaFoto.getInputStream(),Files.newOutputStream(pathOfPhoto));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new StorageException("Não foi possível armazenar arquivo no diretorio",e);
		}
		
	}
	
	private Path getPathOfPhoto(String fotoNome) {
		return this.diretoryOfPhotos.resolve(Path.of(fotoNome));
	}

	@Override
	public void remover(String antigaFoto) {
		Path pathAntigo=getPathOfPhoto(antigaFoto);
		try {
			Files.delete(pathAntigo);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new StorageException("Não foi possível remover arquivo no diretorio",e);
		}
		
	}

	@Override
	public InputStream recuperar(String arquivo) {
		Path searchedFilePath=getPathOfPhoto(arquivo);
		 InputStream inputStream=null;  
		if(Files.exists(searchedFilePath)) {
			
				try {
				   inputStream=Files.newInputStream(searchedFilePath);
				   return inputStream;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					throw new StorageException("Ocorreu um erro inesperado, contate o administrador do sistema",e);
				}
			
		  }
		
		throw new StorageException("A foto procurada não existe no diretorio");
		
	
	}

}

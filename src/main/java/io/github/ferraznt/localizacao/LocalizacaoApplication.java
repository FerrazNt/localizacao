package io.github.ferraznt.localizacao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.github.ferraznt.localizacao.domain.entity.Cidade;
import io.github.ferraznt.localizacao.domain.service.CidadeService;

@SpringBootApplication
public class LocalizacaoApplication implements CommandLineRunner{

	@Autowired
	private CidadeService cidadeService;

	public static void main(String[] args) {
		SpringApplication.run(LocalizacaoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {


		var cidade = new Cidade(1L, "Serra Talhada",2980006L);
		
		//cidadeService.filtroCidadeDinamico(cidade).forEach(System.out::println);
		// Usando a Spec
		//cidadeService.listarCidadesSpecByNome("Sao Paulo");

		cidadeService.listarSpecCidadeDinamico(cidade);

	}

}

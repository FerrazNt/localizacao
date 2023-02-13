package io.github.ferraznt.localizacao.domain.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import io.github.ferraznt.localizacao.domain.entity.Cidade;
import io.github.ferraznt.localizacao.domain.repository.CidadeRepository;

@Service
public class CidadeService {

    private CidadeRepository repository;

    public CidadeService(CidadeRepository repository){
        this.repository = repository;

    }

    public void listarCidades(){
		repository.findAll().forEach(System.out::println);	
	}

	public void cidadesPorNome(String nome){
		repository.findByNome(nome).forEach(System.out::println);	
	}

	public void cidadeComecandoCom(String nome){
		repository.findByNomeStartingWith(nome).forEach(System.out::println);	
	}

	public void cidadeTerminandoCom(String nome){
		repository.findByNomeEndingWith(nome).forEach(System.out::println);	
	}

	public void cidadeContendoNome(String nome){
		repository.findByNomeContaining(nome).forEach(System.out::println);	
	}

	public void cidadeLikeNome(String nome){
		repository.findByNomeLike(nome).forEach(System.out::println);	
	}

	public void cidadeLikeNomeNoCase(String nome){
		repository.findByNomeLikeNoCase(nome).forEach(System.out::println);	
	}

	public void cidadesPorHabitantes(Long habitantes){
		repository.findByHabitantes(habitantes).forEach(System.out::println);	
	}

	public void listarCidadesPorQuantidadeMenor(Long habitantes){
		repository.findByHabitantesLessThan(habitantes).forEach(System.out::println);
	}

	public void listarCidadesPorQuantidadeMaior(Long habitantes){
		repository.findByHabitantesGreaterThanEqual(habitantes).forEach(System.out::println);
	}

	public void listarCidadesPorQuaantENome(Long habitantes, String nome){
		repository.findByHabitantesLessThanAndNomeLike(habitantes, nome).forEach(System.out::println);
	}

    @Transactional
	public void salvarCidade(Cidade cidade){
		if(cidade.getId() != null){
			repository.save(cidade);
			System.out.println("Cidade ["+cidade.getNome()+"] salva com sucesso!");
		}else {
			System.out.println("Eita! A Cidade informada não é válida...");
		}
		
	}

}

package io.github.ferraznt.localizacao.domain.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import io.github.ferraznt.localizacao.domain.entity.Cidade;
import io.github.ferraznt.localizacao.domain.repository.CidadeRepository;
import io.github.ferraznt.localizacao.domain.repository.specs.CidadeSpecs;

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
		repository
            .findByNomeLikeNoCase(nome, Sort.by("habitantes"))
            .forEach(System.out::println);	
	}

    public void cidadeLikeNomeNoCasePaginado(String nome, Integer pagina){
        if (pagina == null){
            pagina = 2;
        }

        Pageable pageable = PageRequest.of(0, pagina);
		repository
            .findByNomeLikeNoCase(nome, pageable)
            .forEach(System.out::println);	
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

    public List<Cidade> filtroCidadeDinamico(Cidade cidade){
        ExampleMatcher matcher = ExampleMatcher
            .matching()
            .withIgnoreCase()
            .withStringMatcher(ExampleMatcher.StringMatcher.STARTING);
        Example<Cidade> example = Example
            .of(cidade,matcher);
        return repository.findAll(example);
    }

    // Montando o Listar a Partir de Uma Spec
    public void listarCidadesSpecByNome(String nome){
        System.out.println("Buscando Cidade "+nome);
        repository
            //.findAll(CidadeSpecs.nomeEqual(nome).and(CidadeSpecs.habitantesGreaterThan(10000000)))
            .findAll(CidadeSpecs.nomeEqual(nome).or(CidadeSpecs.habitantesGreaterThan(10000000L)))
            .forEach(System.out::println);
    }

    public void listarSpecCidadeDinamico(Cidade filtro){

        Specification<Cidade> specs = Specification.where((root, query, cb) -> cb.conjunction());
        // Gera um Modelo Gregoriano de Query
        // select * from cidade where 1 = 1

        if(filtro.getId() != null){
            specs = specs.and(CidadeSpecs.idEqual(filtro.getId()));
        }

        if(StringUtils.hasText(filtro.getNome())){
            specs = specs.and(CidadeSpecs.nomeEqual(filtro.getNome()));
        }

        if(filtro.getHabitantes() != null){
            specs = specs.and(CidadeSpecs.habitantesEqual(filtro.getHabitantes()));
        }

        System.out.println("Listando a partir de uma specification:");

        repository.findAll(specs).forEach(System.out::println);

    }

}

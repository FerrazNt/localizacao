package io.github.ferraznt.localizacao.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import io.github.ferraznt.localizacao.domain.entity.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Long> {
    
    // Busca pelo nome exato
    List<Cidade> findByNome(String nome);

    // Busca começando com String informada
    List<Cidade> findByNomeStartingWith(String nome);

    // Busca terminando com String informada
    List<Cidade> findByNomeEndingWith(String nome);

    // Busca contendo uma String informada
    List<Cidade> findByNomeContaining(String nome);

    // Permite uso de % 
    List<Cidade> findByNomeLike(String nome);

    // Usando Query para desconsiderar o Case.
    @Query(" select c from Cidade c where upper(c.nome) like upper(?1)")
    List<Cidade> findByNomeLikeNoCase(String nome);

    List<Cidade> findByHabitantes(Long habitantes);

    List<Cidade> findByHabitantesLessThan(Long habitantes);

    List<Cidade> findByHabitantesGreaterThanEqual(Long habitantes);

    List<Cidade> findByHabitantesLessThanAndNomeLike(Long habitantes, String nome);


}

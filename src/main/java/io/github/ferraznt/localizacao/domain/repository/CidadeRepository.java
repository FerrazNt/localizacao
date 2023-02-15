package io.github.ferraznt.localizacao.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import io.github.ferraznt.localizacao.domain.entity.Cidade;
import io.github.ferraznt.localizacao.domain.repository.projections.CidadeProjection;

public interface CidadeRepository extends JpaRepository<Cidade, Long>, JpaSpecificationExecutor<Cidade> {

    @Query(nativeQuery = true, value=" select * from cidade as c where c.nome = :nome")
    List<Cidade> findByNomeSQLNativo(@Param("nome") String nome);

    @Query(nativeQuery = true, value=" select c.id_cidade as id, c.nome from cidade as c where c.nome = :nome")
    List<CidadeProjection> selectIdNomeToProjection(@Param("nome") String nome);

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

    // Usando Query para desconsiderar o Case. (Ordenado)
    @Query("select c from Cidade c where upper(c.nome) like upper(?1)")
    List<Cidade> findByNomeLikeNoCase(String nome, Sort sort);

    // Usando Query para desconsiderar o Case. (Paginado)
    @Query("select c from Cidade c where upper(c.nome) like upper(?1)")
    List<Cidade> findByNomeLikeNoCase(String nome, Pageable pagina);

    List<Cidade> findByHabitantes(Long habitantes);

    List<Cidade> findByHabitantesLessThan(Long habitantes);

    List<Cidade> findByHabitantesGreaterThanEqual(Long habitantes);

    List<Cidade> findByHabitantesLessThanAndNomeLike(Long habitantes, String nome);


}

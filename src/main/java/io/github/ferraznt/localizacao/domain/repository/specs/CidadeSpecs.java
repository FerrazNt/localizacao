package io.github.ferraznt.localizacao.domain.repository.specs;

import org.springframework.data.jpa.domain.Specification;

import io.github.ferraznt.localizacao.domain.entity.Cidade;

public abstract class CidadeSpecs {

    
    public static Specification<Cidade> propriedadeEquel(String propriedade, Object valorObjeto){
        return (root, query, cb) -> cb.equal(root.get(propriedade), valorObjeto);
    }
    
    public static Specification<Cidade> nomeEqual(String nome){
        return (root, query, cb) -> cb.equal(root.get("nome"), nome);
    }

    public static Specification<Cidade> habitantesGreaterThan(Long value){
        return (root, query, cb) -> cb.greaterThan(root.get("habitantes"), value);
    }

    public static Specification<Cidade> habitantesBetween(Long min, Long max){
        return (root, query, cb) -> cb.between(root.get("habitantes"), min, max);
    }

    public static Specification<Cidade> nomeLikeIgnoreCase(String nome){
        return (root, query, cb) -> cb.like(cb.upper(root.get("nome")), "%"+nome+"%".toUpperCase());
    }

    public static Specification<Cidade> idEqual(Long id){
        return (root, query, cb) -> cb.equal(root.get("id"), id);
    }

    public static Specification<Cidade> habitantesEqual(Long  habitantes) {
        return (root, query, cb) -> cb.equal(root.get("habitantes"), habitantes);
    }

}

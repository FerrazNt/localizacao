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

    public static Specification<Cidade> habitantesGreaterThan(Integer value){
        return (root, query, cb) -> cb.greaterThan(root.get("habitantes"), value);
    }

}

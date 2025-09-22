package com.examplo.app.repository;
import org.springframework.data.repository.CrudRepository;

import com.examplo.app.model.Produto;

public interface ProdutoRepository extends CrudRepository<Produto, Long>{
        
}

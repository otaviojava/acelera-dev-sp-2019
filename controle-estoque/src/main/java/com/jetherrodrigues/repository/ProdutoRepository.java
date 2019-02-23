package com.jetherrodrigues.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jetherrodrigues.domain.Produto;

@Repository
public interface ProdutoRepository extends CrudRepository<Produto, Long> {
	
}

package com.jetherrodrigues.service;

import java.util.List;
import java.util.Optional;

import com.jetherrodrigues.domain.Produto;

public interface GenericService<T, ID> {
	T save(T t);
	void update(T t);
	void delete(T t);
	List<T> findAll();
	Optional<Produto> findById(ID id);
}

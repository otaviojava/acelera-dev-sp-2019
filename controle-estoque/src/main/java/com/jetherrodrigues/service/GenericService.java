package com.jetherrodrigues.service;

import java.util.List;
import java.util.Optional;

/**
 * 
 * @author jether.rodrigues
 *
 * @param <T>
 * @param <ID>
 */
public interface GenericService<T, ID> {
	T save(T t);
	void update(T t);
	void delete(T t);
	List<T> findAll();
	Optional<T> findById(ID id);
}

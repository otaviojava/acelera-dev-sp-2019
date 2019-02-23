package com.jetherrodrigues.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jetherrodrigues.domain.Produto;
import com.jetherrodrigues.repository.ProdutoRepository;

@Service
public class ProdutoService implements ProdutoGenericService {

	@Autowired 
	private ProdutoRepository produtoRepository;
	
	@Override
	public Produto save(Produto t) {
		return this.produtoRepository.save(t);
	}

	@Override
	public void update(Produto t) {
		this.produtoRepository.save(t);
	}

	@Override
	public void delete(Produto t) {
		this.produtoRepository.delete(t);
	}

	@Override
	public List<Produto> findAll() {
		return StreamSupport.stream(this.produtoRepository.findAll().spliterator(), false)
			      .collect(Collectors.toList());
	}

	@Override
	public Optional<Produto> findById(Long id) {
		return this.produtoRepository.findById(id);
	}
}

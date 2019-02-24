package com.jetherrodrigues.resource;

import java.io.Serializable;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jetherrodrigues.domain.Produto;
import com.jetherrodrigues.exception.ProdutoNotFoundException;
import com.jetherrodrigues.response.MessageResponse;
import com.jetherrodrigues.service.ProdutoGenericService;

/**
 * 
 * @author jether.rodrigues
 *
 */
@RestController
@RequestMapping(value = "v1/produto")
public class ProdutoResource implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private ProdutoGenericService produtoService;

	@GetMapping("/all")
	public ResponseEntity<List<Produto>> findAll() {
		return ResponseEntity
				.ok()
				.body(this.produtoService.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Produto> findById(@PathVariable Long id) {
		return ResponseEntity.ok().body(
				this.produtoService.findById(id)
					.orElseThrow(() -> new ProdutoNotFoundException("Produto não encontrado!"))
			);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		this.produtoService.delete(
			this.produtoService.findById(id)
				.orElseThrow(() -> new ProdutoNotFoundException("Produto não encontrado!"))
		);
		return ResponseEntity.ok().body(new MessageResponse(HttpStatus.OK));
	}
	
	@PostMapping
	public ResponseEntity<Produto> create(@Valid @RequestBody Produto produto) {
		return ResponseEntity.ok().body(this.produtoService.save(produto));
	}
}

package com.jetherrodrigues.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 
 * @author jether.rodrigues
 *
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ProdutoNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ProdutoNotFoundException(String message) {
		super(message);
	}
}

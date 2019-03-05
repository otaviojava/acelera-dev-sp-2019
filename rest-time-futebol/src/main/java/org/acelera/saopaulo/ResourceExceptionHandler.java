package org.acelera.saopaulo;

import javax.servlet.http.HttpServletRequest;

import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResourceExceptionHandler
{
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request)
	{
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError err = StandardError.builder()
				.timestamp(System.currentTimeMillis())
				.status(status.value())
				.error("Recurso não encontrado")
				.message(e.getMessage())
				.path(request.getRequestURI())
				.build();

		return ResponseEntity.status(status).body(err);
	}
	
	@ExceptionHandler({IllegalStateException.class, Exception.class})
	public ResponseEntity<StandardError> illegalState(IllegalStateException e, HttpServletRequest request)
	{
		HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
		StandardError err = StandardError.builder()
				.timestamp(System.currentTimeMillis())
				.status(status.value())
				.error("Erro interno")
				.message(e.getMessage())
				.path(request.getRequestURI())
				.build();

		return ResponseEntity.status(status).body(err);
	}
}

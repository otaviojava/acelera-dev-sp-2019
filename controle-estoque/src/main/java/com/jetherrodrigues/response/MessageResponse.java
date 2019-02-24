package com.jetherrodrigues.response;

import java.io.Serializable;

import org.springframework.http.HttpStatus;

/**
 * @author jether.rodrigues
 */
public class MessageResponse implements Serializable {
	private static final long serialVersionUID = 1L;
	private int code;
	private String message;

	public MessageResponse(HttpStatus status) {
		super();
		this.code = status.value();
		this.message = status.getReasonPhrase();
	}

	public int getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MessageResponse [code=").append(code).append(", message=").append(message).append("]");
		return builder.toString();
	}
}

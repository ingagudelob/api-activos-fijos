package com.serinz.activos.app.configs.exceptions;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class InternalServerError extends RuntimeException {
	
	private HttpStatus status;

	public InternalServerError() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InternalServerError(String message, HttpStatus status) {
		super(message);
		this.status = status;
		
		// TODO Auto-generated constructor stub
	}

}

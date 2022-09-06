package com.serinz.activos.app.configs.exceptions;

import org.springframework.http.HttpStatus;

import lombok.Data;


/**
 * Clase  de contrucción para la configuración para la captura de excepciones del tipo INTERNAL_SERVER_ERROR
 * @author ing_j
 *
 */
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
